require(['main'],function(){
	require([ 'kbconfig', 'i18n', 'helper', 'ngRoute', 'ngAnimate', 'kbFactory'], function(kbconfig, i18n, helper) {
		i18n.loadNamespace("configReceipt", function(){
			var moduleName = window.kbSubModule.name  = "kb.module.receipt.receiptConfigurations";
			var moduleViewRoot  = kbconfig.view.receipt.receiptConfigurations;
			var moduleApi = kbconfig.api.receipt.receiptConfigurations;
			var subModules = ["ReceiptType", "HeadAccount", "FeeCategory", "AdmissionFee", "BusRoute", "BusFeeConfig", "BusAllocation", "HostelFeeConfig", "HostelAllocation"];
			
			var app = angular.module(moduleName, ['ngRoute', 'ngAnimate', 'kbFactory']);
			
			app.factory('sideMenuProvider', function(){
				var subModuleMenu = [];				
				for(var i = 0; i < subModules.length; i++){
					subModuleMenu.push({path: ("#" + subModules[i]), text: i18n.t("menu:ReceiptConfiguration." + subModules[i])});
				}
				return subModuleMenu;
			});
			
			app.config(["$routeProvider", function($routeProvider){
				for(var i = 0; i < subModules.length; i++){
					$routeProvider.when("/" + subModules[i], {
						templateUrl : moduleViewRoot + subModules[i] + ".html",
						controller : subModules[i] + "Ctrl",
						controllerAs : "ctrl"
					});
				}
			}]);

			app.controller("ReceiptTypeCtrl", ["$scope", "kbFactory", function($scope, kbFactory){
				this.controllerName = "ReceiptTypeCtrl";
				var itemModel = function(id, name) {
					this.id = id;
					this.name = name;
	
					this.clear = function() {
						this.id = this.name = undefined;
						return this;
					};
				};
				itemModel.createItem = function(obj) {
					return new itemModel(obj.id, obj.name);
				};
				itemModel.hasDuplicateFields = function(item1, item2){
					return item1.name.trim().equalsIgnoreCase(item2.name.trim());
				};
	
				helper.repositoryCtrl.setup(this, itemModel, helper.joinPaths(moduleApi.root, moduleApi.receiptType), kbFactory, {
					messaging : $scope.messaging
				});
			}]);

			app.controller("HeadAccountCtrl", ["$scope", "kbFactory", function($scope, kbFactory){
				this.controllerName = "ReceiptTypeCtrl";
				var itemModel = function(id, accountName, accountNumber) {
					this.id = id;
					this.accountName = accountName;
					this.accountNumber = accountNumber;
	
					this.clear = function() {
						this.id = this.accountName = this.accountNumber = undefined;
						return this;
					};
				};
				itemModel.createItem = function(obj) {
					return new itemModel(obj.id, obj.accountName, obj.accountNumber);
				};
				itemModel.hasDuplicateFields = function(item1, item2){
					return (item1.accountName.trim().equalsIgnoreCase(item2.accountName.trim()) || item1.accountNumber.trim().equalsIgnoreCase(item2.accountNumber.trim()));
				};
	
				helper.repositoryCtrl.setup(this, itemModel, helper.joinPaths(moduleApi.root, moduleApi.headAccount), kbFactory, {
					messaging : $scope.messaging
				});
			}]);
		});			
	});			
});