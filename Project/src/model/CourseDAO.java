package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.CourseDTO;
import utils.DBUtil;

public class CourseDAO {

	// 강의 정보 생성
	public static boolean addCourse(CourseDTO course) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(
					"insert into course(course_name, start_date, end_date, instructor_instructor_id) values(?, ?, ?, ?)");
			pstmt.setString(1, course.getCourseName());
			pstmt.setDate(2, (Date) course.getStartDate());
			pstmt.setDate(3, (Date) course.getEndDate());
			pstmt.setInt(4, course.getInstructorId());

			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(conn, pstmt);
		}

		return false;
	}

	public static boolean updateCourse(int courseId, int selectNum, String modify)
			throws SQLException, IllegalArgumentException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtil.getConnection();

			if (selectNum == 1) {
				pstmt = conn.prepareStatement("update course set course_name=? where course_id=?");
				pstmt.setString(1, modify);
				pstmt.setInt(2, courseId);

			} else if (selectNum == 2) {
				pstmt = conn.prepareStatement("update course set start_date=? where course_id=?");
				pstmt.setDate(1, Date.valueOf(modify));
				pstmt.setInt(2, courseId);

			} else {
				pstmt = conn.prepareStatement("update course set end_date=? where course_id=?");
				pstmt.setDate(1, Date.valueOf(modify));
				pstmt.setInt(2, courseId);

			}
			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}

		} finally {
			DBUtil.close(conn, pstmt);
		}
		return false;
	}

	// 강의 Id로 강의 정보 삭제
	public static boolean deleteCourse(int courseId) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("delete from course where course_id=?");
			pstmt.setInt(1, courseId);
			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(conn, pstmt);
		}
		return false;
	}

	// 강의 이름으로 강의 정보 검색
	public static CourseDTO getCourseName(String courseName) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		CourseDTO courseInfo = null;

		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("select * from course where course_name=?");
			pstmt.setString(1, courseName);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				courseInfo = new CourseDTO(rset.getInt(1), rset.getString(2), rset.getDate(3), rset.getDate(4),
						rset.getInt(5));
			}
		} finally {
			DBUtil.close(conn, pstmt, rset);
		}
		return courseInfo;
	}

	// 강의 이름으로 강의 정보 검색
	public static CourseDTO getCourseId(int courseId) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		CourseDTO courseInfo = null;

		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("select * from course where course_id=?");
			pstmt.setInt(1, courseId);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				courseInfo = new CourseDTO(rset.getInt(1), rset.getString(2), rset.getDate(3), rset.getDate(4),
						rset.getInt(5));
			}
		} finally {
			DBUtil.close(conn, pstmt, rset);
		}
		return courseInfo;
	}

	// 모든 강의 검색
	public static ArrayList<CourseDTO> getAllCourse() throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<CourseDTO> list = null;
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("select * from course");
			rset = pstmt.executeQuery();

			list = new ArrayList<CourseDTO>();
			while (rset.next()) {
				list.add(new CourseDTO(rset.getInt(1), rset.getString(2), rset.getDate(3), rset.getDate(4),
						rset.getInt(5)));
			}
		} finally {
			DBUtil.close(conn, pstmt, rset);
		}
		return list;
	}

}
