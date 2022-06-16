package model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.StudentDTO;
import utils.DBUtil;

public class StudentDAO {

	// 학생 정보 생성
	public static boolean addStudent(StudentDTO student, int managerId ) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("insert into student values(?, ?, ?, ?, ?, ?, ?, ?, ?)");
			pstmt.setInt(1, student.getId());
			pstmt.setString(2, student.getName());
			pstmt.setInt(3, student.getAge());
			pstmt.setString(4, student.getPhone());
			pstmt.setString(5, student.getAddr());
			pstmt.setString(6, student.getSeatId());
			pstmt.setInt(7, student.getAttendance());
			pstmt.setInt(8, student.getAbsent());
			pstmt.setInt(9, managerId);
			pstmt.executeUpdate();
//			int result = pstmt.executeUpdate();
		} finally {
			DBUtil.close(conn, pstmt);
		}
		return false;
	}
	
	// 학생 ID로 담당자 정보 수정 - 보류
//		public static boolean updateStudent() throws SQLException {
//			Connection con = null;
//			PreparedStatement pstmt = null;
//			try {
//				con = DBUtil.getConnection();
//
//				pstmt = con.prepareStatement("query");
//				pstmt.setString(1, x);
//				
//				int result = pstmt.executeUpdate();
//				if (result == 1) {
//					return true;
//				}
//			} finally {
//				DBUtil.close(con, pstmt);
//			}
//			return false;
//		}

		// 학생 ID로 학생 정보 삭제
		public static boolean deleteStudent(String managerId) throws SQLException {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = DBUtil.getConnection();
				pstmt = con.prepareStatement("delete from student where student_id=?");
				pstmt.setString(1, managerId);
				int result = pstmt.executeUpdate();
				if (result == 1) {
					return true;
				}
			} finally {
				DBUtil.close(con, pstmt);
			}
			return false;
		}

		// 학생 ID로 학생 정보 검색
		public static StudentDTO getStudent(String studentId) throws SQLException {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			StudentDTO studentInfo = null;

			try {
				con = DBUtil.getConnection();
				pstmt = con.prepareStatement("select * from student where student_name=?");
				pstmt.setString(1, studentId);
				rset = pstmt.executeQuery();
				if (rset.next()) {
					studentInfo = new StudentDTO(rset.getInt(1), rset.getString(2), rset.getInt(3),
							rset.getString(4), rset.getString(5), rset.getString(6),rset.getInt(7),
							rset.getInt(8), rset.getInt(9));
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
			ArrayList<StudentDTO> allStudent = null;
			try {
				con = DBUtil.getConnection();
				pstmt = con.prepareStatement("select * from student");
				rset = pstmt.executeQuery();
				
				allStudent = new ArrayList<StudentDTO>();
				while (rset.next()) {
					allStudent.add(new StudentDTO(rset.getInt(1), rset.getString(2), rset.getInt(3),
							rset.getString(4), rset.getString(5), rset.getString(6),rset.getInt(7),
							rset.getInt(8), rset.getInt(9)));
				}
			} finally {
				DBUtil.close(con, pstmt, rset);
			}
			return allStudent;
		} 
	

}
