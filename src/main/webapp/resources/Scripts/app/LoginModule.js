// Register login module
var loginApp = angular.module('loginApp', []);
var rootContext = '/eem';

// Login Factory
loginApp.factory('loginFactory', [ '$http', '$q', function($http, $q) {
	return {

		apiPath : rootContext + '/api/usermgmt/login',

		doLogin : function(loginModel) {
			var deferred = $q.defer();
			// Post request to login
			$http.post(this.apiPath, loginModel).success(function(data) {
				// Passing data to deferred's resolve function on successful
				// completion
				deferred.resolve(data);
			}).error(function(ex) {
				console.log(ex);
				// Sending a friendly error message in case of failure
				deferred.reject("Some error occured while login.");
			});
			// Returning the promise object
			return deferred.promise;
		}
	};
} ]);

// Login Controller
loginApp.controller('loginCtrl', [ '$scope', '$window', 'loginFactory',
		function($scope, $window, loginFactory) {
			$scope.model = {
				userId : '',
				password : ''
			};

			$scope.errors = [];
			$scope.isError = false;
			$scope.messages = {};

			$scope.login = function() {
				var model = $scope.model;
				if (validate(model)) {
					doLogin(model);
				}
			};

			$scope.changePassword = function() {
				doRedirectTo("/changepwd");
			};

			$scope.$watchCollection('errors', function(newValues) {
				$scope.isError = ($scope.errors.length > 0);
			});

			function validate(loginModel) {
				return true;
			}

			function doLogin(loginModel) {
				loginFactory.doLogin(loginModel).then(
				// Resolved
				function(data) {
					console.log(data);
					if (data.success == true && data.model) {
						var redirectTo = data.model.redirectTo;
						if (redirectTo != '') {
							doRedirectTo(redirectTo);
						}
					} else if (data.errors && data.errors.length > 0) {
						console.log(data);
						console.log(data.errors);
						$scope.errors = data.errors;
					}
				},
				// Rejected
				function(ex) {
					console.log(ex);
				});
			}

			function doRedirectTo(redirectTo) {
				if (redirectTo.indexOf("/") != 0) {
					redirectTo = "/" + redirectTo;
				}
				window.location = rootContext + redirectTo;
			}
		} ]);