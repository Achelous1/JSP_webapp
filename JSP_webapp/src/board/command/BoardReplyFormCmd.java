package board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.*;

public class BoardReplyFormCmd implements BoardCmd {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String inputBoard_no = request.getParameter("board_no");
		System.out.println(inputBoard_no);
		BoardDAO dao = new BoardDAO();
		BoardDTO writing = dao.boardUpdateForm(inputBoard_no);
		
		request.setAttribute("boardUpdateForm", writing);
	}

}
