package view;

import java.util.NoSuchElementException;
import java.util.Scanner;

import controller.ManagerController;
import dto.ManagerDTO;

public class ManagerView implements ViewInterface {
	private static ManagerView instance = new ManagerView();
	ManagerController managerCtrl = ManagerController.getInstance();

	private ManagerView() {
	}

	public static ManagerView getInstance() {
		return instance;
	}

	public void allPeople() {
		managerCtrl.allManager();
	}

	public void selectView() throws NoSuchElementException {
		Scanner sc = new Scanner(System.in);
		System.out.println("조회할 담당자의 이름 검색:");
		String managerName = sc.nextLine();
		managerCtrl.managerView(managerName);
		System.out.println();
	}

	public void updateView() throws NoSuchElementException {
		Scanner sc = new Scanner(System.in);
		System.out.println("담당자의 정보를 업데이트합니다.");
		System.out.println("담당자의 id를 입력해주세요:");

		int managerId = sc.nextInt();
		ManagerDTO manager = managerCtrl.checkManagerId(managerId);

		if (manager != null) {
			String managerInput = null; // 이름 or 전화번호 수정
			System.out.println("\n1. 이름");
			System.out.println("2. 전화번호\n");
			int managerInner = sc.nextInt();
			sc.nextLine();

			if (managerInner == 1) {
				System.out.println("이름를 입력해주세요:");
			} else if (managerInner == 2) {
				System.out.println("전화번호를 입력해주세요:");
			}

			managerInput = sc.nextLine(); // 이름 or 전화번호
			managerCtrl.updateManager(manager, managerInner, managerInput);
		}
	}

	public void insertView() throws NoSuchElementException {
		Scanner sc = new Scanner(System.in);
		int defaultManagerId = 0;
		System.out.println("새로운 담당자를 추가합니다.");
//		System.out.println("강사의 id를 입력해주세요:");
//		int instructorId = sc.nextInt();
		System.out.println("담당자의 이름를 입력해주세요:");
		String managerName = sc.nextLine();
		System.out.println("담당자의 전화번호 입력해주세요:");
		String managerPhone = sc.nextLine();
		managerCtrl.insertManager(new ManagerDTO(defaultManagerId, managerName, managerPhone));
	}

	public void deleteView() throws NoSuchElementException {
	}
}
