package lk.ijse.hotelmanagementsystem_ijse.dao.custom.impl;

import lk.ijse.hotelmanagementsystem_ijse.dao.custom.BillingDAO;
import lk.ijse.hotelmanagementsystem_ijse.entity.Billing;
import lk.ijse.hotelmanagementsystem_ijse.dao.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BillingImpl implements BillingDAO {
    public boolean save(Billing billing)
            throws SQLException, ClassNotFoundException {

        String sql = "INSERT INTO Billing " +
                "(bill_id, booking_id, total_amount, paid_amount, billing_date, status) " +
                "VALUES (?,?,?,?,?,?)";

        return CrudUtil.execute(
                sql,
                billing.getBill_id(),
                billing.getReservation_id(),
                billing.getTotal_amount(),
                billing.getPaid_amount(),
                billing.getBilling_date(),
                billing.getStatus()
        );
    }

    public boolean update(Billing billing)
            throws SQLException, ClassNotFoundException {

        String sql = "UPDATE Billing SET " +
                "booking_id=?, total_amount=?, paid_amount=?, billing_date=?, status=? " +
                "WHERE bill_id=?";

        return CrudUtil.execute(
                sql,
                billing.getReservation_id(),
                billing.getTotal_amount(),
                billing.getPaid_amount(),
                billing.getBilling_date(),
                billing.getStatus(),
                billing.getBill_id()
        );
    }

    public boolean delete(String billId)
            throws SQLException, ClassNotFoundException {

        String sql = "DELETE FROM Billing WHERE bill_id=?";
        return CrudUtil.execute(sql, billId);
    }

    public Billing search(String billId)
            throws SQLException, ClassNotFoundException {

        String sql = "SELECT * FROM Billing WHERE bill_id=?";
        ResultSet rs = CrudUtil.execute(sql, billId);

        if (rs.next()) {
            return new Billing(
                    rs.getString("bill_id"),
                    rs.getString("booking_id"),
                    rs.getDouble("total_amount"),
                    rs.getDouble("paid_amount"),
                    rs.getDouble("balance"),
                    rs.getDate("billing_date").toLocalDate(),
                    rs.getString("status")
            );
        }
        return null;
    }

    public List<Billing> getAll()
            throws SQLException {

        ResultSet rs = CrudUtil.execute("SELECT * FROM Billing");
        List<Billing> billList = new ArrayList<>();

        while (rs.next()) {
            billList.add(
                    new Billing(
                            rs.getString("bill_id"),
                            rs.getString("booking_id"),
                            rs.getDouble("total_amount"),
                            rs.getDouble("paid_amount"),
                            rs.getDouble("balance"),
                            rs.getDate("billing_date").toLocalDate(),
                            rs.getString("status")
                    )
            );
        }
        return billList;
    }

    @Override
    public String generateNextId() throws Exception {
        return "";
    }


    public boolean updatePayment(String billId, double paidAmount)
            throws SQLException, ClassNotFoundException {

        String sql = "UPDATE Billing SET paid_amount=? WHERE bill_id=?";
        return CrudUtil.execute(sql, paidAmount, billId);
    }

    public Billing getBillByBookingId(String bookingId)
            throws SQLException, ClassNotFoundException {

        String sql = "SELECT * FROM Billing WHERE booking_id=?";
        ResultSet rs = CrudUtil.execute(sql, bookingId);

        if (rs.next()) {
            return new Billing(
                    rs.getString("bill_id"),
                    rs.getString("booking_id"),
                    rs.getDouble("total_amount"),
                    rs.getDouble("paid_amount"),
                    rs.getDouble("balance"),
                    rs.getDate("billing_date").toLocalDate(),
                    rs.getString("status")
            );
        }
        return null;
    }
}
