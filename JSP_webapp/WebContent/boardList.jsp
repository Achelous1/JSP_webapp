<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<h3>게시판 목록 조회</h3>
		
		<table border="1">
			<tr>
				<td colspan="6" align="right">
					<a href="boardWrite.jsp">[새글쓰기]</a>
				</td>
			</tr>
			<tr>
				<td>글 번호</td>
				<td>글 제목</td>
				<td>작성자</td>
				<td>작성일</td>
				
				<td>조회수</td>
				<td>답글수</td>
			</tr>		
			<c:forEach items="${ boardList }" var="dto">
				<tr>
					<td><a href="viewBoard.bctrl?board_no=${dto.board_no }">${dto.board_no }</a></td>
					<td>
						<c:forEach begin="1" end="${dto.lev }">
							<%= "&nbsp;&nbsp;" %>
						</c:forEach>
						<a href="viewBoard.bctrl?board_no=${dto.board_no }">${dto.title }</a></td> 
					<td>${dto.mem_no }</td>
					<td>${dto.post_date }</td>
					
					<td>${dto.read_cnt }</td>
					<td>${dto.child_cnt }</td>
				</tr>
			</c:forEach>
			
			<tr>
				<td colspan="6">
				        <c:if test="${startPage != 1}">
				            <a href='boardList.bctrl?page=${startPage-1}'>[ 이전 ]</a>
				        </c:if>
				        
				        <c:forEach var="pageNum" begin="${startPage}" end="${endPage}">
				            <c:if test="${pageNum == spage}">
				                ${pageNum}&nbsp;
				            </c:if>
				            <c:if test="${pageNum != spage}">
				                <a href='boardList.bctrl?page=${pageNum}'>${pageNum}&nbsp;</a>
				            </c:if>
				        </c:forEach>
				        
				        <c:if test="${endPage != maxPage }">
				            <a href='boardList.bctrl?page=${endPage+1 }'>[다음]</a>
				        </c:if>
				</td>
			
			</tr>
			
			<tr>
				<td colspan="6" align="center">
					<form action="boardSearch.bctrl" method="post">
						<select name="searchOption">
							<option value="title">제목</option>
							<option value="contents">본문</option>
							<option value="both">제목+본문</option>
							<option value="mem_no">작성자</option>
						</select>
						<input type="text" name="searchWord">
						<input type="submit" value="검색">
					</form>
				</td>
			</tr>
		</table>
</body>
</html>