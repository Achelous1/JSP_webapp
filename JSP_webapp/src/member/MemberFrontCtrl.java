package member;

import java.io.IOException;
import java.sql.SQLException;

import member.command.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("*.mctrl")
public class MemberFrontCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberFrontCtrl() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String cmdURI = requestURI.substring(contextPath.length());
		
		System.out.println(cmdURI);
		System.out.println(contextPath);
		System.out.println(request.getParameter("user_id"));
		
		//회원가입 했을 경구
		if(cmdURI.equals("/signup.mctrl")) {
			MemberCmd cmd = new MemberSignupCmd();
			
			cmd.execute(request, response);
			
			//try-catch문으로 status코드 전송
			/*try {
				cmd.execute(request, response);
				
				//회원가입 성공 시 status 200 전송
				response.setStatus(200);
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			} catch(Exception e) {
				//예외발생 시 status 500 전송
				response.setStatus(500);
				
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp#!/signup");
				rd.forward(request, response);
			}*/
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.forward(request, response);
		//로그인을 했을 경우
		}else if(cmdURI.equals("/login.mctrl")) {
			MemberCmd cmd = new MemberLoginCmd();
			cmd.execute(request, response);
			
			RequestDispatcher rd = request.getRequestDispatcher("public/php/SessionAttributeSet.jsp");
			rd.forward(request, response);
		}
	}

}
