<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="container">
<form action="boardWrite.bctrl" method="POST">
<table class="table table-default">
    <thead>
        <h1> 게시글 올리기 </h1>
    </thead>
    <tbody>
        
            <tr>
                <th>제목</th>
                <td><input type="text" placeholder="제목을 입력하세요. " name="title" class="form-control"/></td>
                <td><input type="hidden" name="mem_no" value= "<%= session.getAttribute("user_no") %>"  /></td>
            </tr>
            <tr>
                <td>작성자</td>
                <td><%= session.getAttribute("user_name") %></td>
            </tr>
            <tr>
              <th></th>
              <td>
                <input type="radio" name="type" value="rev">후기
                <input type="radio" name="type" value="rec" disabled>추천여행지
                <input type="file" name="fileName" value="사진 등록" >
              </td>
            </tr>
            <tr>
                <th>내용</th>
                <td><textarea cols="50" rows="20" placeholder="내용을 입력하세요." name="contents" class="form-control" maxlength="1000"></textarea></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="button" onclick="history.back(-1);" value="취소" class="btn btn-default pull-right"/>
                    <input type="submit" value="등록" class="btn btn-primary pull-right"/>
                </td>
            </tr>
        
    </tbody>
</table>
</form>
</div>