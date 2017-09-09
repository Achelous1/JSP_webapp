<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>회원가입</h1>

<div class="col-sm-10 well" style="margin-top: 40px;">
  <form action="/JSP_webapp/signup.mctrl" method="POST" name="signUpForm" enctype="multipart/form-data">
    <!--Start of form control -->
    <div class="col-sm-7">
      <div class="col-xs-12">
        <!-- ID Input -->
        <div class="col-xs-3" style="margin-top: 20px;">
          <label>ID</label>
        </div>
        <div class="col-xs-9" style="margin-top: 20px;" >
	        <input type="button" style="width: 30%; float: right;" class="form-control" value="중복확인" onclick="checkId(document.getElementById('user_id').value);">
	 		    <div ng-class="{'has-error':!signUpForm.user_id.$valid}">
	          <input type="text" style="width: 65%; margin-right: 5%;" class="form-control" id="user_id" name="user_id" placeholder="아이디 입력" required>
      		</div>
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
        <div class="col-xs-9" style="margin-top: 20px;" ng-class="{'has-error':!signUpForm.name.$valid}">
          <input type="text" class="form-control" name="name" placeholder="이름 입력" ng-model="name" required>
        </div>
        
        <!-- gender input -->
        <div class="col-xs-3" style="margin-top: 20px;">
          <label>성별</label>
        </div>
        <div class="col-xs-9" style="margin-top: 20px;" ng-model="gender">
          <div class="radio">
            <label class="radio-inline"><input type="radio" ng-bind="gender" name="gender" value="M" required>남자</label>
          </div>
          <div class="radio">
            <label class="radio-inline"><input type="radio" ng-bind="gender" name="gender" value="F" required>여자</label>
          </div>
        </div>

        <!-- birthdate input -->
        <div class="col-xs-3" style="margin-top: 20px;">
          <label>생년월일</label>
        </div>
        <div class="col-xs-9" style="margin-top: 20px;" ng-class="{'has-error':!signUpForm.birthdate.$valid}">
          <input type="text" class="form-control" ng-model="birthdate" name="birthdate" placeholder="ex.) 2000-01-01" required>
        </div>

        <!-- phone number input -->
        <div class="col-xs-3" style="margin-top: 20px;">
          <label>핸드폰 번호</label>
        </div>
        <div class="col-xs-9" style="margin-top: 20px;" ng-class="{'has-error':!signUpForm.phoneNo.$valid}">
          <input type="text" class="form-control" ng-model="phoneNo" name="phoneNo" placeholder="ex.) 010-1111-1111" required>
        </div>

        <!-- email input -->
        <div class="col-xs-3" style="margin-top: 20px;">
          <label>이메일주소</label>
        </div>
        <div class="col-xs-9" style="margin-top: 20px;">
          <input type="email" class="form-control" name="email" placeholder="ex.) email@domain.com">
        </div>

        <!-- address input -->
        <div class="col-xs-3" style="margin-top: 20px;">
          <label>주소</label>
        </div>
        <div class="col-xs-9" style="margin-top: 20px;" ng-class="{'has-error':!signUpForm.addr.$valid}">
          <input type="text" class="form-control" ng-model="addr" name="addr" placeholder="주소입력" required>
        </div>

        <!-- submit and cancel -->
        <div class="col-xs-12" style="text-align: right; margin-top: 20px;">
          <input type="submit" class="btn btn-success" style="width: 100px; margin-right: 30px;" value="가입하기" ng-disabled="signUpForm.$invalid">
          <input type="button" class="btn btn-default" style="width: 100px;  float:right;" onclick="moveTo('index.html')" value="취소">
        </div>
      </div>
    </div>
    <div class="col-sm-5">
	  <div id="holder" ng-hide="mem_img.value != null">
	    <img src="./public/img/user_pic_logout.PNG" width="180px" height="180px"><br/>
	  </div>
      <input id="mem_img" name="mem_img" style="margin-top: 20px;" type="file" ng-model="mem_img" name="프로필 사진 추가" onchange="handleFileSelect();">
    </div>
  </form>
</div>

<script>
//image handler
function handleFileSelect() {
    var files = document.getElementById('mem_img').files[0]; //파일 객체

    var reader = new FileReader();

    //파일정보 수집        
    reader.onload = (function(theFile) {
        return function(e) {
            //이미지 뷰
            var img_view = ['<img ng-model="img_preview" src="', e.target.result, '" title="', escape(theFile.name), ' "width="180px" height="180px"/>'].join('');                
            document.getElementById('holder').innerHTML = img_view;
        };

    })(files);
        
    reader.readAsDataURL(files);    
}

var checkedId = <%= session.getAttribute("checkedId") %>;
</script>