<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�Խ��� ���� ����</title>
</head>
<body>
	<h3>�Խ��� ����</h3>
	<form action="boardWrite.bctrl" method="post">
	<table>
		<tr>
			<td colspan="4" align="right"><a href="boardList.bbs">[�������]</a>
			</td>
		</tr>
		<tr>
			<td>������</td>
			<td colspan="3"><input type="text" name="title" maxlength="50" size"50"></td>
		</tr>
		<tr>
			<td>�ۼ���</td>
			<td colspan="3"><input type="text" name="mem_no" maxlength="4" size"20"></td>
		</tr>
		<tr>
			<td>����</td>
			<td colspan="3"><textarea name="contents" rows="8" cols="45"></textarea></td>
		</tr>
		<tr>
			<td colspan="4" align="right">
				<input type="submit" value="�ۿø���"></a>
			</td>
		</tr>
	</table></form>	
</body>
</html>