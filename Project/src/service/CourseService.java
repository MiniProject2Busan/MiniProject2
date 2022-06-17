package service;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.CourseDTO;
import exception.NotExistException;
import model.CourseDAO;

public class CourseService {

	private static CourseService instance = new CourseService();

	private CourseService() {
	}

	public static CourseService getInstance() {
		return instance;
	}

	public void notExistCourseName(String courseName) throws SQLException, NotExistException {
		CourseDTO course = CourseDAO.getCourseName(courseName);
		if (course == null) {
			throw new NotExistException("검색하신 강의 이름이 없습니다.");
		}
	}

	public void notExistCourseId(int courseId) throws SQLException, NotExistException {
		CourseDTO course = CourseDAO.getCourseId(courseId);
		if (course == null) {
			throw new NotExistException("검색하신 강의 Id가 없습니다.");
		}
	}

	// 모든 강의 정보 반환
	public ArrayList<CourseDTO> getAllCourse() throws SQLException {
		return CourseDAO.getAllCourse();
	}

	// 강의 이름으로 검색
	public CourseDTO getCourse(String courseName) throws SQLException, NotExistException {
		CourseDTO course = CourseDAO.getCourseName(courseName);
		if (course == null) {
			throw new NotExistException();
		}
		return course;
	}

	// 강사 id checker
	public CourseDTO getCourseCheckId(int courseId) throws SQLException, NotExistException {
		CourseDTO course = CourseDAO.getCourseId(courseId);
		if (course == null) {
			throw new NotExistException();
		}
		return course;
	}

	// 새로운 강의 저장
	public boolean addCourse(CourseDTO course, int instructorId) throws SQLException {
		return CourseDAO.addCourse(course, instructorId);
	}

	// 기존 강의 이름 수정
	public boolean updateCourseName(int courseId, String courseName) throws SQLException, NotExistException {
		notExistCourseId(courseId);
		boolean check = CourseDAO.updateCourseName(courseId, courseName);
		return check;
	}

	// 기존 강의 시작 일자 수정
	public boolean updateCourseStartDate(int courseId, Date startDate) throws SQLException, NotExistException {
		notExistCourseId(courseId);
		boolean check = CourseDAO.updateCourseStartDate(courseId, startDate);
		return check;
	}

	// 기존 강의 종료 일자 수정
	public boolean updateCourseEndDate(int courseId, Date endDate) throws SQLException, NotExistException {
		notExistCourseId(courseId);
		boolean check = CourseDAO.updateCourseEndDate(courseId, endDate);
		return check;
	}

	// 강의 이름으로 삭제
	public boolean deleteCourse(int courseId) throws SQLException, NotExistException {
		boolean check = CourseDAO.deleteCourse(courseId);
		return check;
	}

}
