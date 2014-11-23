require(['main'],function(){
	require([ 'kbconfig', 'i18n', 'helper', 'ngRoute', 'ngAnimate', 'kbFactory'], function(kbconfig, i18n, helper) {
		i18n.loadNamespace("studentManagement", function(){
			var moduleName = window.kbSubModule.name  = "kb.module.student.studentManagement";
			var moduleViewRoot  = kbconfig.view.student.studentManagement;
			var moduleApi = kbconfig.api.student.studentManagement;
			var subModules = ["NewAdmission", "EditAdmission", "EditClass", "Report", "AdmissionReceipt"];
			
			var app = angular.module(moduleName, ['ngRoute', 'ngAnimate', 'kbFactory']);
			
			app.factory('sideMenuProvider', function(){
				var subModuleMenu = [];				
				for(var i = 0; i < subModules.length; i++){
					subModuleMenu.push({path: ("#" + subModules[i]), text: i18n.t("menu:StudentManagement." + subModules[i])});
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

			app.controller("NewAdmissionCtrl", ["$scope", "kbFactory", function($scope, kbFactory){
				var today = new Date();
				var self = this;
				self.controllerName = "NewAdmissionCtrl";
				window.debugCtrl = this; // Remove this line..

				// Default values
				self.defaults = {
					oneAtATime: false,
					admissionDate: today,
					admissionDateMax: today,
					birthDateMax: today,
					mobileNoPattern: /^([+]?\d{2}[- ])?\d{10}$/,
					emailIdPattern: /^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/,
					positiveNumberPattern: /^\d+$/,
					positiveNonZeroNumberPattern: /^[0-9]*[1-9][0-9]*$/
				};
				// Panel model
				self.panelModel = {};
				// Data model
				self.studentDetails = {};
				self.qualifiedExamDetails = {};				
				// Configuration lists
				self.admissionConfigLists = {};
				// Error flags
				self.errorFlags = {};

				self.OnStudentDetailsSubmit = function () {
					self.trySubmitStudentDetails = self.showStudentDetailsErrors = true;
				};

				self.OnStudentDetailsToggleErrors = function () {
					self.showStudentDetailsErrors = !self.showStudentDetailsErrors;
				};

				self.OnExamDetailsSubmit = function () {
					self.trySubmitExamDetails = self.showExamDetailsErrors = true;
				};

				self.OnExamDetailsToggleErrors = function () {
					self.showExamDetailsErrors = !self.showExamDetailsErrors;
				};

				self.UpdateExamPercentage = function(){
					var perc = CalculateExamPercentage();
					var displayPerc = 0;
					if(perc > 0  && perc <= 100){
						displayPerc = perc;
					}
					self.qualifiedExamDetails.percentage = displayPerc;
					self.errorFlags.scoredMarksGreaterThanTotal = (perc > 100);
				};

				function CalculateExamPercentage () {
					var scoredMarks = self.qualifiedExamDetails.scoredMarks;
					var totalMarks = self.qualifiedExamDetails.totalMarks;

					if(!helper.isEmpty(scoredMarks) && !helper.isEmpty(totalMarks)){
						scoredMarks = parseFloat(scoredMarks);
						totalMarks = parseFloat(totalMarks);

						if(!isNaN(scoredMarks) && !isNaN(totalMarks)){
							if(scoredMarks >=0 && totalMarks > 0){
								if(scoredMarks <= totalMarks){
									return parseFloat(((scoredMarks/totalMarks) * 100).toFixed(2));
								}
								else{
									// Do not round in this case
									return (scoredMarks/totalMarks) * 100;
								}
							}
						}
					}
					return 0;
				}

				// Method to set panel open/close
				function setPanelOpenStatus (details) {
					var panelModel = self.panelModel;
					panelModel.studentDetails.isOpen = !!details.studentDetails;
					panelModel.qualifiedExamDetails.isOpen = !!details.qualifiedExamDetails;
					panelModel.familyDetails.isOpen = !!details.familyDetails;
					panelModel.otherDetails.isOpen = !!details.otherDetails;
				}

				// Method to fetch lists
				function initAdmissionConfigLists () {
					kbFactory.prepareHttpRequest({
						method: 'get',
						url: helper.joinPaths(moduleApi.root, moduleApi.admissionConfig),
						success : function(result) {
							if (result.isSuccess) {
								var lists = result.getData();
								if(lists){
									// Student Panel
									self.admissionConfigLists.admissionTypeList = lists.admissionTypeList;
									self.admissionConfigLists.courseList = lists.courseList;
									self.admissionConfigLists.yearList = lists.yearList;
									self.admissionConfigLists.bloodGroupList = lists.bloodGroupList;
									self.admissionConfigLists.stateList = lists.stateList;
									self.admissionConfigLists.religionList = lists.religionList;
									self.admissionConfigLists.casteList = lists.casteList;
									self.admissionConfigLists.admissionCategoryList = lists.admissionCategoryList;
									self.admissionConfigLists.schemeList = lists.schemeList;

									// Exam Panel
									self.admissionConfigLists.boardExamList = lists.boardExamList;
									self.admissionConfigLists.qualifiedExamList = lists.qualifiedExamList;
									self.admissionConfigLists.previousInstituteList = lists.previousInstituteList;
									self.admissionConfigLists.mediumList = lists.mediumList;
									self.admissionConfigLists.languageList = lists.languageList;

									// Family Panel
									self.admissionConfigLists.occupationList = lists.occupationList;
								}
							}
						},
						error : function(ex) {
							kbFactory.handleError(ex, self.controllerName);
						}	
					});

					self.admissionConfigLists.genderList = [{name:"Male", id:"M"}, {name:"Female", id:"F"}];
					self.admissionConfigLists.nationalityList = [{name:"Indian"}, {name:"Foreign"}];
					self.admissionConfigLists.areaList = [{name:"Urban"}, {name:"Rural"}];
				}

				function init () {
					// Init panel model
					var panelModel = self.panelModel;
					panelModel.oneAtATime = self.defaults.oneAtATime;
					panelModel.studentDetails = {};
					panelModel.qualifiedExamDetails = {};
					panelModel.familyDetails = {};
					panelModel.otherDetails = {};

					setPanelOpenStatus({
						studentDetails:true
					});

					// Init lists
					initAdmissionConfigLists();
				}

				init();

				/*function qualifiedExamDetailsModel (modelData) {
					self.isFresher;
					self.admissionNo;
					self.quaExamRegNo;
					self.quaExamId;
					self.quaExamPassingYear;
					self.quaExamBoardId;
					self.quaExamStateId;
					self.previousInstituteId;
					self.totalMarks;
					self.scoredMarks;
					self.percentage;
					self.medium;
					self.firstLanguage;
					self.secondLanguage;
					//angular.extend(self, modelData);
					//angular.extend(self, listData);
				}*/

			}]);
		});
	});
});