package lk.ijse.hotelmanagementsystem_ijse.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.hotelmanagementsystem_ijse.dto.PaymentDto;
import lk.ijse.hotelmanagementsystem_ijse.dto.tm.RoomReservationTM;
import net.sf.jasperreports.engine.JRException;

import java.sql.SQLException;
import java.util.List;

public interface PaymentBO {
    public boolean saveFullPayment(String paymentId, double totalAmount, String method, ObservableList<RoomReservationTM> rooms) throws SQLException;
    public void printInvoice(String paymentId) throws JRException,SQLException;
    public String generateNextId() throws Exception;
    public List<PaymentDto> getAllPayment() throws SQLException, ClassNotFoundException;
}
