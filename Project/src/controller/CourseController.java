package controller;

import java.sql.Date;
import java.sql.SQLException;

import exception.NotExistException;
import service.CourseService;
import view.RunningEndView;
import view.RunningSuccessView;

public class CourseController {
	private static CourseController instance = new CourseController();

	private CourseService service = CourseService.getInstance();

	private CourseController() {
	}

	public static CourseController getInstance() {
		return instance;
	}

	// 모등 강의 검색
	public void allCourse() {
		try {
			RunningEndView.courseListView(service.getAllCourse());
			RunningSuccessView.showSuccess("모든 강의 검색 성공!");
		} catch (SQLException e) {
			e.printStackTrace();
			RunningEndView.Error("모든 강의 검색시 ERROR");
		}
	}

	// 특정 강의 검색
	public void Course(String courseName) {
		try {
			RunningEndView.courseView(service.getCourse(courseName));
			RunningSuccessView.showSuccess("입력한 강의 검색 성공!");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NotExistException e) {
			e.printStackTrace();
		}
	}

	// 강의 이름 업데이트
	public void updateCourseName(int courseId, String courseName) {
		try {
			RunningEndView.updateCourseNameView(service.updateCourseName(courseId, courseName));
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NotExistException e) {
			e.printStackTrace();
		}

	}

	// 강의 시작 일자 업데이트
	public void updateCourseStartDate(int courseId, Date startDate) {
		try {
			RunningEndView.updateCourseStartDateView(service.updateCourseStartDate(courseId, startDate));
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NotExistException e) {
			e.printStackTrace();
		}

	}

	// 강의 종료 일자 업데이트
	public void updateCourseEndDate(int courseId, Date endDate) {
		try {
			RunningEndView.updateCourseEndDateView(service.updateCourseEndDate(courseId, endDate));
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NotExistException e) {
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
		} catch (NotExistException e) {
			e.printStackTrace();
		}
	}

}