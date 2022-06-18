package view;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class StartView {

	public static void main(String[] args) {

		while (true) {
			Scanner sc = new Scanner(System.in);
			try {
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
					sc.close();
					break;
				}
				SecondView.secondView(num);
			} catch (NoSuchElementException e) {
				System.out.println("입력값이 잘못되었습니다.\n");
			} finally {
				sc.reset();
			}
		}
	}
}
