<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session = "true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
  <!-- <base href="/JSP_webapp/index.html"> -->
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!--외부스타일시트¸-->
  <link rel="stylesheet" href="./public/css/style.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/bootstrap.daterangepicker/2/daterangepicker.css" />
  <!--ì¤í¬ë¦½í¸ íì¼-->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular-route.js"></script>
  <script type="text/javascript" src="//cdn.jsdelivr.net/bootstrap.daterangepicker/2/daterangepicker.js"></script>
  <script async src="//platform.twitter.com/widgets.js" charset="utf-8"></script>
  <script src="./public/js/script.js"></script>
  <script src="./public/js/controllers.js"></script>
  <script src="./public/js/temp.js"></script>

  <title>외로운 여행자</title>
</head>

<body ng-app="layout" background="./public/img/background.jpg">
  <!-- nav bar -->
  <div class="container-fluid">
    <div class="row content">
      <nav class="col-sm-2" id="navBar">
        <p style="font-family: 'lucida handwriting'; font-size: 30px; color: rgb(133,133,133); margin-top: 20px; rgb(38, 38, 38);">Lonely</p>
        <p style="font-family: 'lucida handwriting'; font-size: 30px; color: white; margin-left: 20px; margin-top:-20px;">Travelers</p>
        <ul class="nav nav-pills nav-stacked" style="text-align : right; margin-top : 50px;">
          <li><a href="#!/">여행동반자 찾기</a></li>
          <li><a href="#!/myMatchList.cbs">My 매칭리스트</a></li>
          <li><a href="#!/reviews.bctrl">이용후기</a></li>
          <li><a href="#!/recommendations.bctrl">추천여행지</a></li>
        </ul>
      </nav>

      <!-- header -->
      <div id="contents" class="col-sm-10">

        <div class="row" style="text-align: right; height: 50px; padding-top: 10px; padding-right: 20px;">
          <!-- dropdown -->
          <div class="dropdown">
          <%
          	if(session.getAttribute("user_id") == null){
          %>
            <input type="button" class="btn btn-default" style="float: right;" value="로그인/회원가입" data-toggle="modal" data-target="#logIn">
           <%
          	} else if(session.getAttribute("user_id") != null){
           %>
            <a href="./public/php/SessionQuit.jsp" class="btn btn-default" style="float: right;">로그아웃</a>
            <input type="button" class="btn btn-default" style="float: right;" data-toggle="dropdown" value="마이페이지">
            <ul class="dropdown-menu dropdown-menu-right" style="position: absolute; z-index: 1; margin-right: 20px; margin-top: 30px;">
              <li><a href="#!/myPage">마이페이지</a></li>
              <li class="divider"></li>
              <li><a href="#!/myMatchList.cbs">마이매칭리스트</a></li>
            </ul>
            <p style="float:right; margin-top: 10px; margin-right: 30px;">어서오세요. <strong>[<%= session.getAttribute("user_name") %>]</strong>님</p>
           <%
            }
           %>
          </div>
        </div>
        <!-- 조원코딩구간 -->
        <ng-view></ng-view>
        <!-- 조원코딩구간 끝 -->
      </div>
    </div>
  </div>
  <!--Start of log in modal-->
  <div id="logIn" class="modal fade" role="dialog" ng-controller="mainCtrl">  
    <div class="modal-dialog">
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" id="close" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">로그인</h4>
        </div>
        <div class="modal-body">
          <!--form action for login -->
          <form action="login.mctrl" method="post">
            <div class="form-group">
              <label for="user_id">ID:</label>
              <input type="text" class="form-control" id="user_id" name="user_id" placeholder="Enter ID">
            </div>
            <div class="form-group">
              <label for="user_pw">Password:</label>
              <input type="password" class="form-control" id="user_pw" name="user_pw" placeholder="Enter Password">
            </div>
            <div class="sign_up">
              <div style="text-align: right;"><label>아직 회원이 아니신가요?<i><a href="#!/signup" onclick="document.getElementById('close').click();">여기</a></i>를 클릭하세요</label></div>
            </div>
            <div class="modal-footer">
              <button type="submit" class="btn btn-default" >로그인</button>
              <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
</body>

</html>