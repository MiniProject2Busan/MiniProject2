package controller;

import java.sql.Date;
import java.sql.SQLException;

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

	// 모든 강의 검색
	public void allCourse() {
		try {
			ResultView.courseListView(service.getAllCourse());
			RunningSuccessView.showSuccess("모든 강의 검색 성공!");
		} catch (SQLException e) {
			e.printStackTrace();
			ResultView.Error("모든 강의 검색시 ERROR");
		}
	}

	// 특정 강의 검색
	public void Course(String courseName) {
		try {
			ResultView.courseView(service.getCourse(courseName));
			RunningSuccessView.showSuccess("입력한 강의 검색 성공!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 강의 이름 업데이트
	public void updateCourseName(int courseId, String courseName) {
		try {
			ResultView.updateCourseNameView(service.updateCourseName(courseId, courseName));
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// 강의 시작 일자 업데이트
	public void updateCourseStartDate(int courseId, Date startDate) {
		try {
			ResultView.updateCourseStartDateView(service.updateCourseStartDate(courseId, startDate));
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// 강의 종료 일자 업데이트
	public void updateCourseEndDate(int courseId, Date endDate) {
		try {
			ResultView.updateCourseEndDateView(service.updateCourseEndDate(courseId, endDate));
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// 강의 삭제
	public void deleteCourse(String courseName) {
		try {
			service.deleteCourse(courseName);
			RunningSuccessView.showSuccess("입력한 강의 삭제 성공!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}