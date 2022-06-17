package controller;

import java.sql.SQLException;

import dto.StudentDTO;
import service.StudentService;
import view.RunningEndView;
import view.RunningSuccessView;
import view.StudentView;

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

	// 특정 학생 정보 수정
	public void updateStudentPhone(int id, int selectNum, String modify) {
		
		try {
			if(service.modifyStudent(id, selectNum, modify)){
				RunningSuccessView.showSuccess("수정이 완료되었습니다.");
			}else {
				RunningEndView.Error("존재하지 않는 회원입니다.");
			}
		} catch (SQLException e) {
			RunningEndView.Error("수정에 실패했습니다.");
			System.out.println(e);
		}
	}
	
	// 특정 학생 추가
	public void insertStudent() {
		try {
			service.insertStudent(StudentView.insertView());
		} catch (SQLException e) {
			RunningEndView.Error("학생 정보 추가가 실패하였습니다.");
			
		}
}

	public void deleteStudent() {
		try {
			if(service.deleteStudent(StudentView.deleteView())) {
				RunningSuccessView.showSuccess("삭제완료");
			}else {
				RunningEndView.Error("존재하지 않는 회원입니다.");
			}
		}catch (Exception e) {
			System.out.println("삭제에 실패했습니다.");
		}
	}

	public void salaryCal(String stdName) {
		try {
			RunningEndView.getsalary(service.getData(service.getOneStudnet(stdName)));
		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("글쎄요,,?");
		}
	}
}
























