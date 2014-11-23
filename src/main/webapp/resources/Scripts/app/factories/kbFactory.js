require(['kbconfig', 'helper', 'angular', 'bootstrapUI'], function(kbconfig, helper) {
	var app = angular.module('kbFactory', ['ui.bootstrap']);
	app.factory('kbFactory', ['$http', '$q', '$modal', function ($http, $q, $modal) {
	    return {
	    	prepareHttpRequest: function (ctx) {
	    		return helper.deferredExecute($http, $q, ctx);
	    	},
	        prepareRepository: function (ctx) {
	            return helper.prepareRepository($http, $q, { rootPath: ctx.apiPath, messaging: ctx.messaging });
	        },
	        prepareConfigRepositoryLocal: function (itemModel) {
	            return new configRepositoryLocal(itemModel);
	        },
	        openModal: function (config) {
	            return helper.OpenModal($modal, config);
	        },
	        openConfirmModal: function (config) {
	            return helper.OpenConfirmModal($modal, config);
	        },
	        log: {
	            error: function (error) {
	                console.log(("[" + arguments.callee.caller.name + "]") || '');
	                console.error(error);
	            },
	            info: function (msg) {
	                console.log((("[" + arguments.callee.caller.name + "]") || '') + msg);
	            }
	        },
	        handleError: function (error, senderName) {
	            senderName = senderName || arguments.callee.caller.name || 'N/A';
	            console.error("Error occurred in: " + senderName);
	            console.error(error);
	        },
	        helper: helper,
	        kbconfig: kbconfig
	    };
	}]);
});