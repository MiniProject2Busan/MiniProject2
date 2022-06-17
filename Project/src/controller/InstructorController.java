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
	
	// update/delete를 위한 id값 체크
	public InstructorDTO checkInstructorId(int instructorId) {
		try {
			return service.instructorIdCheck(instructorId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	// 강사 정보 수정
	public void updateInstructor(InstructorDTO instructor, int num, String inputValue) {
		try {
			service.instructorUpdate(instructor, num, inputValue);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 강사 정보 추가
	public void insertInstructor(InstructorDTO instructor) {
		try {
			service.instructorInsert(instructor);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 강사 정보 삭제
	public void deleteInstructor(int instuctorId) {
		try {
			service.instructorDelete(instuctorId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
