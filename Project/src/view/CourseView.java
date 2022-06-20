package view;

import java.util.NoSuchElementException;
import java.util.Scanner;

import controller.CourseController;
import dto.CourseDTO;

public class CourseView {
	private CourseController courseCtrl = CourseController.getInstance();
	private static CourseView courseV = new CourseView();

	private CourseView() {
	}

	public static CourseView getInstance() {
		return courseV;
	}

	public void allCourse() {
		courseCtrl.allCourse();
		System.out.println();
	}

	public void insertView() throws NoSuchElementException {
		Scanner sc = new Scanner(System.in);
		System.out.println("강의 이름을 입력하세요: ");
		System.out.println("(최대 10글자)");
		String courseName = sc.next();
		System.out.println("강의 시작일을 입력하세요: ");
		System.out.println("(yyyy-MM-dd)");
		String startDate = sc.next();
		System.out.println("강의 종료일을 입력하세요: ");
		System.out.println("(yyyy-MM-dd)");
		String endDate = sc.next();
		System.out.println("강의 담당 강사 id를 입력하세요: ");
		int instructorId = sc.nextInt();

		courseCtrl.addCourse(courseName, startDate, endDate, instructorId);
		System.out.println();

	}

	public void selectView() throws NoSuchElementException {
		Scanner sc = new Scanner(System.in);
		System.out.println("조회할 강의 이름 검색: ");
		String courseName = sc.nextLine();
		System.out.println("───────────────────────────────────────────────────────────────────────────────────");
		courseCtrl.selectCourse(courseName);
		System.out.println("───────────────────────────────────────────────────────────────────────────────────");
		System.out.println();
	}

	public void updateView() throws NoSuchElementException {
		Scanner sc = new Scanner(System.in);
		String modify;
		System.out.println("강의 정보를 업데이트 합니다.");
		System.out.println("강의 id를 입력해 주세요.");
		int courseId = sc.nextInt();
		CourseDTO course = courseCtrl.checkCourseId(courseId);
		if (course != null) {
			System.out.println("수정할 강의 정보를 선택해 주세요.");
			System.out.println("\n1. 강의 이름");
			System.out.println("2. 강의 시작일");
			System.out.println("3. 강의 종료일\n");
			int selectNum = sc.nextInt();
			if (selectNum == 1) {
				System.out.println("강의 이름을 입력해 주세요.");
				System.out.println("(최대 10글자)");
			} else if (selectNum == 2) {
				System.out.println("강의 시작일을 입력해 주세요.");
				System.out.println("(yyyy-MM-dd)");
				System.out.println();
			} else if (selectNum == 3) {
				System.out.println("강의 종료일을 입력해 주세요.");
				System.out.println("(yyyy-MM-dd)");
				System.out.println();
			} else {
				System.out.println("잘못된 입력입니다.");
				System.out.println();
			}
			modify = sc.next();
			courseCtrl.updateCourse(courseId, selectNum, modify);
		} else {
			System.out.println("해당하는 강의가 없습니다.");
			System.out.println();
		}
	}

	public void deleteView() throws NoSuchElementException {
		Scanner sc = new Scanner(System.in);
		System.out.println("강의 id를 입력하세요: ");
		System.out.println();
		int courseId = sc.nextInt();
		courseCtrl.deleteCourse(courseId);
	}

}
