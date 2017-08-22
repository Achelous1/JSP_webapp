//login controller
app.controller('mainCtrl', function ($scope, $http) {
    $scope.login = function (result) {
    //     $http({
    //         method: 'POST',
    //         url: './public/js/sign_in.php'
    //     }).success(function () {
    //         alert("successfully logged in");
    //     }).error(function () {
    //         alert("something went wrong");
    //     });
        alert("login!");
    };
});

//recommendations board control
app.controller('recommendationCtrl', function ($scope, $http) {
    $scope.getBoardList = function (result) {
        alert("get recommendations");
    }
    //Get recommendations board list from DB -> JSON
    $scope.listJSON = {Title: "Here comes title", Value: "here comes value"};
    $scope.list = listJSON;
});

//review board control
app.controller('reviewsCtrl', function ($scope, $http) {
    $scope.getBoardList = function (result) {
        alert("get reviews");
        // $http.get("../php/customers.php")
        // .then(function (response) {$scope.names = response.data.records;});
        
    }
    $scope.names = myJSON;
});

//write board control
app.controller('writeCtrl', function ($scope, $http) {
    $scope.boardWrite = function (result) {
        alert("write on board");
    }
});

//sign up control
app.controller('signupCtrl', function ($scope, $http) {
    $scope.signupForward = function (result) {
        alert("signed up");
    }
    $http.post("/JSP_webapp/MemberFrontCtrl")
    .then(function (response) {
        //here comes the sign in result
    });
});

//view contents control
app.controller('viewContentsCtrl', function ($scope, $http) {
    $scope.viewContents = function (result) {
        alert("viewing contents");
    }
});

//match list controll
app.controller('matchListCtrl', function ($scope, $http) {
    $scope.getChatList = function (result) {
        alert("get Chat List");
    }
    //get list from JSON
    $scope.list = listJSON;
});