package view;

import java.util.Scanner;

import dto.StudentDTO;

public class StudentView {
	static Scanner sc = new Scanner(System.in);
	// 학생추가 뷰
	public static StudentDTO insertView() {
		try {
			System.out.println("학생의 이름을 입력하세요:");
			String name = sc.next();
			System.out.println("학생의 나이를 입력하세요:");
			int age = sc.nextInt();
			System.out.println("학생의 전화번호를 입력하세요:");
			String phone = sc.next();
			sc.nextLine();
			System.out.println("학생의 주소를 입력하세요:");
			String addr = sc.next();
			System.out.println("학생의 좌석이름 입력하세요:");
			String seatId =sc.next();
			System.out.println("학생의 매니저를 입력하세요:");
			int manager = sc.nextInt();
			StudentDTO student = new StudentDTO(name,age,phone,addr,seatId,manager);
			return student;			
		} catch (Exception e) {
			RunningEndView.Error("입력값이 잘못되었습니다.");
		}finally{
			sc.close();
		}
		return null;
	}
	public static String deleteView() {
		System.out.println("학생의 id를 입력하세요:");
		String id = sc.next();
		return id;
	}
}
