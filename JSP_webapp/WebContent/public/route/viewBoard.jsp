<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "board.model.BoardDTO" %>
    
<%
	BoardDTO content = (BoardDTO)session.getAttribute("content");
%>
<div class="container">
  <div id="boardContainer">
    <h1>게시글보기</h1>
    <table class="table" width="80%">
      <tr>
        <th style="width: 10%;">제목</th>
        <td style="width: 70%;">${ content.title }</td>
        <th style="width: 10%;">조회수</th>
        <td style="width: 20%;">${ content.read_cnt }</td>
      </tr>
      <tr>
        <th style="width: 10%;">작성자</th>
        <td style="width: 40%;">${ content.mem_no }</td>
        <th style="width: 10%;">날짜</th>
        <td style="width: 40%;">${ content.post_date }</td>
      </tr>
      <tr>
        <td id="boardContent" colspan="4">
        <center>
        	<img src="./public/img/okinawa.jpg" width="70%" height="70%">
        </center>
        	<p style="margin-top: 50px;">${ content.contents }</p>
        </td>
      </tr>
      <tr>
        <td colspan="4" align="right" style="padding-top: 80px;">
          <input type="button" value="글쓰기" onclick="moveTo('#!/boardWrite');" class="btn btn-primary">
          <input type="button" value="목록으로" onclick="moveTo('/JSP_webapp/reviews.bctrl');" class="btn btn-default">
        </td>
      </tr>
    </table>
   </div>
 </div>
