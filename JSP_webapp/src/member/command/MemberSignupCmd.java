package member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;
import java.sql.*;
import com.lonely_traveler.variables.*;
import com.oreilly.servlet.MultipartRequest;

import member.model.MemberDAO;
import member.model.MemberDTO;

public class MemberSignupCmd implements MemberCmd{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		MemberDTO data = new MemberDTO();
		System.out.println(request.getParameter("signUpForm"));
		System.out.println(request.getParameter("signUpForm.user_id"));
		
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

	@Override
	public void execute(MultipartRequest multi, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		MemberDTO data = new MemberDTO();
		System.out.println(multi.getParameter("signUpForm"));
		System.out.println(multi.getParameter("signUpForm.user_id"));
		
		data.setMem_id(multi.getParameter("user_id"));
		data.setMem_pw(multi.getParameter("user_pw"));
		data.setMem_name(multi.getParameter("name"));
		data.setMem_gender(multi.getParameter("gender"));
		data.setBirthdate(multi.getParameter("birthdate"));
		data.setPhoneno(multi.getParameter("phoneNo"));
		data.setEmail(multi.getParameter("email"));
		data.setAddr(multi.getParameter("addr"));
		
		System.out.println(data.toString());

		MemberDAO dao = new MemberDAO();
		dao.signUp(data);
		
	}
	
	
}