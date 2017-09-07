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
	public ArrayList<BoardDTO> boardList(String CurPage) { // 현재 표시할 페이지 받아옴 =
		// listOpt
			ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			/*int start = (Integer)listOpt.get("start"); // 현재 페이지번호
			*/
			try {
			conn = ds.getConnection();
			String sql = "SELECT * FROM BOARD ORDER BY ref desc, step asc ";
			/*sql += "(select rownum rnum, BOARD_NO, MEM_NO, TITLE";
			sql += ", CONTENTS, POST_DATE, REF, STEP, LEV, READ_CNT, CHILD_CNT";
			sql += "FROM";
			sql += " (select * from BOARD order by REF desc, STEP asc)) ";
			sql += "where rnum>=? and rnum<=?";
			// 디비테이블 조회 // ref, step은 이후 답변글 처리하기 위한 컬럼//LIMIT [시작번호], [출력범위]
			*/
			pstmt = conn.prepareStatement(sql);
			/*pstmt.setInt(1, start);
			pstmt.setInt(2, start+9);*/
			
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
				int read_cnt = rs.getInt("read_cnt");
				int child_cnt = rs.getInt("child_cnt");
				
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
	public BoardDTO boardRead(int inputBoard_no) {
		BoardDTO writing = new BoardDTO();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = ds.getConnection();
			String sql = "UPDATE BOARD SET READ_CNT = READ_CNT+1 WHERE BOARD_NO = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, inputBoard_no);

			sql = "SELECT BOARD_NO, MEM_NO, TITLE, CONTENTS, POST_DATE, ref, step, lev, read_cnt, child_cnt FROM BOARD WHERE board_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, inputBoard_no);
			rs = pstmt.executeQuery();

			if (rs.next()) {
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
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return writing;
	}
	
	//게시글 수정
	public void boardUpdate (String inputBoard_no, String inputTitle, String inputContents){
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = ds.getConnection();
			String sql = "UPDATE BOARD SET TITLE=?, CONTENTS=? WHERE Board_no=?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, inputTitle);
			pstmt.setString(2, inputContents);
			pstmt.setInt(3, Integer.parseInt(inputBoard_no));

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	//게시글 수정에 필요한 원글 데이터 조회
	public BoardDTO boardUpdateForm(String inputBoard_no) {
		BoardDTO writing = new BoardDTO();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = ds.getConnection();

			String sql = "SELECT BOARD_NO, MEM_NO, TITLE, CONTENTS, POST_DATE, ref, step, lev, read_cnt, child_cnt FROM BOARD WHERE board_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(inputBoard_no));
			rs = pstmt.executeQuery();

			if (rs.next()) {
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

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return writing;
	}
	
	//게시글 삭제 기능
	public void boardDelete(String inputBoard_no) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = ds.getConnection();

			String sql = "SELECT ref, lev, step FROM BOARD WHERE BOARD_NO = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(inputBoard_no));
			rs = pstmt.executeQuery();

			if (rs.next()) {
				int ref = rs.getInt(1);
				int lev = rs.getInt(2);
				int step = rs.getInt(3);
				boardDeleteChildCntUpdate(ref, lev, step);
			}

			sql = "DELETE FROM BOARD WHERE BOARD_NO=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(inputBoard_no));

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	
	//삭제대상인 게시글에 답글유무 검사
	public boolean boardReplyCheck(String inputBoard_no) {
		boolean replyCheck = false;
		int replyCnt = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = ds.getConnection();
			String sql = "SELECT child_cnt AS reply_check FROM BOARD WHERE BOARD_NO = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(inputBoard_no));

			rs = pstmt.executeQuery();

			if (rs.next())
				replyCnt = rs.getInt("reply_check");
			if (replyCnt == 0)
				replyCheck = true;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return replyCheck;
	}
	
	//게시글이 답글인 경우, 원글들의 답글 개수를 줄여주는 기능
	public void boardDeleteChildCntUpdate(int ref, int lev, int step) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;

		try {
			conn = ds.getConnection();
			for (int updateLev = lev - 1; updateLev >= 0; updateLev--) {
				sql = "SELECT MAX(step) FROM BOARD WHERE ref = ? and lev = ? and step < ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, ref);
				pstmt.setInt(2, updateLev);
				pstmt.setInt(3, step);

				rs = pstmt.executeQuery();
				int maxStep = 0;

				if (rs.next())
					maxStep = rs.getInt(1);
				sql = "UPDATE BOARD SET child_cnt = child_cnt - 1 where ref = ? and lev = ? and step = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, ref);
				pstmt.setInt(2, updateLev);
				pstmt.setInt(3, maxStep);
				pstmt.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//검색기능
	public ArrayList<BoardDTO> boardSearch(String searchOption, String searchWord) {
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = ds.getConnection();
			String sql = "SELECT BOARD_NO, MEM_NO, TITLE, CONTENTS, POST_DATE, ref, step, lev, read_cnt, child_cnt FROM BOARD ";

			if (searchOption.equals("title")) {
				sql += " WHERE title LIKE ?";
				sql += " ORDER BY ref desc, step asc";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%" + searchWord + "%");
			} else if (searchOption.equals("contents")) {
				sql += " WHERE contents LIKE ?";
				sql += " ORDER BY ref desc, step asc";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%" + searchWord + "%");

			} else if (searchOption.equals("mem_no")) {
				sql += " WHERE name LIKE ?";
				sql += " ORDER BY ref desc, step asc";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%" + searchWord + "%");

			} else if (searchOption.equals("both")) {
				sql += " WHERE title LIKE ? OR contents LIKE ? ";
				sql += " ORDER BY ref desc, step asc";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%" + searchWord + "%");
				pstmt.setString(2, "%" + searchWord + "%");
			}

			rs = pstmt.executeQuery();

			while (rs.next()) {

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

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return list;
	}
	/*public ArrayList<BoardDTO> boardSearch(String searchOption, String searchWord){
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = ds.getConnection();
			System.out.println("디비 연결 성공");
			String sql = " SELECT * FROM BOARD ORDER BY REF DESC, STEP ASC WHERE ? = ? ";
			//디비테이블 조회 // ref, step은 이후 답변글 처리하기 위한 컬럼//LIMIT [시작번호], [출력범위]
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchOption);
			pstmt.setString(2, searchWord);
			
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
				int read_cnt = rs.getInt("read_cnt");
				int child_cnt = rs.getInt("child_cnt");
				
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
	}*/
	
	//답글 작성에 필요한 원글 데이터
	public BoardDTO boardReplyForm(String inputBoard_no) {
		BoardDTO writing = new BoardDTO();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = ds.getConnection();
			String sql = "SELECT BOARD_NO, MEM_NO, TITLE, CONTENTS, POST_DATE, ref, step, lev, read_cnt, child_cnt FROM BOARD WHERE BOARD_NO = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(inputBoard_no));
			rs = pstmt.executeQuery();

			if (rs.next()) {
				int board_no = rs.getInt("board_no");
				String mem_no = rs.getString("mem_no");
				String title = "RE:" + rs.getString("title");
				Date post_date = rs.getDate("post_date");
				String contents = "[원문:" + post_date + " 작성됨]\n" + rs.getString("contents");
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

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return writing;
	}
	
	//답글 기능
	public void boardReply(String board_no, String mem_no, String title, String contents, String step, String ref,
			String lev) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int replyBoard_no = 0;
		int replyStep = 0;
		String sql = null;

		try {
			conn = ds.getConnection();

			replyStep = boardReplySearchStep(ref, lev, step); // 답글이 위치할 step 값을
																// 가져옴

			if (replyStep > 0) {
				sql = "UPDATE BOARD SET step = step + 1 where ref = ? and step >= ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, Integer.parseInt(ref));
				pstmt.setInt(2, replyStep);
				pstmt.executeUpdate();
			} else {
				sql = "SELECT MAX(STEP) FROM BOARD WHERE ref = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, Integer.parseInt(ref));
				rs = pstmt.executeQuery();
				if (rs.next())
					replyStep = rs.getInt(1) + 1;
			}

			sql = "SELECT MAX(board_no)+1 AS BOARD_NO FROM BOARD";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next())
				replyBoard_no = rs.getInt("board_no");

			sql = "INSERT INTO BOARD";
			sql += " (board_no, mem_no, title, contents, post_date, ref, step, lev, read_cnt, child_cnt)";
			sql += " values(?, ?, ?, ?, ?, SYSDATE, BOARDNO_SEQUENCE.CURRVAL, ?, ?, ?, 0, 0)";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, replyBoard_no);
			pstmt.setString(2, mem_no);
			pstmt.setString(3, title);
			pstmt.setString(4, contents);
			pstmt.setInt(5, Integer.parseInt(ref));
			pstmt.setInt(6, replyStep);
			pstmt.setInt(7, Integer.parseInt(lev) + 1);

			pstmt.executeUpdate();
			boardReplyChildCntUpdate(ref, lev, replyStep);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//답글의 출력 위치 선정기능
	public int boardReplySearchStep(String ref, String lev, String step){
		int replyStep = 0;
		return replyStep;
	}
	
	//답글 작성 후 원글들의 답글 개수를 늘려주는 기능
	public void boardReplyChildCntUpdate(String ref, String lev, int replyStep){
		
	}
}