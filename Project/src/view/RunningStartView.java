package view;

import java.util.Scanner;

import controller.CourseController;
import controller.StudentController;
import dto.CourseDTO;

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
		CourseController courseCtrl = CourseController.getInstance();
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
				break;
			case 3:
				break;
			case 4:
				courseCtrl.allCourse();
				break;
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
				sc.nextLine();
				String id = sc.nextLine();
				studentctrl.selectStudent(id);
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				System.out.println("조회할 강의 이름 검색:");
				sc.nextLine();
				String courseName = sc.nextLine();
				courseCtrl.Course(courseName);
			}
			break;
		case 3: // 특정 정보 업데이트
			System.out.println("1.학생 정보 업데이트");
			System.out.println("2.강사 정보 업데이트");
			System.out.println("3.담당자 정보 업데이트");
			System.out.println("4.강의 정보 업데이트");
			System.out.println();
			sc.nextLine();
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
				sc.nextLine();
				if (thirdNum == 1) {
					System.out.println("주소를 입력해주세요:");
				} else {
					System.out.println("전화번호를 입력해주세요:");
				}
				modify = sc.nextLine(); // 주소나 번호 (비교대상은 thirdNum)
				studentctrl.updateStudentPhone(id, thirdNum, modify);

				break;

			case 2:
				break;
			case 3:
				break;
			case 4:
				System.out.println("강의 정보를 업데이트 합니다.");
				System.out.println("강의 id를 입력해 주세요");
				int courseId = sc.nextInt(); // ++ 없는 id 예외받도록
				if (courseCtrl.selectCourse(courseId)) {
					System.out.println("업데이트할 정보를 선택해 주세요");
					System.out.println("\n1. 강의명");
					System.out.println("2. 강의 시작 일자");
					System.out.println("3. 강의 종료 일자\n");
					int courseNum = sc.nextInt();
					sc.nextLine();

					switch (courseNum) {
					case 1:
						System.out.println("강의명을 입력해 주세요:");
						String courseName = sc.nextLine();
						courseCtrl.updateCourseName(courseId, courseName);
						break;
					case 2:
						System.out.println("강의 시작일자(yyyy-mm-dd)를 입력해 주세요:");
						String startDate = sc.nextLine();
						courseCtrl.updateCourseStartDate(courseId, startDate);
						break;
					case 3:
						System.out.println("강의 종료일자(yyyy-mm-dd)를 입력해 주세요:");
						String endDate = sc.nextLine();
						courseCtrl.updateCourseStartDate(courseId, endDate);
					}
					break;
				} else {
					break;
				}

			}
			break;
		case 4: // 급여정보
			System.out.println("===== 급여 정보 검색 =====");
			System.out.println("학생 번호를 입력해주세요:");
			System.out.println();
//			int num = sc.nextInt();
			break;
		case 5:
			System.out.println("1.학생 정보 추가");
			System.out.println("2.강사 정보 추가");
			System.out.println("3.담당자 정보 추가");
			System.out.println("4.강의 정보 추가");
			int fourth = sc.nextInt();
			sc.nextLine();
			switch (fourth) {
			case 1:
//				studentctrl.insertStudent();			
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				System.out.println("강의 정보를 추가합니다");
				System.out.println("강의 정보를 추가해 주세요!");

				System.out.println("1.강의명 :");
				String courseName = sc.nextLine();

				System.out.println("2.강의 시작 일자:");
				System.out.println("(yyyy-mm-dd)");
				String startDate = sc.nextLine();

				System.out.println("3.강의 종료 일자:");
				System.out.println("(yyyy-mm-dd)");
				String endDate = sc.nextLine();

				System.out.println("4.강사 id");
				int instructorId = sc.nextInt();

				CourseDTO course = new CourseDTO(courseName, java.sql.Date.valueOf(startDate),
						java.sql.Date.valueOf(endDate));

				courseCtrl.addCourse(course, instructorId);
				break;
			}
			break;
		case 6:
			System.out.println("1.학생 정보 삭제");
			System.out.println("2.강사 정보 삭제");
			System.out.println("3.담당자 정보 삭제");
			System.out.println("4.강의 정보 삭제");
			int sixth = sc.nextInt();
			switch (sixth) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				System.out.println("조회할 강의id:");
				sc.nextLine();
				int courseId = sc.nextInt();
				courseCtrl.deleteCourse(courseId);
			}
			break;

		}
	}
}
