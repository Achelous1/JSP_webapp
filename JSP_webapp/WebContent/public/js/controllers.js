//login controller
app.controller('mainCtrl', ['$scope', '$window', '$http', function ($scope, $http, $modal, $window) {
	$scope.topList = topList;
}]);
//recommendations board control
app.controller('recommendationCtrl', function ($scope, $http) {
    $scope.getBoardList = function (result) {
        alert("get recommendations");
    }
    //Get recommendations board list from DB -> JSON
    $scope.listJSON = {Title: "Here comes title", Value: "here comes value"};
});

//review board control
app.controller('reviewsCtrl', ['$scope', '$window', '$http',  function ($scope, $http, $window) {
	$scope.list = boardList;
}]);

//write board control
app.controller('writeCtrl', function ($scope, $http) {
});

//sign up control
app.controller('signupCtrl', function ($scope, $http) {
	$scope.user_pw = null;
	$scope.pw_confirm = null;
	$scope.user_id = null;
	$scope.birthdate = null;
	$scope.phoneNo = null;
	$scope.name = null;
	$scope.gender = null;
	$scope.checkedId = checkedId;
});

//view contents control
app.controller('viewContentsCtrl', function ($scope, $http) {
});

//match list controll
app.controller('matchListCtrl', function ($scope, $http) {
    $scope.getChatList = function (result) {
        alert("get Chat List");
    }
    //get list from JSON
    $scope.matchList = myJSON;
});

