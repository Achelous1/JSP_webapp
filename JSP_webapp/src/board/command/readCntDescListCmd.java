package board.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import board.model.*;

public class readCntDescListCmd implements BoardCmd {

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) {
      // TODO Auto-generated method stub
      //선언부분
      BoardDAO dao = new BoardDAO();
      ArrayList<BoardDTO> list;
      Gson gson = new Gson();
      
      list = dao.readCntDescList();
      
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
   }

}