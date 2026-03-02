package lk.ijse.hotelmanagementsystem_ijse.dao.custom.impl;

import lk.ijse.hotelmanagementsystem_ijse.dao.custom.BookingDetailsDAO;
import lk.ijse.hotelmanagementsystem_ijse.dto.BookingDetailsDTO;
import lk.ijse.hotelmanagementsystem_ijse.dao.CrudUtil;
import lk.ijse.hotelmanagementsystem_ijse.entity.BookingDetails;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class BookingDetailsImpl implements BookingDetailsDAO {
    public boolean save(BookingDetails bookingDetails) throws SQLException {


        return CrudUtil.execute("INSERT INTO Booking_Details (booking_id, room_id, check_in_date) VALUES (?,?,?)",
                bookingDetails.getBookingId(),
                bookingDetails.getRoomId(),
                bookingDetails.getCheckInDate());

    }

    public BookingDetailsDTO getBookingDetails(String bookingId) throws SQLException {


        ResultSet rs = CrudUtil.execute("SELECT * FROM Booking_Details WHERE booking_id = ?", bookingId);

        if (rs.next()) {
            return new BookingDetailsDTO(
                    rs.getString("booking_id"),
                    rs.getString("room_id"),
                    rs.getString("check_in_date")
            );
        }
        return null;
    }


    public boolean updateBookingDetailsCheckOutDate(String bookingID, Date checkOutDate) throws SQLException {

        return CrudUtil.execute("UPDATE Booking_Details SET check_out_date = ? WHERE booking_id = ?",

                checkOutDate,
                bookingID

        );

    }

    public boolean update(BookingDetails bookingDetails) throws SQLException {

        return CrudUtil.execute("UPDATE Booking_Details SET room_id = ?, check_in_date = ? WHERE booking_id = ?",

                bookingDetails.getRoomId(),
                bookingDetails.getCheckInDate(),
                bookingDetails.getBookingId()

        );

    }

    public boolean delete(String bookingId)
            throws SQLException, ClassNotFoundException {

        String sql = "DELETE FROM Booking_Details WHERE booking_id=?";
        return CrudUtil.execute(sql, bookingId);
    }

    @Override
    public BookingDetails search(String id) throws Exception {
        return null;
    }

    @Override
    public List<BookingDetails> getAll() throws SQLException, ClassNotFoundException {
        return List.of();
    }

    @Override
    public String generateNextId() throws Exception {
        return "";
    }

    public String getRoomIdByBookingId(String bookingId)
            throws SQLException, ClassNotFoundException {

        ResultSet rs = CrudUtil.execute(
                "SELECT room_id FROM Booking_Details WHERE booking_id=?",
                bookingId
        );

        if (rs.next()) {
            return rs.getString("room_id");
        }
        return null;
    }
}
