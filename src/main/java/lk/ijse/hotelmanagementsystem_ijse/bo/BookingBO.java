package lk.ijse.hotelmanagementsystem_ijse.bo;

import lk.ijse.hotelmanagementsystem_ijse.dto.BookingDTO;
import lk.ijse.hotelmanagementsystem_ijse.entity.Booking;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface BookingBO {
    public boolean saveBooking(BookingDTO bookingDTO) throws Exception, ClassNotFoundException;
    public boolean updateBooking(BookingDTO dto) throws Exception;
    public boolean deleteBooking(String bookingId) throws Exception;
    public BookingDTO searchBooking(String bookingId) throws Exception;
    public List<BookingDTO> getAllBookings()throws SQLException, ClassNotFoundException;
    public boolean updateBookingStatus(String bookingId, String status)throws SQLException, ClassNotFoundException;
    public List<Booking> getBookingsByDate(String date) throws SQLException, ClassNotFoundException;
    public String generateNextBookingId() throws Exception;
    public boolean placeBooking(String bookingId, String customerId, String roomId, Date checkInDate, Date checkOutDate, double totalPrice) throws SQLException;
}
