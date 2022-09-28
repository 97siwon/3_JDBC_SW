package edu.kh.jdbc.swtest.dao;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.jdbc.swstudent.vo.Student;
import edu.kh.jdbc.swtest.vo.SwTest;

public class TestDAO {
	
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private Properties prop = null;
	
	
	public TestDAO() {
		try {
			prop = new Properties();
			prop.loadFromXML(new FileInputStream("test-query.xml"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	/** 심사 이름별 원생 목록 조회
	 * @param conn
	 * @param testName
	 * @return testList
	 * @throws Exception
	 */
	public List<SwTest> selectName(Connection conn, String testName) throws Exception {
		List<SwTest> testList = new ArrayList<>();
		
		try {
			String sql = prop.getProperty("selectName");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, testName);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {

				// String testName = rs.getString("TEST_N1M");
				String testDate = rs.getString("TEST_DATE");
				String studentName= rs.getString("STUDENT_NM");
				String studentBelt = rs.getString("STUDENT_BELT");
				String startDate = rs.getString("STUDENT_DATE");
				String studentSecession = rs.getString("STUDENT_SECESSION_FL");

				SwTest test = new SwTest(testName, testDate, studentName, 
						studentBelt, startDate, studentSecession);
				
				testList.add(test);
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
	
		return testList;
	}

	
	
	/** 심사비 납부 DAO
	 * @param conn
	 * @param studentNo
	 * @param testName
	 * @return result
	 * @throws Exception
	 */
	public int testPay(Connection conn, int studentNo, String testName) throws Exception {
		
		int result = 0;
		
		try {
			String sql = prop.getProperty("testPay");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, studentNo);
			pstmt.setString(2, testName);
			
			result = pstmt.executeUpdate();
			
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	/** 심사비 미납자 목록 조회 DAO
	 * @param conn
	 * @param testName
	 * @return testList
	 * @throws Exception
	 */
	public List<SwTest> testNoPay(Connection conn, String testName) throws Exception {
		List<SwTest> testList2 = new ArrayList<>();
		
		try {
			String sql = prop.getProperty("testNoPay");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, testName);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String testDate = rs.getString("TEST_DATE");
				String studentName= rs.getString("STUDENT_NM");
				
				SwTest test = new SwTest(testName, testDate, studentName);
				
				testList2.add(test);
			}
	
		} finally {
			close(rs);
			close(pstmt);
		}
		
		
		return testList2;
	}




}
