require(["main"],function(){
	require([ "kbconfig", "i18n", "helper", "ngResource", "ngRoute", "ngAnimate", "RepositoryFactory", "kbCommonProviders"], function(kbconfig, i18n, helper) {
		var studentAdmissionConfigurations = function(){
			var moduleName = window.kbSubModule.name  = "kb.module.student.studentAdmissionConfigurations";
			var moduleViewRoot  = kbconfig.view.student.studentAdmissionConfigurations;
			var moduleApi = kbconfig.api.student.studentAdmissionConfigurations;
			var subModules = ["AdmissionCategory", "AdmissionType", "BloodGroup", "BoardExam", "Caste", "Course", "Documents", "Nationality", "Occupation", "PreviousInstitute", "QualifiedExam", "Religion","Scheme", "State", "Year"];
			
			var app = angular.module(moduleName, ["ngResource", "ngRoute", "ngAnimate", "RepositoryFactory", "kbCommonProviders"]);
			
			app.config(["$routeProvider", "$locationProvider", function($routeProvider, $locationProvider){
				for(var i = 0; i < subModules.length; i++){
					$routeProvider.when("/" + subModules[i], {
						templateUrl : moduleViewRoot + subModules[i] + ".html",
						controller : subModules[i] + "Ctrl",
						controllerAs : "ctrl"
					});
				}
				$locationProvider.html5Mode(true);
			}]);

			app.config(["kbSubModuleMenuProvider",function(kbSubModuleMenuProvider) {
				// Configure Submodule Menu
				var subModuleList = [];
				for(var i = 0; i < subModules.length; i++){
					subModuleList.push({
						path: subModules[i],
						text: i18n.t("menu:StudentAdmissionConfiguration." + subModules[i])
					});
				}
				kbSubModuleMenuProvider.setMenuList(subModuleList);
			}]);
			
			app.controller("AdmissionCategoryCtrl", ["$scope", "RepositoryLocalFactory", function($scope, RepositoryLocalFactory){
				this.controllerName = "AdmissionCategoryCtrl";
				
				function AdmissionCategoryModel(id, name, active) {
					this.id = id;
					this.name = name;
					this.active = active;
				}
				AdmissionCategoryModel.prototype.clear = function() {
					this.id = this.name = this.active = undefined;
				};
				AdmissionCategoryModel.createItem = function(obj) {
					if(obj) return new AdmissionCategoryModel(obj.id, obj.name, obj.active);
					return new AdmissionCategoryModel();
				};
				AdmissionCategoryModel.getDefaultAddItem = function(){
					return AdmissionCategoryModel.createItem({active:true});
				};
				AdmissionCategoryModel.hasDuplicateFields = function(item1, item2){
					if(item1.name === undefined || item2.name === undefined){
						return false;
					}
					return item1.name.trim().equalsIgnoreCase(item2.name.trim());
				};

				RepositoryLocalFactory.init(this, {
					apiPath : helper.joinPaths(moduleApi.root, moduleApi.category),
					itemModel: AdmissionCategoryModel,
					messaging: $scope.messaging
				});
			}]);
		};

		i18n.loadNamespace("configStudent",studentAdmissionConfigurations);


			/*i18n.loadNamespace("configStudent", function(){
				var moduleName = window.kbSubModule.name  = "kb.module.student.studentAdmissionConfigurations";
				var moduleViewRoot  = kbconfig.view.student.studentAdmissionConfigurations;
				var moduleApi = kbconfig.api.student.studentAdmissionConfigurations;
				var subModules = ["AdmissionCategory", "AdmissionType", "BloodGroup", "BoardExam", "Caste", "Course", "Documents", "Nationality", "Occupation", "PreviousInstitute", "QualifiedExam", "Religion","Scheme", "State", "Year"];
				
				// TODO: Remove kbFactory
				var app = angular.module(moduleName, ['ngResource', 'ngRoute', 'ngAnimate', 'kbFactory', 'RepositoryFactory']);
				
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
				
				app.controller("AdmissionCategoryCtrl", ["$scope", "RepositoryLocalFactory", function($scope, RepositoryLocalFactory){
					this.controllerName = "AdmissionCategoryCtrl";
					
					function AdmissionCategoryModel(id, name, active) {
						this.id = id;
						this.name = name;
						this.active = active;
					}
					AdmissionCategoryModel.prototype.clear = function() {
						this.id = this.name = this.active = undefined;
					};
					AdmissionCategoryModel.createItem = function(obj) {
						if(obj) return new AdmissionCategoryModel(obj.id, obj.name, obj.active);
						return undefined;
					};
					AdmissionCategoryModel.getDefaultAddItem = function(){
						return AdmissionCategoryModel.createItem({active:true});
					};
					AdmissionCategoryModel.hasDuplicateFields = function(item1, item2){
						if(item1.name === undefined || item2.name === undefined){
							return false;
						}
						return item1.name.trim().equalsIgnoreCase(item2.name.trim());
					};

					RepositoryLocalFactory.init(this, {
						apiPath : helper.joinPaths(moduleApi.root, moduleApi.category),
						itemModel: AdmissionCategoryModel,
						messaging: $scope.messaging
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
			});*/			
		});			
});