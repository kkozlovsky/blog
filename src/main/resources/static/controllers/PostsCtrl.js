angular.module('myApp')
	.controller('PostsCtrl', ['$scope', 'PostService',	function ($scope, PostService) {

		$scope.posts = {};

		$scope.init = function() {
			$scope.getPostList();
		};

		$scope.getPostList = function () {
			PostService.getPosts().then(function (postListResponse) {
				$scope.posts = postListResponse;
			})
		};

		$scope.init();

	}]);