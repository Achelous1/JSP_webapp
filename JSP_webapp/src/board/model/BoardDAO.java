package board.model;


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
			Context initContext = (Context)new InitialContext().lookup("java:comp/env/");
			ds = (DataSource)initContext.lookup("jdbc/Oracle11g");
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	//게시판 목록 조회 기능
	public ArrayList<BoardDTO> boardList(String curPage){ //현재 표시할 페이지 받아옴 = curPage
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = ds.getConnection();
			String sql = "SELECT BOARD_NO, TITLE, CONTENTS, POST_DATE, ref, step, lev, read_cnt, child_cnt FROM BOARD ORDER BY ref, step, lev, read_cnt, child_cnt LIMIT ?, ?";
			//디비테이블 조회 -디비 수정필요함// ref, step은 이후 답변글 처리하기 위한 컬럼//LIMIT [시작번호], [출력범위]
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, WRITING_PER_PAGE * (Integer.parseInt(curPage)));
			pstmt.setInt(2, WRITING_PER_PAGE);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				int board_no = rs.getInt("board_no");
				String mem_no = rs.getString("mem_no");
				String title = rs.getString("title");
				String contents = rs.getString("contents");
				Date post_date = rs.getDate("post_date");
				int ref = rs.getInt("ref");
				int step = rs.getInt("step");
				int lev = rs.getInt("lev");
				int read_cnt = rs.getInt("readCnt");
				int child_cnt = rs.getInt("childCnt");
				
				BoardDTO writing = new BoardDTO();
				writing.setBoard_no(board_no);
				writing.setMem_no(mem_no);
				writing.setTitle(title);
				writing.setContents(contents);
				writing.setPost_date(post_date);
				writing.setRef(ref);
				writing.setStep(step);
				writing.setLev(lev);
				writing.setRead_cnt(read_cnt);
				writing.setChild_cnt(child_cnt);
				
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
	
	//게시판 페이징 처리
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
	
	//게시글 등록 기능
	public void boardWrite (String mem_no, String title, String contents){
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		System.out.println(mem_no + title + contents);
		
		try {															/*String sql = "INSERT INTO BOARD (BOARD_NO) VALUES (BOARDNO_SEQUENSE.NEXTVAL) "; //게시글 중 가장 높은 번호에 +1 게시글 하나도 없으면 0에 +1한 값을 넣음pstmt = conn.prepareStatement(sql);	rs = pstmt.executeQuery(); if(rs.next()) {board_no= rs.getInt("board_no");}*/			
			String sql = "INSERT INTO BOARD (BOARD_NO, MEM_NO, TITLE, CONTENTS, POST_DATE, ref, step, lev, read_cnt, child_cnt)\r\n "+
			" VALUES (BOARDNO_SEQUENCE.NEXTVAL, ?, ?, ?, SYSDATE, BOARDNO_SEQUENCE.CURRVAL, 0, 0, 0, 0) ";
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);			
																				/*pstmt = conn.prepareStatement(sql);	pstmt.setInt(1, board_no);*/
			pstmt.setString(1, mem_no);
			pstmt.setString(2, title);
			pstmt.setString(3, contents);
			
			int n = pstmt.executeUpdate();
		}catch(Exception e) {
				e.printStackTrace();
		}finally {
			try {
				if(pstmt !=null) pstmt.close();
				if(conn !=null) conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//게시판 열람
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
				String mem_no = rs.getString("mem_no");
				String title = rs.getString("title");
				String contents = rs.getString("contents");
				Date post_date = rs.getDate("post_date");
				int ref = rs.getInt("ref");
				int step = rs.getInt("step");
				int lev = rs.getInt("lev");
				int read_cnt = rs.getInt("read_cnt");
				int child_cnt = rs.getInt("child_cnt");
				
				writing.setBoard_no(board_no);
				writing.setMem_no(mem_no);
				writing.setTitle(title);
				writing.setContents(contents);
				writing.setPost_date(post_date);
				writing.setRef(ref);
				writing.setStep(step);
				writing.setLev(lev);
				writing.setRead_cnt(read_cnt);
				writing.setChild_cnt(child_cnt);
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
	
	//게시글 수정
	public void boardUpdate (String inputBoard_no, String inputTitle, String inputContent){
		
	}
	
	//게시글 수정에 필요한 원글 데이터 조회
	public BoardDTO boardUpdateForm(String inputBoard_no){
		BoardDTO writing = new BoardDTO();
		return writing;
	}
	
	//게시글 삭제 기능
	public void boardDelete(String inputBoard_no){
		
	}
	
	//삭제대상인 게시글에 답글유무 검사
	public boolean boardReplyCheck(String inputBoard_no){
		boolean replyCheck = false;
		return replyCheck;
	}
	
	//게시글이 답글인 경우, 원글들의 답글 개수를 줄여주는 기능
	public void boardDeleteChildCntUpdate(int ref, int lev, int step){
		
	}
	
	//검색기능
	public ArrayList<BoardDTO> boardSearch(String searchOption, String searchWord){
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		return list;
	}
	
	//답글 작성에 필요한 원글 데이터
	public BoardDTO boardReplyForm(String inputBoard_no){
		BoardDTO writing = new BoardDTO();
		return writing;
	}
	
	//답글 기능
	public void boardReply(String board_no, String title, String content, String step, String ref, String lev){
		
	}
	
	//답글의 출력 위치 선정기능
	public int boardReplySearchStep(String ref, String lev, String step){
		int replyStep = 0;
		return replyStep;
	}
	
	//답글 작성 후 원글들의 답글 개수를 늘려주는 기능
	public void boardReplyChildCntdate(String ref, String lev, int replyStep){
		
	}
}