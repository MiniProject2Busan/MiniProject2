package view;

import java.util.Scanner;


import controller.StudentController;

public class RunningStartView {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		while (true) {
			System.out.println("강의 정보 데이터베이스");
			System.out.println("1. 모든 정보 출력");
			System.out.println("2. 검색");
			System.out.println("3. 수정");
			System.out.println("4. 출결사항 및 교육비 출력");
			System.out.println("5. 추가");
			System.out.println("6. 삭제");
			System.out.println("");
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
		switch (startNum) {
		case 1: // 모든 정보 출력
			System.out.println("1.학생의 모든 정보 출력");
			System.out.println("2.강사의 모든 정보 출력");
			System.out.println("3.담당자 모든 정보 출력");
			System.out.println("4.강의 모든 정보 출력");
			int select = sc.nextInt();
			switch (select) {
			case 1:
				studentctrl.allStudent();
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
				System.out.println("조회할 학생의 이름 검색:");
				String name = sc.next();
				studentctrl.selectStudent(name);
				break;
			case 2:
			}
			break;
		case 3: // 특정 정보 업데이트
			System.out.println("1.학생 정보 업데이트");
			System.out.println("2.강사 정보 업데이트");
			System.out.println("3.담당자 정보 업데이트");
			System.out.println("4.강의 정보 업데이트");
			System.out.println();
			sc.next();
			int third = sc.nextInt();
			switch (third) {
			case 1:
				String modify; // 주소나 전화번호 받음
				System.out.println("학생의 정보를 업데이트합니다.");
				System.out.println("학생의 id를 입력해주세요:");
				int id = sc.nextInt();
				System.out.println("\n1. 주소");
				System.out.println("2. 전화번호\n");
				int thirdNum = sc.nextInt();
				sc.next();
				if (thirdNum == 1) {
					System.out.println("주소를 입력해주세요:");
				} else {
					System.out.println("전화번호를 입력해주세요:");
				}
				modify = sc.next(); // 주소나 번호 (비교대상은 thirdNum)
				studentctrl.updateStudentPhone(id, thirdNum, modify);
				break;
			case 2:
				break;
			case 3:
				break;
			}
			break;
		case 4: // 급여정보
			System.out.println("===== 급여 정보 검색 =====");
			System.out.println("학생 이름을 입력해주세요:");
			System.out.println();
			String stdName= sc.next();
			studentctrl.salaryCal(stdName);
			break;
		case 5:	//정보 추가 
			System.out.println("1.학생 정보 추가");
			System.out.println("2.강사 정보 추가");
			System.out.println("3.담당자 정보 추가");
			System.out.println("4.강의 정보 추가");
			int insert = sc.nextInt();
			switch(insert) {
			case 1:
				studentctrl.insertStudent();			
				break;
			case 2:
				break;
			case 3:
				break;
			}
			break;
		case 6:
			System.out.println("1.학생 정보 삭제");
			System.out.println("2.강사 정보 삭제");
			System.out.println("3.담당자 정보 삭제");
			System.out.println("4.강의 정보 삭제");
			int delete = sc.nextInt();
			switch(delete) {
			case 1:
				studentctrl.deleteStudent();
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			}
			break;
		default:
			System.out.println("입력값이 잘못되었습니다.");
		}
	}
}
