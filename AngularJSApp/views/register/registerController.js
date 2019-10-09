
angular.module('RegisterControllerModule',[])

.controller('RegisterController',['$scope', function($scope){
    $scope.register = function(){
        var data = {
            'name': $scope.name,
            'email': $scope.email,
            'password': $scope.password,
            'country': $scope.nationality,
            'age': $scope.age,
            'subsribed': $scope.subscribe,
            'sdt': $scope.sdt
        }
        console.log(data);
        axios.post('http://localhost:8080/register',data)
            .then((response)=>{
                console.log(response)
        })
    }
}])