//routing function
var app = angular.module('layout', ['ngRoute']);
app.config(function($routeProvider/*, $locationProvider, $httpProvider*/){
  $routeProvider
  //route to main page
  .when('/', {
      templateUrl: './public/route/main.jsp',
      controller: 'mainCtrl'
  })
  //route to matching list
  .when('/myMatchList.cbs', {
      templateUrl: './public/route/myMatchList.jsp',
      controller : 'matchListCtrl'
  })
  //route to chatting room
  .when('/myMatchList.cbs/talkStranger', {
      templateUrl: './public/route/talkStranger.jsp',
      controller : 'chatCtrl'
  })
  //route to recommendations board
  .when('/recommendations.bctrl', {
      templateUrl: './public/route/recommendations.jsp',
      controller : 'recommendationCtrl'
  })
  //route to reviews board
  .when('/reviews', {
      templateUrl: './public/route/reviews.jsp',
      controller : 'reviewsCtrl'
  })
  //route to sign up page
  .when('/signup', {
      templateUrl: './public/route/signup.jsp',
      controller : 'signupCtrl'
  })
  //route to board write page
  .when('/boardWrite', {
      templateUrl: './public/route/boardWrite.jsp',
      controller : 'writeCtrl'
  })
  //route to my page
  .when('/myPage', {
      templateUrl: './public/route/myPage.jsp',
      controller : 'myPageCtrl'
  })
  //route to board content page
  .when('/viewBoard', {
      templateUrl: './public/route/viewBoard.jsp',
      controller : 'viewContentsCtrl'
  })
  .when('/setSession', {
      templateUrl: './public/php/SessionAttributeSet.jsp'
  })
  .when('/boardUpdate', {
      templateUrl: './public/route/boardUpdateForm.jsp'
  })
  //route back to main otherwise
  .otherwise({
    redirectTo: '/'
  });
});
//ng-directives
//password confirm and required directive
app.directive('passwordConfirm', ['$parse', function ($parse) {
	 return {
	    restrict: 'A',
	    scope: {
	      matchTarget: '=',
	    },
	    require: 'ngModel',
	    link: function link(scope, elem, attrs, ctrl) {
	      var validator = function (value) {
	        ctrl.$setValidity('match', value === scope.matchTarget);
	        return value;
	      }
	 
	      ctrl.$parsers.unshift(validator);
	      ctrl.$formatters.push(validator);
	      
	      // This is to force validator when the original password gets changed
	      scope.$watch('matchTarget', function(newval, oldval) {
	        validator(ctrl.$viewValue);
	      });

	    }
	  };
	}]);

app.directive('availConfirm', ['$parse', function ($parse) {
	 return {
	    restrict: 'A',
	    scope: {
	      checkedId: '=',
	    },
	    require: 'ngModel',
	    link: function link(scope, elem, attrs, ctrl) {
		      var validator = function (value) {
		        ctrl.$setValidity('checkedId', value === checkedId);
		        return value;
		      }
		 
		      ctrl.$parsers.unshift(validator);
		      ctrl.$formatters.push(validator);
		      
		      // This is to force validator when the original password gets changed
		      scope.$watch('checkIdAvail', function(checkedId) {
		        validator(ctrl.$viewValue);
		      });
	    }
	  };
	}]);

//cancel button
function moveTo(url){
    window.location.assign(url);
}

//check ID availability
function checkId(user_id){
	var id = user_id;
	window.open("checkId.mctrl?user_id=" + id, "Check_availability", "width=300,height=300");
}

//date picker
$('#datePicker').daterangepicker({
    "showDropdowns": true,
    "timePicker24Hour": true,
    "parentEl": "Menu",
    "startDate": "01/01/2017",
    "endDate": "01/01/2017"
}, function(start, end, label) {
  console.log("New date range selected: ' + start.format('YYYY-MM-DD') + ' to ' + end.format('YYYY-MM-DD') + ' (predefined range: ' + label + ')");
});


//세션 체크 후 로그인 아닐 시 alert
function checkLogin(url, user_id){
	var url = url;
	var user_id = user_id;
	if(user_id == null || user_id == ""){
		alert("해당 서비스를 사용하려면 로그인 해주세요");
	} else {
		moveTo(url);
	}
}

//아이디 동일여부 확인
function checkAuthor(url, user_no, author){
	var url = url;
	var user_no = user_no;
	if(user_no == null || user_no == ""){
		alert("해당 서비스를 사용하려면 로그인 해주세요");
	} else if (user_no == author){
		moveTo(url);
	}else {
		alert("해당 글에 대한 권한이 없습니다");
	}
}

