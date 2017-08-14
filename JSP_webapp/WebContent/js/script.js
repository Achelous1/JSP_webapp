var app = angular.module("layout", ["ngRoute"]);
app.config(function($routeProvider) {
    $routeProvider
    .when("/", {
        templateUrl : "route/main.html"
    })
    .when("/myMatchList", {
        templateUrl : "route/myMatchList.html"
    })
    .when("/recommendations", {
        templateUrl : "route/recommendations.html"
    })
    .when("/reviews", {
        templateUrl : "route/reviews.html"
    })
    .when("/myPage", {
        templateUrl : "route/mypage.html"
    })
    .when("/myMatchList", {
        templateUrl : "route/myMatchList.html"
    })
    .when("/signup", {
        templateUrl : "route/signup.html"
    })
    otherwise({
        redirectTo : "route/main.html:"
    });
});
