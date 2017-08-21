package member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.MemberDAO;

public class MemberLoginCmd implements MemberCmd{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		
		MemberDAO mem = new MemberDAO();
		
		mem.checkLogin(id, pw);
	}

}