require(['main'],function(){
	require([ 'kbconfig', 'i18n', 'helper', 'ngRoute', 'ngAnimate', 'kbFactory'], function(kbconfig, i18n, helper) {
		i18n.loadNamespace("configStudent", function(){
			var moduleName = window.kbSubModule.name  = "kb.module.configurations.studentAdmission";
			var moduleViewRoot  = kbconfig.view.config.student;;
			var moduleApi = kbconfig.api.config.student;
			var subModules = ["AdmissionCategory", "AdmissionType", "BloodGroup", "BoardExam", "Caste", "Course", "Documents", "Nationality", "Occupation", "PreviousInstitute", "QualifiedExam", "Religion","Scheme", "State", "Year"];
			
			var app = angular.module(moduleName, ['ngRoute', 'ngAnimate', 'kbFactory']);
			
			app.factory('sideMenuProvider', function(){
				var subModuleMenu = [];				
				for(var i = 0; i < subModules.length; i++){
					subModuleMenu.push({path: ("#" + subModules[i]), text: i18n.t("menu:StudentAdmissionConfiguration." + subModules[i])});
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

			app.controller("AdmissionCategoryCtrl", ["$scope", "kbFactory", function($scope, kbFactory){
				this.controllerName = "AdmissionCategoryCtrl";
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
	
				helper.repositoryCtrl.setup(this, itemModel, helper.joinPaths(moduleApi.root, moduleApi.admissionCategory), kbFactory, {
					messaging : $scope.messaging
				});
			}]);
			
			app.controller("AdmissionTypeCtrl", ["$scope", "kbFactory", function($scope, kbFactory){
				this.controllerName = "AdmissionTypeCtrl";
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
	
				helper.repositoryCtrl.setup(this, itemModel, helper.joinPaths(moduleApi.root, moduleApi.admissionType), kbFactory, {
					messaging : $scope.messaging
				});
			}]);
			
			app.controller("BloodGroupCtrl", ["$scope", "kbFactory", function($scope, kbFactory){
				this.controllerName = "BloodGroupCtrl";
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
	
				helper.repositoryCtrl.setup(this, itemModel, helper.joinPaths(moduleApi.root, moduleApi.bloodGroup), kbFactory, {
					messaging : $scope.messaging
				});
			}]);
			
			app.controller("BoardExamCtrl", ["$scope", "kbFactory", function($scope, kbFactory){
				this.controllerName = "BoardExamCtrl";
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
	
				helper.repositoryCtrl.setup(this, itemModel, helper.joinPaths(moduleApi.root, moduleApi.boardExam), kbFactory, {
					messaging : $scope.messaging
				});
			}]);
			
			app.controller("CasteCtrl", ["$scope", "kbFactory", function($scope, kbFactory){
				this.controllerName = "BoardExamCtrl";
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
	
				helper.repositoryCtrl.setup(this, itemModel, helper.joinPaths(moduleApi.root, moduleApi.caste), kbFactory, {
					messaging : $scope.messaging
				});
			}]);
			
			app.controller("CourseCtrl", ["$scope", "kbFactory", function($scope, kbFactory){
				this.controllerName = "BoardExamCtrl";
				var itemModel = function (id, name, years) {
			        this.id = id;
			        this.name = name;
			        this.years = years;

			        this.clear = function () {
			            this.id = this.name = this.years= undefined;
			            return this;
			        };
			    };
			    itemModel.createItem = function (obj) {
			        return new itemModel(obj.id, obj.name, obj.years);
			    };
			    itemModel.hasDuplicateFields = function (item1, item2) {
			        return item1.name.trim().equalsIgnoreCase(item2.name.trim());
			    };
			    
				helper.repositoryCtrl.setup(this, itemModel, helper.joinPaths(moduleApi.root, moduleApi.course), kbFactory, {
					messaging : $scope.messaging
				});
			}]);
			
			app.controller("DocumentsCtrl", ["$scope", "kbFactory", function($scope, kbFactory){
				this.controllerName = "DocumentsCtrl";
				var itemModel = function (id, name, remarks) {
			        this.id = id;
			        this.name = name;
			        this.remarks = remarks;

			        this.clear = function () {
			            this.id = this.name = this.remarks= undefined;
			            return this;
			        };
			    };
			    itemModel.createItem = function (obj) {
			        return new itemModel(obj.id, obj.name, obj.remarks);
			    };
			    itemModel.hasDuplicateFields = function (item1, item2) {
			        return item1.name.trim().equalsIgnoreCase(item2.name.trim());
			    };
			    
				helper.repositoryCtrl.setup(this, itemModel, helper.joinPaths(moduleApi.root, moduleApi.documents), kbFactory, {
					messaging : $scope.messaging
				});
			}]);
			
			app.controller("NationalityCtrl", ["$scope", "kbFactory", function($scope, kbFactory){
				this.controllerName = "NationalityCtrl";
				var itemModel = function (id, name) {
			        this.id = id;
			        this.name = name;

			        this.clear = function () {
			            this.id = this.name = undefined;
			            return this;
			        };
			    };
			    itemModel.createItem = function (obj) {
			        return new itemModel(obj.id, obj.name);
			    };
			    itemModel.hasDuplicateFields = function (item1, item2) {
			        return item1.name.trim().equalsIgnoreCase(item2.name.trim());
			    };
			    
				helper.repositoryCtrl.setup(this, itemModel, helper.joinPaths(moduleApi.root, moduleApi.nationality), kbFactory, {
					messaging : $scope.messaging
				});
			}]);
			
			app.controller("OccupationCtrl", ["$scope", "kbFactory", function($scope, kbFactory){
				this.controllerName = "OccupationCtrl";
				var itemModel = function (id, name) {
			        this.id = id;
			        this.name = name;

			        this.clear = function () {
			            this.id = this.name = undefined;
			            return this;
			        };
			    };
			    itemModel.createItem = function (obj) {
			        return new itemModel(obj.id, obj.name);
			    };
			    itemModel.hasDuplicateFields = function (item1, item2) {
			        return item1.name.trim().equalsIgnoreCase(item2.name.trim());
			    };
			    
				helper.repositoryCtrl.setup(this, itemModel, helper.joinPaths(moduleApi.root, moduleApi.occupation), kbFactory, {
					messaging : $scope.messaging
				});
			}]);
			
			app.controller("PreviousInstituteCtrl", ["$scope", "kbFactory", function($scope, kbFactory){
				this.controllerName = "PreviousInstituteCtrl";
				var itemModel = function (id, name) {
			        this.id = id;
			        this.name = name;

			        this.clear = function () {
			            this.id = this.name = undefined;
			            return this;
			        };
			    };
			    itemModel.createItem = function (obj) {
			        return new itemModel(obj.id, obj.name);
			    };
			    itemModel.hasDuplicateFields = function (item1, item2) {
			        return item1.name.trim().equalsIgnoreCase(item2.name.trim());
			    };
			    
				helper.repositoryCtrl.setup(this, itemModel, helper.joinPaths(moduleApi.root, moduleApi.previousInstitute), kbFactory, {
					messaging : $scope.messaging
				});
			}]);
			
			app.controller("QualifiedExamCtrl", ["$scope", "kbFactory", function($scope, kbFactory){
				this.controllerName = "QualifiedExamCtrl";
				var itemModel = function (id, name) {
			        this.id = id;
			        this.name = name;

			        this.clear = function () {
			            this.id = this.name = undefined;
			            return this;
			        };
			    };
			    itemModel.createItem = function (obj) {
			        return new itemModel(obj.id, obj.name);
			    };
			    itemModel.hasDuplicateFields = function (item1, item2) {
			        return item1.name.trim().equalsIgnoreCase(item2.name.trim());
			    };
			    
				helper.repositoryCtrl.setup(this, itemModel, helper.joinPaths(moduleApi.root, moduleApi.qualifiedExam), kbFactory, {
					messaging : $scope.messaging
				});
			}]);
			
			app.controller("ReligionCtrl", ["$scope", "kbFactory", function($scope, kbFactory){
				this.controllerName = "ReligionCtrl";
				var itemModel = function (id, name) {
			        this.id = id;
			        this.name = name;

			        this.clear = function () {
			            this.id = this.name = undefined;
			            return this;
			        };
			    };
			    itemModel.createItem = function (obj) {
			        return new itemModel(obj.id, obj.name);
			    };
			    itemModel.hasDuplicateFields = function (item1, item2) {
			        return item1.name.trim().equalsIgnoreCase(item2.name.trim());
			    };
			    
				helper.repositoryCtrl.setup(this, itemModel, helper.joinPaths(moduleApi.root, moduleApi.religion), kbFactory, {
					messaging : $scope.messaging
				});
			}]);
			
			app.controller("SchemeCtrl", ["$scope", "kbFactory", function($scope, kbFactory){
				this.controllerName = "SchemeCtrl";
				var itemModel = function (id, name, status) {
			        this.id = id;
			        this.name = name;
			        this.status = status;

			        this.clear = function () {
			            this.id = this.name = this.status = undefined;
			            return this;
			        };
			    };
			    itemModel.createItem = function (obj) {
			        return new itemModel(obj.id, obj.name, obj.status);
			    };
			    itemModel.hasDuplicateFields = function (item1, item2) {
			        return item1.name.trim().equalsIgnoreCase(item2.name.trim());
			    };
			    
				helper.repositoryCtrl.setup(this, itemModel, helper.joinPaths(moduleApi.root, moduleApi.scheme), kbFactory, {
					messaging : $scope.messaging
				});
			}]);
			
			app.controller("StateCtrl", ["$scope", "kbFactory", function($scope, kbFactory){
				this.controllerName = "StateCtrl";
				var itemModel = function (id, name) {
			        this.id = id;
			        this.name = name;

			        this.clear = function () {
			            this.id = this.name = undefined;
			            return this;
			        };
			    };
			    itemModel.createItem = function (obj) {
			        return new itemModel(obj.id, obj.name);
			    };
			    itemModel.hasDuplicateFields = function (item1, item2) {
			        return item1.name.trim().equalsIgnoreCase(item2.name.trim());
			    };
			    
				helper.repositoryCtrl.setup(this, itemModel, helper.joinPaths(moduleApi.root, moduleApi.state), kbFactory, {
					messaging : $scope.messaging
				});
			}]);
			
			app.controller("YearCtrl", ["$scope", "kbFactory", function($scope, kbFactory){
				this.controllerName = "YearCtrl";
				var itemModel = function (id, name) {
			        this.id = id;
			        this.name = name;

			        this.clear = function () {
			            this.id = this.name = undefined;
			            return this;
			        };
			    };
			    itemModel.createItem = function (obj) {
			        return new itemModel(obj.id, obj.name);
			    };
			    itemModel.hasDuplicateFields = function (item1, item2) {
			        return item1.name.trim().equalsIgnoreCase(item2.name.trim());
			    };
			    
				helper.repositoryCtrl.setup(this, itemModel, helper.joinPaths(moduleApi.root, moduleApi.year), kbFactory, {
					messaging : $scope.messaging
				});
			}]);
		});			
	});			
});