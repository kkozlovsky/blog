angular.module('myApp')
	.service('UserService', ['$http', function ($http) {
		
		this.getUsers = function () {
			return $http.get('api/users').then(function (response) {
				console.log(response.data);
				return response.data;
			});
		};
		
		this.getUserById = function (id) {
			return $http.get('api/users/' + id).then(function (response) {
				console.log(response.data);
				return response.data;
			});
		};
		
	}
	
	]);