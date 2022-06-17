package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.InstructorDTO;
import utils.DBUtil;

public class InstructorDAO {
	// 강사 정보 생성
	public static boolean addInstructor(InstructorDTO instructor) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
	
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("insert into instructor values(?, ?, ?)");
	        pstmt.setInt(1, instructor.getInstructorId());
	        pstmt.setString(2, instructor.getInstructorName());
	        pstmt.setString(3, instructor.getInstructorPhone());
	         
	        int result = pstmt.executeUpdate();
		} finally {
			DBUtil.close(conn, pstmt);
		}
	      
	      return false;
	   }
	   
	   // 강사 ID로 이름 수정
	   public static boolean updateInstructor(InstructorDTO instructor, int num, String inputValue) throws SQLException {
	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      try {
	         conn = DBUtil.getConnection();
	         
	         if(num == 1) {
	            pstmt = conn.prepareStatement("update instructor set instructor_name=? where instructor_id=?");
	        pstmt.setString(1, inputValue);
	        pstmt.setInt(2, instructor.getInstructorId());
	     } else if(num == 2) {
	        pstmt = conn.prepareStatement("update instructor set instructor_phone=? where instructor_id=?");
	        pstmt.setString(1, inputValue);
	        pstmt.setInt(2, instructor.getInstructorId());
	     }
	//         pstmt.setString(2, instructorPhone);
	         
	         int result = pstmt.executeUpdate();
	         if (result == 1) {
	            return true;
	         }
	      } finally {
	         DBUtil.close(conn, pstmt);
	      }
	      return false;
	   }

	
	   // 강사 ID로 강사 정보 삭제
	   public static boolean deleteInstructor(int instructorId) throws SQLException {
	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      try {
	         conn = DBUtil.getConnection();
	         pstmt = conn.prepareStatement("delete from instructor where instructor_id=?");
	         pstmt.setInt(1, instructorId);
	         int result = pstmt.executeUpdate();
	         if (result == 1) {
	            return true;
	         }
	      } finally {
	         DBUtil.close(conn, pstmt);
	      }
	      return false;
	   }
	
	   // 강사 이름으로 강사 정보 검색
	   public static InstructorDTO getInstructor(String instructorName) throws SQLException {
	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      ResultSet rset = null;
	      InstructorDTO instructorInfo = null;
	
	      try {
	         conn = DBUtil.getConnection();
	         pstmt = conn.prepareStatement("select * from instructor where instructor_name=?");
	         pstmt.setString(1, instructorName);
	         rset = pstmt.executeQuery();
	         if (rset.next()) {
	            instructorInfo = new InstructorDTO(rset.getInt(1), rset.getString(2), rset.getString(3));
	         }
	      } finally {
	         DBUtil.close(conn, pstmt, rset);
	      }
	
	      return instructorInfo;
	   }
	   
	   // 강사 id로 강사 정보 검색 (update)
	   public static InstructorDTO getInstructor(int instructorId) throws SQLException {
	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      ResultSet rset = null;
	      InstructorDTO instructorInfo = null;
	
	      try {
	         conn = DBUtil.getConnection();
	         pstmt = conn.prepareStatement("select * from instructor where instructor_id=?");
	         pstmt.setInt(1, instructorId);
	         rset = pstmt.executeQuery();
	         if (rset.next()) {
	            instructorInfo = new InstructorDTO(rset.getInt(1), rset.getString(2), rset.getString(3));
	         }
	      } finally {
	         DBUtil.close(conn, pstmt, rset);
	      }
	
	      return instructorInfo;
	   }
	
	      // 모든 강사 검색
	//      public static ArrayList<InstructorDTO> getAllInstructor() throws SQLException {
	//         Connection con = null;
	//         PreparedStatement pstmt = null;
	//         ResultSet rset = null;
	//         ArrayList<InstructorDTO> list = null;
	//         try {
	//            con = DBUtil.getConnection();
	//            pstmt = con.prepareStatement("select * from instructor");
	//            rset = pstmt.executeQuery();
	//
	//            list = new ArrayList<ManagerDTO>();
	//            while (rset.next()) {
	//               list.add(new InstructorDTO(rset.getString(1), rset.getString(2), rset.getString(3)));
	//            }
	//         } finally {
	//            DBUtil.close(con, pstmt, rset);
	//         }
	//         return list;
	//      } 
   
   
}