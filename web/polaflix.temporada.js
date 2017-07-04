angular.module('polaflix').controller('TempController', ['$scope', '$http', '$route', '$templateCache',
		function($scope, $http, $route, $templateCache){
			$scope.usuario = 'bartolo';
			$scope.serie_id = getParameterByName("id");
			$scope.serie = [];
			$scope.epVisualizados = [];
			$scope.tempActual = [];
			$scope.showModal = false;
			$scope.popup = false;
			$scope.desc = false;
			$scope.currentEpisode = "";
			$scope.dataLoaded2 = false;

			$http.get('http://localhost:8080/series/'+$scope.serie_id).then(
				function(response) {
					$scope.serie = response.data;
					$scope.tempActual = $scope.serie.temporadas.find(x => x.numTemporada === 1);
					$scope.tipoSerie = $scope.serie.tipoSerie.tipo;
					$scope.dataLoaded = true;
				},
				function(response) {
					$scope.dataLoaded = false;
				}
			);

			$http.get('http://localhost:8080/usuarios/'+$scope.usuario+'/empezadas/'+$scope.serie_id).then(
				function(response) {
					$scope.epVisualizados = response.data;
					$scope.dataLoaded2 = true;
				},
				function(response) {
					$scope.dataLoaded2 = false;
				}
			);

			this.changeSeason = function(temp){
				var tmp = $scope.serie.temporadas.find(x => x.numTemporada === temp);
				if(typeof tmp !== "undefined" && tmp.episodios.length > 0) {
					$scope.tempActual = tmp;
				}
			}

			this.episodeSeen = function(episodeID){
				if (typeof $scope.epVisualizados.episodiosVisualizados !== "undefined")
					return typeof $scope.epVisualizados.episodiosVisualizados.find(x => x.id === episodeID) !== "undefined";
				return false;
			}

			this.formatNumber = function(n){
			    return n > 9 ? "" + n: "0" + n;
			}

			this.verEpisodio = function(numEpisodio, titulo){
				$scope.currentEpisode = "E"+this.formatNumber(numEpisodio)+". "+titulo;
				var url = 'http://localhost:8080/usuarios/'+$scope.usuario+'/empezadas/'+$scope.serie_id+
					'?episodio='+numEpisodio+'&temporada='+$scope.tempActual.numTemporada;
				$http.post(url).then(
					function(response){
						console.log('Episodio añadido correctamente');
					},
					function(response){
						//do nothing
					}
				);
				$scope.popup = true;
			}

			this.verDescripcion = function(serie){
				$scope.currentEpisode = "E"+this.formatNumber(serie.numEpisodio)+". "+serie.titulo;
				$scope.currentDesc = serie.descripcion;
				$scope.desc = true;
			}

			this.closePopup = function(){
				$scope.popup = false;
				var currentPageTemplate = $route.current.templateUrl;
				$templateCache.remove(currentPageTemplate);
				$route.reload();
			}

			this.closeDesc = function(){
				$scope.desc = false;
			}
		}
	]);
var getParameterByName = function(name) {
	url = window.location.href;
	name = name.replace(/[\[\]]/g, "\\$&");
	var regex = new RegExp("[?&]" + name + "(=([^&#]*)|&|#|$)"),
	results = regex.exec(url);
	if (!results) return null;
	if (!results[2]) return '';
	return decodeURIComponent(results[2].replace(/\+/g, " "));
}