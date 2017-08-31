<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h1>여행 후기</h1>

<!-- <div id="review_table" ng-repeat="x in names">
	<table>
		<td rowspan="2" style="width: 130px;"><img src="./public/img/tokyo.jpg" width="120px" height="120px" align="left"></td>
		<td style="margin-left: 10px"><a href="#!/viewBoard.bctrl"><font style="font-size:25px">{{ x.Name }}</font></a></td>
		<tr>
			<td style="margin-left: 10px">{{ x.City }}</td>
		</tr>
		<tr>
			<input type="hidden" name="board_num" value="{{x.board_num}}">
		</tr>
	</table> -->
	<div class="form-group" style="margin-top:50px; padding-left: 60%;">
 		<select class="form-control" name="search_type" ng-model="search_type" style="width:150px; float:left; height: 30px;">
			<option style="font-size: 16px;" value="title" selected>제목 검색</option>
			<option value="content">내용 검색</option>
			<option value="user_name">작성자 검색</option>
		</select>
		 
	  <div class="input-group-btn">
	  	<input class="form-control" type="text" name="searchStr" ng-model="searchStr" placeholder="검색할 문맥" style="width:250px; float:left; height:30px;">
		  <a href="#!/search.bctrl?{{ search_type }}={{ searchStr }}" class="btn btn-info" style="height: 30px;">
		  	<i class="glyphicon glyphicon-search"></i>
		  </a>
		  <a href="#!/boardWrite" class="btn btn-success" style="height:30px;">	<span class="glyphicon glyphicon-pencil"></span></a>
		</div>
	</div>
	<c:forEach items="${list}">
		<table>
			<tr>
				<td rowspan="2" style="width: 130px;"><img src="./public/img/tokyo.jpg" width="120px" height="120px" align="left"></td>
				<td style="margin-left: 10px"><a href="#!/viewBoard.bctrl"><font style="font-size:25px">${list.title}</font></a></td>
			</tr>
			<tr>
				<td style="margin-left: 10px">${person.contents}</td>
			</tr>
			<tr>
				<input type="hidden" name="board_num" value="${list.board_no}">
			</tr>
		</table>
	 </c:forEach>
	 
	 
</div>