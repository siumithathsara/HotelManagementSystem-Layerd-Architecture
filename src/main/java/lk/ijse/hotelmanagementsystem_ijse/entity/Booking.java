package lk.ijse.hotelmanagementsystem_ijse.entity;

import lk.ijse.hotelmanagementsystem_ijse.dto.BookingDetailsDTO;
import lombok.*;

import java.time.LocalTime;
import java.sql.Date;

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

    public Booking(String bookingId, String customerId, Date checkinDate, String specialNote, String status, String createdAt) {
            this.booking_id=bookingId;
            this.customer_id=customerId;
            this.booking_date=checkinDate;
            this.special_note=specialNote;
            this.status=status;
            this.created_by=createdAt;
           // this.bookingDetails= new BookingDetailsDTO();

    }

//    public Booking(String bookingId, String customerId, java.sql.Date bookingDate, LocalTime bookingTime, String specialNote, String status, String createdBy, LocalDateTime createdAt) {
//                                                    this.booking_id=bookingId;
//                                                    this.customer_id=customerId;
//                                                    this.booking_date=bookingDate;
//
//                                                    this.booking_time=bookingTime;
//                                                    this.special_note=specialNote;
//                                                    this.status=status;
//                                                    this.created_by=createdBy;
//                                                    this.
//    }

    public Booking(String booking_id, String customer_id, Date booking_date, String status, BookingDetails bookingDetails) {
        this.booking_id = booking_id;
        this.customer_id = customer_id;
        this.booking_date = booking_date;
        this.status = status;
        this.bookingDetails = bookingDetails;
    }

    public Booking(String bookingId, String customerId, Date bookingDate, LocalTime bookingTime, String specialNote, String status, String createdBy) {
        this.booking_id = bookingId;
        this.customer_id = customerId;
        this.booking_date = bookingDate;
        this.booking_time = bookingTime;
        this.special_note = specialNote;
        this.status = status;
        this.created_by=createdBy;

    }

//    public Booking(String bookingId, String customerId, Date bookingDate, String status, BookingDetailsDTO bookingDetails) {
//                                    this.booking_id = bookingId;
//                                    this.customer_id = customerId;
//                                    this.booking_date = bookingDate;
//                                    this.status = status;
//
//    }

    public Booking(String bookingId, String customerId, Date bookingDate, String status) {
        this.booking_id = bookingId;
        this.customer_id = customerId;
        this.booking_date = bookingDate;
        this.status = status;
    }

    public Booking(String customer_id, Date bookingDate, String status, String bookingId) {
            this.customer_id = customer_id;
            this.booking_date = bookingDate;
            this.status = status;
            this.booking_id=bookingId;
    }
}
