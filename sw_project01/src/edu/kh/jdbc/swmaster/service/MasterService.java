package edu.kh.jdbc.swmaster.service;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;

import edu.kh.jdbc.swmaster.dao.MasterDAO;
import edu.kh.jdbc.swmaster.vo.SwMaster;

public class MasterService {
	
	private MasterDAO dao = new MasterDAO();

	/** 회원 정보 수정 서비스
	 * @param master
	 * @return result
	 * @throws Exception
	 */
	public int updateMaster(SwMaster master) throws Exception {
		Connection conn = getConnection();
		
		int result = dao.updateMaster(conn, master);
		
		if(result > 0) commit(conn);
		else           rollback(conn);
		
		close(conn);
		
		return result;
	}

	/** 비밀번호 변경 서비스
	 * @param currentPw
	 * @param newPw1
	 * @param masterId
	 * @return result
	 * @throws Exception
	 */
	public int updatePw(String currentPw, String newPw1, String masterId) throws Exception {
		Connection conn = getConnection();
		
		int result = dao.updatePw(conn, currentPw, newPw1, masterId);
		
		if(result > 0) commit(conn);
		else           rollback(conn);
		
		close(conn);
		
		return result;
	}

	/** 회원 탈퇴 서비스
	 * @param masterPw
	 * @param masterName
	 * @return
	 * @throws Exception
	 */
	public int secession(String masterPw, String masterName) throws Exception {
		 Connection conn = getConnection();
		 
		 int result = dao.secession(conn, masterPw, masterName);
		 
		 if(result > 0) commit(conn);
		 else           rollback(conn);
		
		return result;
	}

}
