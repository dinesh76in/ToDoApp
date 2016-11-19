var module = angular.module('todoApp', []);
module.constant('baseURL', 'http://localhost:8080/todo/rest/todo/');
module.service('ToDoService', ['$http', 'baseURL', function($http, baseURL) {

    this.save = function(todo) {
        $http.post(baseURL + todo).success(function() {
        });
    }

    this.get = function(id) {
        $http.get(baseURL + id).success(function(data) {
            return data;
        });
    }

    this.delete = function(id) {
        $http.delete(baseURL + id).success(function() {
        });
    }

}]);

module.controller('ToDoController', ['$scope', 'ToDoService', '$http', '$window', 'baseURL', function($scope, ToDoService, $http, $window, baseURL) {

    $scope.selected = {};

    $http.get(baseURL).success(function(data) {
        $scope.todos = data;
    });

    $scope.save = function() {
        ToDoService.save($scope.title);
        $http.get(baseURL).success(function(data) {
            $scope.todos = data;
        });
    }

    $scope.update = function(id, status,priority) {
        $http.put(baseURL + id + '/' + status+'/'+priority).success(function(data) {
            $http.get(baseURL).success(function(data) {
                $scope.todos = data;
            });
        });
        $scope.mode = '';
    }

    $scope.delete = function(id) {
        ToDoService.delete(id);
        $window.location.reload();
    }

    $scope.edit = function(todo) {
        $scope.mode = 'edit';
        $scope.selected = angular.copy(todo);
    }

    $scope.cancel = function() {
        $scope.mode = '';
    }

}])