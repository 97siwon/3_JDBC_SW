package edu.kh.jdbc.swstudent.vo;

import edu.kh.jdbc.swstudent.vo.Student;

public class Student {

	private int studentId;
	private String studentName;
	private String studentGender; 
	private String studentNo;
	private String startDate;
	private String studentBelt;
	private String studentSecession;
	
	
	public Student() { }

	public Student(int studentId, String studentName, String studentGender, String studentNo, String startDate,
			String studentBelt, String studentSecession) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentGender = studentGender;
		this.studentNo = studentNo;
		this.startDate = startDate;
		this.studentBelt = studentBelt;
		this.studentSecession = studentSecession;
	}


	public Student(int studentId, String studentName, String studentGender, String studentNo, String startDate,
			String studentBelt) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentGender = studentGender;
		this.studentNo = studentNo;
		this.startDate = startDate;
		this.studentBelt = studentBelt;
	}




	public int getStudentId() {
		return studentId;
	}


	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}


	public String getStudentName() {
		return studentName;
	}


	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}


	public String getStudentGender() {
		return studentGender;
	}


	public void setStudentGender(String studentGender) {
		this.studentGender = studentGender;
	}


	public String getStudentNo() {
		return studentNo;
	}


	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}


	public String getStartDate() {
		return startDate;
	}


	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}


	public String getStudentBelt() {
		return studentBelt;
	}


	public void setStudentBelt(String studentBelt) {
		this.studentBelt = studentBelt;
	}
	

	public String getStudentSecession() {
		return studentSecession;
	}


	public void setStudentSecession(String studentSecession) {
		this.studentSecession = studentSecession;
	}
	
	
}
