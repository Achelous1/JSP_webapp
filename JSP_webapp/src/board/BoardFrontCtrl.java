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
import member.command.MemberCmd;
import member.command.MemberLoginCmd;
import member.command.MemberSignupCmd;

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
		
		//�� ��� ��ȸ
		if(cmdURI.equals("/reviews.bctrl")){
			cmd = new BoardListCmd();
			cmd.execute(request, response);
			viewPage = "reviews.jsp";
		}
		
		//�� �ۼ� ȭ�� ����
		if(cmdURI.equals("/boardWrite.bctrl")) {
			cmd = new BoardWriteCmd();
			cmd.execute(request, response);
			viewPage = "boardWrite.bctrl";
		}
		
		//�� �ۼ� ó��
		if(cmdURI.equals("/boardWrite.bctrl")) {
			cmd = new BoardWriteCmd();
			cmd.execute(request, response);
			viewPage = "boardWrite.jsp";
		}
		
		// �ۺ���
		if(cmdURI.equals("/viewBoard.bctrl")) {
			cmd = new BoardWriteCmd();
			cmd.execute(request, response);
			viewPage = "viewBoard.jsp";
		}
		
		
		RequestDispatcher dis = request.getRequestDispatcher(viewPage);
		dis.forward(request, response);
		
		
		//doGet(request, response);
	}

}