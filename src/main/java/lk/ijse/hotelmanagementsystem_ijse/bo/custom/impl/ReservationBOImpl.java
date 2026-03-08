package lk.ijse.hotelmanagementsystem_ijse.bo.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.hotelmanagementsystem_ijse.bo.custom.ReservationBO;
import lk.ijse.hotelmanagementsystem_ijse.dao.DAOFactory;
import lk.ijse.hotelmanagementsystem_ijse.dao.custom.BookingDAO;
import lk.ijse.hotelmanagementsystem_ijse.dao.custom.BookingDetailsDAO;
import lk.ijse.hotelmanagementsystem_ijse.dao.custom.CustomerDAO;
import lk.ijse.hotelmanagementsystem_ijse.dao.custom.RoomDetailsDAO;
import lk.ijse.hotelmanagementsystem_ijse.dao.custom.impl.BookingDetailsImpl;
import lk.ijse.hotelmanagementsystem_ijse.dao.custom.impl.BookingImpl;
import lk.ijse.hotelmanagementsystem_ijse.dao.custom.impl.CustomerImpl;
import lk.ijse.hotelmanagementsystem_ijse.dao.custom.impl.RoomDetailsImpl;
import lk.ijse.hotelmanagementsystem_ijse.dto.BookingDetailsDTO;
import lk.ijse.hotelmanagementsystem_ijse.dto.tm.RoomReservationTM;
import lk.ijse.hotelmanagementsystem_ijse.entity.BookingDetails;

import java.sql.SQLException;
import java.util.Date;

public class ReservationBOImpl implements ReservationBO {

    private CustomerDAO customerDao = (CustomerDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    private RoomDetailsDAO roomDetailsDao = (RoomDetailsDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ROOM_DETAILS);
    private BookingDAO bookingDao = (BookingDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.BOOKING);
    private BookingDetailsDAO bookingDetailsDao = (BookingDetailsDAO)  DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.BOOKING_DETAILS);

    @Override
    public boolean saveBookingDetails(BookingDetailsDTO bookingDetailsDTO) throws Exception {
      return bookingDetailsDao.save(new BookingDetails(

              bookingDetailsDTO.getRoomId(),
              bookingDetailsDTO.getCheckInDate(),
              bookingDetailsDTO.getBookingId()
      ));

    }

    @Override
    public BookingDetailsDTO getBookingDetails(String bookingId) throws SQLException {
        return bookingDetailsDao.getBookingDetails(bookingId);
    }

    @Override
    public boolean updateBookingDetailsCheckOutDate(String bookingID, Date checkOutDate) throws SQLException {
        return bookingDetailsDao.updateBookingDetailsCheckOutDate(bookingID, checkOutDate);
    }

    @Override
    public boolean updateBookingDetails(BookingDetailsDTO bookingDetailsDTO) throws Exception {
        return bookingDetailsDao.update(new BookingDetails(
                bookingDetailsDTO.getBookingId(),
                bookingDetailsDTO.getRoomId(),
                bookingDetailsDTO.getCheckInDate()
        ));
    }

    @Override
    public boolean deleteBookingDetails(String bookingId) throws Exception {
        return bookingDetailsDao.delete(bookingId);
    }

    @Override
    public String getRoomIdByBookingId(String bookingId) throws SQLException, ClassNotFoundException {
        return bookingDetailsDao.getRoomIdByBookingId(bookingId);
    }
}
