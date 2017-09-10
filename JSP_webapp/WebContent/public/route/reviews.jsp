<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "board.model.BoardDTO" %>
<h1>여행 후기</h1>


<script>
var boardList = <%= (String)session.getAttribute("json") %>;
var user_id = <%= (String)session.getAttribute("user_id") %>;
console.log(user_id);
</script>

<div class="form-group" style="margin-top:50px; padding-left: 60%;">
	<select class="form-control" name="search_type" ng-model="search_type" style="width:150px; float:left; height: 30px;" placeholder="검색 유형">
	   <option style="font-size: 16px;" value="title" selected>제목 검색</option>
	   <option value="content">내용 검색</option>
	   <option value="user_name">작성자 검색</option>
   </select>
	
 <div class="input-group-btn">
	 <input class="form-control" type="text" name="searchStr" ng-model="searchStr" placeholder="검색할 문맥" style="width:250px; float:left; height:30px;">
	 <a id="searchBtn" href="#!/search.bctrl?page=index.html#!/reviews.bctrl&search_type={{ search_type }}&searchStr={{ searchStr }}" class="btn btn-info" style="height: 30px;">
		 <i class="glyphicon glyphicon-search"></i>
	 </a>
	 <a onclick="checkLogin('#!/boardWrite', user_id);" class="btn btn-success" style="height:30px;">	<span class="glyphicon glyphicon-pencil"></span></a>
   </div>
</div>

<%
	String json = (String)session.getAttribute("json");
%>

<div id="review_table" ng-repeat="x in list">
	<table>
		<td rowspan="2" style="width: 100px;"><img src="./public/img/tokyo.jpg" width="90px" height="90px" align="left"></td>
		<td style="margin-left: 10px">
			<font style="font-size:25px">
			<a href="viewBoard.bctrl?board_no={{ x.board_no }}">{{ x.title }}</a>
			</font>
		</td>
		<tr>
			<td style="margin-left: 10px">{{x.contents | limitTo : 100 }}...</td>
		</tr>
		<tr>
			<input type="hidden" name="board_num" value="${ x.mem_no }">
		</tr>
	</table>
</div>


<center>
	<ul class="pagination pagination">
	    <li><a href="reviews.bctrl?page=1">1</a></li>
	    <li><a href="reviews.bctrl?page=2">2</a></li>
	    <li><a href="reviews.bctrl?page=3">3</a></li>
	    <li><a href="reviews.bctrl?page=4">4</a></li>
	    <li><a href="reviews.bctrl?page=5">5</a></li>
	</ul>
</center>

