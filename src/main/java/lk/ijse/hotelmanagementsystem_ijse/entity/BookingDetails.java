package lk.ijse.hotelmanagementsystem_ijse.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BookingDetails {
    private String bookingId;
    private String roomId;
    private String checkInDate;
    private String checkOutDate;
}
