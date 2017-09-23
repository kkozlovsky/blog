angular.module('myApp')
	.controller('UsersCtrl', ['$scope', 'UserService',	function ($scope, UserService) {
	
		$scope.users = {};

		$scope.init = function() {
			$scope.getUserList();
		};
		
		$scope.getUserList = function () {
			UserService.getUsers().then(function (userList) {
				$scope.users = userList;
			})
		};

		$scope.init();
		
	}]);