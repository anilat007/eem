define('helper', ['RRModel', 'RepositoryCtrlHelper', 'i18n', 'jquery'], function (RRModel, RepositoryCtrlHelper, i18n, $) {
    var isString = function (value) {
        return (typeof value === "string");
    };
    var isDefined = function (value) {
        return (typeof value !== "undefined");
    };
    var isNull = function (value) {
        return (typeof value == null);
    };

    var isEmpty = function(value, trimString) {
        if(!isDefined(value) || isNull(value)){
            return true;
        }
        if(isString(value)){
            if(trimString === true){
                value = value.trim(); 
            }
            return value == '';
        }
        return false;
    };

    if (!String.prototype.trim) {
        String.prototype.trim = function () {
            return this.replace(/^\s\s*/, '').replace(/\s\s*$/, '');
        };
    }

    if (!String.isNullOrEmpty) {
        String.isNullOrEmpty = function (value) {
            if (!isString(value)) return false;
            return isEmpty(value);
        };
    }

    if (!String.isNullOrWhiteSpace) {
        String.isNullOrWhiteSpace = function (value) {
            if (!isString(value)) return false;
            return isEmpty(value, true);
        };
    }

    if (!String.prototype.equalsIgnoreCase) {
        String.prototype.equalsIgnoreCase = function (stringToCompare) {
            return (this.toUpperCase() == stringToCompare.toUpperCase());
        };
    }

    if (!Array.prototype.removeAt) {
        Array.prototype.removeAt = function (index) {
            return this.splice(index, 1);
        };
    }

    function deferredExecute($http, $q, context) {
        var deferred = $q.defer();

        if (!context.success) {
            context.success = function () {
                console.error('Success callback not configured.');
            };
        }
        if (!context.error) {
            context.error = function () {
                console.error('[Error callback not configured.] Following error occurred');
                console.error(ex); // Comment this for production
            };
        }

        $http({
            method: context.method || 'get',
            url: context.url,
            params: context.params,
            data: context.data
        }).success(function (result, status, headers, config) {
            var transformedResult = new RRModel.KBResponse(result);
            if (transformedResult.isSuccess) {
                context.showMessageCB && context.showMessageCB.success();
                deferred.resolve(transformedResult);
            } else {
            	if (transformedResult.exception){
            		context.showMessageCB && context.showMessageCB.exception(transformedResult.exception);
            	}
                deferred.reject(transformedResult);
            }
        }).error(function (result, status, headers, config) {
            context.showMessageCB && context.showMessageCB.error();
            deferred.reject(result);
        });
        deferred.promise.then(context.success, context.error);
    }

    function joinPaths() {
        var parts = arguments;
        if (parts.length == 0)
            return "";

        var separator = "/";
        var path = parts[0];
        for (var i = 1; i < parts.length; i++) {
            var part = parts[i], p1 = path.charAt(path.length - 1) == separator, p2 = part.charAt(0) == separator;
            path += (p1 && p2) ? part.substr(1) : ((p1 || p2) ? part : (separator + part));
        }
        return path;
    }

    var helper = {
        repositoryCtrl: RepositoryCtrlHelper,

        deferredExecute: deferredExecute,

        joinPaths: joinPaths,

        isEmpty: isEmpty,

        prepareRepository: function ($http, $q, ctx) {
            if (ctx.messaging) {
                var exceptionCB = function (exception) {
                    if (exception.code == "DBError") {
                        putError(i18n.t("common:DBExceptionMessage"));
                    } else if (exception.code == "GeneralError") {
                        putError(i18n.t("common:GeneralExceptionMessage"));
                    }
                };

                var putError = ctx.messaging.putErrorMessage;
                var putSuccess = ctx.messaging.putSuccessMessage;
                ctx.getCB = { success: function () { putSuccess(i18n.t("common:getSuccess")); }, error: function () { putError(i18n.t("common:getError")); }, exception: exceptionCB };
                ctx.addCB = { success: function () { putSuccess(i18n.t("common:addSuccess")); }, error: function () { putError(i18n.t("common:addError")); }, exception: exceptionCB };
                ctx.removeCB = { success: function () { putSuccess(i18n.t("common:removeSuccess")); }, error: function () { putError(i18n.t("common:removeError")); }, exception: exceptionCB };
                ctx.updateCB = { success: function () { putSuccess(i18n.t("common:updateSuccess")); }, error: function () { putError(i18n.t("common:updateError")); }, exception: exceptionCB };
            }

            function repDeferredExecute(reqContext) {
                deferredExecute($http, $q, reqContext);
            }

            function _Get(context) {
                context.url = ctx.rootPath;
                context.method = 'GET';
                ctx.messaging && (context.showMessageCB = ctx.getCB);
                repDeferredExecute(context);
            }

            function _Add(context) {
                context.url = ctx.rootPath;
                context.method = 'POST';
                context.data = angular.toJson(context.data);
                ctx.messaging && (context.showMessageCB = ctx.addCB);
                repDeferredExecute(context);
            }

            function _Remove(context) {
                context.url = joinPaths(ctx.rootPath, 'remove');
                context.method = 'POST';
                ctx.messaging && (context.showMessageCB = ctx.removeCB);
                repDeferredExecute(context);
            }

            function _Update(context) {
                context.url = ctx.rootPath;
                context.method = 'PUT';
                context.data = angular.toJson(context.data);
                ctx.messaging && (context.showMessageCB = ctx.updateCB);
                repDeferredExecute(context);
            }

            return {
                get: _Get,
                add: _Add,
                remove: _Remove,
                update: _Update
            };
        },

        OpenConfirmModal: function (modal, config) {
            var setFocus = function () {
                var focusSelector = config.focusSelector || ".modal-dialog button.btn-primary:first";
                setTimeout(function () {
                    $(focusSelector).focus();
                }, 500);
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

            var modalInstance = modal.open({
                //template: '<div class="modal-header"><h3 class="modal-title" ng-bind="title"></h3></div><div class="modal-body"><div ng-bind="message"></div></div><div class="modal-footer"><button class="btn btn-primary" ng-click="ok()" ng-bind="okText"></button><button class="btn btn-default" ng-click="cancel()" ng-bind="cancelText"></button></div>',
                templateUrl: config.templateUrl || 'deleteConfirmModal.html',
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

            modalInstance.opened.then(function () {
                setFocus();
            }, undefined);

            modalInstance.result.then(function () {
                config.onOk && config.onOk();
            }, function () {
                config.onCancel && config.onCancel();
            });
        },

        OpenModal: function (modal, config) {
            var setFocus = function () {
                var focusSelector = config.focusSelector || ".modal-dialog:visible input:visible:first";
                setTimeout(function () {
                    $(focusSelector).focus();
                }, 500);
            };

            var openModalCtrl = function ($scope, $modalInstance, configurations) {
                var checkValid = configurations.checkValid;

                $scope.model = configurations.model;

                $scope.ok = function () {
                    if (checkValid && !checkValid()) {
                        return;
                    }
                    configurations.onOk && configurations.onOk();
                    $modalInstance.close();
                };
                $scope.okContinue = function () {
                    if (checkValid && !checkValid()) {
                        return;
                    }
                    configurations.onOkContinue && configurations.onOkContinue();
                    setFocus();
                };
                $scope.cancel = function () {
                    configurations.onCancel && configurations.onCancel();
                    $modalInstance.dismiss('cancel');
                };
            };

            var modalInstance = modal.open({
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
                            onOkContinue: config.onOkContinue || undefined,
                            checkValid: config.checkValid || undefined
                        };
                    }
                }
            });

            modalInstance.opened.then(function () {
                setFocus();
            }, undefined);

            return modalInstance;
        }

    };
    return helper;
});