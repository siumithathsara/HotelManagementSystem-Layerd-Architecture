package lk.ijse.hotelmanagementsystem_ijse.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class RoomDetails {

    private String roomId;
    private String roomType;
    private double pricePerRoom;
    private String status;
}
