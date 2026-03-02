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

    public RoomDetails(String roomType, double pricePerRoom, String status) {

                this.roomType=roomType;
                this.pricePerRoom=pricePerRoom;
                this.status=status;
    }
}
