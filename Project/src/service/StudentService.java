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
	// 특정 학생 정보 수정
	public boolean updateStudent(int id, int selectNum, String modify) throws SQLException {
		return (StudentDAO.updateStudent(id, selectNum, modify));
	}
	// 지각정보 수정
	public void updateAttendance(int id, int attendance) throws SQLException {
		StudentDAO.updateAttendance(id, attendance);
		
	}
	
	
//	 학생의 모든 정보 출력
	public ArrayList<StudentDTO> getAllstudent() throws SQLException {
		return StudentDAO.getAllStudent();
	}

	// 특정 학생 정보 출력
	public StudentDTO getOneStudnet(String name) throws SQLException {
		return StudentDAO.getStudent(name);

	}

	
	// 특정 학생 정보 추가
	public boolean insertStudent(StudentDTO student) throws SQLException {
		return StudentDAO.addStudent(student);
	}

	public boolean deleteStudent(int studentId) throws SQLException {
		return StudentDAO.deleteStudent(studentId);

	}


	// 특정 학생에 대한 출결정보 출력
	public int getData(StudentDTO oneStudnet) throws SQLException, NullPointerException {
		ArrayList<Integer> attendance = StudentDAO.getData(oneStudnet);

		int tardy = attendance.get(0); // 지각
		int absent = attendance.get(1); // 결석
		return (salary(tardy, absent));
	}

	// 지급금액 계산메서드
	public int salary(int tar, int absent) {
		int sal = 300000;
		sal = sal - ((tar % 3 + absent) * 15000);
		return sal;
	}
}
