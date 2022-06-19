package service;

import java.sql.SQLException;
import java.util.ArrayList;
// 업데이트는 파라미터의 개수가 다 다르기 때문에 인터페이스 구현 불가능
public interface ServiceInteface {
	public ArrayList<?> getAll() throws SQLException;
	public Object getOne(String name) throws SQLException;
	public void insertPeople(Object obj) throws SQLException;
	public boolean deletePeople(int id) throws SQLException;
}
