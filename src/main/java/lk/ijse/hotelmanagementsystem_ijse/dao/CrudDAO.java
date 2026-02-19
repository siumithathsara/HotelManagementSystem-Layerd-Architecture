package lk.ijse.hotelmanagementsystem_ijse.dao;

import lk.ijse.hotelmanagementsystem_ijse.dto.CustomerDTO;

import java.sql.SQLException;
import java.util.List;

public interface CrudDAO<T> extends SuperDAO {
    public boolean save(T dto) throws Exception;
    public boolean update(T dto) throws Exception;
    public boolean delete(String id) throws Exception;
    public T search(String id) throws Exception;
    public List<T> getAll() throws SQLException, ClassNotFoundException;
    public String generateNextId() throws Exception;
}
