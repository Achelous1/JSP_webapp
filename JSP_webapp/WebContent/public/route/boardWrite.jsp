<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="container">
<table class="table table-default">
    <thead>
        <h1> 게시글 올리기 </h1>
    </thead>
    <tbody>
        <form action="boardWrite.bctrl" method="POST">
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
                <!-- <select name='job' size='1'>
                  <option value=''>나의 여행지</option>
                  <option value='17/10/18~17/10/20'>17/10/18~17/10/20</option>
                  <option value='17/10/28~17/10/05'>17/10/28~17/10/05</option>
                  <option value=''>3</option>
                  <option value=''>4</option>
                  <option value=''>5</option>
                  <option value=''>6</option>
                  <option value=''>7</option>
                  <option value=''>8</option>
                  <option value=''>9</option>
                  <option value=''>10</option>
                  <option value=''>11</option>
                </select> -->
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
        </form>
    </tbody>
</table>
</div>