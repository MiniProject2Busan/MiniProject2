package service;

import java.sql.SQLException;
import java.util.ArrayList;

import dto.CourseDTO;
import model.CourseDAO;

public class CourseService {

	private static CourseService instance = new CourseService();

	private CourseService() {
	}

	public static CourseService getInstance() {
		return instance;
	}

	// 모든 강의 정보 반환
	public ArrayList<CourseDTO> getAllCourse() throws SQLException {
		return CourseDAO.getAllCourse();
	}

	// 강의 이름으로 검색
	public CourseDTO getCourse(String courseName) throws SQLException {
		CourseDTO course = CourseDAO.getCourseName(courseName);
		return course;
	}

	// 강사 id checker
	public CourseDTO checkCourseId(int courseId) throws SQLException {
		return CourseDAO.getCourseId(courseId);

	}

	// 새로운 강의 저장
	public boolean addCourse(CourseDTO course) throws SQLException, IllegalArgumentException {
		return CourseDAO.addCourse(course);
	}

	public boolean updateCourse(int courseId, int selectNum, String modify)
			throws SQLException, IllegalArgumentException {
		return CourseDAO.updateCourse(courseId, selectNum, modify);
	}

	// id로 삭제
	public boolean deleteCourse(int courseId) throws SQLException {
		return CourseDAO.deleteCourse(courseId);
	}

}
