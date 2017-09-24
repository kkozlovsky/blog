angular.module('myApp')
	.controller('PostCtrl', ['$scope', 'PostService', '$stateParams', '$sce',	function ($scope, PostService, $stateParams, $sce) {

		$scope.post = {};
		$scope.comments;

		$scope.id = $stateParams.id;

		$scope.init = function() {
			$scope.getPostById($scope.id);
		};

		$scope.getPostById = function (id) {
			PostService.getPostById(id).then(function (postResponse) {
				$scope.post = postResponse;
				$scope.post.htmlContent = $sce.trustAsHtml(postResponse.content);
				$scope.comments = postResponse.comments;
			})
		};

		$scope.init();

	}]);