<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>여행 후기</h1>

<div id="review_table" ng-repeat="x in names">
	<table>
		<td rowspan="2" style="width: 130px;"><img src="./public/img/tokyo.jpg" width="120px" height="120px" align="left"></td>
		<td style="margin-left: 10px"><font style="font-size:25px">{{ x.Name }}</font></td>
		<tr>
			<td style="margin-left: 10px">{{ x.City }}</td>
		</tr>
		<tr>
			<input type="hidden" name="board_num" value="{{x.board_num}}">
		</tr>
	</table>
</div>