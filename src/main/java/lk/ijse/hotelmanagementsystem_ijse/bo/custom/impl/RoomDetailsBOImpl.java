package lk.ijse.hotelmanagementsystem_ijse.bo.custom.impl;

import lk.ijse.hotelmanagementsystem_ijse.bo.custom.RoomDetailsBO;
import lk.ijse.hotelmanagementsystem_ijse.dao.DAOFactory;
import lk.ijse.hotelmanagementsystem_ijse.dao.custom.RoomDetailsDAO;
import lk.ijse.hotelmanagementsystem_ijse.dao.custom.impl.RoomDetailsImpl;
import lk.ijse.hotelmanagementsystem_ijse.dto.RoomDetailsDTO;
import lk.ijse.hotelmanagementsystem_ijse.entity.RoomDetails;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomDetailsBOImpl implements RoomDetailsBO {

    private RoomDetailsDAO roomDetailsDAO = (RoomDetailsDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ROOM_DETAILS);

    @Override
    public boolean saveRoom(RoomDetailsDTO roomDetailsDTO) throws Exception {
        return roomDetailsDAO.save(new RoomDetails(
                roomDetailsDTO.getRoomId(),
                roomDetailsDTO.getRoomType(),
                roomDetailsDTO.getPricePerRoom(),
                roomDetailsDTO.getStatus()

        ));
    }

    @Override
    public boolean updateRoom(RoomDetailsDTO roomDetailsDTO) throws Exception {
        return roomDetailsDAO.update(new RoomDetails(
                roomDetailsDTO.getRoomId(),
                roomDetailsDTO.getRoomType(),
                roomDetailsDTO.getPricePerRoom(),
                roomDetailsDTO.getStatus()
        ));
    }

    @Override
    public boolean deleteRoom(String roomId) throws Exception {
        return roomDetailsDAO.delete(roomId);
    }

    @Override
    public RoomDetailsDTO searchRoom(String roomId) throws Exception {
        RoomDetails roomDetails = roomDetailsDAO.search(roomId);
        return new RoomDetailsDTO(
                roomDetails.getRoomId(),
                roomDetails.getRoomType(),
                roomDetails.getPricePerRoom(),
                roomDetails.getStatus()
        );
    }

    @Override
    public List<RoomDetailsDTO> getAllRooms() throws SQLException, ClassNotFoundException {
        List<RoomDetails> roomDetails = roomDetailsDAO.getAll();
        List<RoomDetailsDTO> roomDetailsDTOs = new ArrayList<>();
        for (RoomDetails roomDetail : roomDetails) {
            RoomDetailsDTO roomDetailsDTO = new RoomDetailsDTO(
                    roomDetail.getRoomId(),
                    roomDetail.getRoomType(),
                    roomDetail.getPricePerRoom(),
                    roomDetail.getStatus()
            );

            roomDetailsDTOs.add(roomDetailsDTO);
        }
        return roomDetailsDTOs;
    }

    @Override
    public boolean updateRoomStatus(String roomId, String status) throws SQLException, ClassNotFoundException {
        return roomDetailsDAO.updateRoomStatus(roomId, status);
    }

    @Override
    public String generateNextEmployeeId() throws Exception {
        return roomDetailsDAO.generateNextId();
    }
}
