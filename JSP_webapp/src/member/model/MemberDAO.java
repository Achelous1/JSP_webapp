package member.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;

import javax.naming.Context;
import javax.naming.InitialContext;
//import javax.security.auth.message.callback.PrivateKeyCallback.Request;
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
	
	public MemberDTO checkLogin(String user_id, String user_pw){
		MemberDTO mem = new MemberDTO();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			String sql = " SELECT * FROM MEMBERS WHERE MEM_ID = ? AND MEM_PW = ? ";
			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, user_id);
			pstmt.setString(2, user_pw);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				mem.setMem_no(rs.getInt("mem_no"));
				mem.setMem_id(rs.getString("mem_id"));
				mem.setMem_pw(rs.getString("mem_pw"));
				mem.setMem_name(rs.getString("mem_name"));
			}
			System.out.println(mem.getMem_id() + " " + mem.getMem_pw() + " logged in.");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null)
					conn.close();
				if(pstmt != null)
					pstmt.close();
				if(rs != null)
					rs.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}

		return mem;
	}
	
	public void signUp(MemberDTO mem){
		
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
		} catch(Exception e){
			e.printStackTrace();
		}finally {
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