package service;

import java.sql.SQLException;

import dto.InstructorDTO;
import model.InstructorDAO;

public class InstructorService {
	
	private static InstructorService instance = new InstructorService();
	
	private InstructorService() {}
	
	public static InstructorService getInstance() {
		return instance;
	}
	
	// Instructor 이름으로 검색
	public InstructorDTO getInstructor(String instructorName) throws SQLException {
		return InstructorDAO.getInstructor(instructorName);
	}
	
	// 기존 Instructor 수정
//	public boolean updateInstructor(InstructorDTO instructor) {
////		return InstructorDAO.updateInstructor(instructorId);
//	}
	
	// 디비에 수정할 데이터 있는지 확인
	public InstructorDTO instructorIdCheck(int instructorId) throws SQLException {
		return InstructorDAO.getInstructor(instructorId);
	}
	
	// 이름 수정
	public boolean instructorUpdate(InstructorDTO instructor, int num, String inputValue) throws SQLException {
		return InstructorDAO.updateInstructor(instructor, num, inputValue);
	}
	
	// 새로운 강사 저장
	public boolean instructorInsert(InstructorDTO instructor) throws SQLException {
		return InstructorDAO.addInstructor(instructor);
	}
	
	// 강사 삭제
	public boolean instructorDelete(int instuctorId) throws SQLException {
		return InstructorDAO.deleteInstructor(instuctorId);
	}
}
