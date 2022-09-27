package edu.kh.jdbc.swmaster.vo;

public class SwMaster {

	private String masterId;
	private String masterPw;
	private String gymName;
	private String masterName;
	private int studentCount;
	private String enrollDate;
	private String secessionFlag;
	
	public SwMaster() { }
	
	public SwMaster(String masterId, String masterPw, String gymName, String masterName, int studentCount,
			String enrollDate, String secessionFlag) {
		super();
		this.masterId = masterId;
		this.masterPw = masterPw;
		this.gymName = gymName;
		this.masterName = masterName;
		this.studentCount = studentCount;
		this.enrollDate = enrollDate;
		this.secessionFlag = secessionFlag;
	}

	public SwMaster(String masterId, String masterPw2, String gymName, String masterName, int studentCount) {
		super();
		this.masterId = masterId;
		this.masterPw = masterPw2;
		this.gymName = gymName;
		this.masterName = masterName;
		this.studentCount = studentCount;
	}


	public String getMasterId() {
		return masterId;
	}

	public void setMasterId(String masterId) {
		this.masterId = masterId;
	}

	public String getMasterPw() {
		return masterPw;
	}

	public void setMasterPw(String masterPw) {
		this.masterPw = masterPw;
	}

	public String getGymName() {
		return gymName;
	}

	public void setGymName(String gymName) {
		this.gymName = gymName;
	}

	public String getMasterName() {
		return masterName;
	}

	public void setMasterName(String masterName) {
		this.masterName = masterName;
	}

	public int getStudentCount() {
		return studentCount;
	}

	public void setStudentCount(int studentCount) {
		this.studentCount = studentCount;
	}

	public String getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}

	public String getSecessionFlag() {
		return secessionFlag;
	}

	public void setSecessionFlag(String secessionFlag) {
		this.secessionFlag = secessionFlag;
	}
	
	
	
	
	
}
