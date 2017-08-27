package member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MemberCmd {
	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
}