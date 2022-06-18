package view;

import java.util.Scanner;

import controller.InstructorController;
import controller.ManagerController;
import controller.StudentController;
import dto.InstructorDTO;
import dto.ManagerDTO;

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
		InstructorController instructorCtrl = InstructorController.getInstance();
		ManagerController managerCtrl = ManagerController.getInstance();
		
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
				instructorCtrl.allInstructor();
				break;
			case 3:
				managerCtrl.allManager();
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
				studentV.selectStudent();
				break;
			case 2:
				System.out.println("조회할 강사의 이름 검색:");
				sc.nextLine();
				String instructorName = sc.nextLine();
				instructorCtrl.instructorView(instructorName);
				System.out.println();
				break;
			case 3:
				System.out.println("조회할 담당자의 이름 검색:");
				sc.nextLine();
				String managerName = sc.nextLine();
				managerCtrl.managerView(managerName);
				System.out.println();
				break;
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
    	case 2:
				System.out.println("강사의 정보를 업데이트합니다.");
				System.out.println("강사의 id를 입력해주세요:");
				
				int instructorId = sc.nextInt();
				InstructorDTO instructor = instructorCtrl.checkInstructorId(instructorId);
				
				if(instructor != null) {
					String instructorInput = null; // 이름 or 전화번호 수정
					System.out.println("\n1. 이름");
					System.out.println("2. 전화번호\n");
					int instructorInner = sc.nextInt();
					sc.nextLine();

					if (instructorInner == 1) {
						System.out.println("이름를 입력해주세요:");
					} else if(instructorInner == 2) {
						System.out.println("전화번호를 입력해주세요:");
					}
		
					instructorInput = sc.nextLine(); // 이름 or 전화번호
					instructorCtrl.updateInstructor(instructor, instructorInner, instructorInput);
				}
				break;
			case 3:
				System.out.println("담당자의 정보를 업데이트합니다.");
				System.out.println("담당자의 id를 입력해주세요:");
				
				int managerId = sc.nextInt();
				ManagerDTO manager = managerCtrl.checkManagerId(managerId);
				
				if(manager != null) {
					String managerInput = null; // 이름 or 전화번호 수정
					System.out.println("\n1. 이름");
					System.out.println("2. 전화번호\n");
					int managerInner = sc.nextInt();
					sc.nextLine();

					if (managerInner == 1) {
						System.out.println("이름를 입력해주세요:");
					} else if(managerInner == 2) {
						System.out.println("전화번호를 입력해주세요:");
					}
		
					managerInput = sc.nextLine(); // 이름 or 전화번호
					managerCtrl.updateManager(manager, managerInner, managerInput);
				}
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
      case 2:
				int defaultInstructorId = 0;
				System.out.println("새로운 강사를 추가합니다.");
//				System.out.println("강사의 id를 입력해주세요:");
//				int instructorId = sc.nextInt();
				System.out.println("강사의 이름를 입력해주세요:");
				String instructorName = sc.nextLine();
//				sc.nextLine();
				System.out.println("강사의 전화번호 입력해주세요:");
				String instructorPhone = sc.nextLine();
//				sc.nextLine();
//				System.out.println(1);
				instructorCtrl.insertInstructor(new InstructorDTO(defaultInstructorId, instructorName, instructorPhone));
				break;
			case 3:
				int defaultManagerId = 0;
				System.out.println("새로운 담당자를 추가합니다.");
//				System.out.println("강사의 id를 입력해주세요:");
//				int instructorId = sc.nextInt();
				System.out.println("담당자의 이름를 입력해주세요:");
				String managerName = sc.nextLine();
				System.out.println("담당자의 전화번호 입력해주세요:");
				String managerPhone = sc.nextLine();
				
				managerCtrl.insertManager(new ManagerDTO(defaultManagerId, managerName, managerPhone));
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
			case 2:
				System.out.println("삭제할 강사의 id를 입력해주세요:");
				int instructorId = sc.nextInt();
				sc.nextLine();
				
				InstructorDTO instructor = instructorCtrl.checkInstructorId(instructorId);
				if(instructor != null) {
					System.out.println(instructor);
					
					instructorCtrl.deleteInstructor(instructorId);
				} else {
					System.out.println("일치하는 데이터가 존재하지 않습니다.");
				}
					
//				instructorCtrl.deleteInstructor(instructorId);
				break;
			case 3:
				managerCtrl.allManager();
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
