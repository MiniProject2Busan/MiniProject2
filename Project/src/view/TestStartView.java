package view;

import java.util.Scanner;

import controller.InstructorController;
import controller.ManagerController;
import dto.InstructorDTO;
import dto.ManagerDTO;

public class TestStartView {

	public static void main(String[] args) {
		// Scanner
		Scanner sc = new Scanner(System.in);
		
		InstructorController controller = InstructorController.getInstance();
		ManagerController mController = ManagerController.getInstance();
		
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
//				
////				int num = sc.nextInt();
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
//
////			}
//			
//			// 연락처, 이름 수정
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
		// 강사 추가
		System.out.println("===특정 강사 정보 추가====");
		controller.insertInstructor(new InstructorDTO(0, "정영광", "010-1111-1111"));
		
		// 강사 삭제 (추후 고민)
		// 해당 교육이 진행중인지? ---> course의 instructor_id 값 update 
		// 해당 교육이 종료됐는지? --> 담당 강사의 course도 같이 삭제 
		
		// 도중에 강사가 변경되는 사항은 고려하지 않음
		// 강사가 삭제되면 해당 강의도 같이 삭제
//		System.out.println("===특정 강사 정보 삭제====");
//		InstructorDTO instructorD = controller.checkInstructorId(1);
//		if(instructorD != null) {
//			System.out.println(instructorD);
//			System.out.println("정말 삭제하시겠습니까?");
//		
//			controller.deleteInstructor(1);
//		} else {
//			System.out.println("일치하는 데이터가 존재하지 않습니다.");
//		}
		
		// 특정 담당자 조회
//		mController.managerView("윤다경");
//		
//		// 특정 담당자 수정
//		System.out.println("===특정 담당자 정보 수정====");
//		ManagerDTO managerU = mController.checkManagerId(1);
//		if(managerU != null) {
////			while (true) {
//				System.out.println("1. 이름");
//				System.out.println("2. 연락처");
//				
//				int num = sc.nextInt();
////				if (num < 0) {
////					RunningSuccessView.showSuccess("프로그램을 종료합니다.");
////					break;
////				}
////			}
//			
//			// 연락처, 이름 수정
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
//			mController.updateManager(managerU, num, inputValue);
//		} else {
//			System.out.println("일치하는 데이터가 존재하지 않습니다.");
//		}
		
		// 담당자 추가
//		System.out.println("===특정 담당자 정보 추가====");
//		mController.insertManager(new ManagerDTO(0, "백성준", "010-1111-1111"));
		
		// 담당자 삭제
//		System.out.println("===특정 담당자 정보 삭제====");
//		ManagerDTO managerD = mController.checkManagerId(1);
//		if(managerD != null) {
//			System.out.println(managerD);
//			System.out.println("정말 삭제하시겠습니까?");
//		
//			mController.deleteManager(1);
//		} else {
//			System.out.println("일치하는 데이터가 존재하지 않습니다.");
//		}
	}

}
