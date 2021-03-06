package board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.*;

public class BoardUpdateCmd implements BoardCmd {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String inputBoard_no = request.getParameter("board_no");
		String inputTitle = request.getParameter("title");
		String inputContents = request.getParameter("contents");
		
		BoardDAO dao = new BoardDAO();
		dao.boardUpdate(inputBoard_no, inputTitle, inputContents);
	}

}
