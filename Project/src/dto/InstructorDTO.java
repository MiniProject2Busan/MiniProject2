package dto;

public class InstructorDTO {
	private int instructor_id; // 강사 id
	private String instructor_name; // 강사 이름
	private String instructor_phone; // 강사 연락처
	
	public InstructorDTO() {}
	public InstructorDTO(int instructor_id, String instructor_name, String instructor_phone) {
		super();
		this.instructor_id = instructor_id;
		this.instructor_name = instructor_name;
		this.instructor_phone = instructor_phone;
	}
	
	public int getInstructorId() {
		return instructor_id;
	}
	public void setInstructorId(int instructor_id) {
		this.instructor_id = instructor_id;
	}
	public String getInstructorName() {
		return instructor_name;
	}
	public void setInstructorName(String instructor_name) {
		this.instructor_name = instructor_name;
	}
	public String getInstructorPhone() {
		return instructor_phone;
	}
	public void setInstructorPhone(String instructor_phone) {
		this.instructor_phone = instructor_phone;
	}
	
	@Override
	public String toString() {
		return "강사아이디 = " + instructor_id + "\n강사이름 = " + instructor_name
				+ "\n강사연락처 = " + instructor_phone;
	}
	
}
