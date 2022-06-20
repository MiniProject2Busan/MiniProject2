package controller;

import java.sql.SQLException;

import dto.ManagerDTO;
import service.ManagerService;
import view.ResultView;

public class ManagerController {
	private static ManagerController instance = new ManagerController();
	private ManagerService service = ManagerService.getInstance();

	private ManagerController() {
	}

	public static ManagerController getInstance() {
		return instance;
	}

	// 모든 담당자 검색
	public void allManager() {
		try {
			ResultView.allListView(service.getAllmanager());
		} catch (SQLException e) {
			System.out.println(e); 
		}
	}

	// 이름으로 특정 담당자 검색
	public void managerView(String managerName) {
		try {
			ResultView.managerView(service.getManager(managerName));
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
			ResultView.updateView(service.managerUpdate(manager, num, inputValue));
//			ResultView.managerView(manager);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 담당자 정보 추가
	public void insertManager(ManagerDTO manager) {
		try {
			if(service.managerInsert(manager)) {
				System.out.println("정보 추가 성공");
			}else{
				System.out.println("정보 추가 실패");
			};
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
