angular.module('myApp', [
	'ui.router',
	'ngSanitize'
]).config(['$stateProvider', '$urlRouterProvider', '$locationProvider', '$httpProvider',
	function($stateProvider, $urlRouterProvider, $locationProvider, $httpProvider){

	$locationProvider.html5Mode({enabled: true, requireBase: false});
	
	$stateProvider
		.state('main', {
			url: '/',
			templateUrl: 'index.html',
			controller: 'MainCtrl',
			title: "Главная"
		})
		.state('users', {
			url: '/users',
			templateUrl: 'templates/users.html',
			controller: 'UsersCtrl',
		})
		.state('user', {
			url: '/users/:id',
			templateUrl: 'templates/user.html',
			controller: 'UserCtrl',
		})
		.state('posts', {
			url: '/posts',
			templateUrl: 'templates/posts.html',
			controller: 'PostsCtrl',
		})
		.state('post', {
			url: '/posts/:id',
			templateUrl: 'templates/post.html',
			controller: 'PostCtrl',
		})
		.state('404', {
			url: '/404',
			templateUrl: 'templates/404.html'
		})
	;
	$urlRouterProvider.otherwise('/404');
}]);