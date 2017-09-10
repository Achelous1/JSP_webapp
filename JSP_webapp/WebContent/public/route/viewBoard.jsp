<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "board.model.BoardDTO" %>
    
<%
	BoardDTO content = (BoardDTO)session.getAttribute("content");
	String user_id = (String)session.getAttribute("user_id");
	int user_no = (Integer)session.getAttribute("user_no");
%>

 <script>
 	debugger;
 	var user_id = ${ user_id };
 	var user_no = ${ user_no };
 </script>
 
<div class="container">
  <div id="boardContainer">
    <table class="table" width="80%">
    <tr>
        <td colspan="4" align="right">
        <h1 style="float:left;">게시글보기</h1>
	        <div class="btn-group"  style="float: right; padding-top: 40px;">
			  <input type="button" value="글쓰기" onclick="checkLogin('#!/boardWrite', user_id);" class="btn btn-primary btn-sm">
	          <input type="button" value="글수정" onclick="checkAuthor('boardUpdateForm.bctrl?board_no=${content.board_no}', user_no, ${ content.mem_no });" class="btn btn-warning btn-sm">
	          <input type="button" value="글삭제" onclick="checkAuthor('boardDelete.bctrl?board_no=${content.board_no}', user_no, ${ content.mem_no });" class="btn btn-danger btn-sm">
	          <input type="button" value="답글작성" onclick="checkLogin('boardReplyForm.bctrl?board_no=${content.board_no}', user_id);" class="btn btn-success btn-sm">
			  <input type="button" value="목록으로" onclick="history.back(-1);" class="btn btn-default btn-sm">
			</div>
        </td>
      </tr>
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
      
    </table>
   </div>
 </div>
 

