package lk.ijse.hotelmanagementsystem_ijse.dao.custom;

import lk.ijse.hotelmanagementsystem_ijse.dto.UserDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface UserDAO {
    public boolean saveUser(UserDTO userDTO) throws SQLException, ClassNotFoundException;
    public boolean updateUser(UserDTO userDTO) throws SQLException, ClassNotFoundException;
    public boolean deleteUser(String userId) throws SQLException, ClassNotFoundException;
    public UserDTO searchUser(String username, String password) throws SQLException, ClassNotFoundException;
    public boolean updateUserStatus(String userId, String status) throws SQLException, ClassNotFoundException;
    public String getLastUserId() throws SQLException, ClassNotFoundException;
    public ArrayList<UserDTO> getAllUsers() throws SQLException, ClassNotFoundException;

}

