package lk.ijse.hotelmanagementsystem_ijse.bo;

import lk.ijse.hotelmanagementsystem_ijse.dao.custom.impl.DashboardImpl;
import lk.ijse.hotelmanagementsystem_ijse.dto.RoomDetailsDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface DashboardBO {

    public  int getCustomerCount()throws SQLException, ClassNotFoundException;
    public  int getAvailableRoomCount()throws SQLException, ClassNotFoundException;
    public  int getTodayBookingCount() throws SQLException, ClassNotFoundException;
    public  double getTodayRevenue() throws SQLException, ClassNotFoundException;
    public List<RoomDetailsDTO> getRoomDetails() throws SQLException, ClassNotFoundException;
    public ResultSet getWeeklyBookings() throws SQLException, ClassNotFoundException;
}
