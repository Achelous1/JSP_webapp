package board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDAO;

public class BoardWriteCmd implements BoardCmd{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String mem_no = request.getParameter("mem_no");
		//int mem_no= Integer.parseInt(sMem_no);		
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		
		System.out.println(mem_no + title + contents);
		
		BoardDAO dao = new BoardDAO();
		dao.boardWrite(mem_no, title, contents);
	}
	
}