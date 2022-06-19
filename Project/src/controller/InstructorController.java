package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;

import dto.CourseDTO;
import dto.InstructorDTO;
import service.CourseService;
import service.InstructorService;
import view.ResultView;

public class InstructorController {
	private static InstructorController instance = new InstructorController();
	private InstructorService service = InstructorService.getInstance();

	private InstructorController() {
	}

	public static InstructorController getInstance() {
		return instance;
	}

	// 모든 강사 검색
	public void allInstructor() throws InputMismatchException {
		try {
			ResultView.instructorView(service.getAllInstructor());
		} catch (SQLException e) {
			ResultView.Error("조회 가능한 데이터가 존재하지 않습니다.");
			e.printStackTrace();
		}
	}

	// 이름으로 특정 강사 검색
	public void instructorView(String instructorName) throws InputMismatchException {
		try {
			ResultView.instructorVeiw(service.getInstructor(instructorName));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// update/delete를 위한 id값 체크
	public InstructorDTO checkInstructorId(int instructorId) throws InputMismatchException {
		try {
			return service.instructorIdCheck(instructorId);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	// 강사 정보 수정
	public void updateInstructor(InstructorDTO instructor, int num, String inputValue) throws InputMismatchException {
		try {
			ResultView.updateView(service.instructorUpdate(instructor, num, inputValue));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 강사 정보 추가
	public void insertInstructor(InstructorDTO instructor) throws InputMismatchException {
		try {
//			System.out.println("instructor : " + instructor);
			service.instructorInsert(instructor);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 강사 정보 삭제
	public void deleteInstructor(int instuctorId) throws InputMismatchException {
		try {
			service.instructorDelete(instuctorId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
