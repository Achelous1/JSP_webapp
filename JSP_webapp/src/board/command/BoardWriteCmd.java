package board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDAO;

public class BoardWriteCmd implements BoardCmd{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		
		BoardDAO dao = new BoardDAO();
		dao.boardWrite(title, contents);
	}
	
}
