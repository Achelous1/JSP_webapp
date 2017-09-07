package board.command;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.lonely_traveler.variables.DatabaseInfo;

import board.model.*;

import java.sql.*;
import java.util.ArrayList;

public class BoardListCmd implements BoardCmd {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//선언부분
		BoardDAO dao = new BoardDAO();
		ArrayList<BoardDTO> list;
		Gson gson = new Gson();
		
		//구현부분
		System.out.println("list()");
		int pageCnt = 0;
		String curPage = request.getParameter("curPage");
		
		if(curPage == null) {
			curPage = "1";
		}
		
		list = dao.boardList(curPage);
		
		String json = gson.toJson(list);
        try {
    		response.setContentType("application/json");
			response.getWriter().write(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        request.setAttribute("boardList", list);
        request.setAttribute("json", json);
		System.out.println(list);
		System.out.println(json);
		
		pageCnt = dao.boardPageCnt();
		request.setAttribute("pageCnt", pageCnt);
		
		/*// 현재 페이지 번호 만들기
	    int spage = 1;
	    String page = request.getParameter("page");
	    
	    if(page != null)
	        spage = Integer.parseInt(page);
	    
	    // 페이지를 Map에 담는다.
	    HashMap<String, Object> listOpt = new HashMap<String, Object>();
	    listOpt.put("start", spage*10-9);
	    
	    BoardDAO dao = new BoardDAO();
	    int listCount = dao.getBoardListCount(listOpt);
	    ArrayList<BoardDTO> list =  dao.boardList(listOpt);
	    
	    // 한 화면에 10개의 게시글을 보여지게함
	    // 페이지 번호는 총 5개, 이후로는 [다음]으로 표시
	    
	    // 전체 페이지 수
	    int maxPage = (int)(listCount/10.0 + 0.9);
	    //시작 페이지 번호
	    int startPage = (int)(spage/5.0 + 0.8) * 5 - 4;
	    //마지막 페이지 번호
	    int endPage = startPage + 4;
	    if(endPage > maxPage)    endPage = maxPage;
	    
	    // 4개 페이지번호 저장
	    request.setAttribute("spage", spage);
	    request.setAttribute("maxPage", maxPage);
	    request.setAttribute("startPage", startPage);
	    request.setAttribute("endPage", endPage);
	    
	    // 글의 총 수와 글목록 저장
	    //request.setAttribute("listCount", listCount);
	    request.setAttribute("list", list);
	*/
	}

}
