package view;

import java.util.Scanner;

import controller.InstructorController;
import dto.InstructorDTO;

public class TestInstructorView {

	public static void main(String[] args) {
		// Scanner
		Scanner sc = new Scanner(System.in);
		
		InstructorController controller = InstructorController.getInstance();
//		
//		System.out.println("===특정 강사 정보 출력====");
//		controller.instructorView("신용기");
//		
//		System.out.println();
//
//		System.out.println("===특정 강사 정보 수정====");
//		InstructorDTO instructorU = controller.checkInstructorId(1);
//		if(instructorU != null) {
////			while (true) {
//				System.out.println("1. 이름");
//				System.out.println("2. 연락처");
				
//				int num = sc.nextInt();
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
			
			// 연락처, 이름 수정
//			String inputValue = null;
//			
//			if(num == 1) {
//				System.out.println("수정할 이름을 입력하세요 : ");
//			} else if(num == 2) {
//				System.out.println("수정할 연락처를 입력하세요 : ");
//			}
//			
//			sc.nextLine();
//			inputValue = sc.nextLine();
//			controller.updateInstructor(instructorU, num, inputValue);
//			
////			// 이름, 연락처 수정
////			System.out.println("수정할 이름을 입력하세요:");
////			sc.nextLine();
////			String name = sc.nextLine();
////			controller.updateInstructor(instructor, num, name);
//		} else {
//			System.out.println("일치하는 데이터가 존재하지 않습니다.");
//		}
//		
//		// 강사 추가
//		System.out.println("===특정 강사 정보 추가====");
//		controller.insertInstructor(new InstructorDTO(1, "백문기", "010-1111-1111"));
		
		// 강사 삭제
		System.out.println("===특정 강사 정보 삭제====");
		InstructorDTO instructorD = controller.checkInstructorId(1);
		if(instructorD != null) {
			System.out.println(instructorD);
			System.out.println("정말 삭제하시겠습니까?");
		
			controller.deleteInstructor(1);
		} else {
			System.out.println("일치하는 데이터가 존재하지 않습니다.");
		}
	}

}