app.controller('task-ctrl', function($scope, $http, $filter, ngTableParams, appServices) {
	
	$scope.searchKeyword = "";
	$scope.getList = function(callback) {
		$http({
			method: 'GET',
			url: '/tasks'
		}).then(function(response) {
			if(typeof response.data._embedded != 'undefined') {
				$scope.tasks = response.data._embedded.tasks;
			}
			else {
				$scope.tasks = [];
			}
			callback.call(this);
		}, function(response) {

		});
	};
	
	
	$scope.deleteItem = function(link) {
		var r = confirm("Are you sure you want to delete?")
		
		if(!r) {return}
		
		$http({
			method: 'DELETE',
			url: link
		}).then(function(response) {
			$scope.getList($scope.initTable);
		}, function(response) {

		});
	};
	
	$scope.initTable = function() {
		$scope.tableParams = new ngTableParams({
			page: 1,
			count: 10,
			sorting: {
				"stationName": "asc"
			}
		}, {
			counts:[],
			getData: function($defer, params) {
				appServices.tablePagination($defer, $filter, params, $scope.tasks, $scope.searchKeyword);
				
			}
		});
	}
	
	$scope.init = function() {
		$scope.getList($scope.initTable);
	}
	
	$scope.init();

})