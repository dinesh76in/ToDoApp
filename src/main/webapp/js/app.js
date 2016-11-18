var module = angular.module('todoApp', []);
module.service('ToDoService', function ($http) {
    
    this.save = function (todo) {

        console.log("Saving new todo");
        $http.put('http://localhost:8080/todo/rest/todo/'+todo).success(function() {
            
        });
    }

    this.get = function (id) {
        $http.get('http://localhost:8080/todo/rest/todo/'+id).success(function(data) {
            return data;
        });
    }
    
    this.delete = function (id) {
        $http.delete('http://localhost:8080/todo/rest/todo/'+id).success(function() {
            
        });
    }

    this.list = function () {
          $http.get('http://localhost:8080/todo/rest/todo').success(function(data) {
           console.log(" todos"+data);
           
        });
        return data;
    }


});

module.controller('ToDoController', function ($scope, ToDoService,$http) {
  
     $http.get('http://localhost:8080/todo/rest/todo').success(function(data) {
           $scope.todos= data;
        });
    
    $scope.save = function () {
        ToDoService.save($scope.title);
        
        $http.get('http://localhost:8080/todo/rest/todo').success(function(data) {
           $scope.todos= data;
        });

    }

    $scope.delete = function (id) {
        ToDoService.delete(id);
        if ($scope.newtodo.id == id) $scope.newtodo = {};
    }

    $scope.edit = function (id) {
        $scope.newtodo = angular.copy(ToDoService.get(id));
    }
})