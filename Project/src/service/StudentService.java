package service;

import java.sql.SQLException;
import java.util.ArrayList;

import dto.StudentDTO;
import model.StudentDAO;

//학생 정보에 대한 CRUD	
public class StudentService {
	private static StudentService instance = new StudentService();

	private StudentService() {
	}

	public static StudentService getInstance() {
		return instance;
	}

	// 학생의 모든 정보 출력
	public ArrayList<StudentDTO> getAllstudent() throws SQLException {
		return StudentDAO.getAllStudent(); // Arraylist
	}

	// 특정 학생 정보 출력
	public StudentDTO getOneStudnet(String name) {
		try {
			return StudentDAO.getStudent(name);
		} catch (SQLException e) {
			System.out.println("에러");
			e.printStackTrace();
		}
		return null;
	}

	public StudentDTO modifyStudent(int id, int selectNum, String modify) throws SQLException {
		StudentDAO.updateStudent(id, selectNum, modify);
		return null;
	}
}
