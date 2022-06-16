package controller;

public class MainController {

	public static void selectView(int num) {

		switch (num) {
		case 1: // 학생 모든 정보 출력
//			StudentDAO.getAllStudent();
			break;
		case 2: // 강사 모든 정보 출력

			break;
		case 3: // 강의 모든 정보 출력

			break;
		case 4: // 담당자 정보 출력

			break;
		default:
			System.out.println("입력 값이 잘못되었습니다.");
			System.out.println("이전 화면으로 돌아갑니다.\n");
			break;
		}
	}
}
