package board.command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import board.model.BoardDAO;
import board.model.BoardDTO;

public class BoardSearchCmd implements BoardCmd {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		BoardDAO dao = new BoardDAO();
		ArrayList<BoardDTO> list = null;
		
		int spage = 1;
		String page = request.getParameter("page");
		Gson gson = new Gson();
		
		if(page != null) 
			spage = Integer.parseInt(page);
		
		// 페이지를 Map에 담는다.
	    HashMap<String, Object> listOpt = new HashMap<String, Object>();
	    listOpt.put("start", spage*10-9);
		
	    int listCount = dao.getBoardListCount(listOpt);
	    list =  dao.boardList(listOpt);
	    
	    String json = gson.toJson(list);
        try {
    		response.setContentType("application/json");
			response.getWriter().write(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
     // 한 화면에 10개의 게시글을 보여지게함
	    // 페이지 번호는 총 5개, 이후로는 [다음]으로 표시
	    
	    // 전체 페이지 수
	    int maxPage = (int)(listCount/10.0 + 0.9);
	    //시작 페이지 번호
	    int startPage = (int)(spage/5.0 + 0.8) * 5 - 4;
	    //마지막 페이지 번호
	    int endPage = startPage + 4;
	    if(endPage > maxPage)    endPage = maxPage;
	    
		if(request.getAttribute("search_type") == null) {
			list =  dao.boardList(listOpt);
		} else if(request.getAttribute("search_type") != null) {
			list = dao.boardSearch((String)request.getAttribute("search_type"), (String)request.getAttribute("searchStr"));
		}
		request.setAttribute("boardList", list);
	}

}
