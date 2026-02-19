package lk.ijse.hotelmanagementsystem_ijse.dao;

import lk.ijse.hotelmanagementsystem_ijse.dao.custom.impl.*;

public class DAOFactory {

    public static DAOFactory daoFactory;

    private DAOFactory() {}

    public static DAOFactory getInstance() {
        return daoFactory == null ? new DAOFactory() : daoFactory;
    }

    public enum DAOTypes{
        BILLING,
        BOOKING_DETAILS,
        BOOKING,
        CUSTOMER,
        DASHBOARD,
        EMPLOYEE,
        PAYMENT,
        ROOM_DETAILS,
        USER
    }

    public Object getDAO(DAOTypes daoTypes){
        switch (daoTypes){
            case BILLING:
                return new BillingImpl();
            case BOOKING_DETAILS:
                return new BookingDetailsImpl();
            case BOOKING:
                return new BookingImpl();
            case CUSTOMER:
                return new CustomerImpl();
            case DASHBOARD:
                return new DashboardImpl();
            case EMPLOYEE:
                return new EmployeeImpl();
            case PAYMENT:
                return new PaymentImpl();
            case ROOM_DETAILS:
                return new RoomDetailsImpl();
            case USER:
                return new UserImpl();
            default:
                return null;
        }

    }
}
