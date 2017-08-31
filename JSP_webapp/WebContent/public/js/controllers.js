//login controller
app.controller('mainCtrl', function ($scope, $http, $modal) {

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
    // $scope.signup = function(){
    //     $http.post("/signup.mctrl")({
    //     }).then(function mySuccess(response) {
    //         $scope.successSignup = response.data;
    //     }, function myError(response) {
    //         $scope.failSignup = response.statusText;
    //     });
    // }
    if(response.status == 500){
        $scope.data = {
            boldTextTitle: "에러!",
            textAlert : "무언가 잘못되었군요! 다시 가입해주세요.",
            mode : 'warning'
          }  
    }
    else if(response.status == 200){
        $scope.data = {
            boldTextTitle: "가입성공!",
            textAlert : "회원가입이 완료되었습니다. 로그인해주세요.",
            mode : 'success'
          }
    }
});

//view contents control
app.controller('viewContentsCtrl', function ($scope, $http) {
    $http.get("viewBoard.bctrl")
    .then(function(response) {
        //First function handles success
        //$scope.content = response.data;
        $scope.content = myJSON;
    }, function(response) {
        //Second function handles error
        $scope.error = respons.error;
        if(error == '404')
            $scope.content = "there are not contents available";
    });
});

//match list controll
app.controller('matchListCtrl', function ($scope, $http) {
    $scope.getChatList = function (result) {
        alert("get Chat List");
    }
    //get list from JSON
    $scope.list = listJSON;
});

