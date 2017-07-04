angular.
  module('polaflix').
    config(['$locationProvider','$routeProvider',
      function config($locationProvider,$routeProvider) {
        $locationProvider.hashPrefix('!');

        $routeProvider.
          when('/',{
            templateUrl: 'content/inicio.html'
          }).
          when('/buscar_serie',{
            templateUrl: 'content/buscar_serie.html'
          }).
          when('/ver_facturas',{
            templateUrl: 'content/ver_facturas.html'
          }).
          when('/visualizar_temporada',{
            templateUrl: 'content/visualizar_temporada.html'
          }).
          otherwise({
            template : '<p> Ruta no disponible </p>'
          });
      }
    ]);