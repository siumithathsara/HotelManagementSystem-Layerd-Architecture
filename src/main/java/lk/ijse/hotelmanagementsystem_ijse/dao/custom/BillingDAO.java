package lk.ijse.hotelmanagementsystem_ijse.dao.custom;

import lk.ijse.hotelmanagementsystem_ijse.dao.CrudDAO;
import lk.ijse.hotelmanagementsystem_ijse.dto.BillingDTO;
import lk.ijse.hotelmanagementsystem_ijse.entity.Billing;

import java.sql.SQLException;
import java.util.List;

public interface BillingDAO extends CrudDAO<Billing> {
   /* public boolean saveBill(BillingDTO dto)throws SQLException, ClassNotFoundException;
    public boolean updateBill(BillingDTO dto)throws SQLException, ClassNotFoundException;
    public boolean deleteBill(String billId)throws SQLException, ClassNotFoundException;
    public BillingDTO searchBill(String billId)throws SQLException, ClassNotFoundException;
    public List<BillingDTO> getAllBills()throws SQLException, ClassNotFoundException;*/
    public boolean updatePayment(String billId, double paidAmount)throws SQLException, ClassNotFoundException;
    public Billing getBillByBookingId(String bookingId)throws SQLException, ClassNotFoundException;
}
