package lk.ijse.hotelmanagementsystem_ijse.entity;

import lombok.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Booking {
    private String booking_id;
    private String customer_id;
    private Date booking_date;
    private LocalTime booking_time;
    private String special_note;
    private String status;
    private String created_by;
    private BookingDetails bookingDetails;

    public Booking(String bookingId, String customerId, java.sql.Date checkinDate, String specialNote, String status, LocalDateTime createdAt) {
            this.booking_id=bookingId;
            this.customer_id=customerId;
            this.booking_date=checkinDate;
            this.special_note=specialNote;
            this.status=status;
            this.created_by=createdAt.getDayOfWeek().toString();
           // this.bookingDetails= new BookingDetailsDTO();

    }

    public Booking(String bookingId, String customerId, java.sql.Date bookingDate, LocalTime bookingTime, String specialNote, String status, String createdBy, LocalDateTime createdAt) {
                                                    this.booking_id=bookingId;
                                                    this.customer_id=customerId;
                                                    this.booking_date=bookingDate;

                                                    this.booking_time=bookingTime;
                                                    this.special_note=specialNote;
                                                    this.status=status;
                                                    this.created_by=createdBy;
                                                    this.bookingDetails=new BookingDetails();
    }
}
