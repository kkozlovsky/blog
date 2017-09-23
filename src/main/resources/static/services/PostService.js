angular.module('myApp')
	.service('PostService', ['$http', function ($http) {

		this.getPosts = function () {
			return $http.get('api/posts').then(function (response) {
				console.log(response.data);
				return response.data;
			});
		};

		this.getPostById = function (id) {
			return $http.get('api/posts/' + id).then(function (response) {
				console.log(response.data);
				return response.data;
			});
		};
	}

	]);