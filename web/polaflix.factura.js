angular.module('polaflix').controller('FacturaController', ['$scope', '$http',
		function($scope, $http){
			$scope.usuario = 'bartolo';
			$scope.facturas = [];
			$scope.dataLoaded = false;
			$scope.cuota = 0;
			$scope.total = 0;
			$scope.meses = ['Enero','Febrero','Marzo','Abril','Mayo','Junio','Julio','Agosto','Septiembre','Octubre','Noviembre','Diciembre'];
			var d = new Date();
			$scope.mesActual = d.getMonth();
			$scope.yrActual = d.getFullYear();
			$scope.facturaActual;
			$http.get('http://localhost:8080/usuarios/'+$scope.usuario+'/facturas').then(
				function(response) {
					$scope.facturas = response.data;
					if(typeof $scope.facturas !== "undefined"){
						$scope.facturaActual = $scope.facturas.find(f => (f.mes-1) === $scope.mesActual && f.year === $scope.yrActual);
						if(typeof $scope.facturaActual !== "undefined"){
							$scope.total = $scope.facturaActual.episodios.reduce((a,b) => a+b.precio, 0);
						}
					}
					$scope.dataLoaded = true;
				},
				function(response) {
					$scope.dataLoaded = false;
				}
			);

			$http.get('http://localhost:8080/usuarios/'+$scope.usuario).then(
				function(response) {
					$scope.cuota = response.data.cuota;
					if ($scope.cuota > 0) {
						$scope.total = $scope.cuota
					}
				},
				function(response) {}
			);

			this.formatNumber = function(n){
			    return n > 9 ? "" + n: "0" + n;
			}

			this.formatFloat = function(n){
				return parseFloat(n).toFixed(2);
			}

			this.nextMonth = function(){
				$scope.mesActual++;
				if ($scope.mesActual > 11){
					$scope.mesActual = 0;
					$scope.yrActual++;
				}
				this.setFacturaActual();
			}

			this.previousMonth = function(){
				$scope.mesActual--;
				if($scope.mesActual < 0){
					$scope.mesActual = 11;
					$scope.yrActual--;
				}
				this.setFacturaActual();
			}

			this.setFacturaActual = function(){
				if(typeof $scope.facturas !== "undefined"){
					$scope.facturaActual = $scope.facturas.find(f => (f.mes-1) === $scope.mesActual && f.year === $scope.yrActual);
					if(typeof $scope.facturaActual !== "undefined" && $scope.cuota == 0){
						$scope.total = $scope.facturaActual.episodios.reduce((a,b) => a+b.precio, 0);
					} else if ($scope.cuota == 0){
						$scope.total = 0;
					}
				}
			}

			this.hayFactura = function() {
				return typeof $scope.facturaActual !== "undefined";
			}
		}]);