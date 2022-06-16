package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import utils.DBUtil;

public class CourseDAO {

	// 강의 정보 생성
	public static boolean addStudent(CourseDTO course, int instructorId ) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("insert into course values(?, ?, ?, ?, ?)");
			pstmt.setInt(1, course.getCourseId());
			pstmt.setString(2, course.getCourseName());
			pstmt.setDate(3, course.getStartDate());
			pstmt.setDate(4, course.getEndDate());
			pstmt.setInt(5, instructorId);
			
			int result = pstmt.executeUpdate();
		} finally {
			DBUtil.close(conn, pstmt);
		}
		
		return false;
	}
	
	// 강의 ID로 강의 정보 수정
		public static boolean updateCourse(int courseId, String courseName, Date startDate, Date endDate) throws SQLException {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = DBUtil.getConnection();

				pstmt = con.prepareStatement("updete course set course_name=?, start_date=?, end_date=? where course_id=?");
				pstmt.setString(1, courseName);
				pstmt.setDate(2, (java.sql.Date) startDate);
				pstmt.setDate(3, (java.sql.Date) endDate);
				pstmt.setInt(4, courseId);
				
				int result = pstmt.executeUpdate();
				if (result == 1) {
					return true;
				}
			} finally {
				DBUtil.close(con, pstmt);
			}
			return false;
		}


		// 강의 이름으로 강의 정보 삭제
		public static boolean deleteCourse(String courseName) throws SQLException {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = DBUtil.getConnection();
				pstmt = con.prepareStatement("delete from course where course_name=?");
				pstmt.setString(1, courseName);
				int result = pstmt.executeUpdate();
				if (result == 1) {
					return true;
				}
			} finally {
				DBUtil.close(con, pstmt);
			}
			return false;
		}

		// 강의 이름으로 강의 정보 검색
		public static CourseDTO getCourse(String courseName) throws SQLException {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			CourseDTO courseInfo = null;

			try {
				con = DBUtil.getConnection();
				pstmt = con.prepareStatement("select * from course where course_name=?");
				pstmt.setString(1, courseName);
				rset = pstmt.executeQuery();
				if (rset.next()) {
					courseInfo = new CourseDTO(rset.getInt(1), rset.getString(2), rset.getDate(3),rset.getDate(4), rset.getInt(5));
				}
			} finally {
				DBUtil.close(con, pstmt, rset);
			}
			return courseInfo;
		}

		// 모든 학생 검색
		public static ArrayList<CourseDTO> getAllCourse() throws SQLException {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			ArrayList<CourseDTO> list = null;
			try {
				con = DBUtil.getConnection();
				pstmt = con.prepareStatement("select * from course");
				rset = pstmt.executeQuery();

				list = new ArrayList<CourseDTO>();
				while (rset.next()) {
					list.add(new CourseDTO(rset.getInt(1), rset.getString(2), rset.getDate(3),rset.getDate(4), rset.getInt(5)));
				}
			} finally {
				DBUtil.close(con, pstmt, rset);
			}
			return list;
		} 
	

}

