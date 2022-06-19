package controller;

import java.sql.Date;
import java.sql.SQLException;

import dto.CourseDTO;
import service.CourseService;
import view.ResultView;
import view.RunningSuccessView;

public class CourseController {
	private static CourseController instance = new CourseController();

	private CourseService service = CourseService.getInstance();

	private CourseController() {
	}

	public static CourseController getInstance() {
		return instance;
	}

	public void addCourse(String courseName, String startDate, String endDate, int instructorId) {
		try {
			CourseDTO course = new CourseDTO(courseName, Date.valueOf(startDate), Date.valueOf(endDate), instructorId);
			service.addCourse(course);
		} catch (SQLException e) {
			int error = e.getErrorCode();

			if (error == 1406) {
				RunningEndView.Error("강의명은 최대 10글자 입니다.");
			} else if (error == 1452) {
				RunningEndView.Error("해당하는 강사가 없습니다.");
			} else {
				RunningEndView.Error("강의 정보 추가가 실패하였습니다.");
			}
		} catch (IllegalArgumentException e) {
			RunningEndView.Error("형식이 맞지 않습니다.");
		}
	}

	// 모든 강의 검색
	public void allCourse() {
		try {
			ResultView.allListView(service.getAllCourse());
		} catch (SQLException e) {
			e.printStackTrace();
			ResultView.Error("모든 강의 검색시 ERROR");
		}
	}

	// 특정 강의 검색
	public void selectCourse(String courseName) {
		try {
			ResultView.courseView(service.getCourse(courseName));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// id checker
	public CourseDTO checkCourseId(int courseId) {
		try {
			return service.checkCourseId(courseId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void updateCourse(int courseId, int selectNum, String modify) {
		try {

			if (service.updateCourse(courseId, selectNum, modify)) {
				RunningSuccessView.showSuccess("수정이 완료되었습니다.");
			} else {
				RunningEndView.Error("존재하지 않는 강의입니다.");
			}
		} catch (SQLException e) {
			int error = e.getErrorCode();

			if (error == 1406) {
				RunningEndView.Error("강의명은 최대 10글자 입니다.");
			} else {
				RunningEndView.Error("강의 정보 수정이 실패하였습니다.");
			}
		} catch (IllegalArgumentException e) {
			RunningEndView.Error("형식이 맞지 않습니다.");
		}
	}

	// 강의 삭제
	public void deleteCourse(int courseId) {
		try {
			if (service.deleteCourse(courseId)) {
				RunningSuccessView.showSuccess("입력한 강의 삭제 성공!");
			} else {
				RunningEndView.Error("존재하지 않는 강의입니다.");
			}
		} catch (SQLException e) {
			RunningEndView.Error("삭제에 실패했습니다.");
		}
	}

}