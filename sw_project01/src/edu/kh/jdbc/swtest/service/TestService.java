package edu.kh.jdbc.swtest.service;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import edu.kh.jdbc.swtest.dao.TestDAO;
import edu.kh.jdbc.swtest.vo.SwTest;

public class TestService {

	private TestDAO dao = new TestDAO();
	
	/** 심사 이름별 원생 목록 조회 서비스
	 * @param testName
	 * @return testList
	 * @throws Exception
	 */
	public List<SwTest> selectName(String testName) throws Exception {
		Connection conn = getConnection();
		
		List<SwTest> testList = dao.selectName(conn, testName);
		
		close(conn);
		
		return testList;
	}


	/** 심사비 납부 서비스
	 * @param studentNo
	 * @param testName
	 * @return result
	 * @throws Exception
	 */
	public int testPay(int studentNo, String testName) throws Exception {
		Connection conn = getConnection();
		
		int result = dao.testPay(conn, studentNo, testName);
		
		if(result > 0) commit(conn);
		else           rollback(conn);
		
		close(conn);
		
		return result;
	}


	/** 심사비 미납자 목록 조회
	 * @param testName
	 * @return testList
	 * @throws Exception
	 */
	public List<SwTest> testNoPay(String testName) throws Exception {
		
		Connection conn = getConnection();
		
		List<SwTest> testList2 = dao.testNoPay(conn, testName);
		
		close(conn);
		
		return testList2;
	}






}
