package edu.kh.jdbc.swstudent.dao;

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

public class StudentDAO {

	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private Properties prop = null;
	
	public StudentDAO() {
		try {
			prop = new Properties();
			prop.loadFromXML(new FileInputStream("sw_query.xml"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** 원생 추가 DAO
	 * @param conn
	 * @param student
	 * @return result
	 * @throws Exception
	 */
	public int insertStudent(Connection conn, Student student) throws Exception {
		int result = 0;
		
		try {
			String sql = prop.getProperty("insertStudent");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, student.getStudentId());
			pstmt.setString(2, student.getStudentName());
			pstmt.setString(3, student.getStudentGender());
			pstmt.setString(4, student.getStudentNo());
			pstmt.setString(5, student.getStartDate());
			pstmt.setString(6, student.getStudentBelt());
			
			result = pstmt.executeUpdate();
			
			if(result > 0) commit(conn);
			else           rollback(conn);
			
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}

	/** 원생 목록 조회 DAO
	 * @param conn
	 * @return 
	 * @throws Exception
	 */
	public List<Student> selectAll(Connection conn) throws Exception {
		List<Student> studentList = new ArrayList<>();
		
		try {
			String sql = prop.getProperty("selectAll");
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int studentId = rs.getInt("STUDENT_NO");
				String studentName = rs.getString("STUDENT_NM");
				String studentGender = rs.getString("STUDENT_GENDER");
				String studentNo = rs.getString("STUDENT_SSN");
				String startDate = rs.getString("STUDENT_DATE");
				String studentBelt = rs.getString("STUDENT_BELT");
				
				Student student = new Student(studentId, studentName, studentGender,
						studentNo, startDate, studentBelt);
			
				studentList.add(student);	
			}
			
		} finally {
			close(rs);
			close(stmt);
		}
	
		return studentList;
	}

	/** 이름이 일치하는 사원 조회 DAO
	 * @param conn
	 * @param studentName
	 * @return student
	 * @throws Exception
	 */
	public Student selectName(Connection conn, String studentName) throws Exception {
		Student student = null;
		
		try {
			String sql = prop.getProperty("selectName");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, studentName);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int studentId = rs.getInt("STUDENT_NO");
				String studentGender = rs.getString("STUDENT_GENDER");
				String studentNo = rs.getString("STUDENT_SSN");
				String startDate = rs.getString("STUDENT_DATE");
				String studentBelt = rs.getString("STUDENT_BELT");
				
				student = new Student(studentId, studentName, studentGender,
						studentNo, startDate, studentBelt);
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return student;
	}

	/** 원생 정보 수정 DAO
	 * @param conn
	 * @param student
	 * @return result
	 * @throws Exception
	 */
	public int updateStudent(Connection conn, Student student) throws Exception {
		int result = 0;
		
		try {
			String sql = prop.getProperty("updateStudent");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, student.getStudentId());
			pstmt.setString(2, student.getStudentBelt());
			pstmt.setString(3, student.getStudentName());
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}

	/** 원생 퇴원 DAO
	 * @param conn
	 * @param studentName
	 * @return result
	 * @throws Exception
	 */
	public int secession(Connection conn, String studentName) throws Exception {
		int result = 0;
		
		try {
			String sql = prop.getProperty("secession");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, studentName);
			
			result = pstmt.executeUpdate();
					
			
		} finally {
			close(pstmt);
		}
		
		
		
		return result;
	}

}

	

