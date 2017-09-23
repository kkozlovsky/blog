angular.module('myApp')
	.controller('UserCtrl', ['$scope', 'UserService', '$stateParams', function ($scope, UserService, $stateParams) {

		$scope.user = {};
		
		$scope.id = $stateParams.id;

		$scope.init = function() {
			$scope.getUserById($scope.id);
		};
		
		$scope.getUserById = function (id) {
			UserService.getUserById(id).then(function (userResponse) {
				$scope.user = userResponse;
			})
		};

		$scope.init();
		
	}]);