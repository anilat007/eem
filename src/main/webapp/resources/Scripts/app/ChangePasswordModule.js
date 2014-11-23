// Register Appointments module
var app = angular.module('changePwdApp', []);
var rootContext = '/eem';

// DMS Appointment Factory
app.factory('changePwdFactory', [ '$http', '$q', function($http, $q) {
	return {
		apiPath : rootContext + '/api/usermgmt/changepwd',

		doChangePassword : function(model) {
			var deferred = $q.defer();
			// Get request to fetch appointments
			$http.post(this.apiPath, model).success(function(data) {
				// Passing data to deferred's resolve function on successful
				// completion
				deferred.resolve(data);
			}).error(function(ex) {
				console.log(ex);
				// Sending a friendly error message in case of failure
				deferred.reject("Some error occured while changing password.");
			});
			// Returning the promise object
			return deferred.promise;
		}
	};
} ]);

// ChangePwd Controller
app.controller('changePwdCtrl', [ '$scope', '$window', 'changePwdFactory',
		function($scope, $window, changePwdFactory) {
			$scope.model = {
				userId : '',
				password : '',
				newPassword : '',
				confirmPassword : ''
			};

			$scope.errors = [];
			$scope.isError = false;
			$scope.messages = {};

			$scope.changePassword = function() {
				var model = $scope.model;
				if (validate(model)) {
					changePwd(model);
				}
			};

			$scope.backTologin = function() {
				doRedirectTo("/login");
			};

			$scope.$watchCollection('errors', function(newValues) {
				$scope.isError = ($scope.errors.length > 0);
			});

			function validate(model) {
				return true;
			}

			function changePwd(model) {
				changePwdFactory.doChangePassword(model).then(
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