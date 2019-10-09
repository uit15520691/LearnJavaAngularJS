
angular.module('loginControllerModule',[])

.controller('LoginController',['$scope', function($scope,$location){
	$scope.isloggedIn = false;

	$scope.toRegisterPage = function(){
		$location.path('/register');
	},
	$scope.login = function(){
		var userData = {
			"email": $scope.email,
			"password":$scope.password
		}
		axios.post('http://localhost:8080/login',userData)
			.then((response)=>{
				if (response.data['Succeeded']){
					$scope.isloggedIn = true;
				}
				console.log($scope.isloggedIn)
		})
	}
}]);
    