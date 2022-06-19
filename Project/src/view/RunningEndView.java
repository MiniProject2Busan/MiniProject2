package view;

import java.util.ArrayList;

import dto.CourseDTO;
import dto.StudentDTO;
import dto.InstructorDTO;
import dto.ManagerDTO;

public class RunningEndView {
	// 모든 강의 정보 출력
	public static void courseListView(ArrayList<CourseDTO> allCourse) {
		int length = allCourse.size();
		if (length != 0) {
			for (int index = 0; index < length; index++) {
				System.out.println("검색정보 " + (index + 1) + " - " + allCourse.get(index));
			}
		}
	}
	/**
	 * Instructor
	 * */
	// 모든 강사 정보 출력
	public static void instructorView(ArrayList<InstructorDTO> instructorList) {
		int length = instructorList.size();
		if (length != 0) {
			for (int index = 0; index < length; index++) {
				System.out.println("검색정보 " + (index + 1) + " - " + instructorList.get(index));
			}
		}

	}
	
	// 특정 강사 정보 출력
	public static void instructorVeiw(InstructorDTO instructor) {
		if(instructor != null) {
			System.out.println(instructor);
		} else {
			System.out.println("해당하는 데이터가 존재하지 않습니다.");
		}
	}
	
	// 특정 강사 정보 수정
	public static void updateView(boolean check) {
		if(check) {
			System.out.println("해당하는 데이터가 수정 되었습니다.");
			System.out.println();
		} else {
			System.out.println("해당하는 데이터가 수정되지 않았습니다.");
			System.out.println();
		}
	}
	
	/**
	 * Manager
	 * */
	// 모든 담당자 정보 출력
	public static void managerView(ArrayList<ManagerDTO> managerList) {
		int length = managerList.size();
		if (length != 0) {
			for (int index = 0; index < length; index++) {
				System.out.println("검색정보 " + (index + 1) + " - " + managerList.get(index));
			}
			System.out.println();
		}

	}
	
	// 특정 담당자 정보 출력
	public static void managerView(ManagerDTO manager) {
		if(manager != null) {
			System.out.println(manager);
		} else {
			System.out.println("해당하는 데이터가 존재하지 않습니다.");
		}
	}
	
	// 특정 강의 정보 출력
	public static void courseView(CourseDTO course) {
		System.out.println(course);
	}
	
	public static void updateCourseNameView(boolean check) {
		if (check) {
			System.out.println("강의 이름이 수정 되었습니다!");
		} else {
			System.out.println("강의 이름이 수정 되지 않았습니다!");
		}
	}

	public static void updateCourseStartDateView(boolean check) {
		if (check) {
			System.out.println("강의 시작일이 수정 되었습니다!");
		} else {
			System.out.println("강의 시작일이 수정 되지 않았습니다!");
		}
	}

	public static void updateCourseEndDateView(boolean check) {
		if (check) {
			System.out.println("강의 종료일이 수정 되었습니다!");
		} else {
			System.out.println("강의 종료일이 수정 되지 않았습니다!");
		}
	}

	public static void Error(String msg) {
		System.out.println(msg);
	}

	public static void projectListView(ArrayList<StudentDTO> allProject) {
		int length = allProject.size();
		System.out.println();
		if (length != 0) {
			for (int index = 0; index < length; index++) {
				System.out.println("검색정보 " + (index + 1) + " - " + allProject.get(index));
			}
		}

	}
	
	
	public static void selectView(StudentDTO studentinfo) {
		if (studentinfo == null) {
			System.out.println("존재하지 않는 회원입니다.");
		}
		System.out.println(studentinfo);
	}

	public static void getsalary(int data) {
		System.out.println("총 금액은 " + data + "원 입니다.");
	}
}
