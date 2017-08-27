package member.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import board.model.BoardDTO;

public class MemberDAO {
	DataSource ds;
	
	public MemberDAO() {
		try {
			
			//getting connection pool from the server
			Context initContext = (Context)new InitialContext().lookup("java:comp/env/");	//getting context from tomcat configured at context.xml
			ds = (DataSource)initContext.lookup("jdbc/Oracle11g");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//getting member data from db
	
	public MemberDTO checkLogin(String id, String pw){
		MemberDTO mem = new MemberDTO();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			String sql = "SELECT MEM_ID, MEM_PW FROM MEMBERS WHERE MEM_ID = ? AND MEM_PW = ?;";
			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				mem.setMem_id( rs.getString("mem_id") );
				mem.setMem_pw( rs.getString("mem_pw") );
				
				System.out.println(mem.getMem_id() + "logged in.");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

		return mem;		
		
	}
	
	public void signUp(MemberDTO mem) throws Exception{
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			String sql = " INSERT INTO MEMBERS (MEM_NO, MEM_ID, MEM_PW, MEM_NAME, MEM_GENDER, BIRTHDATE, PHONENO, EMAIL, ADDR)\r\n "+
						" VALUES (MEMNO_SEQUENCE.NEXTVAL, ?, ?, ?, ?, TO_DATE(?, 'YYYY-MM-DD'), ?, ?, ?) ";
			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mem.getMem_id());
			pstmt.setString(2, mem.getMem_pw());
			pstmt.setString(3, mem.getMem_name());
			pstmt.setString(4, mem.getMem_gender());
			pstmt.setString(5, mem.getBirthdate());
			pstmt.setString(6, mem.getPhoneno());
			pstmt.setString(7, mem.getEmail());
			pstmt.setString(8, mem.getAddr());
			
			System.out.println(mem.toString());
			System.out.println(pstmt);
			
			
			pstmt.executeUpdate();
		} finally {
			try {
				if(conn != null)
					conn.close();
				if(pstmt != null)
					pstmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}

	}
	
}