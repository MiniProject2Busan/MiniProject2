package view;

import java.util.NoSuchElementException;
import java.util.Scanner;

import controller.InstructorController;
import dto.InstructorDTO;

public class InstructorView implements ViewInterface {
	InstructorController instructorCtrl = InstructorController.getInstance();

	private static InstructorView instructorV = new InstructorView();

	private InstructorView() {
	};

	public static InstructorView getInstance() {
		return instructorV;
	}

	public void allPeople() {
		instructorCtrl.allInstructor();
	}

	public void selectView() throws NoSuchElementException {
		Scanner sc = new Scanner(System.in);
		System.out.println("조회할 강사의 이름 검색:");
		String instructorName = sc.nextLine();
		instructorCtrl.instructorView(instructorName);
		System.out.println();
	}

	public void updateView() throws NoSuchElementException {
		Scanner sc = new Scanner(System.in);
		System.out.println("강사의 정보를 업데이트합니다.");
		System.out.println("강사의 id를 입력해주세요:");

		int instructorId = sc.nextInt();
		InstructorDTO instructor = instructorCtrl.checkInstructorId(instructorId);

		if (instructor != null) {
			String instructorInput = null; // 이름 or 전화번호 수정
			
			System.out.println();
			System.out.println("1. 이름");
			System.out.println("2. 전화번호");
			System.out.println();
			
			int instructorInner = sc.nextInt();
			sc.nextLine();

			if (instructorInner == 1) {
				System.out.println("이름를 입력해주세요:");
			} else if (instructorInner == 2) {
				System.out.println("전화번호를 입력해주세요:");
			}
			//

			instructorInput = sc.nextLine(); // 이름 or 전화번호
			instructorCtrl.updateInstructor(instructor, instructorInner, instructorInput);
		} else {
			System.out.println("요청하신 데이터가 존재하지 않습니다.");
			System.out.println();
		}
	}

	public void insertView() throws NoSuchElementException {
		Scanner sc = new Scanner(System.in);
		int defaultInstructorId = 0;
		System.out.println("새로운 강사를 추가합니다.");
//		System.out.println("강사의 id를 입력해주세요:");
//		int instructorId = sc.nextInt();
		System.out.println("강사의 이름를 입력해주세요:");
		String instructorName = sc.nextLine();
//		sc.nextLine();
		System.out.println("강사의 전화번호 입력해주세요:");
		String instructorPhone = sc.nextLine();
//		sc.nextLine();
//		System.out.println(1);
		System.out.println();
		instructorCtrl.insertInstructor(new InstructorDTO(defaultInstructorId, instructorName, instructorPhone));
	}

	public void deleteView() throws NoSuchElementException {
		Scanner sc = new Scanner(System.in);
		System.out.println("삭제할 강사의 id를 입력해주세요:");
		int instructorId = sc.nextInt();
		sc.nextLine();

		InstructorDTO instructor = instructorCtrl.checkInstructorId(instructorId);
		if (instructor != null) {
			System.out.println("Deleted! " + instructor);
			System.out.println();

			instructorCtrl.deleteInstructor(instructorId);
		} else {
			System.out.println("일치하는 데이터가 존재하지 않습니다.");
			System.out.println();
		}
//		instructorCtrl.deleteInstructor(instructorId);
	}
}
