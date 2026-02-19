package lk.ijse.hotelmanagementsystem_ijse.dao.custom.impl;

import lk.ijse.hotelmanagementsystem_ijse.dao.custom.RoomDetailsDAO;
import lk.ijse.hotelmanagementsystem_ijse.entity.RoomDetails;
import lk.ijse.hotelmanagementsystem_ijse.dao.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomDetailsImpl  implements RoomDetailsDAO {
    public boolean save(RoomDetails roomDetails) throws SQLException, ClassNotFoundException {

        String sql = "INSERT INTO Room_Details (room_id, room_type, price_per_room, status) " +
                "VALUES (?,?,?,?)";

        return CrudUtil.execute(
                sql,
                roomDetails.getRoomId(),
                roomDetails.getRoomType(),
                roomDetails.getPricePerRoom(),
                roomDetails.getStatus()
        );
    }

    public boolean update(RoomDetails roomDetails) throws SQLException, ClassNotFoundException {

        String sql = "UPDATE Room_Details SET room_type=?, price_per_room=?, status=? " +
                "WHERE room_id=?";

        return CrudUtil.execute(
                sql,
                roomDetails.getRoomType(),
                roomDetails.getPricePerRoom(),
                roomDetails.getStatus(),
                roomDetails.getRoomId()
        );
    }

    public boolean delete(String roomId) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM Room_Details WHERE room_id=?";
        return CrudUtil.execute(sql, roomId);
    }

    public RoomDetails search(String roomId) throws SQLException, ClassNotFoundException {

        String sql = "SELECT * FROM Room_Details WHERE room_id=?";
        ResultSet rs = CrudUtil.execute(sql, roomId);

        if (rs.next()) {
            return new RoomDetails(
                    rs.getString("room_id"),
                    rs.getString("room_type"),
                    rs.getDouble("price_per_room"),
                    rs.getString("status")
            );
        }
        return null;
    }

    public List<RoomDetails> getAll() throws SQLException, ClassNotFoundException {

        ResultSet rs = CrudUtil.execute("SELECT * FROM Room_Details ORDER BY room_id DESC");
        List<RoomDetails> roomList = new ArrayList<>();

        while (rs.next()) {
            roomList.add(
                    new RoomDetails(
                            rs.getString("room_id"),
                            rs.getString("room_type"),
                            rs.getDouble("price_per_room"),
                            rs.getString("status")
                    )
            );
        }
        return roomList;
    }



    public boolean updateRoomStatus(String roomId, String status)
            throws SQLException, ClassNotFoundException {

        String sql = "UPDATE Room_Details SET status=? WHERE room_id=?";
        return CrudUtil.execute(sql, status, roomId);
    }

    public List<RoomDetails> getAvailableRooms()
            throws SQLException, ClassNotFoundException {

        String sql = "SELECT * FROM Room_Details WHERE status='Available'";
        ResultSet rs = CrudUtil.execute(sql);

        List<RoomDetails> availableRooms = new ArrayList<>();
        while (rs.next()) {
            availableRooms.add(
                    new RoomDetails(
                            rs.getString("room_id"),
                            rs.getString("room_type"),
                            rs.getDouble("price_per_room"),
                            rs.getString("status")
                    )
            );
        }
        return availableRooms;
    }

    public String generateNextId() throws SQLException {
        ResultSet rs = CrudUtil.execute(
                "SELECT room_id FROM Room_Details ORDER BY room_id DESC LIMIT 1"
        );

        if (rs.next()) {
            String lastId = rs.getString(1); // E.g., C005
            int number = Integer.parseInt(lastId.substring(1));
            number++;
            return String.format("R%03d", number);
        }
        return "R001";
    }
}
