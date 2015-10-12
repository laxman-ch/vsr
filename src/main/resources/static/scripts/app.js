var app = angular.module('app',['ngRoute', 'ui.bootstrap', 'ngTable']);

app.config(function($routeProvider) {
        $routeProvider
        // route for the home page
        .when('/', {
            templateUrl : 'pages/stations.html',
            controller  : 'station-ctrl',
            activetab:'station'
        })
        
        .when('/station', {
            templateUrl : 'pages/stations.html',
            controller  : 'station-ctrl',
            activetab:'station'
        })

        // route for the about page
        .when('/department', {
            templateUrl : 'pages/departments.html',
            controller  : 'department-ctrl',
            activetab:'department'
        })
        
        // route for the about page
        .when('/tasks', {
            templateUrl : 'pages/tasks.html',
            controller  : 'task-ctrl',
            activetab:'tasks'
        })
        
        .when('/invoices', {
            templateUrl : 'pages/invoice.html',
            controller  : 'invoice-ctrl',
            activetab:'invoices'
        })
});
