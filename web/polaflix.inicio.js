angular.module('polaflix',['ngRoute']).controller('InicioController',['$scope', '$http',
		function($scope, $http){
			$scope.usuario = 'bartolo';
			$scope.pendientes = [];
			$scope.terminadas = [];
			$scope.empezadas = [];
			$http.get('http://localhost:8080/usuarios/'+$scope.usuario).then(
				function(response) {
					$scope.pendientes = response.data.seriesPendientes;
					$scope.terminadas = response.data.seriesTerminadas;
					$scope.empezadas = response.data.seriesEmpezadas;
					$scope.dataLoaded = true;
				},
				function(response) {
					$scope.dataLoaded = false;
				}
			);
		}
	]);