var app = angular.module('main', ['ngRoute']);

headerCfg = {
	'Access-Control-Allow-Origin': '*',
	'Content-Type': 'application/json'
	};

app.config(function($routeProvider) {
	$routeProvider.when('/', {
		templateUrl: './components/home/home.html',
		controller: 'homeCtrl'
	}).when('/login', {
		templateUrl: './components/login/login.html',
		controller: 'loginCtrl'
	})	.when('/test', {
		templateUrl: './components/test.html',
		controller: 'testCtrl'
	}).otherwise({
		template: '404'
	})
});

app.service('userServices',function(){
	var username;
	var isLoggedIn ;
	var id;
	
	this.setIsLoggedIn = function(loggedIn){
		isLoggedIn = loggedIn;
	}
	this.getIsLoggedIn = function(){
		return isLoggedIn ;
	}
})

app.controller('testCtrl', function($scope, $location) {
	$scope.goToLogin = function() {
		$location.path('/login');
	};
	$scope.regiser = function() {
		$location.path('/register');
	};

	$scope.test = function(){
		(async () => {
			const response = await axios({
			  url: 'http://localhost:8080/users',
			  headers: {
				'Access-Control-Allow-Origin': '*',
				'Content-Type': 'application/json'
				},
			  method: 'GET'
			})
		  
			console.log(response)
		  })()
	}	
});

app.controller('homeCtrl', function($scope, $location){
	$scope.toLoginPage = function(){
		$location.path('/login');
	};
	$scope.toRegisterPage = function(){
		$location.path('/register');
	};
	$scope.test = function(){
		(async () => {
			const response = await axios({
			  url: 'http://localhost:8080/users',
			  headers: {
				'Access-Control-Allow-Origin': '*',
				'Content-Type': 'application/json'
				},
			  method: 'GET'
			})
		  
			console.log(response)
		  })()
	}	
});

app.controller('loginCtrl', function($scope, $location){
	$scope.login = function(){
		
		(async () => {
			var response = await axios({
				method: 'POST',
			  	URL: 'http://localhost:8080/login',
			  	headers: {
					'Access-Control-Allow-Origin': '*',
					'Content-Type': 'application/json'
				},
				data: {
					"email": "quang@gmail.com",
					"password": "123456"
				}
			})
			console.log(response);
		  })()
	};
	$scope.toRegisterPage = function(){
		$location.path('/register');
	}
})
