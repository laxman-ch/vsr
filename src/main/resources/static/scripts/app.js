var app = angular.module('app',['ngRoute', 'ui.bootstrap', 'ngTable']);

app.config(function($routeProvider) {
        $routeProvider
        // route for the home page
        .when('/', {
            templateUrl : 'pages/stations.html',
            controller  : 'stations-ctrl',
            activetab:'stations'
        })
        
        .when('/stations', {
            templateUrl : 'pages/stations.html',
            controller  : 'stations-ctrl',
            activetab:'stations'
        })

        // route for the about page
        .when('/departments', {
            templateUrl : 'pages/departments.html',
            controller  : 'departments-ctrl',
            activetab:'departments'
        })
        
        // route for the about page
        .when('/fares', {
            templateUrl : 'pages/fares.html',
            controller  : 'fares-ctrl',
            activetab:'fares'
        })
        
        .when('/invoices', {
            templateUrl : 'pages/invoices.html',
            controller  : 'invoices-ctrl',
            activetab:'invoices'
        })
});
