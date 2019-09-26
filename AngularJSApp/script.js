var app = angular.module('main', ['ngRoute']);

app.config(function($routeProvider) {
	$routeProvider.when('/', {
		templateUrl: './components/home.html',
		controller: 'homeCtrl'
	}).when('/test', {
		templateUrl: './components/test.html',
		controller: 'testCtrl'
	}).otherwise({
		template: '404'
	})
});


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
			  method: 'GET'
			})
		  
			console.log(response)
		  })()
	}	
})
