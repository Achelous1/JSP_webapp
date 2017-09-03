package board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.command.*;
import board.command.BoardListCmd;


/**
 * Servlet implementation class BoardFrontCtrl
 */
@WebServlet("*.bctrl")
public class BoardFrontCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardFrontCtrl() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
		
/*		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String cmdURI = requestURI.substring(contextPath.length());
		
		if(cmdURI.equals("/reviews.bctrl")) {
			MemberCmd cmd = new MemberSignupCmd();
			cmd.execute(request, response);
			RequestDispatcher rd = request.getRequestDispatcher("reviews.bctrl");
			rd.forward(request, response);
		}else if(cmdURI.equals("/viewBoard.bctrl")) {
			MemberCmd cmd = new MemberLoginCmd();
			cmd.execute(request, response);
			RequestDispatcher rd = request.getRequestDispatcher("viewBoard.bctrl");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("reviews.bctrl");
			rd.forward(request, response);
		}*/
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String cmdURI = requestURI.substring(contextPath.length());
		
		BoardCmd cmd = null;
		String viewPage = null;
		
		//글 목록 조회
		if(cmdURI.equals("/reviews.bctrl")){
			cmd = new BoardListCmd();
			cmd.execute(request, response);
			viewPage = "reviews.jsp";
		}
		else if(cmdURI.equals("/boardList.bctrl")){
			cmd = new BoardListCmd();
			cmd.execute(request, response);
			viewPage = "boardList.jsp";
		}
		
		//글 작성 화면 제공
		else if(cmdURI.equals("/boardWrite")) {
			viewPage = "boardWrite.jsp";
		}
		
		//글 작성 처리
		else if(cmdURI.equals("/boardWrite.bctrl")) {
			System.out.println("write()");
			cmd = new BoardWriteCmd();
			cmd.execute(request, response);
			viewPage = "/boardList.bctrl";
		}
		
		// 글보기
		else if(cmdURI.equals("/viewBoard.bctrl")) {
			cmd = new BoardWriteCmd();
			cmd.execute(request, response);
			viewPage = "viewBoard.jsp";
		}
		
		
		RequestDispatcher dis = request.getRequestDispatcher(viewPage);
		dis.forward(request, response);
		
		
		//doGet(request, response);
	}
}