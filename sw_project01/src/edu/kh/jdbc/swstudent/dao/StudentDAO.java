package edu.kh.jdbc.swstudent.dao;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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

	/** 새로운 원생 추가
	 * @return result
	 * @throws Exception
	 */
	public static int insertStudent() throws Exception {
		int result = 0;
		
		

		return result;
	}
	
	
	
	
	
	
	
	
	
	
}
