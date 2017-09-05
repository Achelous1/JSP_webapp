package board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDAO;

public class BoardDeleteCmd implements BoardCmd{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String inputBoard_no = request.getParameter("board_no");
		
		BoardDAO dao = new BoardDAO();
		dao.boardDelete(inputBoard_no);
	}

}
