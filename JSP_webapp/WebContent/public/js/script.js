//routing function
var app = angular.module('layout', ['ngRoute']);
app.config(function($routeProvider/*, $locationProvider, $httpProvider*/){
  $routeProvider
  //route to main page
  .when('/', {
      templateUrl: './public/route/main.html',
      controller: 'mainCtrl'
  })
  //route to matching list
  .when('/myMatchList.cbs', {
      templateUrl: './public/route/myMatchList.html',
      controller : 'matchListCtrl'
  })
  //route to chatting room
  .when('/myMatchList.cbs/talkStranger', {
      templateUrl: './public/route/talkStranger.html',
      controller : 'chatCtrl'
  })
  //route to recommendations board
  .when('/recommendations.bctrl', {
      templateUrl: './public/route/recommendations.html',
      controller : 'recommendationCtrl'
  })
  //route to reviews board
  .when('/reviews.bctrl', {
      templateUrl: './public/route/reviews.html',
      controller : 'reviewsCtrl'
  })
  //route to sign up page
  .when('/signup', {
      templateUrl: './public/route/signup.html',
      controller : 'signupCtrl'
  })
  //route to board write page
  .when('/boardWrite.bctrl', {
      templateUrl: './public/route/boardWrite.html',
      controller : 'writeCtrl'
  })
  //route to my page
  .when('/myPage', {
      templateUrl: './public/route/myPage.html',
      controller : 'myPageCtrl'
  })
  //route to board content page
  .when('/viewBoard', {
      templateUrl: './public/route/viewBoard.html',
      controller : 'viewContentsCtrl'
  })
  //route back to main otherwise
  .otherwise({
    redirectTo: '/'
  });
/*  $locationProvider.html5Mode(true);
*/});

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

//cancel button
function moveTo(url){
    window.location.assign(url);
}

//alert modal
var modalInstance = $modal.open({
    controller: ModalInstanceCtrl,
    backdrop: true,
    keyboard: true,
    backdropClick: true,
    size: 'lg',
    resolve: {
      data: function () {
        return $scope.data;
      }
    }
  });
