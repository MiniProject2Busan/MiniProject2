package view;

import java.util.Scanner;

import controller.MainController;

public class AllListsView {

	//
	public static void secondView(int num) {
		switch (num) {
		case 1:
			allListView();
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		}
	}

	private static void allListView() {
		Scanner sc = new Scanner(System.in);
		System.out.println("==모든 정보 출력 ==");
		System.out.println("\n1.학생 정보 출력");
		System.out.println("2.강사 정보 출력");
		System.out.println("3.강의 정보 출력");
		System.out.println("4.담당자 정보 출력");
		System.out.println();
		try {
			int num = sc.nextInt();
			MainController.selectView(num);
		} catch (Exception e) {

		}
	}
}
