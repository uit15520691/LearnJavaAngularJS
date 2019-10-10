
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
    ];
    $scope.newTodo = {
        title: "",
        detail: "",
    };
    $scope.isAdding = false;
    $scope.isUpdating = false;
    $scope.selectedTodo = {
        title:"",
        detail:""
    };
    $scope.selectedIndex = null;
    $scope.chooseTodo = function(index){
        $scope.selectedTodo.title = $scope.todoList[index].title.concat();
        $scope.selectedTodo.detail = $scope.todoList[index].detail.concat();
        $scope.selectedIndex = index;
    }
    $scope.addTodo = function(){
        var newTitle = $scope.newTodo.title;
        var newDetail = $scope.newTodo.detail;
        
        $scope.todoList.push({
            title : newTitle,
            detail: newDetail
        });
        $scope.isAdding = !$scope.isAdding;
        $scope.newTodo = {
        }
    }
    $scope.cancelUpdate = function(){
        $scope.isUpdating = !$scope.isUpdating;
        var index = $scope.selectedIndex;
        $scope.selectedTodo.title = $scope.todoList[index].title.concat();
        $scope.selectedTodo.detail = $scope.todoList[index].detail.concat();

    }
    $scope.cancelAdd = function(){
        $scope.isAdding = !$scope.isAdding;
        $scope.newTodo = {
            title: "",
            detail: "",
        };
    }
    $scope.showAddForm = function(){
        $scope.isAdding = !$scope.isAdding;
    }
    $scope.showUpdateForm = function(){
        $scope.isUpdating = true;
    }
    $scope.delete = function(index){
        console.log($scope.selectedIndex );
        if($scope.selectedIndex != null){
            $scope.todoList.splice($scope.selectedIndex,1);
            $scope.selectedIndex = null;
            $scope.selectedTodo = {
                title:"",
                detail:""
            }
        }
    }
    $scope.ok = function(){
        $scope.todoList[$scope.selectedIndex].title = $scope.selectedTodo.title;
        $scope.todoList[$scope.selectedIndex].detail = $scope.selectedTodo.detail;
        $scope.isUpdating = false;
    }
}])

.directive("homeWork",function(){
    
    return {
        restrict :"E",
        templateUrl: "../views/homeWork.html"
    }
})

.directive("column1", function(){
    return {
        restrict :"E",
        templateUrl:"../views/column1/column1.html"
    }
})

.directive("column2", function(){
    return {
        restrict :"E",
        templateUrl:"../views/column2/column2.html"
    }
})

.directive("content", function(){
    return {
        restrict :"E",
        templateUrl:"../views/content/content.html"
    }
})

.directive("addForm", function(){
    return {
        restrict :"E",
        templateUrl:"../views/addForm/form.html"
    }
})

.directive("updateForm", function(){
    return {
        restrict :"E",
        templateUrl:"../views/updateForm/form.html"
    }
})


.directive("header", function(){
    return {
        restrict :"E",
        templateUrl:"../views/header/header.html"
    }
})