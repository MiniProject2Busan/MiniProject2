package view;

import java.util.Scanner;

import controller.StudentController;

public class RunningStartView {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("강의 정보 데이터베이스");
			System.out.print("1. 모든 정보 출력");
			System.out.print("\t2. 검색");
			System.out.print("\t3. 수정\n");
			System.out.print("4. 교육비 출력");
			System.out.print("\t5. 추가");
			System.out.print("\t6. 삭제");
			System.out.println();
			int num = sc.nextInt();
			if (num < 0) {
				System.out.println("종료");
				break;
			}
			secondView(num);
		}
	}

	public static void secondView(int startNum) {
		StudentController studentctrl = StudentController.getInstance();
		StudentView studentV = StudentView.getInstance();
		Scanner sc = new Scanner(System.in);
		switch (startNum) {
		case 1: // 모든 정보 출력
			System.out.println("1.학생의 모든 정보 출력");
			System.out.println("2.강사의 모든 정보 출력");
			System.out.println("3.담당자 모든 정보 출력");
			System.out.println("4.강의 모든 정보 출력");
			int select = sc.nextInt();
			switch (select) {
			case 1:
				studentV.allStudent();
				break;
			case 2:
			}
			break;

		case 2: // 특정 정보 검색

			System.out.println("1.학생 인물 검색");
			System.out.println("2.강사 인물 검색");
			System.out.println("3.담당자 인물 검색");
			System.out.println("4.강의 검색");
			System.out.println();
			int second = sc.nextInt();
			switch (second) {
			case 1:
				studentV.selectStudent();
				break;
			case 2:
			}
			break;
		case 3: // 특정 정보 업데이트
			System.out.println("1.학생 정보 업데이트");
			System.out.println("2.강사 정보 업데이트");
			System.out.println("3.담당자 정보 업데이트");
			System.out.println("4.강의 정보 업데이트");
			System.out.println("5.급여 정보 업데이트");
			System.out.println();
			int third = sc.nextInt();
			switch (third) {
			case 1: // 학생 정보 업데이트
				studentV.updateStudent();
				break;
			case 2: // 강사 정보 업데이트
				break;
			case 3: // 담당자 정보 업데이트
				break;
			case 4:
				break;
			case 5:
				studentV.updateAttendance();
				break;
			}
			break;
		case 4: // 급여정보
			studentV.searchSalary();
			break;
		case 5: // 정보 추가
			System.out.println("1.학생 정보 추가");
			System.out.println("2.강사 정보 추가");
			System.out.println("3.담당자 정보 추가");
			System.out.println("4.강의 정보 추가");
			int insert = sc.nextInt();
			switch (insert) {
			case 1: // 학생 정보 추가
				studentV.insertView();
				break;
			case 2: // 강사 정보 추가
				break;
			case 3: // 담당자 정보 추가
				break;
			case 4: // 강의 정보 추가
				break;
			default:
				System.out.println("입력값 에러");
				break;
			}
			break;
		case 6:
			System.out.println("1.학생 정보 삭제");
			System.out.println("2.강사 정보 삭제");
			System.out.println("3.담당자 정보 삭제");
			System.out.println("4.강의 정보 삭제");
			int delete = sc.nextInt();
			switch (delete) {
			case 1: // 학생 정보 삭제
				studentctrl.deleteStudent();
				break;
			case 2: // 강사 정보 삭제
				break;
			case 3: // 담당자 정보 삭제
				break;
			case 4: // 강의 정보 삭제
				break;
			default:
				System.out.println("입력값 오류");
				break;
			}
			break;
		default:
			System.out.println("입력값이 잘못되었습니다.");
		}
	}
}
