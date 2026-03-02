package lk.ijse.hotelmanagementsystem_ijse.bo.custom;

import lk.ijse.hotelmanagementsystem_ijse.dto.RoomDetailsDTO;

import java.sql.SQLException;
import java.util.List;

public interface RoomDetailsBO {
    public boolean saveRoom(RoomDetailsDTO dto) throws Exception;
    public boolean updateRoom(RoomDetailsDTO dto) throws Exception;
    public boolean deleteRoom(String roomId) throws Exception;
    public RoomDetailsDTO searchRoom(String roomId) throws Exception;
    public List<RoomDetailsDTO> getAllRooms() throws SQLException, ClassNotFoundException;
    public boolean updateRoomStatus(String roomId, String status)throws SQLException, ClassNotFoundException;
    public String generateNextEmployeeId() throws Exception;
}
