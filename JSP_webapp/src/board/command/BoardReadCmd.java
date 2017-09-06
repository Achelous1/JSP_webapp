package board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.command.BoardCmd;
import board.model.*;


public class BoardReadCmd implements BoardCmd {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String Board_no = request.getParameter("board_no");
		int inputBoard_no = Integer.parseInt(Board_no);
		
		BoardDAO dao = new BoardDAO();
		BoardDTO writing = dao.boardRead(inputBoard_no);
		
		request.setAttribute("boardRead", writing);
	}
}
