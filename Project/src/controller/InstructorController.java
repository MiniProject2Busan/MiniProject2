package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;

import dto.CourseDTO;
import dto.InstructorDTO;
import service.CourseService;
import service.InstructorService;
import view.RunningEndView;

public class InstructorController {
	private static InstructorController instance = new InstructorController();
	private InstructorService service = InstructorService.getInstance();
	private CourseService courseService = CourseService.getInstance();

	private InstructorController() {
	}

	public static InstructorController getInstance() {
		return instance;
	}

	// 모든 강사 검색
	public void allInstructor() throws InputMismatchException {
		try {
			RunningEndView.instructorView(service.getAllInstructor());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 이름으로 특정 강사 검색
	public void instructorView(String instructorName) throws InputMismatchException {
		try {
			RunningEndView.instructorVeiw(service.getInstructor(instructorName));
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
			RunningEndView.updateView(service.instructorUpdate(instructor, num, inputValue));
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
			// 해당 강의 삭제
			ArrayList<CourseDTO> course = courseService.getAllCourse();
			// instructorId로 courseName 검색
			for (int i = 0; i < courseService.getAllCourse().size(); i++) {
//				System.out.println("in : " + instuctorId);
				if (instuctorId == course.get(i).getInstructorId()) {
					courseService.deleteCourse(course.get(i).getCourseId());
					// 강사 삭제
				}
			}

			service.instructorDelete(instuctorId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
