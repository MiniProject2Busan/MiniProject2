package view;

import java.util.Scanner;

import controller.InstructorController;
import dto.InstructorDTO;

public class TestInstructorView {

	public static void main(String[] args) {
		// Scanner
		Scanner sc = new Scanner(System.in);
		
		InstructorController controller = InstructorController.getInstance();
		
		System.out.println("===특정 강사 정보 출력====");
		controller.instructorView("신용기");
		
		System.out.println();

		System.out.println("===특정 강사 정보 수정====");
		InstructorDTO instructor = controller.checkInstructorId(1);
		if(instructor != null) {
//			while (true) {
				System.out.println("1. 이름");
				System.out.println("2. 연락처");
				
				int num = sc.nextInt();
//					if (num < 0) {
//						RunningSuccessView.showSuccess("프로그램을 종료합니다.");
//						break;
//					}
////					AllListsView.secondView(num);
//				} catch (Exception e) {
//					RunningEndView.Error("잘못된 입력입니다.");
//					System.out.println("종료합니다.");
//					break;
//				}

//			}
			
			// 이름 수정
			System.out.println("수정할 이름을 입력하세요:");
			sc.nextLine();
			String name = sc.nextLine();
			controller.updateInstructor(instructor, num, name);
			
			// 연락처 수정
		} else {
			System.out.println("일치하는 데이터가 존재하지 않습니다.");
		}
	}

}
