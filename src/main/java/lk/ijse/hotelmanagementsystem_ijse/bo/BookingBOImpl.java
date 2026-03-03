package lk.ijse.hotelmanagementsystem_ijse.bo;

import lk.ijse.hotelmanagementsystem_ijse.dao.CrudUtil;
import lk.ijse.hotelmanagementsystem_ijse.dao.custom.BookingDAO;
import lk.ijse.hotelmanagementsystem_ijse.dao.custom.BookingDetailsDAO;
import lk.ijse.hotelmanagementsystem_ijse.dao.custom.CustomerDAO;
import lk.ijse.hotelmanagementsystem_ijse.dao.custom.RoomDetailsDAO;
import lk.ijse.hotelmanagementsystem_ijse.dao.custom.impl.BookingDetailsImpl;
import lk.ijse.hotelmanagementsystem_ijse.dao.custom.impl.BookingImpl;
import lk.ijse.hotelmanagementsystem_ijse.dao.custom.impl.CustomerImpl;
import lk.ijse.hotelmanagementsystem_ijse.dao.custom.impl.RoomDetailsImpl;
import lk.ijse.hotelmanagementsystem_ijse.db.DBConnection;
import lk.ijse.hotelmanagementsystem_ijse.dto.BookingDTO;
import lk.ijse.hotelmanagementsystem_ijse.entity.Booking;
import lk.ijse.hotelmanagementsystem_ijse.entity.BookingDetails;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class BookingBOImpl implements BookingBO {
    private CustomerDAO customerDao = new CustomerImpl();
    private RoomDetailsDAO roomDetailsDao = new RoomDetailsImpl();
    private BookingDAO bookingDao = new BookingImpl();
    private final BookingDetailsDAO bookingDetailsDao = new BookingDetailsImpl();

    @Override
    public boolean saveBooking(BookingDTO bookingDTO) throws Exception, ClassNotFoundException {
        Connection conn = DBConnection.getInstance().getConnection();

        try {

            conn.setAutoCommit(false);

            boolean isSaved = bookingDao.saveBooking(new Booking(
                    bookingDTO.getBooking_id(),
                    bookingDTO.getBooking_date(),
                    bookingDTO.getCustomer_id(),
                    bookingDTO.getStatus()
            ));

            if (isSaved) {


                BookingDetails bookingDetails = new BookingDetails(bookingDTO.getBookingDetails().getBookingId(),
                        bookingDTO.getBookingDetails().getRoomId(), bookingDTO.getBookingDetails().getCheckInDate(),
                        bookingDTO.getBookingDetails().getCheckOutDate());

                boolean isSavedBookingDetails = bookingDetailsDao.save(bookingDetails);

                if (isSavedBookingDetails) {

                    roomDetailsDao.updateRoomStatus(bookingDTO.getBookingDetails().getRoomId(), "Booked");
                } else {
                    throw new Exception("Something went wrong when saving to the booking details table");
                }
            } else {
                throw new Exception("Something went wrong when saving to the booking table");
            }

            conn.commit();
            return true;

        } catch (Exception e) {

            conn.rollback();
            System.out.println(e.getMessage());
        } finally {
            conn.setAutoCommit(true);

        }
        return false;
    }

    @Override
    public boolean updateBooking(BookingDTO dto) throws Exception {
        return false;
    }

    @Override
    public boolean deleteBooking(String bookingId) throws Exception {
        Connection conn = DBConnection.getInstance().getConnection();

        try {
            conn.setAutoCommit(false);


            String roomId = bookingDetailsDao.getRoomIdByBookingId(bookingId);

            if (roomId == null) {
                throw new SQLException("Room ID not found for booking: " + bookingId);
            }


            boolean isDetailsDeleted =
                    bookingDetailsDao.delete(bookingId);

            if (!isDetailsDeleted) {
                throw new SQLException("Booking details delete failed");
            }


//            boolean isBookingDeleted = CrudUtil.execute(
//                    "DELETE FROM Booking WHERE booking_id=?",
//                    bookingId
//            );
            boolean isBookingDeleted = bookingDao.delete(bookingId);

            if (!isBookingDeleted) {
                throw new SQLException("Booking delete failed");
            }

            boolean isRoomUpdated =
                    roomDetailsDao.updateRoomStatus(roomId, "Available");

            if (!isRoomUpdated) {
                throw new SQLException("Room status update failed");
            }

            conn.commit();
            return true;

        } catch (Exception e) {
            conn.rollback();
            System.out.println("DELETE ERROR: " + e.getMessage());
        } finally {
            conn.setAutoCommit(true);
        }
        return false;
    }

    @Override
    public BookingDTO searchBooking(String bookingId) throws Exception {
        return null;
    }

    @Override
    public List<BookingDTO> getAllBookings() throws SQLException, ClassNotFoundException {
        return List.of();
    }

    @Override
    public boolean updateBookingStatus(String bookingId, String status) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public List<Booking> getBookingsByDate(String date) throws SQLException, ClassNotFoundException {
        return List.of();
    }

    @Override
    public String generateNextBookingId() throws Exception {
        return bookingDao.generateNextId();
    }

    @Override
    public boolean placeBooking(String bookingId, String customerId, String roomId, Date checkInDate, Date checkOutDate, double totalPrice) throws SQLException {
        Connection conn = DBConnection.getInstance().getConnection();

        try {

            conn.setAutoCommit(false);

//            String sql = "UPDATE Booking SET checkout_date = ? WHERE booking_id = ?";
//
//            boolean isUpdate =  CrudUtil.execute(
//                    sql,
//                    checkOutDate,
//                    bookingId
//            );

            boolean isUpdate = bookingDao.placeBooking(bookingId, customerId, roomId, checkInDate, checkOutDate, totalPrice);
            if (isUpdate) {

                boolean isUpdateBookingDetails = bookingDetailsDao.updateBookingDetailsCheckOutDate(bookingId, checkOutDate);

                if (isUpdateBookingDetails) {

                    roomDetailsDao.updateRoomStatus(roomId, "Available");

                } else {
                    throw new Exception("Something went wrong when update to the checkout date to the booking details table");
                }
            } else {
                throw new Exception("Something went wrong when update to the checkout date in booking table");
            }

            conn.commit();
            return true;

        } catch (Exception e) {

            conn.rollback();
            System.out.println(e.getMessage());
        } finally {
            conn.setAutoCommit(true);
        }

        return false;
    }
}
