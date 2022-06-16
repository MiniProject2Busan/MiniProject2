package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import utils.DBUtil;

public class StudentDAO {

	// 학생 정보 생성
	public static boolean addStudent(StudentDTO student, int managerId ) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("insert into student values(?, ?, ?, ?, ?, ?, ?, ?, ?)");
			pstmt.setInt(1, student.getStudentId());
			pstmt.setString(2, student.getStudentName());
			pstmt.setInt(3, student.getStudentAge());
			pstmt.setString(4, student.getStudentPhone());
			pstmt.setString(5, student.getStudentaddr());
			pstmt.setString(6, student.getStudentSeatId());
			pstmt.setString(7, student.getStudentAttendance());
			pstmt.setString(8, student.getStudentAbsent());
			pstmt.setInt(9, managerId);
			
			int result = pstmt.executeUpdate();
		} finally {
			DBUtil.close(conn, pstmt);
		}
		
		return false;
	}
	
	// 학생 ID로 학생 정보(번호, 주소) 수정
		public static boolean updateStudent(int studentId, String studentName, String studentPhone) throws SQLException {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = DBUtil.getConnection();

				pstmt = con.prepareStatement("updete student set student_name=?, student_phone=? where student_id=?");
				pstmt.setString(1, studentName);
				pstmt.setString(2, studentPhone);
				pstmt.setInt(3, studentId);
				
				int result = pstmt.executeUpdate();
				if (result == 1) {
					return true;
				}
			} finally {
				DBUtil.close(con, pstmt);
			}
			return false;
		}


		// 학생 이름으로 학생 정보 삭제
		public static boolean deleteStudent(String managerName) throws SQLException {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = DBUtil.getConnection();
				pstmt = con.prepareStatement("delete from student where student_name=?");
				pstmt.setString(1, managerName);
				int result = pstmt.executeUpdate();
				if (result == 1) {
					return true;
				}
			} finally {
				DBUtil.close(con, pstmt);
			}
			return false;
		}

		// 학생 이름으로 학생 정보 검색
		public static StudentDTO getStudent(String studentName) throws SQLException {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			StudentDTO studentInfo = null;

			try {
				con = DBUtil.getConnection();
				pstmt = con.prepareStatement("select * from student where student_name=?");
				pstmt.setString(1, studentName);
				rset = pstmt.executeQuery();
				if (rset.next()) {
					studentInfo = new StudnetDTO(rset.getString(1), rset.getString(2), rset.getString(3),rset.getString(4), rset.getString(5), rset.getString(6),rset.getString(7), rset.getString(8), rset.getString(9));
				}
			} finally {
				DBUtil.close(con, pstmt, rset);
			}
			return studentInfo;
		}

		// 모든 학생 검색
		public static ArrayList<StudentDTO> getAllStudent() throws SQLException {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			ArrayList<StudentDTO> list = null;
			try {
				con = DBUtil.getConnection();
				pstmt = con.prepareStatement("select * from student");
				rset = pstmt.executeQuery();

				list = new ArrayList<StudentDTO>();
				while (rset.next()) {
					list.add(new StudentDTO(rset.getString(1), rset.getString(2), rset.getString(3),rset.getString(4), rset.getString(5), rset.getString(6),rset.getString(7), rset.getString(8), rset.getString(9)));
				}
			} finally {
				DBUtil.close(con, pstmt, rset);
			}
			return list;
		} 
	

}
