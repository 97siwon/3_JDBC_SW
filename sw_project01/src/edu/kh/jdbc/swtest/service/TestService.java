package edu.kh.jdbc.swtest.service;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;

import edu.kh.jdbc.swtest.dao.TestDAO;
import edu.kh.jdbc.swtest.vo.SwTest;

public class TestService {

	private TestDAO dao = new TestDAO();
	
	/** 심사 정보 조회 서비스
	 * @param testDate
	 * @return 
	 * @throws Exception
	 */
	public SwTest selectTestInfo(String testDate) throws Exception {
		Connection conn = getConnection();
		
		//SwTest test = dao.selectTestInfo(conn, testDate);
		
		close(conn);
		
		return null;
	}

	/** 띠 별 원생 조회
	 * @param testBelt
	 * @return test
	 * @throws Exception
	 */
	public SwTest selectBelt(String testBelt) throws Exception{
		Connection conn = getConnection();
		
		SwTest test = dao.selectBelt(conn, testBelt);
		
		close(conn);
		
		return test;
	}

}
