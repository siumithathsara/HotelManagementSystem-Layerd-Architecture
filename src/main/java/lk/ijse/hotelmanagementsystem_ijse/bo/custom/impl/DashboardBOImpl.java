package lk.ijse.hotelmanagementsystem_ijse.bo.custom.impl;

import lk.ijse.hotelmanagementsystem_ijse.bo.custom.DashboardBO;
import lk.ijse.hotelmanagementsystem_ijse.dao.DAOFactory;
import lk.ijse.hotelmanagementsystem_ijse.dao.custom.impl.DashboardImpl;
import lk.ijse.hotelmanagementsystem_ijse.dto.RoomDetailsDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DashboardBOImpl implements DashboardBO {

    private DashboardImpl dashboardDao = (DashboardImpl) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.DASHBOARD);
    @Override
    public int getAvailableRoomCount() throws SQLException, ClassNotFoundException {
        return dashboardDao.getAvailableRoomCount();
    }

    @Override
    public int getCustomerCount() throws SQLException, ClassNotFoundException {
        return dashboardDao.getCustomerCount();
    }

    @Override
    public int getTodayBookingCount() throws SQLException, ClassNotFoundException {
        return dashboardDao.getTodayBookingCount();
    }

    @Override
    public double getTodayRevenue() throws SQLException, ClassNotFoundException {
        return dashboardDao.getTodayRevenue();
    }

    @Override
    public List<RoomDetailsDTO> getRoomDetails() throws SQLException, ClassNotFoundException {
        return List.of();
    }

    @Override
    public ResultSet getWeeklyBookings() throws SQLException, ClassNotFoundException {
        return dashboardDao.getWeeklyBookings();
    }
}
