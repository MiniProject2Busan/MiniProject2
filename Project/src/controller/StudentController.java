package controller;

import java.sql.SQLException;

import dto.StudentDTO;
import service.StudentService;
import view.RunningEndView;
import view.RunningSuccessView;

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

	// 특정 학생 이름 검색
	public void selectStudent(String name) {
		try {
			RunningEndView.selectView(service.getOneStudnet(name));
		} catch (SQLException e) {
			System.out.println("검색한 학생 정보가 없습니다.");
		}
	}

	// 특정 학생 정보 수정
	public void updateStudent(int id, int selectNum, String modify) {

		try {
			if (service.updateStudent(id, selectNum, modify)) {
				RunningSuccessView.showSuccess("수정이 완료되었습니다.");
			} else {
				RunningEndView.Error("존재하지 않는 회원입니다.");
			}
		} catch (SQLException e) {
			RunningEndView.Error("수정에 실패했습니다.");
			System.out.println(e);
		}
	}

	// 특정 학생 추가
	public void insertStudent(StudentDTO student) {
		try {
//			service.insertStudent(student);
			service.insertPeople(student);
		} catch (SQLException e) {
			RunningEndView.Error("학생 정보 추가가 실패하였습니다.");
		}
	}

	// 특정 학생 삭제
	public void deleteStudent(int studentId) {
		try {
			if (service.deleteStudent(studentId)) {
				RunningSuccessView.showSuccess("삭제완료");
			} else {
				RunningEndView.Error("존재하지 않는 회원입니다.");
			}
		} catch (Exception e) {
			System.out.println("삭제에 실패했습니다.");
		}
	}

	// 급여 정보 검색
	public void salaryCal(String stdName) {
		try {
			RunningEndView.getsalary(service.getData(service.getOneStudnet(stdName)));
		} catch (SQLException e) {
			RunningEndView.Error("SQL문 에러");
		}
	}

	// 출결 업데이트
	public void updateAttendance(int attendance, String stdName) {
		StudentDTO getStudent;
		try {
			getStudent = service.getOneStudnet(stdName);
			if (getStudent.equals(null)) { // 검색정보 없다면
				RunningEndView.Error("검색하신 학생 정보가 존재하지 않습니다.");
			} else { // 검색정보가 존재한다면
				if (attendance == 1 | attendance == 2) { // 1이나 2라면
					if (attendance == 1) {
						RunningSuccessView.showSuccess("지각정보 수정이 완료되었습니다.");
					} else {
						RunningSuccessView.showSuccess("결석정보 수정이 완료되었습니다.");
					}
				} else { // 1이나 2가 아니라면
					RunningEndView.Error("입력값이 잘못되었습니다.");
				}
			}
		} catch (SQLException e) {
			RunningEndView.Error(e.getMessage());
		}
	}
}
