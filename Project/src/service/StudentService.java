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
		return StudentDAO.getAllStudent(); 
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
	// 특정 학생 정보 수정
	public boolean modifyStudent(int id, int selectNum, String modify) throws SQLException {
		return(StudentDAO.updateStudent(id, selectNum, modify));
	}
	
	// 특정 학생 정보 추가
	public void insertStudent(StudentDTO student) throws SQLException {		
		StudentDAO.addStudent(student);
	}

	public boolean deleteStudent(String id) throws SQLException {
		if(StudentDAO.deleteStudent(id)) {
			return true;
		}
		return false;
		
	}
	
	// 특정 학생에 대한 출결정보 출력
	public int getData(StudentDTO oneStudnet) throws SQLException {
		ArrayList<Integer> attendance= StudentDAO.getData(oneStudnet);
		
		int tardy = attendance.get(0);	//지각
		int absent = attendance.get(1);	//결석
		return(salary(tardy,absent));
	}
	
	public int salary(int tar,int absent) {
		int sal = 300000;
		sal = sal- ((tar%3 + absent) * 15000);
		return sal;
	}
}
