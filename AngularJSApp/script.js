// create angular app name "main"
var app = angular.module('main', ['ngRoute','loginControllerModule','RegisterControllerModule','HomeWorkModule',"DirectiveModule"]);

// can be written in a different file 
app.config(function($routeProvider) {
	$routeProvider.when('/', {
		templateUrl: './views/home/home.html',
		controller: 'homeCtrl'
	}).when('/login', {
		templateUrl: './views/login/login.html',
		controller: 'LoginController'
	}).when('/register', {
		templateUrl: './views/register/register.html',
		controller: 'RegisterController'
	}).when('/homework', {
		templateUrl: './views/homework/homeWork.html',
		controller: 'HomeWorkController'
	})
	.otherwise({
		template: '404'
	})
});

app.controller('homeCtrl', function($scope, $location){
	$scope.toLoginPage = function(){
		$location.path('/login');
	};
	$scope.toRegisterPage = function(){
		$location.path('/register');
	};
});