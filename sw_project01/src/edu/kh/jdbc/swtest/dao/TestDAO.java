package edu.kh.jdbc.swtest.dao;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import edu.kh.jdbc.swtest.vo.SwTest;

public class TestDAO {

	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private Properties prop = null;
	
	public TestDAO() {
		try {
			prop = new Properties();
			prop.loadFromXML(new FileInputStream("sw_query.xml"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** 띠 별 원생 조회
	 * @param conn
	 * @param testBelt
	 * @return test
	 * @throws Exception
	 */
	public SwTest selectBelt(Connection conn, String testBelt) throws Exception {
		SwTest test = null;
		
		try {
			String sql = prop.getProperty("selectBelt");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, testBelt);
			
			if(rs.next()) {
				String studentName = rs.getString("STUDENT_NAME");
				String startDate = rs.getString("STUDENT_DATE");
				String secession = rs.getString("STUDENT_SECESSION_FL");
				
				test = new SwTest(studentName, startDate, secession);
				
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		
		return test;
	}

}
