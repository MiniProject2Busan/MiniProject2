package controller;

import java.sql.SQLException;
import java.util.Scanner;

import dto.InstructorDTO;
import model.InstructorDAO;
import service.InstructorService;
import view.TestInstructorEndView;

public class InstructorController {
	private static InstructorController instance = new InstructorController();
	private InstructorService service = InstructorService.getInstance();
	
	private InstructorController() {}
	
	public static InstructorController getInstance() {
		return instance;
	}
	
	// 이름으로 특정 강사 검색
	public void instructorView(String instructorName) {
		try {
			TestInstructorEndView.instructorVeiw(service.getInstructor(instructorName));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// update를 위한 checkid
	public InstructorDTO checkInstructorId(int instructorId) {
		try {
			return service.instructorIdCheck(instructorId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	// 강사 정보 수정
	public void updateInstructor(InstructorDTO instructor, int num,String name) {
		try {
			service.instructorUpdate(instructor, num, name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
//	// 연락처 수정
//	public void updateInstructorPhone() {
//		
//	}
}
