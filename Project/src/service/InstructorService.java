package service;

import java.sql.SQLException;
import java.util.ArrayList;

import dto.InstructorDTO;
import model.CourseDAO;
import model.InstructorDAO;

public class InstructorService {
	
	private static InstructorService instance = new InstructorService();
	
	private InstructorService() {}
	
	public static InstructorService getInstance() {
		return instance;
	}
	
	// 강사의 모든 정보 출력
	public ArrayList<InstructorDTO> getAllInstructor() throws SQLException {
		return InstructorDAO.getAllInstructor();
	}
	
	// Instructor 이름으로 검색
	public InstructorDTO getInstructor(String instructorName) throws SQLException {
		return InstructorDAO.getInstructorByName(instructorName);
	}
	
	// 기존 Instructor 수정
//	public boolean updateInstructor(InstructorDTO instructor) {
////		return InstructorDAO.updateInstructor(instructorId);
//	}
	
	// 디비에 수정할 데이터 있는지 확인
	public InstructorDTO instructorIdCheck(int instructorId) throws SQLException {
		return InstructorDAO.getInstructorById(instructorId);
	}
	
	// 이름 or 연락처 수정
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
