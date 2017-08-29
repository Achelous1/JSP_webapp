<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="container">
        <h1>게시글보기</h1>
        <form action="/bbs/replyForm.bbs" method="post">

          <table class="table" width="100%">
            <tr>
              <th width="30">{{ content.name }}}</th>
              <td width="80%">{{ content.city }}.</td>
              <th>조회수</th>
              <td>500</td>
            </tr>
            <tr>
              <th>작성자</th>
              <td>{{ content.author }}</td>
              <th>날짜</th>
              <td>2017/08/17</td>
            </tr>
            <tr height="400" align="top">
              <td colspan="4">{{ content.country }}</td>
            </tr>
            <tr>
              <th>첨부</th>
              <td colspan="3">없음</td>
            </tr>
            <tr>
              <td colspan="4" align="right">
                <input type="button" value="글쓰기" onclick="#!/boardWrite" class="btn btn-primary">
                <input type="button" value="목록으로" onclick="#!/board.bbs" class="btn btn-default">
              </td>
            </tr>
          </table>
      </form>
    </div>
