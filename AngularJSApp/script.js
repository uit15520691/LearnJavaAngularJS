var app = angular.module('main', ['ngRoute','loginControllerModule']);

app.config(function($routeProvider) {
	$routeProvider.when('/', {
		templateUrl: './views/home/home.html',
		controller: 'homeCtrl'
	}).when('/login', {
		templateUrl: './views/login/login.html',
		controller: 'LoginController'
	}).when('/register', {
		templateUrl: './views/register/register.html',
		controller: 'registerCtrl'
	}).otherwise({
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