package edu.kh.jdbc.swstudent.service;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import edu.kh.jdbc.swstudent.dao.StudentDAO;
import edu.kh.jdbc.swstudent.vo.Student;

public class StudentService {
	
	private StudentDAO dao = new StudentDAO();

	/** 원생 등록 서비스
	 * @param student
	 * @return result
	 * @throws Exception
	 */
	public int insertStudent(Student student) throws Exception {
		Connection conn = getConnection();
		
		int result = dao.insertStudent(conn, student);
		
		if(result > 0) commit(conn);
		else           rollback(conn);
		
		close(conn);
		
		return result;
	}

	/** 원생 목록 조회 서비스
	 * @return studentList
	 * @throws Exception
	 */
	public List<Student> selectAll() throws Exception {
		Connection conn = getConnection();
		
		List<Student> studentList = dao.selectAll(conn);
		
		close(conn);
		
		return studentList;
	}

}
