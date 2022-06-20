package dto;

public class ManagerDTO {
	private int manager_id; // 담당자 id
	private String manager_name; // 담당자 이름
	private String manager_phone; // 담당자 연락처
	
	public ManagerDTO() {}
	public ManagerDTO(int manager_id, String manager_name, String manager_phone) {
		super();
		this.manager_id = manager_id;
		this.manager_name = manager_name;
		this.manager_phone = manager_phone;
	}
	public int getManagerId() {
		return manager_id;
	}
	public void setManagerId(int manager_id) {
		this.manager_id = manager_id;
	}
	public String getManagerName() {
		return manager_name;
	}
	public void setManagerName(String manager_name) {
		this.manager_name = manager_name;
	}
	public String getManagerPhone() {
		return manager_phone;
	}
	public void setManagerPhone(String manager_phone) {
		this.manager_phone = manager_phone;
	}
	@Override
	public String toString() {

		return "담당자 ID:" + manager_id + "\t담당자 이름:" + manager_name + "\t담당자 전화번호:"
				+ manager_phone;
	}
	
}
