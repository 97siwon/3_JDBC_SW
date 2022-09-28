package edu.kh.jdbc.swtest.vo;

public class SwTest {
	
	private int testNo;
	private String testName;
	private String testDate;
	private int studentId;
	private String studentBelt;
	private String testAttendance;
	private String testPay;
	private String studentName;
	private String startDate;
	private String studentSecession;


	public SwTest(int testNo, String testName, String testDate, int studentId, String studentBelt,
			String testAttendance, String testPay, String studentName, String startDate, String studentSecession) {
		super();
		this.testNo = testNo;
		this.testName = testName;
		this.testDate = testDate;
		this.studentId = studentId;
		this.studentBelt = studentBelt;
		this.testAttendance = testAttendance;
		this.testPay = testPay;
		this.studentName = studentName;
		this.startDate = startDate;
		this.studentSecession = studentSecession;
	}
	
	
	public SwTest() {  }


	
	

	public SwTest(String testName, String testDate, String studentBelt, String studentName, String startDate,
			String studentSecession) {
		super();
		this.testName = testName;
		this.testDate = testDate;
		this.studentBelt = studentBelt;
		this.studentName = studentName;
		this.startDate = startDate;
		this.studentSecession = studentSecession;
	}


	public SwTest(String testName, String testDate, String studentName) {
		super();
		this.testName = testName;
		this.testDate = testDate;
		this.studentName = studentName;
	}


	public int getTestNo() {
		return testNo;
	}

	public void setTestNo(int testNo) {
		this.testNo = testNo;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public String getTestDate() {
		return testDate;
	}

	public void setTestDate(String testDate) {
		this.testDate = testDate;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentBelt() {
		return studentBelt;
	}

	public void setStudentBelt(String studentBelt) {
		this.studentBelt = studentBelt;
	}

	public String getTestAttendance() {
		return testAttendance;
	}

	public void setTestAttendance(String testAttendance) {
		this.testAttendance = testAttendance;
	}

	public String getTestPay() {
		return testPay;
	}

	public void setTestPay(String testPay) {
		this.testPay = testPay;
	}


	public String getStudentName() {
		return studentName;
	}


	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}


	public String getStartDate() {
		return startDate;
	}


	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}


	public String getStudentSecession() {
		return studentSecession;
	}


	public void setStudentSecession(String studentSecession) {
		this.studentSecession = studentSecession;
	}

	
	
	
	
	
	
	
	
	
	
}


