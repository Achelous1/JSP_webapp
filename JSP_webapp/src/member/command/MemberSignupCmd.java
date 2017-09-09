package member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;
import java.sql.*;
import com.lonely_traveler.variables.*;

import member.model.MemberDAO;
import member.model.MemberDTO;

public class MemberSignupCmd implements MemberCmd{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		MemberDTO data = new MemberDTO();
		
		//File mem_img = request.getParameter("mem_img");
		
		data.setMem_id(request.getParameter("user_id"));
		data.setMem_pw(request.getParameter("user_pw"));
		data.setMem_name(request.getParameter("name"));
		data.setMem_gender(request.getParameter("gender"));
		data.setBirthdate(request.getParameter("birthdate"));
		data.setPhoneno(request.getParameter("phoneNo"));
		data.setEmail(request.getParameter("email"));
		data.setAddr(request.getParameter("addr"));
		data.setMem_img("./public/FILE_SYSTEM/MEM_IMG/" + data.getMem_no());
		
		System.out.println(data.toString());
		
	    

		MemberDAO dao = new MemberDAO();
		dao.signUp(data);
	}
	
	
}