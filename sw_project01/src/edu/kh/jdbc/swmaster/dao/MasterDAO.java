package edu.kh.jdbc.swmaster.dao;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import edu.kh.jdbc.swmaster.vo.SwMaster;

public class MasterDAO {
	
	// 필드(== 멤버 변수)
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Properties prop;
	
	public MasterDAO() { // 기본 생성자
		try {
			prop = new Properties();
			prop.loadFromXML(new FileInputStream("master-query.xml"));
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
			
	}

	/** 회원 정보 수정 DAO
	 * @param conn
	 * @param master
	 * @return result
	 * @throws Exception
	 */
	public int updateMaster(Connection conn, SwMaster master) throws Exception {
		int result = 0;
		
		try {
			String sql = prop.getProperty("updateMaster");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, master.getGymName());
			pstmt.setInt(2, master.getStudentCount());
			pstmt.setString(3, master.getMasterId());
			
			result = pstmt.executeUpdate();

		} finally {
			close(pstmt);
		}	
		return result;
	}

	/** 비밀번호 변경 DAO
	 * @param conn
	 * @param currentPw
	 * @param newPw1
	 * @param masterId
	 * @return result
	 * @throws Exception
	 */
	public int updatePw(Connection conn, String currentPw, String newPw1, String masterId) throws Exception {
		int result = 0;
		
		try {
			String sql = prop.getProperty("updatePw");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,  newPw1);
			pstmt.setString(2, masterId);
			pstmt.setString(3, currentPw);
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}

		return result;
	}

	/** 회원 탈퇴 DAO
	 * @param conn
	 * @param masterPw
	 * @param masterName
	 * @return result
	 * @throws Exception
	 */
	public int secession(Connection conn, String masterPw, String masterName) throws Exception {
		int result = 0;
		
		try {
			String sql = prop.getProperty("secession");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, masterName);
			pstmt.setString(2, masterPw);
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}

}
