package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import utils.DBUtil;

public class InstructorDAO {

	// 강사 정보 생성
	public static boolean addInstructor(InstructorDTO instructor) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("insert into instructor values(?, ?, ?)");
			pstmt.setString(1, instructor.getInstructorId());
			pstmt.setString(2, instructor.getInstructorName());
			pstmt.setString(3, instructor.getInstructorPhone());
			
			int result = pstmt.executeUpdate();
		} finally {
			DBUtil.close(conn, pstmt);
		}
		
		return false;
	}
	
	// 강사 ID로 강사 정보 수정
		public static boolean updateInstructor(String instructorId, String instructorName, String instructorPhone) throws SQLException {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = DBUtil.getConnection();

				pstmt = con.prepareStatement("update instructor set instructor_name=?, instructor_phone=? where instructor_id=?");
				pstmt.setString(1, instructorName);
				pstmt.setString(2, instructorPhone);
				pstmt.setString(3, instructorId);
				
				int result = pstmt.executeUpdate();
				if (result == 1) {
					return true;
				}
			} finally {
				DBUtil.close(con, pstmt);
			}
			return false;
		}


		// 강사 ID로 강사 정보 삭제
		public static boolean deleteInstructor(String instructorId) throws SQLException {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = DBUtil.getConnection();
				pstmt = con.prepareStatement("delete from instructor where instructor_id=?");
				pstmt.setString(1, instructorId);
				int result = pstmt.executeUpdate();
				if (result == 1) {
					return true;
				}
			} finally {
				DBUtil.close(con, pstmt);
			}
			return false;
		}

		// 강사 ID로 강사 정보 검색
		public static InstructorDTO getInstructor(String instructorId) throws SQLException {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			InstructorDTO instructorInfo = null;

			try {
				con = DBUtil.getConnection();
				pstmt = con.prepareStatement("select * from instructor where instructor_id=?");
				pstmt.setString(1, instructorId);
				rset = pstmt.executeQuery();
				if (rset.next()) {
					instructorInfo = new InstructorDTO(rset.getString(1), rset.getString(2), rset.getString(3));
				}
			} finally {
				DBUtil.close(con, pstmt, rset);
			}
			return instructorInfo;
		}

		// 모든 강사 검색
		public static ArrayList<InstructorDTO> getAllInstructor() throws SQLException {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			ArrayList<InstructorDTO> list = null;
			try {
				con = DBUtil.getConnection();
				pstmt = con.prepareStatement("select * from instructor");
				rset = pstmt.executeQuery();

				list = new ArrayList<ManagerDTO>();
				while (rset.next()) {
					list.add(new InstructorDTO(rset.getString(1), rset.getString(2), rset.getString(3)));
				}
			} finally {
				DBUtil.close(con, pstmt, rset);
			}
			return list;
		} 
	
	
}