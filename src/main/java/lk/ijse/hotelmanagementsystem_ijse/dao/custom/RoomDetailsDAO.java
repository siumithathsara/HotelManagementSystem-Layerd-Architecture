package lk.ijse.hotelmanagementsystem_ijse.dao.custom;

import lk.ijse.hotelmanagementsystem_ijse.dao.CrudDAO;
import lk.ijse.hotelmanagementsystem_ijse.dto.RoomDetailsDTO;
import lk.ijse.hotelmanagementsystem_ijse.entity.RoomDetails;

import java.sql.SQLException;
import java.util.List;

public interface RoomDetailsDAO extends CrudDAO<RoomDetails> {
   /* public boolean saveRoom(RoomDetailsDTO dto) throws SQLException, ClassNotFoundException;
    public boolean updateRoom(RoomDetailsDTO dto) throws SQLException, ClassNotFoundException;
    public boolean deleteRoom(String roomId) throws SQLException, ClassNotFoundException;
    public RoomDetailsDTO searchRoom(String roomId) throws SQLException, ClassNotFoundException;
    public List<RoomDetailsDTO> getAllRooms() throws SQLException, ClassNotFoundException;*/
    public boolean updateRoomStatus(String roomId, String status)throws SQLException, ClassNotFoundException;
//    public String generateNextEmployeeId() throws SQLException;

}
