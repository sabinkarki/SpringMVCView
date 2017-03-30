'use strict'

var app=angular.module('myApp',['ngRoute']);

app.config(['$routeProvider', function($routeProvider){
	when('/', {
		templateUrl : 'home.jsp',
		controller : ''
	}).
	when('/angular', {
		templateUrl : '/angularPage.jsp',
		controller : 'ReportCtrl'
	}).
	otherwise({
		redirectTo : '/'
	})
}]);

app.Controller('')