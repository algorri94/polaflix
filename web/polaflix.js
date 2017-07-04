angular.module('polaflix',['ngRoute']).
	controller('SeriesController',['$scope','$http',
         function($scope,$http){
         	$scope.series = [];
         	$scope.usuario = 'bartolo';
         	$scope.dataLoaded = false;
         	$scope.initial = '';
         	$scope.initials =
			    [ { 'initial':'A', 'id':'a', 'active':false},
			      { 'initial':'B', 'id':'b', 'active':false},
			      { 'initial':'C', 'id':'c', 'active':false},
			      { 'initial':'D', 'id':'d', 'active':false},
			      { 'initial':'E', 'id':'e', 'active':false},
			      { 'initial':'F', 'id':'f', 'active':false},
			      { 'initial':'G', 'id':'g', 'active':false},
			      { 'initial':'H', 'id':'h', 'active':false},
			      { 'initial':'I', 'id':'i', 'active':false},
			      { 'initial':'J', 'id':'j', 'active':false},
			      { 'initial':'K', 'id':'k', 'active':false},
			      { 'initial':'L', 'id':'l', 'active':false},
			      { 'initial':'M', 'id':'m', 'active':false},
			      { 'initial':'N', 'id':'n', 'active':false},
			      { 'initial':'O', 'id':'o', 'active':false},
			      { 'initial':'P', 'id':'p', 'active':false},
			      { 'initial':'Q', 'id':'q', 'active':false},
			      { 'initial':'R', 'id':'r', 'active':false},
			      { 'initial':'S', 'id':'s', 'active':false},
			      { 'initial':'T', 'id':'t', 'active':false},
			      { 'initial':'U', 'id':'u', 'active':false},
			      { 'initial':'V', 'id':'v', 'active':false},
			      { 'initial':'W', 'id':'w', 'active':false},
			      { 'initial':'X', 'id':'x', 'active':false},
			      { 'initial':'Y', 'id':'y', 'active':false},
			      { 'initial':'Z', 'id':'z', 'active':false},
			      { 'initial':'0-9', 'id':'number', 'active':false}
			    ];
         	$http.get('http://localhost:8080/series').then(
				function(response) {
					$scope.series = response.data;
					$scope.dataLoaded = true;
				},
				function(response) {
					$scope.dataLoaded = false;
				}
			);

			this.hasInitial = function() {
	          return function(item) {
	          	var output = true;
	          	if($scope.initial != ''){
	          		if($scope.initial == 'number'){
	          			output = item.titulo.match(/^\d/)
	          		} else {
	          			output = item.titulo.toLowerCase().startsWith($scope.initial);
	          		}
	          	}
	            return output;
	          };
	        };

	        this.onInitialClicked = function(initial) {
	        	console.log(initial);
	          if($scope.initial === initial){
	          	$scope.initial = '';
	          	for (var i = 0; i < $scope.initials.length; ++i) {
				    if ($scope.initials[i]['id'] === initial) {
				        $scope.initials[i]['active'] = false;
				    }
				}
	          } else {
	          	$scope.initial = initial;
	          	for (var i = 0; i < $scope.initials.length; ++i) {
				    if ($scope.initials[i]['active']) {
				        $scope.initials[i]['active'] = false;
				    } else if ($scope.initials[i]['id'] === initial) {
				        $scope.initials[i]['active'] = true;
				    }
				}
	          }
	        };

	        this.addPendiente = function(usuario, serie){
	        	$http.post('http://localhost:8080/usuarios/'+usuario+'/pendientes/'+serie).then(
					function(response){
						console.log('Serie añadida correctamente.');
					},
					function(response){
						//do nothing
					}
				);
	        }
    	}
    ]).controller('InicioController',['$scope', '$http',
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
	]).controller('TempController', ['$scope', '$http',
		function($scope, $http){
			$scope.usuario = 'bartolo';
			$scope.serie_id = getParameterByName("id");
			$scope.serie = [];
			$scope.epVisualizados = [];
			$scope.tempActual = [];
			$scope.showModal = false;
			$scope.popup = false;
			$scope.currentEpisode = "";
			$scope.dataLoaded2 = false;

			$http.get('http://localhost:8080/series/'+$scope.serie_id).then(
				function(response) {
					$scope.serie = response.data;
					$scope.tempActual = $scope.serie.temporadas.find(x => x.numTemporada === 1);
					$scope.dataLoaded = true;
				},
				function(response) {
					$scope.dataLoaded = false;
				}
			);

			$http.get('http://localhost:8080/usuarios/'+$scope.usuario+'/empezadas/'+$scope.serie_id).then(
				function(response) {
					$scope.epVisualizados = response.data;
					console.log($scope.epVisualizados);
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
				return typeof $scope.epVisualizados.episodiosVisualizados.find(x => x.id === episodeID) !== "undefined";
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

			this.closePopup = function(){
				$scope.popup = false;
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