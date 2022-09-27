package edu.kh.jdbc.swtest.vo;

public class SwTest {

	private int testNo;
	private String testName;
	private String testDate;
	private int studentId;
	private String studentBelt;
	private String testAttendance;
	private String testPay;
	private int testCount;
	
	public SwTest() {  }

	public SwTest(int testNo, String testName, String testDate, int studentId, String studentBelt,
			String testAttendance, String testPay, int testCount) {
		super();
		this.testNo = testNo;
		this.testName = testName;
		this.testDate = testDate;
		this.studentId = studentId;
		this.studentBelt = studentBelt;
		this.testAttendance = testAttendance;
		this.testPay = testPay;
		this.testCount = testCount;
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

	public int getTestCount() {
		return testCount;
	}

	public void setTestCount(int testCount) {
		this.testCount = testCount;
	}
	
	
	
	
	
	
	
	
	
	
	
}


