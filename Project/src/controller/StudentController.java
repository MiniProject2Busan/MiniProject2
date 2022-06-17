package controller;

import java.sql.SQLException;

import dto.StudentDTO;
import service.StudentService;
import view.RunningEndView;

public class StudentController {
	private static StudentController instance = new StudentController();
	private StudentService service = StudentService.getInstance();

	private StudentController() {
	}

	public static StudentController getInstance() {
		return instance;
	}

	// 모든 학생 검색
	public void allStudent() {
		try {
			RunningEndView.projectListView(service.getAllstudent());
		} catch (SQLException s) {
			System.out.println(s);
		}
	}

	// 특정 학생 검색
	public void selectStudent(String name) {
		RunningEndView.selectView(service.getOneStudnet(name));
	}

	// 특정 학생 추가
	public void insertStudent(StudentDTO student) {

	}

	// 특정 학생 정보 수정
	public void updateStudentPhone(int id, int selectNum, String modify) {

		try {
			service.modifyStudent(id, selectNum, modify);
		} catch (SQLException e) {
			RunningEndView.Error("에러");
		}
	}

}
