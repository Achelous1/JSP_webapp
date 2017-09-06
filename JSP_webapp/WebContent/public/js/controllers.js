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
});

//review board control
app.controller('reviewsCtrl', ['$scope', '$window', '$http',  function ($scope, $http, $window) {
    //moveTo('search.bctrl?page=index.html#!/reviews');
    // $scope.getListFromServer = function(){
    //     $http({
    //         method : 'GET',
    //         url : '/JSP_webapp/reviews.bctrl'
    //     }).success(function(data, status, headers, config) {
    //             $scope.list = data;
    //     }).error(function(data, status, headers, config) {
    //             // called asynchronously if an error occurs
    //             // or server returns response with an error status.
    //     });
    // };
	console.log(boardList);
	$scope.list = boardList;
	console.log($scope.list);
}]);

//write board control
app.controller('writeCtrl', function ($scope, $http) {
});

//sign up control
app.controller('signupCtrl', function ($scope, $http) {

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

