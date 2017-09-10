package com.lonely_traveler.variables;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.command.BoardCmd;
import board.command.readCntDescListCmd;

@WebServlet("/Main")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HomeController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/xml;charset=UTF-8");
        response.setHeader("Cache-Control", "no-cache");

		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String cmdURI = requestURI.substring(contextPath.length());
		
		BoardCmd cmd = null;
		String viewPage = null;
		
		//조회수 상위 3개 목록 조회
		if(cmdURI.equals("/Main")){
			cmd = new readCntDescListCmd();
			cmd.execute(request, response);
			viewPage = "index.jsp";
		}
		
		RequestDispatcher dis = request.getRequestDispatcher(viewPage);
		dis.forward(request, response);
	}

}
