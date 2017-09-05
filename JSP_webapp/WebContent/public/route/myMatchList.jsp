<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="container">
  <h1>매칭리스트</h1>
  <%
  	if(session.getAttribute("user_id") == null){
  %>
  	<script>
  		alert("로그인 후 서비스를 이용해 주세요");
  		moveTo("index.jsp");
  	</script>
  <%
  	} else if(session.getAttribute("user_id") != null) {
  %>
  <table class="table">
    <thead>
      <tr>
        <th colspan="3">2017/9/27 ~ 2017/10/02 까지 대구에서 도쿄로~</th>
      </tr>
      <tbody>
        <tr>
          <td>1</td>
          <td width="80%">ooo님과 매칭 되었습니다</td>
          <td>
            <div class="btn-group">
                <a class="btn btn-primary btn-sm" href="#!/myMatchList.cbs/talkStranger/{{ chat_no }}">대화하기</a>
                <a class="btn btn-danger btn-sm">나가기</a>
            </div>
          </td>
        </tr>
        <tr>
          <td>2</td>
          <td width="60%">ooo님과 매칭 되었습니다</td>
          <td>
              <div class="btn-group">
                  <a class="btn btn-primary btn-sm" href="#!/myMatchList.cbs/talkStranger/{{ chat_no }}">대화하기</a>
                  <a class="btn btn-danger btn-sm">나가기</a>
              </div>
          </td>
        </tr>
        <tr>
          <td>3</td>
          <td width="60%">ooo님과 매칭 되었습니다</td>
          <td>
              <div class="btn-group">
                  <a class="btn btn-primary btn-sm" href="#!/myMatchList.cbs/talkStranger/{{ chat_no }}">대화하기</a>
                  <a class="btn btn-danger btn-sm">나가기</a>
              </div>
          </td>
        </tr>
      </tbody>
    </thead>
  </table>
  <%
  	}
  %>
