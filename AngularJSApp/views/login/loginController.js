
angular.module('loginControllerModule',[])

.controller('LoginController',['$scope', function($scope,$location){
    $scope.email = "abc@gmail";

    $scope.$watch("email", function() {
        console.log($scope.email);
    });

    $scope.login = function(){
		(async () => {
			var userData = {
				"email": $scope.email,
				"password":$scope.password
			}
			var response = await axios({
				method: 'POST',
			  	url: 'http://localhost:8080/login',
			  	headers: {
					'Content-Type': 'application/json'
				},
				data: userData
			})
			console.log(response);
		  })()
    };
    
	$scope.toRegisterPage = function(){
		$location.path('/register');
	}
    }]
);