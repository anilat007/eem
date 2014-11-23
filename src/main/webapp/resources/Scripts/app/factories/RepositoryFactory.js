require(["i18n", "ngResource", "ModalProvider"], function(i18n) {
	var app = angular.module("RepositoryFactory", ["ngResource", "ModalProvider"]);

	app.factory("RepositoryApifactory", ["$resource", function ($resource) {
		var apiFactory = function (apiPath) {
			var api = $resource(apiPath + "/:id");

			var getById = function (id, onSuccess, onError) {
				api.get({id:id}, 
					function (result) {
						var transformedResult = new KBResponse(result);
			            if (transformedResult.isSuccess) {
			            	onSuccess(transformedResult);
			            } else {
			                onError(transformedResult);
			            }
					},
					function (result) {
						onError(result);
					}
				);
			};

			var get = function (onSuccess, onError) {
				api.get(
					function (result) {
						var transformedResult = new KBResponse(result);
			            if (transformedResult.isSuccess) {
			            	onSuccess(transformedResult);
			            } else {
			                onError(transformedResult);
			            }
					},
					function (result) {
						onError(result);
					}
				);
			};

			var getActive = function (onSuccess, onError) {
				api.get({activeOnly:true}, 
					function (result) {
						var transformedResult = new KBResponse(result);
			            if (transformedResult.isSuccess) {
			            	onSuccess(transformedResult);
			            } else {
			                onError(transformedResult);
			            }
					},
					function (result) {
						onError(result);
					}
				);
			};

			var save = function (entity, onSuccess, onError) {
				api.save(entity,
					function (result) {
						var transformedResult = new KBResponse(result);
			           if (transformedResult.isSuccess) {
			            	onSuccess(transformedResult);
			            } else {
			                onError(transformedResult);
			            }
					},
					function (result) {
						onError(result);
					}
				);
			};

			var deleteFn = function (id, onSuccess, onError) {
				api.delete({id:id},
					function (result) {
						var transformedResult = new KBResponse(result);
			            if (transformedResult.isSuccess) {
			            	onSuccess(transformedResult);
			            } else {
			                onError(transformedResult);
			            }
					},
					function (result) {
						onError(result);
					}
				);
			};

			return{
				api:api,
				get: get,
				getById: getById,
				getActive: getActive,
				save: save,
				delete: deleteFn
			};
		};
		return apiFactory;
	}]);

	app.factory("RepositoryLocalFactory", ["RepositoryApifactory", "ConfirmModal", "RepositoryModal", function (RepositoryApifactory, ConfirmModal, RepositoryModal) {
		function RepositoryLocal(itemModel) {
			var model = this.model = {
				items : null,
				itemList : null,
				searchBy : ""
			};

			function clearItems() {
				try {
					if (model.itemList && model.itemList.length > 0) {
						for (var i = 0; i < model.itemList.length; i++) {
							delete model.itemList[i];
						}

						for ( var i in model.items) {
							delete model.items[model.items[i].id];
							delete model.items[i];
						}
					}
				} catch (err) {
					console.error(err);
				}
			};

			this.initItems = function(result) {
				clearItems();

				model.items = {};
				model.itemList = [];

				angular.forEach(result.getData(), function(item) {
					var category = itemModel.createItem(item);
					model.items[item.id] = category;
					model.itemList.push(category);
				});
			};

			this.add = function(item) {
				var temp = itemModel.createItem(item);
				model.items[temp.id] = temp;
				model.itemList.push(temp);
			};

			this.udpate = function(item) {
				model.items[item.id] = item;
				for (var i = 0; i < model.itemList.length; i++) {
					if (model.itemList[i].id == item.id) {
						model.itemList[i] = item;
						break;
					}
				}
			};

			this.remove = function(item) {
				var id = item.id;
				delete model.items[id];

				for (var j = 0; j < model.itemList.length; j++) {
					if (model.itemList[j].id == id) {
						delete model.itemList[j];
						model.itemList.removeAt(j);
						break;
					}
				}
			};

			this.reset = function() {
				model.searchBy = "";
			};
		}		

		function RepositoryLocalSetup($ctrl, context) {
			var itemModel = context.itemModel;
			var apiFactory = RepositoryApifactory(context.apiPath);
			var messaging = MessagingHelper(context.messaging);
			var repositoryLocal = new RepositoryLocal(itemModel);
			var model = $ctrl.model = repositoryLocal.model;
			
			function isDuplicate(item) {
				for ( var i in model.items) {
					var currItem = model.items[i];
					if (currItem.id != item.id && itemModel.hasDuplicateFields(currItem, item)){
						return currItem;
					}
				}
				return false;
			}

			$ctrl.reset = repositoryLocal.reset;

			$ctrl.fetch = function() {
				apiFactory.get(
					function onSuccess(result){
						repositoryLocal.initItems(result);
						messaging.onSuccess("get");
					},
					function onError(result){
						messaging.onError("get", result);
					}
				);
			};

			$ctrl.add = function() {
				var addModel = itemModel.getDefaultAddItem();
				
				function checkValid() {
					var isValid = false;
					addModel.isDuplicate = addModel.isSuccess = addModel.isDuplicateInactive = undefined;
					var objDuplicate = isDuplicate(addModel);
					if(objDuplicate === false){
						addModel.isDuplicate = false;
						addModel.isDuplicateInactive = false;
						isValid = true;
					}
					else{
						addModel.isDuplicate = true;
						addModel.isDuplicateInactive = !objDuplicate.active;
					}
					return isValid;
				}

				function doAdd(isAddAndNew, formObj) {
					var itemToSave = itemModel.createItem(addModel);
					apiFactory.save(itemToSave,
						function onSuccess(result) {
							repositoryLocal.add(result.getData());
							if (isAddAndNew) {
								angular.extend(addModel, itemModel.getDefaultAddItem())
								addModel.isSuccess = true;
								addModel.formSubmitted = false;
								if(formObj){
									formObj.$setPristine();
								}
							}
							messaging.onSuccess("add");
						},
						function onError(result){
							if(isAddAndNew){
								addModel.isSuccess = false;
							}
							messaging.onError("add", result);
						}
					);
				}

				function onOkay (isFormInvalid, isAddAndNew, formObj){
					addModel.formSubmitted = true;
					addModel.isSuccess = undefined;
					if(isFormInvalid || !checkValid()){
						// Keep popup open
						return false;
					}
					doAdd(isAddAndNew, formObj);
					return true;
				}

				var modalConfig = {
					templateUrl : "addModal.html",
					model : addModel,
					onOk : function(isFormInvalid){
						return onOkay(isFormInvalid, false);
					},
					onOkContinue : function(isFormInvalid, formObj){
						return onOkay(isFormInvalid, true, formObj);
					}
				};
				RepositoryModal(modalConfig);
			};

			$ctrl.edit = function(item) {
				var editModel = itemModel.createItem(item);

				function checkValid() {
					var isValid = false;
					editModel.isDuplicate = editModel.isSuccess = editModel.isDuplicateInactive = undefined;
					var objDuplicate = isDuplicate(editModel);
					if(objDuplicate === false){
						editModel.isDuplicate = false;
						editModel.isDuplicateInactive = false;
						isValid = true;
					}
					else{
						editModel.isDuplicate = true;
						editModel.isDuplicateInactive = !objDuplicate.active;
					}
					return isValid;
				}

				function onOkay (isFormInvalid){
					editModel.formSubmitted = true;
					//editModel.isFormInvalid = isFormInvalid;
					if(isFormInvalid || !checkValid()){
						// Keep popup open
						return false;
					}
					doEdit();
					return true;
				}

				function doEdit () {
					var item = itemModel.createItem(editModel);
					apiFactory.save(item,
						function onSuccess(result) {
							repositoryLocal.udpate(item);
							messaging.onSuccess("update");
						},
						function onError(result) {
							messaging.onError("update", result);
						}
					);
				}
				
				var modalConfig = {
					templateUrl : "editModal.html",
					model : editModel,
					onOk : onOkay
				};
				RepositoryModal(modalConfig);
			};

			$ctrl.remove = function(item) {
				ConfirmModal({
					onOk : function() {
						apiFactory.delete(item.id,
							function onSuccess(result) {
								repositoryLocal.remove(item);
								messaging.onSuccess("delete");
							},
							function onError(result) {
								messaging.onError("delete", result);
							}
						);
					}
				});
			};

			// Fetch items
			$ctrl.fetch();
		}
		
		return{
			init : RepositoryLocalSetup
		};
	}]);

	function KBResponse(response) {
		var self = this;
		self.httpStatus = response.status || null;
		self.isSuccess = response.success;
		//this.errors = null;
		//this.data = null;
		//this.exception = response.exception;

		if (response.errors && response.errors.length > 0) {
			self.errors = [];
			for ( var i in response.errors) {
				var errorModel = new KBErrorModel(response.errors[i]);
				self.errors.push(errorModel);
			}
		}
		if(response.success){
			if(response.model){
				self.data = new KBSuccessModel(response.model);
			}
		}else if( response.exception){
			self.isException = true;
			self.exception = new KBErrorModel(response.exception);
		}

		self.getData = function() {
			if(self.data && self.data.model){
				return self.data.model;
			}
			return null;
		};
	}

	function KBErrorModel(error) {
		this.code = error.code || null;
		this.message = error.message || null;
		this.field = error.field || null;
	}
	
	function KBSuccessModel(success){
		this.message = success.message || null;
		this.redirectTo = success.redirectTo || null;
		this.model = success.data;
	}

    function MessagingHelper (messagingProvider) {
    	var putError = messagingProvider && messagingProvider.putErrorMessage || console.log;
		var putSuccess = messagingProvider && messagingProvider.putSuccessMessage || console.error;

		var exceptionCB = function (exception) {
        	var errorMessage = "";
            if (exception.code == "DBError") {
            	errorMessage = i18n.t("common:DBExceptionMessage");
            } else if (exception.code == "GeneralError") {
                errorMessage = i18n.t("common:GeneralExceptionMessage");
            }
            putError(errorMessage);
        };

        var types = [];
        types["get"] = { onSuccess: function () { putSuccess(i18n.t("common:getSuccess")); }, onError: function () { putError(i18n.t("common:getError")); }, onException: exceptionCB };
        types["add"] = { onSuccess: function () { putSuccess(i18n.t("common:addSuccess")); }, onError: function () { putError(i18n.t("common:addError")); }, onException: exceptionCB };
        types["delete"] = { onSuccess: function () { putSuccess(i18n.t("common:removeSuccess")); }, onError: function () { putError(i18n.t("common:removeError")); }, onException: exceptionCB };
        types["update"] = { onSuccess: function () { putSuccess(i18n.t("common:updateSuccess")); }, onError: function () { putError(i18n.t("common:updateError")); }, onException: exceptionCB };

    	var onSuccessHandler = function (type) {
			types[type].onSuccess();
        };

        var onErrorHandler = function (type, error) {
            if(error.isException){
        		types[type].onException();
        	}else{
        		types[type].onError();
        	}
        };

        return{
        	onSuccess: onSuccessHandler,
        	onError: onErrorHandler,
        	putSuccess: putSuccess,
        	putError: putError
        };
    }
});