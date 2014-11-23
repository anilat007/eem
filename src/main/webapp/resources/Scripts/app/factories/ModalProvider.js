require(['i18n', 'bootstrapUI'], function(i18n) {
	var app = angular.module('ModalProvider', ['ui.bootstrap']);

	app.factory('ConfirmModal', ['$modal', function($modal){
		return function (config){
			var setFocus = function () {
	            var focusSelector = config.focusSelector || ".modal-dialog button.btn-primary:first";
	            setTimeout(function () {
	                $(focusSelector).focus();
	            }, 100);
	        };

	        var openConfirmModalCtrl = function ($scope, $modalInstance, configurations) {
	            $scope.title = configurations.title;
	            $scope.message = configurations.message;

	            $scope.ok = function () {
	                $modalInstance.close();
	            };

	            $scope.cancel = function () {
	                $modalInstance.dismiss('cancel');
	            };
	        };

	        var template = 
	            '<div class="modal-header">\n' + 
				'	<button type="button" class="close" aria-hidden="true" ng-click="cancel()">x</button>\n' + 
		        '   <h3 class="modal-title" ng-bind="title"></h3>\n' + 
		        '</div>\n' + 
		        '<div class="modal-body">\n' + 
		        '	<div ng-bind="message"></div>\n' + 
		        '</div>\n' + 
		        '<div class="modal-footer">\n' + 
				'	<kb-button btntype="ok" ng-click="ok()"></kb-button>\n' + 
				'	<kb-button btntype="cancel" ng-click="cancel()"></kb-button>\n' + 
		        '</div>';

	        var modalInstance = $modal.open({
	            //templateUrl: config.templateUrl || 'deleteConfirmModal.html',
	            template: template,
	            controller: openConfirmModalCtrl,
	            size: config.size || '',
	            resolve: {
	                configurations: function () {
	                    return {
	                        title: config.title || i18n.t("common:deleteConfirmTitle"),
	                        message: config.message || i18n.t("common:deleteConfirmMessage")
	                    };
	                }
	            }
	        });

	        modalInstance.opened.then(setFocus, undefined);

	        modalInstance.result.then(function () {
	            config.onOk && config.onOk();
	        }, function () {
	            config.onCancel && config.onCancel();
	        });
		};
	}]);

	app.factory('RepositoryModal', ['$modal', function($modal){
		return function (config){
			var setFocus = function () {
	            var focusSelector = config.focusSelector || ".modal-dialog:visible input:visible:first";
	            setTimeout(function () {
	                $(focusSelector).focus();
	            }, 100);
        	};

	        var openModalCtrl = function ($scope, $modalInstance, configurations) {
	            var checkValid = configurations.checkValid;

	            $scope.model = configurations.model;
	            $scope.ok = function (isFormInvalid) {
	                if(configurations.onOk){
	                	if(!configurations.onOk(isFormInvalid)){
	                		// Return whithout closing modal if false is returned 
	                		return;
	                	}
	                }
	                $modalInstance.close();
	            };
	            $scope.okContinue = function (isFormInvalid, formObj) {
	            	if(configurations.onOkContinue){
	                	configurations.onOkContinue(isFormInvalid, formObj)
	                }
	                setFocus();
	            };
	            $scope.cancel = function () {
	                if(configurations.onCancel){
	                	configurations.onCancel();
                	}
	                $modalInstance.dismiss('cancel');
	            };
	        };

	        var modalInstance = $modal.open({
	            templateUrl: config.templateUrl,
	            size: config.size || '',
	            backdrop: config.backdrop || 'static',
	            controller: openModalCtrl,
	            resolve: {
	                configurations: function () {
	                    return {
	                        model: config.model || undefined,
	                        onOk: config.onOk || undefined,
	                        onCancel: config.onCancel || undefined,
	                        onOkContinue: config.onOkContinue || undefined
	                    };
	                }
	            }
	        });

	        modalInstance.opened.then(setFocus, undefined);

	        //return modalInstance;
		};
	}]);
});