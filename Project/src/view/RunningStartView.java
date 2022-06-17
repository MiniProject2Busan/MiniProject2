package view;

import java.util.Scanner;

import controller.CourseController;
import dto.CourseDTO;

public class RunningStartView {

	public static void main(String[] args) {
		CourseController controller = CourseController.getInstance();
//		Scanner sc = new Scanner(System.in);
//		while (true) {
//			System.out.println("First.메인 시스템");
//			System.out.println("1.정보 출력"); // 클리어
//			System.out.println("2.특정 정보 출력"); // 클리어
//			System.out.println("3.정보 수정 ");
//			System.out.println("4.출결 사항 및 교육비 출력");
//			System.out.println("-1. 종료");
//			System.out.println();
//			try {
//				int num = sc.nextInt();
//				if (num < 0) {
//					RunningSuccessView.showSuccess("프로그램을 종료합니다.");
//					break;
//				}
//				AllListsView.secondView(num);
//			} catch (Exception e) {
//				RunningEndView.Error("잘못된 입력입니다.");
//				System.out.println("종료합니다.");
//				break;
//			}
//
//		}
//		controller.allCourse();
//		controller.Course("Network");
//		controller.updateCourseName(1, "Network");
		
//		controller.updateCourseStartDate(1, "2022-03-11");
//		controller.deleteCourse("React");
		
//		controller.addCourse(new CourseDTO(1, "Java", "2022-01-22", "2022-02-22", 1));
		controller.allCourse();
		
	}
}
