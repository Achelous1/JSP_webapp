var app = angular.module('layout', ['ngRoute']);
app.config(function($routeProvider/*, $locationProvider, $httpProvider*/){

  $routeProvider
  .when('/', {
      templateUrl: './public/route/main.html'
  })
  .when('/myMatchList', {
      templateUrl: './public/route/myMatchList.html'
  })
  .when('/myMatchList/:talkStranger', {
      templateUrl: './public/route/talkStranger.html'
  })
  .when('/recommendations', {
      templateUrl: './public/route/recommendations.html'
  })
  .when('/reviews', {
      templateUrl: './public/route/reviews.html'
  })
  .when('/signup', {
      templateUrl: './public/route/signup.html'
  })
  .when('/boardWrite', {
      templateUrl: './public/route/boardWrite.html'
  })
  .when('/myPage', {
      templateUrl: './public/route/myPage.html'
  })
  .otherwise({
    redirectTo: '/'
  });
  //$locationProvider.html5Mode(true);
});