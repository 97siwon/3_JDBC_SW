package edu.kh.jdbc.swmain.dao;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import edu.kh.jdbc.swmaster.vo.SwMaster;

public class SwDAO {

	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private Properties prop = null;
	
	// 기본 생성자
	public SwDAO() {
		
		try {
			prop = new Properties(); // Properties 객체 생성
			prop.loadFromXML(new FileInputStream("main-query.xml"));
			// main-query.xml 파일의 내용을 읽어와 Properties 객체에 저장
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/** 아이디 중복 검사 DAO
	 * @param conn
	 * @param masterId
	 * @return result
	 * @throws Exception
	 */
	public int idDupCheck(Connection conn, String masterId) throws Exception {
		int result = 0;
		
		try {
			String sql = prop.getProperty("idDupCheck");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, masterId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		
		return result;
	}

	/** 회원 가입 DAO
	 * @param conn
	 * @param master
	 * @return result
	 * @throws Exception
	 */
	public int signUp(Connection conn, SwMaster master) throws Exception {
		int result = 0;
		try {
			String sql = prop.getProperty("signUp");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, master.getMasterId());
			pstmt.setString(2, master.getMasterPw());
			pstmt.setString(3, master.getGymName());
			pstmt.setString(4, master.getMasterName());
			pstmt.setInt(5, master.getStudentCount());
			
			result = pstmt.executeUpdate();
			
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	/** 로그인 DAO
	 * @param conn
	 * @param masterId
	 * @param masterPw
	 * @return loginMaster
	 * @throws Exception
	 */
	public SwMaster login(Connection conn, String masterId, String masterPw) throws Exception {
		SwMaster loginMaster = null;
		
		try {
			String sql = prop.getProperty("login");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, masterId);
			pstmt.setString(2, masterPw);
			
			rs = pstmt.executeQuery();
					
			if(rs.next()) {
				loginMaster = new SwMaster();
				
				loginMaster.setMasterId(rs.getString("MASTER_ID"));
				loginMaster.setGymName(rs.getString("GYM_NM"));
				loginMaster.setMasterName(rs.getString("MASTER_NM"));
				loginMaster.setStudentCount(rs.getInt("STUDENT_COUNT"));
				loginMaster.setEnrollDate(rs.getString("ENROLL_DATE"));
				
			}
	
		} finally {
			close(rs);
			close(pstmt);
		}

		return loginMaster;
	}

}
