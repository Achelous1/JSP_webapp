<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h3>�Խ��� ��� ��ȸ</h3>
		
		<table border="1">
			<tr>
				<td colspan="6" align="right">
					<a href="boardWrite.bctrl">[���۾���]</a>
				</td>
			</tr>
			<tr>
				<td>�� ��ȣ</td>
				<td>�� ����</td>
				<td>�ۼ���</td>
				<td>�ۼ���</td>
				
				<td>��ȸ��</td>
				<td>��ۼ�</td>
			</tr>		
			<c:forEach items="${boardList }" var="dto">
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
				<a href="boardList.bctrl">[ù ��������]</a>
					<c:forEach var ="i" begin="1" end ="${pageCnt}">
						<a href="boardList.bctrl?curPage=${i}">[${i}]</a>
					</c:forEach>
				</td>
			
			</tr>
			
			<tr>
				<td colspan="6" align="center">
					<form action="boardSearch.bctrl" method="post">
						<select name="searchOption">
							<option value="title">����</option>
							<option value="contents">����</option>
							<option value="both">����+����</option>
							<option value="mem_no">�ۼ���</option>
						</select>
						<input type="text" name="searchWord">
						<input type="submit" value="�˻�">
					</form>
				</td>
			</tr>
		</table>
</body>
</html>