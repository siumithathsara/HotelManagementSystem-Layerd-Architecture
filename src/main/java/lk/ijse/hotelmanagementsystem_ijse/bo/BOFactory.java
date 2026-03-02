package lk.ijse.hotelmanagementsystem_ijse.bo;

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
        BOOKING_DETAILS,
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
