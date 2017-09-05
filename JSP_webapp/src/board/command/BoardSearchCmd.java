package board.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDAO;
import board.model.BoardDTO;

public class BoardSearchCmd implements BoardCmd {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		BoardDAO dao = new BoardDAO();
		ArrayList<BoardDTO> list = null;
		
		int pageCnt = 0;
		String curPage = request.getParameter("curPage");
		if(curPage == null) curPage = "1";
		
		if(request.getAttribute("search_type") == null) {
			list = dao.boardList(curPage);
		} else if(request.getAttribute("search_type") != null) {
			list = dao.boardSearch((String)request.getAttribute("search_type"), (String)request.getAttribute("searchStr"));
		}
		request.setAttribute("boardList", list);
		
		pageCnt = dao.boardPageCnt();
		request.setAttribute("pageCnt", pageCnt);
	}

}
