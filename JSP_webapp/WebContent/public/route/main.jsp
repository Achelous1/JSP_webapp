<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h3 style="color: rgb(133,133,133);">여행일정</h3>

<div id="Menu" class="col-sm-10">
	<form action="" method="post">
		<div class="form-group row">
			<input id="datePicker" placeholder="가는 날짜" style="width: 10%; float:left; margin-right: 30px; margin-left: 20px;" class="form-control" type="text" name="datePicker" value="">
			<input id="datePicker" placeholder="오는 날짜" style="width: 10%;float:left; margin-right: 30px;" class="form-control" type="text" name="datePicker" value="">
			<select class="form-control" style="width:10%; float:left; margin-right: 30px;">
				<option value="">출발 지역</option>
				<option value="">서울ㆍ경기</option>
				<option value="">강원</option>
				<option value="">충북</option>
				<option value="">대전ㆍ충남</option>
				<option value="">대구ㆍ경북</option>
				<option value="">전북</option>
				<option value="">광주ㆍ전남</option>
				<option value="">부산ㆍ경남</option>
				<option value="">제주</option>
			</select>
			<select class="form-control" style="width:10%; float:left; margin-right: 30px;">
				<option value="">가는 지역</option>
				<option value="">서울ㆍ경기</option>
				<option value="">강원</option>
				<option value="">충북</option>
				<option value="">대전ㆍ충남</option>
				<option value="">대구ㆍ경북</option>
				<option value="">전북</option>
				<option value="">광주ㆍ전남</option>
				<option value="">부산ㆍ경남</option>
				<option value="">제주</option>
			</select>
			<input class="form-control" type="number" style="width: 10%; float:left; margin-right: 30px;" placeholder="가는 인원" name="person_going">
			<input class="form-control" type="number" style="width: 10%; float:left; margin-right: 30px;" placeholder="오는 인원" name="person_req">
			<input type="button" class="btn btn-default" value="찾아줘요!">
		</div>
	</form>
</div>

<div id="main_best" class="col-sm-7">
	<h3>베스트 후기</h3>
	<div id="topList" ng-repeat="x in topList">
		<table>
			<td rowspan="2" style="width: 100px;"><img src="./public/FILE_SYSTEM/BOARD_IMG/{{ x.board_no }}.jpg" width="90px" height="90px" align="left"></td>
			<td style="margin-left: 10px">
				<font style="font-size:25px">
				<a href="viewBoard.bctrl?board_no={{ x.board_no }}">{{ x.title }}</a>
				</font>
			</td>
			<tr>
				<td style="margin-left: 10px">{{x.contents | limitTo : 100 }}...</td>
			</tr>
			<tr>
				<input type="hidden" name="board_num" value="${ x.mem_no }">
			</tr>
		</table>
	</div>

</div>

<div style="padding: 30px;" id="main_social" class="col-sm-3">
	<div style="background-color: white; padding: 5px; box-shadow: 3px 3px 3px rgba(133,133,133,0.60);" data-skyscanner-widget="SearchWidget"></div>
	<script src="https://widgets.skyscanner.net/widget-server/js/loader.js" async></script>
	
	<div style="box-shadow: 3px 3px 3px rgba(133,133,133,0.60); margin-top: 20px;" >
		<a class="twitter-timeline" data-lang="ko" data-width="100%" data-height="300" data-dnt="true" data-theme="light" data-link-color="#E81C4F" href="https://twitter.com/LonelyTravele10">Tweets by LonelyTravele10</a> 
		<script async src="//platform.twitter.com/widgets.js" charset="utf-8"></script>
	</div>
</div>


