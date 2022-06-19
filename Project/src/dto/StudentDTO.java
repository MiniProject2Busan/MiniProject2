package dto;

public class StudentDTO {
	private int id;
	private String name;
	private int age;
	private String phone;
	private String addr;
	private String seatId;
	private int attendance;
	private int absent;
	private int manager_id;

	public StudentDTO() {
	}

	// 학생 정보 출력
	public StudentDTO(int id, String name, int age, String phone, String addr, String seatId, int attendance, int absent,
			int manager_id) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.phone = phone;
		this.addr = addr;
		this.seatId = seatId;
		this.attendance = attendance;
		this.absent = absent;
		this.manager_id = manager_id;
	}
	// 학생추가
	public StudentDTO(String name, int age, String phone, String addr,String seatId,int manager_id) {
		this.name = name;
		this.age = age;
		this.seatId=seatId;
		this.phone = phone;
		this.addr = addr;
		this.manager_id = manager_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getSeatId() {
		return seatId;
	}

	public void setSeatId(String seatId) {
		this.seatId = seatId;
	}

	public int getAttendance() {
		return attendance;
	}

	public void setAttendance(int attendance) {
		this.attendance = attendance;
	}

	public int getAbsent() {
		return absent;
	}

	public void setAbsent(int absent) {
		this.absent = absent;
	}

	public int getManager_id() {
		return manager_id;
	}

	public void setManager_id(int manager_id) {
		this.manager_id = manager_id;
	}

	@Override
	public String toString() {
		return "StudentDTO [id=" + id + ", name=" + name + ", age=" + age + ", phone=" + phone + ", addr=" + addr
				+ ", seatId=" + seatId + ", attendance=" + attendance + ", absent=" + absent + ", manager_id="
				+ manager_id + "]";
	}
}
