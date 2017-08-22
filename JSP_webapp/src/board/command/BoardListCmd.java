package board.command;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.lonely_traveler.variables.DatabaseInfo;

import board.model.BoardDTO;

import java.sql.*;

@WebServlet("*.bbs")
public class BoardListCmd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardListCmd() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			//connecting to DB
			Class.forName(DatabaseInfo.driver);
			conn = DriverManager.getConnection(DatabaseInfo.url, DatabaseInfo.uid, DatabaseInfo.upw);
			System.out.println("connected to DB");
			
			pstmt = conn.prepareStatement(" select * from board order by desc(post_date); ");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDTO list = null;
				list.setBoard_no(rs.getInt("board_no"));
				System.out.println();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null)
					rs.close();
				if(pstmt != null)
					pstmt.close();
				if(conn != null)
					conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
