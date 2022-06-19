package service;

import java.sql.SQLException;
import java.util.ArrayList;

import dto.ManagerDTO;
import model.ManagerDAO;

public class ManagerService{
	private static ManagerService instance = new ManagerService();
	
	private ManagerService() {}
	
	public static ManagerService getInstance() {
		return instance;
	}

	// manager 모든 정보 출력
	public ArrayList<ManagerDTO> getAllmanager() throws SQLException {
		return ManagerDAO.getAllManager(); // Arraylist
	}
	
	// manager 이름으로 검색
	public ManagerDTO getManager(String managerName) throws SQLException {
		return ManagerDAO.getManager(managerName);
	}
	
	// 디비에 수정할 데이터 있는지 확인
	public ManagerDTO managerIdCheck(int managerId) throws SQLException {
		return ManagerDAO.getManager(managerId);
	}
	
	// 이름 수정
	public boolean managerUpdate(ManagerDTO manager, int num, String inputValue) throws SQLException {
		return ManagerDAO.updateManager(manager, num, inputValue);
	}
	
	// 새로운 담당자 저장
	public boolean managerInsert(ManagerDTO manager) throws SQLException {
		return ManagerDAO.addManager(manager);
	}
	
	// 강사 삭제
	public boolean managerDelete(int managerId) throws SQLException {
		return ManagerDAO.deleteManager(managerId);
	}
}
