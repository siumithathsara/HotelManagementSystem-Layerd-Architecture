package lk.ijse.hotelmanagementsystem_ijse.dao.custom.impl;

import lk.ijse.hotelmanagementsystem_ijse.dao.custom.BookingDAO;
import lk.ijse.hotelmanagementsystem_ijse.dao.custom.BookingDetailsDAO;
import lk.ijse.hotelmanagementsystem_ijse.dao.custom.RoomDetailsDAO;
import lk.ijse.hotelmanagementsystem_ijse.db.DBConnection;
import lk.ijse.hotelmanagementsystem_ijse.entity.Booking;
import lk.ijse.hotelmanagementsystem_ijse.dao.CrudUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookingImpl implements BookingDAO {
    private final BookingDetailsDAO bookingDetailsDao = new BookingDetailsImpl();
    private final RoomDetailsDAO roomDetailsDao = new RoomDetailsImpl();

    @Override
    public boolean saveBooking(Booking dto) throws Exception {
        String sql = "INSERT INTO Booking (booking_id, customer_id, checkin_date, status) VALUES (?,?,?,?)";

        boolean isSaved =  CrudUtil.execute(
                sql,
                dto.getBooking_id(),
                dto.getCustomer_id(),
                dto.getBooking_date(),
                dto.getStatus()
        );
        return  isSaved;
    }

    @Override
    public boolean save(Booking dto) throws Exception {
        return false;
    }

    @Override
    public boolean update(Booking dto) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return false;
    }

    public boolean updateBooking(Booking booking) throws SQLException, ClassNotFoundException {

//        Connection conn = DBConnection.getInstance().getConnection();
//
//        try {
//
//            conn.setAutoCommit(false);


            String sql = "UPDATE Booking SET customer_id = ?, checkin_date = ?, status = ? WHERE booking_id = ?";

            boolean isSaved =  CrudUtil.execute(
                    sql,
                    booking.getCustomer_id(),
                    booking.getBooking_date(),
                    booking.getStatus(),
                    booking.getBooking_id()
            );
            return  isSaved;


//            if (isSaved) {
//
//                boolean isSavedBookingDetails = bookingDetailsDao.update(booking.getBookingDetails());
//
//                if (isSavedBookingDetails) {
//
//                    roomDetailsDao.updateRoomStatus(booking.getBookingDetails().getRoomId(), "Available");
//                } else {
//                    throw new Exception("Something went wrong when saving to the booking details table");
//                }
//            } else {
//                throw new Exception("Something went wrong when saving to the booking table");
//            }
//
//            conn.commit();
//            return true;
//
//        } catch (Exception e) {
//
//            conn.rollback();
//            System.out.println(e.getMessage());
//        } finally {
//            conn.setAutoCommit(true);
//        }
//        return false;
    }

    public boolean deleteBooking(String bookingId)
            throws SQLException, ClassNotFoundException {

//        Connection conn = DBConnection.getInstance().getConnection();
//
//        try {
//            conn.setAutoCommit(false);
//
//
//            String roomId = bookingDetailsDao.getRoomIdByBookingId(bookingId);
//
//            if (roomId == null) {
//                throw new SQLException("Room ID not found for booking: " + bookingId);
//            }
//
//
//            boolean isDetailsDeleted =
//                    bookingDetailsDao.delete(bookingId);
//
//            if (!isDetailsDeleted) {
//                throw new SQLException("Booking details delete failed");
//            }
//
//
//            boolean isBookingDeleted = CrudUtil.execute(
//                    "DELETE FROM Booking WHERE booking_id=?",
//                    bookingId
//            );
//
//            if (!isBookingDeleted) {
//                throw new SQLException("Booking delete failed");
//            }
//
//            boolean isRoomUpdated =
//                    roomDetailsDao.updateRoomStatus(roomId, "Available");
//
//            if (!isRoomUpdated) {
//                throw new SQLException("Room status update failed");
//            }
//
//            conn.commit();
//            return true;
//
//        } catch (Exception e) {
//            conn.rollback();
//            System.out.println("DELETE ERROR: " + e.getMessage());
//        } finally {
//            conn.setAutoCommit(true);
//        }
//        return false;

        boolean isBookingDeleted = CrudUtil.execute(
                "DELETE FROM Booking WHERE booking_id=?",
                bookingId
        );
        return  isBookingDeleted;
    }



    public Booking search(String bookingId)
            throws SQLException, ClassNotFoundException {

        String sql = "SELECT * FROM Booking WHERE booking_id=?";
        ResultSet rs = CrudUtil.execute(sql, bookingId);

        if (rs.next()) {
            return new Booking(
                    rs.getString("booking_id"),
                    rs.getString("customer_id"),
                    rs.getDate("checkin_date"),
                    //rs.getTime("booking_time").toLocalTime(),
                    rs.getString("special_note"),
                    rs.getString("status"),
                    //rs.getString("created_by"),
                    rs.getString("created_at")
            );
        }
        return null;
    }

    public List<Booking> getAll()
            throws SQLException, ClassNotFoundException {

        ResultSet rs = CrudUtil.execute("SELECT * FROM Booking ORDER BY booking_id DESC");
        List<Booking> bookingList = new ArrayList<>();

        while (rs.next()) {
            bookingList.add(
                    new Booking(
                            rs.getString("booking_id"),
                            rs.getString("customer_id"),
                            rs.getDate("checkin_date"),
                            rs.getString("special_note"),
                            rs.getString("status"),
                            // rs.getString("created_by"),
                            rs.getString("created_at")
                    )
            );
        }
        return bookingList;
    }



    public boolean updateBookingStatus(String bookingId, String status)
            throws SQLException, ClassNotFoundException {

        String sql = "UPDATE Booking SET status=? WHERE booking_id=?";
        return CrudUtil.execute(sql, status, bookingId);
    }

    public List<Booking> getBookingsByDate(String date)
            throws SQLException, ClassNotFoundException {

        String sql = "SELECT * FROM Booking WHERE booking_date=?";
        ResultSet rs = CrudUtil.execute(sql, date);

        List<Booking> list = new ArrayList<>();
        while (rs.next()) {
            list.add(
                    new Booking(
                            rs.getString("booking_id"),
                            rs.getString("customer_id"),
                            rs.getDate("booking_date"),
                            rs.getTime("booking_time").toLocalTime(),
                            rs.getString("special_note"),
                            rs.getString("status"),
                            rs.getString("created_by")

                    )
            );
        }
        return list;
    }

    @Override
    public boolean placeBooking(String bookingId, String customerId, String roomId, Date checkInDate, Date checkOutDate, double totalPrice) throws SQLException {
//       Connection conn = DBConnection.getInstance().getConnection();
//
//        try {
//
//            conn.setAutoCommit(false);
//
//            String sql = "UPDATE Booking SET checkout_date = ? WHERE booking_id = ?";
//
//            boolean isUpdate =  CrudUtil.execute(
//                    sql,
//                    checkOutDate,
//                    bookingId
//            );
//
//            if (isUpdate) {
//
//                boolean isUpdateBookingDetails = bookingDetailsDao.updateBookingDetailsCheckOutDate(bookingId, checkOutDate);
//
//                if (isUpdateBookingDetails) {
//
//                    roomDetailsDao.updateRoomStatus(roomId, "Available");
//
//                } else {
//                    throw new Exception("Something went wrong when update to the checkout date to the booking details table");
//                }
//            }  else {
//                throw new Exception("Something went wrong when update to the checkout date in booking table");
//            }
//
//            conn.commit();
//            return true;
//
//        } catch (Exception e) {
//
//            conn.rollback();
//            System.out.println(e.getMessage());
//        } finally {
//            conn.setAutoCommit(true);
//        }
//
//        return false;

        String sql = "UPDATE Booking SET checkout_date = ? WHERE booking_id = ?";

        boolean isUpdate =  CrudUtil.execute(
                sql,
                checkOutDate,
                bookingId
        );
        return  isUpdate;
    }


    public String generateNextId() throws SQLException {
        ResultSet rs = CrudUtil.execute(
                "SELECT booking_id FROM Booking ORDER BY booking_id DESC LIMIT 1"
        );

        if (rs.next()) {
            String lastId = rs.getString(1); // E.g., C005
            int number = Integer.parseInt(lastId.substring(1));
            number++;
            return String.format("B%03d", number);
        }
        return "B001";
    }

    public boolean updateCheckOutDate(String bookingId, Date checkoutDate)
            throws SQLException, ClassNotFoundException {
        String sql = "UPDATE Booking SET checkout_date = ? WHERE booking_id = ?";

        boolean isUpdate =  CrudUtil.execute(
                sql,
                checkoutDate,
                bookingId
        );
        return isUpdate;
    }
}
