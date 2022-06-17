package view;

import controller.StudentController;
	
public class StudentView {
	private static StudentView instance = new StudentView();
	StudentController controller = StudentController.getInstance();
	StudentView(){}
	StudentView getInstance(){
		return instance;
	}
	
	public void allStudent() {
		controller.allStudent();
	}
}
