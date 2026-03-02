package lk.ijse.hotelmanagementsystem_ijse.bo;

import lk.ijse.hotelmanagementsystem_ijse.dao.custom.impl.DashboardImpl;
import lk.ijse.hotelmanagementsystem_ijse.dto.RoomDetailsDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DashboardBOImpl implements DashboardBO {

    private DashboardImpl dashboardDao = new DashboardImpl();
    @Override
    public int getAvailableRoomCount() throws SQLException, ClassNotFoundException {
        return 0;
    }

    @Override
    public int getCustomerCount() throws SQLException, ClassNotFoundException {
        return 0;
    }

    @Override
    public int getTodayBookingCount() throws SQLException, ClassNotFoundException {
        return 0;
    }

    @Override
    public double getTodayRevenue() throws SQLException, ClassNotFoundException {
        return 0;
    }

    @Override
    public List<RoomDetailsDTO> getRoomDetails() throws SQLException, ClassNotFoundException {
        return List.of();
    }

    @Override
    public ResultSet getWeeklyBookings() throws SQLException, ClassNotFoundException {
        return null;
    }
}
