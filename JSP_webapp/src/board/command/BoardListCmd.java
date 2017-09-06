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
		// TODO Auto-generated method stub
		BoardDAO dao = new BoardDAO();
		ArrayList<BoardDTO> list;
		//Gson gson = new Gson();

		int pageCnt = 0;
		String curPage = request.getParameter("curPage");
		
		if(curPage == null) {
			curPage = "1";
		}
		
		list = dao.boardList(curPage);
		/*
		String json = gson.toJson(list);
        try {
    		response.setContentType("application/json");
			response.getWriter().write(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		request.setAttribute("boardList", list);
		System.out.println(list);
		//System.out.println(json);
		pageCnt = dao.boardPageCnt();
		request.setAttribute("pageCnt", pageCnt);
	}

}
