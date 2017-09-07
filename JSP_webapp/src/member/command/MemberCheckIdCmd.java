package member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.MemberDAO;

public class MemberCheckIdCmd implements MemberCmd{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		MemberDAO dao = new MemberDAO();
		String mem_id = request.getParameter("user_id");
		boolean isAvailable;
		if(mem_id.equals(null) || mem_id.equals("")) {
			isAvailable = false;
		} else {
			isAvailable = dao.checkId(mem_id);
		}
		request.setAttribute("isAvailable", isAvailable);
	}

}
