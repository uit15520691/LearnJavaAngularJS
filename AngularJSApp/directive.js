angular.module("DirectiveModule",[])

.directive('contentPage', function() {
    return {
      restrict: 'E',
      templateUrl: './views/homeWork/content/contentPage.html'
    };
});