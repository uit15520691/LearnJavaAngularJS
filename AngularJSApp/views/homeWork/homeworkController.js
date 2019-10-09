
angular.module("HomeWorkModule",[])

.controller("HomeWorkController",['$scope',function($scope){
    $scope.todoList = [
        {
            title:"todo #1",
            detail: "this is the detail of todo #1"
        },
        {
            title:"todo #2",
            detail: "this is the detail of todo #2"
        },
        {
            title:"todo #3",
            detail: "this is the detail of todo #3"
        },
        {
            title:"todo #4",
            detail: "this is the detail of todo #4"
        }
    ]
    $scope.newTodo = {
        title: "",
        detail: "asdasd",
    }
    $scope.isAdding = false;
    $scope.selectedTodo = $scope.todoList[0];
    $scope.selectedIndex = 0;
    $scope.chooseTodo = function(index){
        $scope.selectedTodo = $scope.todoList[index];
        $scope.selectedIndex = index;
    }
    $scope.addTodo = function(){
        var newTitle = $scope.newTodo.title;
        var newDetail = $scope.newTodo.detail;
        var index = $scope.todoList.length + 1;
        
        $scope.todoList.push({
            tittle : newTitle,
            detail: newDetail
        });
        $scope.newTodo = {
        }
    }
    $scope.cancel = function(){
        $scope.isAdding = !$scope.isAdding;
        $scope.newTodo = {
        }
        console.log($scope.isAdding);
        console.log($scope.todoList);
        console.log($scope.todoList.length);
    }
    $scope.showAddForm = function(){
        $scope.isAdding = !$scope.isAdding;
        console.log($scope.isAdding);
    }
    $scope.delete = function(index){
        $scope.todoList.splice($scope.selectedIndex,1);
        $scope.selectedIndex = "";
        $scope.selectedTodo = "";
    }
}])
.provider
