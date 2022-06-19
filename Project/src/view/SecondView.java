package view;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class SecondView {
	public static void secondView(int startNum) throws NoSuchElementException {
		Scanner sc = new Scanner(System.in);
		StudentView studentV = StudentView.getInstance();
		InstructorView instructorV = InstructorView.getInstance();
		ManagerView managerV = ManagerView.getInstance();
		switch (startNum) {
		case 1: // 모든 정보 출력
			System.out.println("1.학생의 모든 정보 출력");
			System.out.println("2.강사의 모든 정보 출력");
			System.out.println("3.담당자 모든 정보 출력");
			System.out.println("4.강의 모든 정보 출력\n");
			int select = sc.nextInt();
			switch (select) {
			case 1:
				studentV.allPeople();
				break;
			case 2:
				instructorV.allPeople();
				break;
			case 3:
				managerV.allPeople();
				break;
			}
			break;

		case 2: // 특정 정보 검색

			System.out.println("1.학생 인물 검색");
			System.out.println("2.강사 인물 검색");
			System.out.println("3.담당자 인물 검색");
			System.out.println("4.강의 검색\n");
			System.out.println();
			int second = sc.nextInt();
			switch (second) {
			case 1:
				studentV.selectView();
				break;
			case 2:
				instructorV.selectView();
				break;
			case 3:
				managerV.selectView();
				break;
			default:
				System.out.println("입력값이 잘못되었습니다.\n");
			}
			break;
		case 3: // 특정 정보 업데이트
			System.out.println("1.학생 정보 업데이트");
			System.out.println("2.강사 정보 업데이트");
			System.out.println("3.담당자 정보 업데이트");
			System.out.println("4.강의 정보 업데이트");
			System.out.println("5.급여 정보 업데이트\n");
			int third = sc.nextInt();
			switch (third) {
			case 1: // 학생 정보 업데이트
				studentV.updateView();
				break;
			case 2: // 강사 정보 업데이트
				instructorV.updateView();
				break;
			case 3: // 매니저 정보 업데이트
				managerV.updateView();
			case 4:
				break;
			case 5: // 출결 업데이트
				studentV.updateSalary();
				break;
			default:
				System.out.println("입력값이 잘못되었습니다.");
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
				instructorV.insertView();
				break;
			case 3: // 매니저 정보 추가
				managerV.insertView();
				break;
			case 4: // 강의 정보 추가
				break;
			default:
				System.out.println("입력값이 잘못되었습니다.");

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
				studentV.deleteView();
				break;
			case 2: // 강사 정보 삭제
				instructorV.deleteView();
				break;
			case 3: // 담당자 정보 삭제
				managerV.deleteView();
				break;
			case 4: // 강의 정보 삭제
				break;
			default:
				System.out.println("입력값이 잘못되었습니다.");
			}
			break;
		default:
			System.out.println("입력값이 잘못되었습니다.");
		}
	}
}
