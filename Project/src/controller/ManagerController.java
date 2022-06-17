package controller;

import java.sql.SQLException;

import dto.InstructorDTO;
import dto.ManagerDTO;
import service.ManagerService;
import view.RunningEndView;
import view.TestEndView;

public class ManagerController {
	private static ManagerController instance = new ManagerController();
	private ManagerService service = ManagerService.getInstance();
	
	private ManagerController() {}
	
	public static ManagerController getInstance() {
		return instance;
	}
	
	// 모든 담당자 검색
	public void allManager() {
		try {
			RunningEndView.managerView(service.getAllmanager());
		} catch (SQLException s) {
			System.out.println(s);
		}
	}
	
	// 이름으로 특정 담당자 검색
	public void managerView(String managerName) {
		try {
			RunningEndView.managerView(service.getManager(managerName));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// update/delete를 위한 id값 체크
	public ManagerDTO checkManagerId(int managerId) {
		try {
			return service.managerIdCheck(managerId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	// 담당자 정보 수정
	public void updateManager(ManagerDTO manager, int num, String inputValue) {
		try {
			RunningEndView.updateView(service.managerUpdate(manager, num, inputValue));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 담당자 정보 추가
	public void insertManager(ManagerDTO manager) {
		try {
			service.managerInsert(manager);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 담당자 정보 삭제
	public void deleteManager(int managerId) {
		try {
			service.managerDelete(managerId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
