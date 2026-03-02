package lk.ijse.hotelmanagementsystem_ijse.bo;

import lk.ijse.hotelmanagementsystem_ijse.dto.BookingDetailsDTO;

import java.sql.SQLException;
import java.util.Date;

public class ReservationBOImpl implements ReservationBO {

    @Override
    public boolean saveBookingDetails(BookingDetailsDTO bookingDetailsDTO) throws SQLException {
        return false;
    }

    @Override
    public BookingDetailsDTO getBookingDetails(String bookingId) throws SQLException {
        return null;
    }

    @Override
    public boolean updateBookingDetailsCheckOutDate(String bookingID, Date checkOutDate) throws SQLException {
        return false;
    }

    @Override
    public boolean updateBookingDetails(BookingDetailsDTO bookingDetailsDTO) throws SQLException {
        return false;
    }

    @Override
    public boolean deleteBookingDetails(String bookingId) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String getRoomIdByBookingId(String bookingId) throws SQLException, ClassNotFoundException {
        return "";
    }
}
