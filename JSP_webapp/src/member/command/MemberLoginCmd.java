package member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import member.model.*;

public class MemberLoginCmd implements MemberCmd{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		
		MemberDAO mem = new MemberDAO();
		MemberDTO memInfo = mem.checkLogin(id, pw);
		
		request.setAttribute("memInfo", memInfo);
	}

	@Override
	public void execute(MultipartRequest multi, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

}