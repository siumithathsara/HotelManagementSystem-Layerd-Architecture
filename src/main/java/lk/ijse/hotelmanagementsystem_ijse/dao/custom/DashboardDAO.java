package lk.ijse.hotelmanagementsystem_ijse.dao.custom;

import lk.ijse.hotelmanagementsystem_ijse.dao.CrudDAO;
import lk.ijse.hotelmanagementsystem_ijse.dto.RoomDetailsDTO;
import lk.ijse.hotelmanagementsystem_ijse.entity.RoomDetails;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface DashboardDAO {
    public  int getCustomerCount()throws SQLException, ClassNotFoundException;
    public  int getAvailableRoomCount()throws SQLException, ClassNotFoundException;
    public  int getTodayBookingCount() throws SQLException, ClassNotFoundException;
    public  double getTodayRevenue() throws SQLException, ClassNotFoundException;
    public List<RoomDetailsDTO> getRoomDetails() throws SQLException, ClassNotFoundException;
    public ResultSet getWeeklyBookings() throws SQLException, ClassNotFoundException;
}
