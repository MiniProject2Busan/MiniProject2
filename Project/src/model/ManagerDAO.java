package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import utils.DBUtil;

public class ManagerDAO {

	// 담당자 정보 생성
	public static boolean addManager(ManagerDTO manager) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("insert into manager values(?, ?, ?)");
			pstmt.setInt(1, manager.getManagerId());
			pstmt.setString(2, manager.getManagerName());
			pstmt.setString(3, manager.getManagerPhone());
			
			int result = pstmt.executeUpdate();
		} finally {
			DBUtil.close(conn, pstmt);
		}
		
		return false;
	}
	
	// 담당자 ID로 담당자 정보 수정
		public static boolean updateManager(int managerId, String managerName, String managerPhone) throws SQLException {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = DBUtil.getConnection();

				pstmt = con.prepareStatement("update manager set manager_name=?, manager_phone=? where manager_id=?");
				pstmt.setString(1, managerName);
				pstmt.setString(2, managerPhone);
				pstmt.setInt(3, managerId);
				
				int result = pstmt.executeUpdate();
				if (result == 1) {
					return true;
				}
			} finally {
				DBUtil.close(con, pstmt);
			}
			return false;
		}


		// 담당자 이름으로 담당자 정보 삭제
		public static boolean deleteManager(String managerName) throws SQLException {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = DBUtil.getConnection();
				pstmt = con.prepareStatement("delete from manager where manager_name=?");
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

		// 담당자 이름으로 담당자 정보 검색
		public static ManagerDTO getManager(String managerName) throws SQLException {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			ManagerDTO managerInfo = null;

			try {
				con = DBUtil.getConnection();
				pstmt = con.prepareStatement("select * from manager where manager_name=?");
				pstmt.setString(1, managerName);
				rset = pstmt.executeQuery();
				if (rset.next()) {
					managerInfo = new ManagerDTO(rset.getInt(1), rset.getString(2), rset.getString(3));
				}
			} finally {
				DBUtil.close(con, pstmt, rset);
			}
			return managerInfo;
		}

		// 모든 담당자 검색
		public static ArrayList<ManagerDTO> getAllManager() throws SQLException {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			ArrayList<ManagerDTO> list = null;
			try {
				con = DBUtil.getConnection();
				pstmt = con.prepareStatement("select * from manager");
				rset = pstmt.executeQuery();

				list = new ArrayList<ManagerDTO>();
				while (rset.next()) {
					list.add(new ManagerDTO(rset.getInt(1), rset.getString(2), rset.getString(3)));
				}
			} finally {
				DBUtil.close(con, pstmt, rset);
			}
			return list;
		} 
	
	
}