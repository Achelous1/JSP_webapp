<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>회원가입</h1>

<div class="col-sm-10 well" style="margin-top: 40px;" ng-controller="signupCtrl">
  <form action="/JSP_webapp/signup.mctrl" method="POST" name="signUpForm"  novalidate>
    <!--Start of form control -->
    <div class="col-sm-7">
      <div class="col-xs-12">
        <!-- ID Input -->
        <div class="col-xs-3" style="margin-top: 20px;">
          <label>ID</label>
        </div>
        <div class="col-xs-9" style="margin-top: 20px;">
          <input type="button" style="width: 30%; float: right;" class="form-control" value="중복확인" onclick="checkId(document.getElementById('user_id').value);">
          <input type="text" style="width: 65%; margin-right: 5%;" class="form-control" id="user_id" name="user_id" placeholder="아이디 입력">
        </div>

        <!-- password input -->
        <div class="col-xs-3" style="margin-top: 20px;">
          <label>비밀번호</label>
        </div>
        <div class="col-xs-9" style="margin-top: 20px;" ng-class="{'has-error':!signUpForm.user_pw.$valid}">
          <input type="password" class="form-control" name="user_pw" ng-model="user_pw" placeholder="비밀번호 입력" required>
        </div>

        <!-- confirm password input -->
        <div class="col-xs-3" style="margin-top: 20px;">
          <label>비밀번호 확인</label>
        </div>
        <div class="col-xs-9" style="margin-top: 20px;" ng-class="{'has-error':!signUpForm.pw_confirm.$valid}">
          <input type="password" class="form-control" name="pw_confirm" ng-model="pw_confirm" placeholder="비밀번호 입력" required password-confirm match-target="user_pw">
       	  <span class="help-block" ng-show="signUpForm.pw_confirm.$error.match">비밀번호가 같지 않습니다</span>
        </div>

        <!-- name input -->
        <div class="col-xs-3" style="margin-top: 20px;">
          <label>이름</label>
        </div>
        <div class="col-xs-9" style="margin-top: 20px;">
          <input type="text" class="form-control" name="name" placeholder="이름 입력" required>
        </div>
        
        <!-- gender input -->
        <div class="col-xs-3" style="margin-top: 20px;">
          <label>성별</label>
        </div>
        <div class="col-xs-9" style="margin-top: 20px;">
          <div class="radio">
            <label class="radio-inline"><input type="radio" name="gender" value="M" required>남자</label>
          </div>
          <div class="radio">
            <label class="radio-inline"><input type="radio" name="gender" value="F" required>여자</label>
          </div>
        </div>

        <!-- birthdate input -->
        <div class="col-xs-3" style="margin-top: 20px;">
          <label>생년월일</label>
        </div>
        <div class="col-xs-9" style="margin-top: 20px;">
          <input type="text" class="form-control" name="birthdate" placeholder="ex.) 2000-01-01" required>
        </div>

        <!-- phone number input -->
        <div class="col-xs-3" style="margin-top: 20px;">
          <label>핸드폰 번호</label>
        </div>
        <div class="col-xs-9" style="margin-top: 20px;">
          <input type="text" class="form-control" name="phoneNo" placeholder="ex.) 010-1111-1111" required>
        </div>

        <!-- email input -->
        <div class="col-xs-3" style="margin-top: 20px;">
          <label>이메일주소</label>
        </div>
        <div class="col-xs-9" style="margin-top: 20px;">
          <input type="email" class="form-control" name="email" placeholder="ex.) email@domain.com" required>
        </div>

        <!-- address input -->
        <div class="col-xs-3" style="margin-top: 20px;">
          <label>주소</label>
        </div>
        <div class="col-xs-9" style="margin-top: 20px;">
          <input type="text" class="form-control" name="addr" placeholder="주소입력" required>
        </div>

        <!-- submit and cancel -->
        <div class="col-xs-12" style="text-align: right; margin-top: 20px;">
          
          <input type="submit" class="btn btn-success" style="width: 100px; margin-right: 30px;" value="가입하기" ng-disabled="signUpForm.$invalid">
          <input type="button" class="btn btn-default" style="width: 100px;  float:right;" onclick="moveTo('index.html')" value="취소">
        </div>
      </div>
    </div>
    <div class="col-sm-5">
      <img src="./public/img/user_pic_logout.PNG" width="180px" height="180px"><br/>
      <input style="margin-top: 20px;" type="file" name="프로필 사진 추가">
    </div>
  </form>
</div>