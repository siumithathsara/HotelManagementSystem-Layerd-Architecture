package lk.ijse.hotelmanagementsystem_ijse.dao;

import javafx.collections.ObservableList;
import lk.ijse.hotelmanagementsystem_ijse.dto.PaymentDto;
import lk.ijse.hotelmanagementsystem_ijse.dto.tm.RoomReservationTM;
import net.sf.jasperreports.engine.JRException;

import java.sql.SQLException;
import java.util.List;

public interface PaymentDAO {
    public boolean saveFullPayment(String paymentId, double totalAmount, String method, ObservableList<RoomReservationTM> rooms) throws SQLException;
    public List<PaymentDto> getAllPayments() throws SQLException;
    public String generateNextPaymentId() throws SQLException;
    public void printInvoice(String paymentId) throws JRException,SQLException;

}
