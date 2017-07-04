angular.module('polaflix').
	controller('SeriesController',['$scope','$http',
         function($scope,$http){
         	$scope.series = [];
         	$scope.usuario = 'bartolo';
         	$scope.dataLoaded = false;
         	$scope.initial = '';
         	$scope.searchText = "";
         	$scope.popup = false;
         	$scope.directores = [];
         	$scope.actores = [];
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

	        this.busqueda = function() {
	        	return function(item) {
	        		var output = true;
	        		if ($scope.searchText.length > 0) {
	        			output = item.titulo.toLowerCase().indexOf($scope.searchText.toLowerCase()) > -1;
	        		}
	        		return output;
	          };
	        }

	        this.closePopup = function(){
				$scope.popup = false;
			}

			this.verDescripcion = function(serie){
				$scope.currentSerie = serie;
				this.getArtistas(serie);
				$scope.popup = true;
			}

			this.getArtistas = function(serie) {
				$scope.directores = [];
				$scope.actores = [];
				for (artista in serie.artistas) {
					if(serie.artistas[artista].class === "es.unican.polaflix.domain.Creador"){
						$scope.directores.push(serie.artistas[artista]);
					} else {
						$scope.actores.push(serie.artistas[artista]);
					}
				}
			}
    	}
    ]);