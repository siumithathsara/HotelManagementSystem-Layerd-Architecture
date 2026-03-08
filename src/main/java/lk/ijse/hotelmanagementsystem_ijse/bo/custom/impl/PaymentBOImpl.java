package lk.ijse.hotelmanagementsystem_ijse.bo.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.hotelmanagementsystem_ijse.bo.custom.PaymentBO;
import lk.ijse.hotelmanagementsystem_ijse.dao.CrudUtil;
import lk.ijse.hotelmanagementsystem_ijse.dao.DAOFactory;
import lk.ijse.hotelmanagementsystem_ijse.dao.custom.PaymentDAO;
import lk.ijse.hotelmanagementsystem_ijse.dao.custom.impl.PaymentImpl;
import lk.ijse.hotelmanagementsystem_ijse.db.DBConnection;
import lk.ijse.hotelmanagementsystem_ijse.dto.PaymentDto;
import lk.ijse.hotelmanagementsystem_ijse.dto.tm.RoomReservationTM;
import lk.ijse.hotelmanagementsystem_ijse.entity.Payment;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PaymentBOImpl  implements PaymentBO {
    private final PaymentDAO paymentDao = (PaymentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.PAYMENT);

    public boolean saveFullPayment(String paymentId, double totalAmount, String method, ObservableList<RoomReservationTM> rooms) throws SQLException {

        Connection conn = DBConnection.getInstance().getConnection();

        try {
            conn.setAutoCommit(false);


//            String sql = "INSERT INTO payment (payment_id, amount, payment_method, payment_status) VALUES (?,?,?,?)";
//           boolean isSaved = CrudUtil.execute(conn, sql, paymentId, totalAmount, method, "Success");

            boolean isSaved = paymentDao.saveFullPayment(paymentId, totalAmount, method, rooms);

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

    @Override
    public String generateNextId() throws Exception {
        return paymentDao.generateNextId();
    }

    @Override
    public List<PaymentDto> getAllPayment() throws SQLException, ClassNotFoundException {
        List<Payment> payments = paymentDao.getAll();
        ArrayList<PaymentDto> paymentDtos=new ArrayList<>();

        for (Payment payment : payments) {
            PaymentDto paymentDto=new PaymentDto(
                    payment.getPayment_id(),
                    payment.getPayment_date(),
                    payment.getAmount(),
                    payment.getPayment_method(),
                    payment.getPayment_status());

            paymentDtos.add(paymentDto);
        }
        return paymentDtos;
    }

}
