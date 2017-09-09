package member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

public interface MemberCmd {
	
	public void execute(HttpServletRequest request, HttpServletResponse response);
	public void execute(MultipartRequest multi, HttpServletResponse response);
}