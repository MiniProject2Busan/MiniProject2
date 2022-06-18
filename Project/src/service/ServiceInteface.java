package service;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ServiceInteface {
	public ArrayList<?> getAll() throws SQLException;
	public Object getOne(String name) throws SQLException;
	public void insertPeople(Object obj) throws SQLException;
	public void deletePeople(int id) throws SQLException;
}
