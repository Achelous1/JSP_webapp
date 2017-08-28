package board;


import java.sql.*;
import java.util.ArrayList;
import javax.naming.*;
import javax.sql.DataSource;

import board.model.BoardDTO;

public class BoardDAO {
	DataSource ds;
	public static final int WRITING_PER_PAGE = 10;
	
	public BoardDAO(){
		try{
			Context initContext = (Context)new InitialContext().lookup("comp/env/");
			ds = (DataSource)initContext.lookup("jdbc/Oracle11g");
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	//�Խ��� ��� ��ȸ ���
	public ArrayList<BoardDTO> boardList(String curPage){ //���� ǥ���� ������ �޾ƿ� = curPage
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = ds.getConnection();
			String sql = "SELECT BOARD_NO, TITLE, CONTENTS, POST_DATE, ref, step, lev, read_cnt, child_cnt FROM BOARD ORDER BY ref, step, lev, read_cnt, child_cnt LIMIT ?, ?";
			//������̺� ��ȸ -��� �����ʿ���// ref, step�� ���� �亯�� ó���ϱ� ���� �÷�//LIMIT [���۹�ȣ], [��¹���]
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, WRITING_PER_PAGE * (Integer.parseInt(curPage)));
			pstmt.setInt(2, WRITING_PER_PAGE);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				int board_no = rs.getInt("board_no");
				String title = rs.getString("title");
				String contents = rs.getString("contents");
				Date post_date = rs.getDate("post_date");
				int ref = rs.getInt("ref");
				int step = rs.getInt("step");
				int lev = rs.getInt("lev");
				int readCnt = rs.getInt("readCnt");
				int childCnt = rs.getInt("childCnt");
				
				BoardDTO writing = new BoardDTO();
				writing.setBoard_no(board_no);
				writing.setTitle(title);
				writing.setContents(contents);
				writing.setPost_date(post_date);
				writing.setRef(ref);
				writing.setStep(step);
				writing.setlev(lev);
				writing.setReadCnt(readCnt);
				writing.setChildCnt(childCnt);
				
				list.add(writing);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				if(rs !=null) rs.close();
				if(pstmt !=null) pstmt.close();
				if(conn !=null) conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	//�Խ��� ����¡ ó��
	public int boardPageCnt(){
		int pageCnt = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = ds.getConnection();
			String sql = "SELECT COUNT(*) AS BOARD_NO FROM BOARD";		
			pstmt = conn.prepareStatement(sql);			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				pageCnt = rs.getInt("board_no") / WRITING_PER_PAGE +1;
			}
		}catch(Exception e) {
				e.printStackTrace();
		}finally {
			try {
				if(rs !=null) rs.close();
				if(pstmt !=null) pstmt.close();
				if(conn !=null) conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return pageCnt;
	}
	
	//�Խñ� ��� ���
	public void boardWrite (String title, String contents){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int board_no = 1;
		
		try {
			conn = ds.getConnection();
			String sql = "SELECT IFNULL(MAX(BOARD_NO), 0) +1 AS BOARD_NO FROM BOARD"; //�Խñ� �� ���� ���� ��ȣ�� +1 �Խñ� �ϳ��� ������ 0�� +1�� ���� ����
			pstmt = conn.prepareStatement(sql);			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				board_no= rs.getInt("board_no");
			}
			
			sql = "INSERT INTO BOARD (BOARD_NO, TITLE, CONTENTS, POST_DATE, ref, step, lev, read_cnt, child_cnt) values(?, ?, ?, curdate(), ?, 0, 0, 0, 0)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, board_no);
			pstmt.setString(2, title);
			pstmt.setString(3, contents);
			pstmt.setInt(4, board_no);
			
			pstmt.executeUpdate();
		}catch(Exception e) {
				e.printStackTrace();
		}finally {
			try {
				if(rs !=null) rs.close();
				if(pstmt !=null) pstmt.close();
				if(conn !=null) conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//�Խ��� ����
	public BoardDTO boardRead(String inputBoard_no){
		BoardDTO writing = new BoardDTO();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = ds.getConnection();
			String sql = "UPDATE BOARD SET READ_CNT = READ_CNT +1 WHERE BOARD_NO = ?"; 
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(inputBoard_no));
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int board_no = rs.getInt("board_no");
				String title = rs.getString("title");
				String contents = rs.getString("contents");
				Date post_date = rs.getDate("post_date");
				int ref = rs.getInt("ref");
				int step = rs.getInt("step");
				int lev = rs.getInt("lev");
				int read_cnt = rs.getInt("read_cnt");
				int child_cnt = rs.getInt("child_cnt");
				
				writing.setBoard_no(board_no);
				writing.setTitle(title);
				writing.setContents(contents);
				writing.setPost_date(post_date);
				writing.setRef(ref);
				writing.setStep(step);
				writing.setlev(lev);
				writing.setReadCnt(read_cnt);
				writing.setChildCnt(child_cnt);
			}
		}catch(Exception e) {
				e.printStackTrace();
		}finally {
			try {
				if(rs !=null) rs.close();
				if(pstmt !=null) pstmt.close();
				if(conn !=null) conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return writing;
	}
	
	//�Խñ� ����
	public void boardUpdate (String inputBoard_no, String inputTitle, String inputContent){
		
	}
	
	//�Խñ� ������ �ʿ��� ���� ������ ��ȸ
	public BoardDTO boardUpdateForm(String inputBoard_no){
		BoardDTO writing = new BoardDTO();
		return writing;
	}
	
	//�Խñ� ���� ���
	public void boardDelete(String inputBoard_no){
		
	}
	
	//��������� �Խñۿ� ������� �˻�
	public boolean boardReplyCheck(String inputBoard_no){
		boolean replyCheck = false;
		return replyCheck;
	}
	
	//�Խñ��� ����� ���, ���۵��� ��� ������ �ٿ��ִ� ���
	public void boardDeleteChildCntUpdate(int ref, int lev, int step){
		
	}
	
	//�˻����
	public ArrayList<BoardDTO> boardSearch(String searchOption, String searchWord){
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		return list;
	}
	
	//��� �ۼ��� �ʿ��� ���� ������
	public BoardDTO boardReplyForm(String inputBoard_no){
		BoardDTO writing = new BoardDTO();
		return writing;
	}
	
	//��� ���
	public void boardReply(String board_no, String title, String content, String step, String ref, String lev){
		
	}
	
	//����� ��� ��ġ �������
	public int boardReplySearchStep(String ref, String lev, String step){
		int replyStep = 0;
		return replyStep;
	}
	
	//��� �ۼ� �� ���۵��� ��� ������ �÷��ִ� ���
	public void boardReplyChildCntdate(String ref, String lev, int replyStep){
		
	}
}