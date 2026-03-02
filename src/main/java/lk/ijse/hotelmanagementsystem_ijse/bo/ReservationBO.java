package lk.ijse.hotelmanagementsystem_ijse.bo;

import lk.ijse.hotelmanagementsystem_ijse.dto.BookingDetailsDTO;

import java.sql.SQLException;
import java.util.Date;

public interface ReservationBO {

    public boolean saveBookingDetails(BookingDetailsDTO bookingDetailsDTO) throws SQLException;
    public BookingDetailsDTO getBookingDetails(String bookingId) throws SQLException;
    public boolean updateBookingDetailsCheckOutDate(String bookingID, Date checkOutDate) throws SQLException;
    public boolean updateBookingDetails(BookingDetailsDTO bookingDetailsDTO) throws SQLException;
    public boolean deleteBookingDetails(String bookingId)throws SQLException, ClassNotFoundException;
    public String getRoomIdByBookingId(String bookingId)throws SQLException, ClassNotFoundException;
}
