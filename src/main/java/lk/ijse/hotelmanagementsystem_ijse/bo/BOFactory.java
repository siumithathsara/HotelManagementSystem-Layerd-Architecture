package lk.ijse.hotelmanagementsystem_ijse.bo;

import lk.ijse.hotelmanagementsystem_ijse.bo.custom.impl.*;
import lk.ijse.hotelmanagementsystem_ijse.dao.DAOFactory;
import lk.ijse.hotelmanagementsystem_ijse.dao.custom.impl.*;

public class BOFactory {
    public static BOFactory boFactory;

    private BOFactory() {}

    public static BOFactory getInstance() {
        return boFactory == null ? new BOFactory() : boFactory;
    }

    public enum BOTypes{
        BILLING,
        RESERVATION,
        BOOKING,
        CUSTOMER,
        DASHBOARD,
        EMPLOYEE,
        PAYMENT,
        ROOM_DETAILS,
        USER
    }

    public Object getBO(BOTypes boTypes){
        switch (boTypes){
            case RESERVATION:
                return new ReservationBOImpl();
            case BOOKING:
                return new BookingBOImpl();
            case CUSTOMER:
                return new CustomerBOImpl();
            case DASHBOARD:
                return new DashboardBOImpl();
            case EMPLOYEE:
                return new EmployeeBOImpl();
            case PAYMENT:
                return new PaymentBOImpl();
            case ROOM_DETAILS:
                return new RoomDetailsBOImpl();
//            case USER:
//                return new UserBOImpl();
            default:
                return null;
        }

    }
}
