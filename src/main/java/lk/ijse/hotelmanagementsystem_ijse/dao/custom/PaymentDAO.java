package lk.ijse.hotelmanagementsystem_ijse.dao.custom;

import javafx.collections.ObservableList;
import lk.ijse.hotelmanagementsystem_ijse.dao.CrudDAO;
import lk.ijse.hotelmanagementsystem_ijse.dto.PaymentDto;
import lk.ijse.hotelmanagementsystem_ijse.dto.tm.RoomReservationTM;
import lk.ijse.hotelmanagementsystem_ijse.entity.Payment;
import net.sf.jasperreports.engine.JRException;

import java.sql.SQLException;
import java.util.List;

public interface PaymentDAO extends CrudDAO<Payment> {
    public boolean saveFullPayment(String paymentId, double totalAmount, String method, ObservableList<RoomReservationTM> rooms) throws SQLException;
   /* public List<PaymentDto> getAllPayments() throws SQLException;
    public String generateNextPaymentId() throws SQLException;*/
    public void printInvoice(String paymentId) throws JRException,SQLException;

}
