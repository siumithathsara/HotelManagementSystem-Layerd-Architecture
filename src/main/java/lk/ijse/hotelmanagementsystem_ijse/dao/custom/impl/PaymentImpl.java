package lk.ijse.hotelmanagementsystem_ijse.dao.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.hotelmanagementsystem_ijse.dao.custom.PaymentDAO;
import lk.ijse.hotelmanagementsystem_ijse.db.DBConnection;
import lk.ijse.hotelmanagementsystem_ijse.dto.tm.RoomReservationTM;
import lk.ijse.hotelmanagementsystem_ijse.entity.Payment;
import lk.ijse.hotelmanagementsystem_ijse.dao.CrudUtil;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PaymentImpl implements PaymentDAO {
    public boolean saveFullPayment(String paymentId, double totalAmount, String method, ObservableList<RoomReservationTM> rooms) throws SQLException {

        Connection conn = DBConnection.getInstance().getConnection();

        try {
            conn.setAutoCommit(false);


            String sql = "INSERT INTO payment (payment_id, amount, payment_method, payment_status) VALUES (?,?,?,?)";
            boolean isSaved = CrudUtil.execute(conn, sql, paymentId, totalAmount, method, "Success");

            if (!isSaved) {
                System.out.println("Failed to save payment");
                conn.rollback();
                return false;
            }


            for (RoomReservationTM room : rooms) {
                String bookingId = room.getBookingId();
                double paidAmount = room.getTotalPrice();

                if (bookingId == null || bookingId.isEmpty()) {
                    System.out.println("Invalid booking ID for room: " + room);
                    conn.rollback();
                    return false;
                }

                String sql2 = "INSERT INTO payment_booking (payment_id, booking_id, paid_amount) VALUES (?,?,?)";
                boolean isSavedDetails = CrudUtil.execute(conn, sql2, paymentId, bookingId, paidAmount);

                if (!isSavedDetails) {
                    System.out.println("Failed to save payment booking for bookingId: " + bookingId);
                    conn.rollback();
                    return false;
                }
            }

            conn.commit();
            printInvoice(paymentId);
            return true;

        } catch (SQLException | JRException e) {
            conn.rollback();
            e.printStackTrace();
            return false;
        } finally {
            conn.setAutoCommit(true);
        }
    }


    @Override
    public boolean save(Payment dto) throws Exception {
        return false;
    }

    @Override
    public boolean update(Payment dto) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return false;
    }

    @Override
    public Payment search(String id) throws Exception {
        return null;
    }

    public List<Payment> getAll() throws SQLException {
        ResultSet rs = CrudUtil.execute("SELECT * FROM payment");
        List<Payment> list = new ArrayList<>();

        while (rs.next()) {
            list.add(new Payment(
                    rs.getString("payment_id"),
                    rs.getTimestamp("payment_date").toLocalDateTime().toLocalDate(),
                    rs.getDouble("amount"),
                    rs.getString("payment_method"),
                    rs.getString("payment_status")
            ));
        }
        return list;
    }


    public String generateNextId() throws SQLException {
        ResultSet rs = CrudUtil.execute(
                "SELECT payment_id FROM payment ORDER BY payment_id DESC LIMIT 1"
        );

        if (rs.next()) {
            int id = Integer.parseInt(rs.getString(1).substring(1)) + 1;
            return String.format("P%03d", id);
        }
        return "P001";
    }

    public void printInvoice(String paymentId) throws JRException,SQLException {

        Connection conn = DBConnection.getInstance().getConnection();


        InputStream reportObject = getClass().getResourceAsStream("/report/invoice.jrxml");
        if (reportObject == null) {
            System.out.println("JRXML file not found! Check path.");
        }



        JasperReport jr = JasperCompileManager.compileReport(reportObject);


        Map<String, Object> params = new HashMap<>();
        params.put("PAYMENT_ID", paymentId);
        JasperPrint jp = JasperFillManager.fillReport(jr, params, conn);


        JasperViewer.viewReport(jp, false);
    }
}
