package view;

import java.util.ArrayList;

import dto.StudentDTO;

public class RunningEndView {

	public static void Error(String msg) {
		System.out.println(msg);
	}
	public static void projectListView(ArrayList<StudentDTO> allProject) {
//		System.out.println(allProject);
		int length = allProject.size();
		if (length != 0) {
			for (int index = 0; index < length; index++) {
				System.out.println("검색정보 " + (index + 1) + " - " + allProject.get(index));
			}
		}
	}
}
