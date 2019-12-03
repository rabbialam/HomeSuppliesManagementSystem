var app = angular.module('app', ['ngRoute','ngResource']);
app.config(function($routeProvider){
debugger;
    $routeProvider
        .when('/list',{
            templateURL: 'List/list.html',
            controller: 'ItemsController'
        })
        .when('/roles',{
            templateUrl: '/views/roles.html',
            controller: 'rolesController'
        })
        .otherwise(
            { redirectTo: '/'}
        );
});