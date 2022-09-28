package edu.kh.jdbc.swmain.service;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;

import edu.kh.jdbc.swmain.dao.SwDAO;
import edu.kh.jdbc.swmaster.vo.SwMaster;

public class SwService {

	private SwDAO dao = new SwDAO();
	
	/** 아이디 중복 검사 서비스
	 * @param masterId
	 * @return result
	 * @throws Exception
	 */
	public int idDupCheck(String masterId) throws Exception {
		Connection conn = getConnection();
		
		int result = dao.idDupCheck(conn, masterId);
		
		close(conn);
		
		return result;
	}

	/** 회원 가입 서비스
	 * @param master
	 * @return result
	 * @throws Exception
	 */
	public int signUp(SwMaster master) throws Exception {
		Connection conn = getConnection();
		
		int result = dao.signUp(conn, master);
		
		if(result > 0) commit(conn);
		else           rollback(conn);
		
		return result;
	}

	/** 로그인 서비스
	 * @param masterId
	 * @param masterPw
	 * @return result
	 * @throws Exception
	 */
	public SwMaster login(String masterId, String masterPw) throws Exception {
		Connection conn = getConnection();
		
		SwMaster loginMaster = dao.login(conn, masterId, masterPw);
		
		close(conn);
		
		return loginMaster;
	}

}
