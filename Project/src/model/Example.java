//package blood.transfusion.model;
//sada
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//
//import blood.transfusion.dto.BTProjectDTO;
//import blood.transfusion.util.DBUtil;
//
//public class BTProjectDAO {
//	// �봽濡쒖젥�듃 ���옣
//	public static boolean addBTProject(BTProjectDTO btProject) throws SQLException {
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		try {
//			con = DBUtil.getConnection();
//			pstmt = con.prepareStatement("insert into bt_project values(?, ?, ?, ?, ?)");
//			pstmt.setString(1, btProject.getBtProjectName());
//			pstmt.setString(2, btProject.getBtProjectId());
//			pstmt.setString(3, btProject.getDonorId());
//			pstmt.setString(4, btProject.getRecipientId());
//			pstmt.setString(5, btProject.getbtContent());
//			// �엯�젰媛� 諛쏆쓣 �닔 �엳�쓬
//			int result = pstmt.executeUpdate(); // �뿉�윭臾몄옣
//
//			if (result == 1) {
//				return true;
//			}
//		} finally {
//			DBUtil.close(con, pstmt);
//		}
//		return false;
//	}
//
//	// �봽濡쒖젥�듃 �븘�씠�뵒濡� �뿄�삁�옄 �젙蹂� �닔�젙
//	public static boolean updateBTProjectdonor(String btProjectId, String donorId) throws SQLException {
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		try {
//			con = DBUtil.getConnection();
//			pstmt = con.prepareStatement("update bt_project set donor_id=? where bt_project_id= ?");
//			pstmt.setString(1, donorId);
//			pstmt.setString(2, btProjectId);
//
//			int result = pstmt.executeUpdate();
//			if (result == 1) {
//				return true;
//			}
//		} finally {
//			DBUtil.close(con, pstmt);
//		}
//		return false;
//	}
//
//	// �봽濡쒖젥�듃 �븘�씠�뵒濡� �닔�삁�옄 �젙蹂� �닔�젙
//	public static boolean updateBTProjectReceive(String btProjectId, String recipientId) throws SQLException {
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		try {
//			con = DBUtil.getConnection();
//
//			pstmt = con.prepareStatement("update bt_project set receive_id=? where bt_project_id=?");
//			pstmt.setString(1, recipientId);
//			pstmt.setString(2, btProjectId);
//
//			int result = pstmt.executeUpdate();
//			if (result == 1) {
//				return true;
//			}
//		} finally {
//			DBUtil.close(con, pstmt);
//		}
//		return false;
//	}
//
//	// �봽濡쒖젥�듃 �씠由꾩쑝濡� �봽濡쒖젥�듃 �궘�젣
//	public static boolean deleteBTProject(String btProjectid) throws SQLException {
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		try {
//			con = DBUtil.getConnection();
//			pstmt = con.prepareStatement("delete from bt_project where bt_project_id=?");
//			pstmt.setString(1, btProjectid);
//			int result = pstmt.executeUpdate();
//			if (result == 1) {
//				return true;
//			}
//		} finally {
//			DBUtil.close(con, pstmt);
//		}
//		return false;
//	}
//
//	// �봽濡쒖젥�듃 �씠由꾩쑝濡� �봽濡쒖젥�듃 寃��깋
//	public static BTProjectDTO getBTProject(String btProjectid) throws SQLException {
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rset = null;
//		BTProjectDTO blood_transfusionUser = null;
//
//		try {
//			con = DBUtil.getConnection();
//			pstmt = con.prepareStatement("select * from bt_project where bt_project_id=?");
//			pstmt.setString(1, btProjectid);
//			rset = pstmt.executeQuery();
//			if (rset.next()) {
//				blood_transfusionUser = new BTProjectDTO(rset.getString(1), rset.getString(2), rset.getString(3),
//						rset.getString(4), rset.getString(5));
//			}
//		} finally {
//			DBUtil.close(con, pstmt, rset);
//		}
//		return blood_transfusionUser;
//	}
//
//	// 紐⑤뱺 �닔�삁 �봽濡쒖젥�듃 寃��깋
//	public static ArrayList<BTProjectDTO> getAllBTProjects() throws SQLException {
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rset = null;
//		ArrayList<BTProjectDTO> list = null;
//		try {
//			con = DBUtil.getConnection();
//			pstmt = con.prepareStatement("select * from bt_project");
//			rset = pstmt.executeQuery();
//
//			list = new ArrayList<BTProjectDTO>();
//			while (rset.next()) {
//				list.add(new BTProjectDTO(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4),
//						rset.getString(5)));
//			}
//		} finally {
//			DBUtil.close(con, pstmt, rset);
//		}
//		return list;
//	}
//
//	// Donor �씠由꾩쑝濡� �봽濡쒖젥�듃 �씠由� 異붿텧
//	public static String getBtID(String donor_id) throws SQLException {
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rset = null;
//		ArrayList<BTProjectDTO> list = null;
//		try {
//			con = DBUtil.getConnection();
//			pstmt = con.prepareStatement("select bt_project_id from bt_project where donor_id=?");
//			pstmt.setString(1, donor_id);
//			rset = pstmt.executeQuery();
////			System.out.println(rset);
////			while (rset.next()) {
////			}
//		} finally {
//			DBUtil.close(con, pstmt, rset);
//		}
//		return null;
//	}
//}


// ---------------------------------------------------------------

//package blood.transfusion.model;
//
//import java.sql.SQLException;
//import java.util.ArrayList;
//
//import blood.transfusion.dto.BTProjectDTO;
//import blood.transfusion.dto.DonorDTO;
//import blood.transfusion.dto.RecipientDTO;
//import blood.transfusion.exception.NotExistException;
//
//public class BTService {
//
//	private static BTService instance = new BTService();
//
//	private BTService() {
//	}
//
//	public static BTService getInstance() {
//		return instance;
//	}
//
//	// BTProject - CRUD
//	public void notExistBTProject(String btProjectId) throws NotExistException, SQLException {
//		BTProjectDTO btProject = BTProjectDAO.getBTProject(btProjectId);
//		if (btProject == null) {
//			throw new NotExistException("寃��깋�븯吏� �닔�삁 �젙蹂닿� �뾾�뒿�땲�떎.");
//		}
//	}
//
//	// 紐⑤뱺 BTProject �젙蹂� 諛섑솚
//	public ArrayList<BTProjectDTO> getAllBTProjects() throws SQLException {
//		return BTProjectDAO.getAllBTProjects();
//	}
//
//	// Donor ID濡� BTProject 媛� 寃��깋
//	public String getBTPid(String donor_id) throws SQLException, NotExistException {
//
//		return BTProjectDAO.getBtID(donor_id);
//	}
//
//	// BTProject id濡� 寃��깋
//	public BTProjectDTO getBTProject(String btProjectid) throws SQLException, NotExistException {
//		BTProjectDTO getBTO = BTProjectDAO.getBTProject(btProjectid);
//		return getBTO;
//	}
//
//	// �깉濡쒖슫 BTProject ���옣
//	public boolean addBTProject(BTProjectDTO btProject) throws SQLException {
//		BTProjectDAO.addBTProject(btProject);
//		return false;
//	}
//
//	// 湲곗〈 BTProject �닔�젙
//	public boolean updateBTProject(String btProjectId, String btProjectContent) throws SQLException, NotExistException {
//		if (BTProjectDAO.updateBTProjectdonor(btProjectId, btProjectContent)) {
//			return true;
//		}
//		return false;
//	}
//
//	// BTProject �궘�젣
//	public boolean deleteBTProject(String btProjectId) throws SQLException, NotExistException {
//		if (BTProjectDAO.deleteBTProject(btProjectId)) {
//
//			return true;
//		}
//		;
//		return false;
//	}
//
//	// Donor - CRUD
////	public void notExistDonor(String donorId) throws NotExistException, SQLException {
//	public void notExistDonor(String donorId) throws NotExistException, SQLException {
//		System.out.println(donorId);
//		DonorDTO Donor = DonorDAO.getDonor(donorId);
//		if (Donor == null) {
//			throw new NotExistException("寃��깋�븳  �뿄�삁�옄媛� 誘� 議댁옱�빀�땲�떎.");
//		}
//	}
//
//	public boolean addDonor(DonorDTO donor) throws SQLException {
//		return DonorDAO.addDonor(donor);
//	}
//
//	public boolean updateDonor(String donorId, String purposeDonation) throws SQLException, NotExistException {
//		notExistDonor(donorId);
//		return DonorDAO.updateDonor(donorId, purposeDonation);
//	}
//
//	public boolean deleteDonor(String donorId) throws SQLException, NotExistException {
//		notExistDonor(donorId);
//		return DonorDAO.deleteDonor(donorId);
//	}
//
//	public DonorDTO getDonor(String donorId) throws SQLException, NotExistException {
//		DonorDTO donor = DonorDAO.getDonor(donorId);
//		if (donor == null) {
//			throw new NotExistException("寃��깋�븳 �뿄�삁�옄媛� 誘� 議댁옱�빀�땲�떎.");
//		}
//		return donor;
//	}
//
//	public ArrayList<DonorDTO> getAllDonors() throws SQLException {
//		return DonorDAO.getAllDonors();
//	}
//
//	// Recipient - CRUD
//	public static void notExistRecipient(String recipientId) throws NotExistException, SQLException {
//		RecipientDTO recipient = RecipientDAO.getRecipient(recipientId);
//		if (recipient == null) {
//			throw new NotExistException("寃��깋�븳  �닔�삁�옄媛� 誘� 議댁옱�빀�땲�떎.");
//		}
//	}
//
//	public boolean addRecipient(RecipientDTO recipient) throws SQLException {
//		return RecipientDAO.addRecipient(recipient);
//	}
//
//	public static boolean updateRecipient(String recipientId, String purposeTransfusion)
//			throws SQLException, NotExistException {
//		notExistRecipient(recipientId);
//		return RecipientDAO.updateRecipient(recipientId, purposeTransfusion);
//	}
//
//	public boolean deleteRecipient(String recipientId) throws SQLException, NotExistException {
//		notExistRecipient(recipientId);
//		return RecipientDAO.deleteRecipient(recipientId);
//	}
//
//	public static RecipientDTO getRecipient(String recipientId) throws SQLException {
//		return RecipientDAO.getRecipient(recipientId);
//	}
//
//	public static ArrayList<RecipientDTO> getAllRecipients() throws SQLException {
//		return RecipientDAO.getAllRecipients();
//	}
//}



