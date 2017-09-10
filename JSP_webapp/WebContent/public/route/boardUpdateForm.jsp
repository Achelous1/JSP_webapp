<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "board.model.BoardDTO" %>
<% 
	BoardDTO boardUpdateForm = (BoardDTO)session.getAttribute("boardUpdateForm");
%>
<div class="container">
<form action="boardUpdate.bctrl" method="POST">
<table class="table table-default">
    <thead>
        <h1> 게시글 수정 </h1>
    </thead>
    <tbody>
            <tr>
                <th>제목</th>
                <td><input type="text" placeholder="제목을 입력하세요. " name="title" class="form-control" value="${boardUpdateForm.title}"/></td>
                <td><input type="hidden" name="mem_no" value= "<%= session.getAttribute("user_no") %>"  /></td>
            </tr>
            <tr>
                <td>작성자</td>
                <td>${boardUpdateForm.mem_no}</td>
            </tr>
            <tr>
                <th>내용</th>
                <td><textarea cols="50" rows="20" placeholder="내용을 입력하세요." name="contents" class="form-control" maxlength="1000">${boardUpdateForm.contents}</textarea></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="button" onclick="history.back(-1);" value="취소" class="btn btn-default pull-right"/>
                    <input type="submit" value="수정" class="btn btn-primary pull-right"/>
                </td>
            </tr>
    </tbody>
</table>
</form>
</div>