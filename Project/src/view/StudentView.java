package view;

import java.util.Scanner;

import controller.StudentController;
import dto.StudentDTO;

public class StudentView {
	private StudentController studentctrl = StudentController.getInstance();
	private static StudentView studentV = new StudentView();

	private StudentView() {
	};

	public static StudentView getInstance() {
		return studentV;
	}

	// 학생 모든 정보 출력
	public void allStudent() {
		studentctrl.allStudent();
	}

	// 학생추가 뷰
	public void insertView() {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("학생의 이름을 입력하세요:");
			String name = sc.next();
			System.out.println("학생의 나이를 입력하세요:");
			int age = sc.nextInt();
			System.out.println("학생의 전화번호를 입력하세요:");
			String phone = sc.next();
			sc.nextLine();
			System.out.println("학생의 주소를 입력하세요:");
			String addr = sc.next();
			System.out.println("학생의 좌석이름 입력하세요:");
			String seatId = sc.next();
			System.out.println("학생의 매니저를 입력하세요:");
			int manager = sc.nextInt();
			StudentDTO student = new StudentDTO(name, age, phone, addr, seatId, manager);
			studentctrl.insertStudent(student);
		} catch (Exception e) {
			RunningEndView.Error("입력값이 잘못되었습니다.");
		}
	}

	// 학생 삭제 뷰
	public static String deleteView() {
		Scanner sc = new Scanner(System.in);
		System.out.println("학생의 id를 입력하세요:");
		String id = sc.next();
		return id;
	}

	// 학생 정보 업데이트 뷰
	public void updateStudent() {
		Scanner sc = new Scanner(System.in);
		String modify; // 주소나 전화번호 받음
		System.out.println("학생의 정보를 업데이트합니다.");
		System.out.println("- - - - - - - - - -");
		System.out.println("학생의 id를 입력해주세요:");
		int id = sc.nextInt();
		System.out.println("\n1. 주소");
		System.out.println("2. 전화번호\n");
		int thirdNum = sc.nextInt();
		if (thirdNum == 1) {
			System.out.println("주소를 입력해주세요:");
		} else {
			System.out.println("전화번호를 입력해주세요:");
		}
		modify = sc.next(); // 주소나 번호 (비교대상은 thirdNum)
		sc.close();
		studentctrl.updateStudent(id, thirdNum, modify);
	}

	// 특정 정보 검색 뷰
	public void selectStudent() {
		Scanner sc = new Scanner(System.in);
		System.out.println("조회할 학생의 이름 검색:");
		String name = sc.next();
		studentctrl.selectStudent(name);
	}

	// 급여정보 확인
	public void searchSalary() {
		Scanner sc = new Scanner(System.in);
		System.out.println("===== 급여 정보 검색 =====");
		System.out.println("학생 이름을 입력해주세요:");
		System.out.println();
		String stdName = sc.next();
		studentctrl.salaryCal(stdName);
	}

	public void updateAttendance() {
		Scanner sc = new Scanner(System.in);
		System.out.println("학생의 이름을 입력해주세요:");
//		sc.nextLine();
		String stdName = sc.next();
		System.out.println("출결정보를 수정합니다.");
		System.out.println("1.지각정보 업데이트");
		System.out.println("2.결석정보 업데이트");
		int selectAttendance = sc.nextInt();
		studentctrl.updateAttendance(selectAttendance, stdName);
	}
}
