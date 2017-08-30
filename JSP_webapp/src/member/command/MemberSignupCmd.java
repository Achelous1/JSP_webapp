package member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import com.lonely_traveler.variables.*;

import member.model.MemberDAO;
import member.model.MemberDTO;

public class MemberSignupCmd implements MemberCmd{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		MemberDTO data = new MemberDTO();
		
		data.setMem_id(request.getParameter("user_id"));
		data.setMem_pw(request.getParameter("user_pw"));
		data.setMem_name(request.getParameter("name"));
		data.setMem_gender(request.getParameter("gender"));
		data.setBirthdate(request.getParameter("birthdate"));
		data.setPhoneno(request.getParameter("phoneNo"));
		data.setEmail(request.getParameter("email"));
		data.setAddr(request.getParameter("addr"));
		
		System.out.println(data.toString());

		MemberDAO dao = new MemberDAO();
		dao.signUp(data);
	}
}