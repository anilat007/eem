var roleModulesApp = angular.module('roleModulesApp', []);
var rootContext = '/eem';

roleModulesApp.factory('roleModulesFactory', [ '$http', '$q',
		function($http, $q) {
			return {
				apiPath : rootContext + '/api/rolemodules/modules',
				getModules : function() {
					var deferred = $q.defer();
					$http.get(this.apiPath).success(function(data) {
						deferred.resolve(data);
					}).error(function(ex) {
						console.log(ex);
						deferred.reject("Some error occured while login.");
					});
					return deferred.promise;
				}
			};
		} ]);

roleModulesApp.controller('roleModulesCtrl', [ '$scope', '$window',
		'roleModulesFactory', function($scope, $window, roleModulesFactory) {
			$scope.modules = [];

			getModules();

			function getModules() {
				roleModulesFactory.getModules().then(
				// Resolved
				function(data) {
					console.log(data);
					if (data.success == true) {
						$scope.modules = data.model;
					} else if (data.errors && data.errors.length > 0) {
						console.log(data);
						console.log(data.errors);
					}
				},
				// Rejected
				function(ex) {
					console.log(ex);
				});
			}
		} ]);