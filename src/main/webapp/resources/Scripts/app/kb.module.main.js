define(["kbconfig", "i18n", "helper", "angular", "once", "ngRoute", "ngAnimate", "ngSanitize", "bootstrapUI","kbDirectives","kbCommonProviders"], function (kbconfig, i18n, helper) {
	require(["domain/" + window.kbSubModule.path], function(){
		var submoduleName, timeoutId;

		safeInit();

		function safeInit () {
			if(timeoutId){
				clearTimeout(timeoutId);
				timeoutId = undefined;
			}
			// Confirm if sub-module loaded
			submoduleName = window.kbSubModule.name;
			if(!submoduleName || submoduleName == ""){
				console.log("Module not loaded yet. Retry after 500ms");
				timeoutId = setTimeout(safeInit, 500);				
			}
			else{
				init();
			}
		}

		function init () {
			var mainModuleName = kbconfig.ng.mainModuleName;
		    var app = angular.module(mainModuleName, ["once", "ngRoute", "ngAnimate", "ngSanitize", "ui.bootstrap", "kbDirectives", "kbCommonProviders", submoduleName]);
		
		    app.run(["$rootScope", function ($rootScope) {
		            var kb = {};
	            	kb.val = function (key, options) {
		                return i18n.t(key, options);
		            };

		            kb.imgRoot = kbconfig.framework.imgRoot;
		            kb.jsRoot = kbconfig.framework.jsRoot;

		            // Put kb on rootScope
		            $rootScope.kb = kb;
		        }
		    ]);
		
		    var messaging = function () {
		        var clsMessage = function (text, type) {
		            this.text = text;
		            this.type = type;
		        };
		
		        clsMessage.prototype = {
		            clear: function () {
		                this.text = this.type = undefined;
		            },
		            set: function (text, type) {
		                this.text = text;
		                this.type = type;
		            }
		        };
		
		        var self = this;
		        var putMessage = function (text, type) {
		            self.message.set(text, type);
		        };
		
		        this.message = new clsMessage();
		
		        this.clearMessage = function () {
		            self.message.clear();
		        };
		        this.putErrorMessage = function (text) {
		            putMessage(text, "error");
		        };
		        this.putSuccessMessage = function (text) {
		            putMessage(text, "success");
		        };
		        this.putInfoMessage = function (text) {
		            putMessage(text, "info");
		        };
		    };
		
		    /*app.controller("MainCtrl", ["$scope", "sideMenuProvider", function ($scope, sideMenuProvider) {
	    		var self = this;

		    	// Side Menu
		    	var menuId = 0;
		    	angular.forEach(SubModuleMenu, function(menu){
		    		menu.id = menuId++;
		    	});
		    	SubModuleMenu.setActive = function(id){
		    		SubModuleMenu.activeId = id;
		    	};
		    	SubModuleMenu.setActive(-1);
		    	self.sideMenu = SubModuleMenu;

		        // Message functionality
		    	self.messaging = $scope.messaging = new messaging();
		    }]);*/

		    app.controller("MainCtrl", ["$scope", "kbSubModuleMenu", function ($scope, kbSubModuleMenu) {
		    	// Side Menu
		    	this.sideMenu = kbSubModuleMenu;

		        // Message functionality
		    	this.messaging = $scope.messaging = new messaging();
		    }]);
		
		    angular.bootstrap(document.getElementById(mainModuleName), [mainModuleName]);
	    }
	});
});