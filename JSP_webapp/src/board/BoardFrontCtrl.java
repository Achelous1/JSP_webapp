package board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.command.*;


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
			viewPage = "public/php/boardRedirect.jsp";
		}
		else if(cmdURI.equals("/boardList.bctrl")){
			cmd = new BoardListCmd();
			cmd.execute(request, response);
			viewPage = "boardList.jsp";
		}
		//글 작성 화면 제공
		/*else if(cmdURI.equals("/boardWrite")) {
			viewPage = "boardWrite.jsp";
		}*/
		//글 작성 처리
		else if(cmdURI.equals("/boardWrite.bctrl")) {
			System.out.println("write()");
			cmd = new BoardWriteCmd();
			cmd.execute(request, response);
			if(request.getAttribute("type") == "rev")
				viewPage = "reviews.bctrl";
			else if(request.getAttribute("type") == "rec")
				viewPage = "recommendations.bctrl";
		}
		// 글보기
		else if(cmdURI.equals("/viewBoard.bctrl")) {
			cmd = new BoardReadCmd();
			cmd.execute(request, response);
			viewPage = "viewBoard.jsp";
		}
		//검색 버튼
		else if(cmdURI.equals("/search.bctrl")) {
			cmd = new BoardSearchCmd();
			cmd.execute(request, response);
			viewPage = (String) request.getAttribute("page");
			System.out.println(viewPage);
		}
		RequestDispatcher dis = request.getRequestDispatcher(viewPage);
		dis.forward(request, response);
		
		}
}