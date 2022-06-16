package controller;

import java.sql.SQLException;

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
	public void selectStudent(String id) {
		service.getOneStudnet(id);
	}

}
