package dto;

import java.sql.Date;

public class CourseDTO {
	private int courseId;
	private String courseName;
	private Date startDate;
	private Date endDate;
	private int instructorId;

	public CourseDTO() {
	}

	// 강의 정보 입력
	public CourseDTO(String courseName, Date startDate, Date endDate, int instructorId) {
		super();
		this.courseName = courseName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.instructorId = instructorId;
	}

	// 강의 정보 출력
	public CourseDTO(int courseId, String courseName, Date startDate, Date endDate, int instructorId) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.instructorId = instructorId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getInstructorId() {
		return instructorId;
	}

	public void setInstructorId(int instructorId) {
		this.instructorId = instructorId;
	}

	@Override
	public String toString() {
		
		return "강의ID:" + courseId + "\t강의명:" + courseName +  "\t강의 시작 일자:" + startDate
				+"\t강의 종료 일자:" + endDate + "\t강사Id:" + instructorId;
	}

}
