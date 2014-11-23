define("RepositoryCtrlHelper", function() {
	function RepositoryLocal(itemModel) {
		var model = this.model = {
			items : null,
			itemList : null,
			searchBy : ''
		};

		var clearItems = function() {
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

			angular.forEach(result.data.model, function(item) {
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
		this.remove = function(ids) {
			for (var i = 0; i < ids.length; i++) {
				var id = ids[i];
				delete model.items[id];

				for (var j = 0; j < model.itemList.length; j++) {
					if (model.itemList[j].id == id) {
						delete model.itemList[j];
						model.itemList.removeAt(j);
						break;
					}
				}
			}
		};
		this.reset = function() {
			model.searchBy = '';
			if (model.itemList && model.itemList.length > 0) {
				for (var i = 0; i < model.itemList.length; i++) {
					model.itemList[i].selected
							&& (model.itemList[i].selected = false);
				}
			}
		};
		this.getSelectedItems = function() {
			var ids = [];
			if (model.itemList) {
				for (var i = 0; i < model.itemList.length; i++) {
					var item = model.itemList[i];
					item.selected && ids.push(item.id);
				}
			}
			return ids;
		};
	}
	
	function RepositoryCtrlSetup($ctrl, itemModel, apiPath, kbFactory, context) {
		var repository = kbFactory.prepareRepository({
			apiPath : apiPath,
			messaging : context.messaging
		});
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
			repository.get({
				success : function(result) {
					if (result.isSuccess) {
						repositoryLocal.initItems(result);
					}
				},
				error : function(ex) {
					kbFactory.handleError(ex, $ctrl.controllerName);
				}
			});
		};

		$ctrl.add = function() {
			var addModel = new itemModel();

			var checkValid = function() {
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
					addModel.isDuplicateInactive = objDuplicate.active;
				}
				return isValid;
			};

			var doAdd = function(isAddAndNew) {
				var item = itemModel.createItem(addModel);
				repository.save({
					data : item,
					success : function(result) {
						repositoryLocal.add(result.data.model);
						if (isAddAndNew) {
							addModel.clear();
							addModel.isSuccess = true;
						}
					},
					error : function(ex) {
						kbFactory.handleError(ex, $ctrl.controllerName);
						isAddAndNew && (addModel.isSuccess = false);
					}
				});
			};
			var doAddAndContinue = function() {
				doAdd(true);
			};
			var modalConfig = {
				templateUrl : 'addModal.html',
				model : addModel,
				onOk : doAdd,
				onOkContinue : doAddAndContinue,
				checkValid : checkValid
			};
			kbFactory.openModal(modalConfig);
		};

		$ctrl.edit = function(item) {
			var editModel = itemModel.createItem(item);
			var checkValid = function() {
				var objDuplicate = isDuplicate(editModel);
				var isValid = false;
				if(objDuplicate === false){
					editModel.isDuplicate = editModel.isDuplicateInactive = false;
					isValid = true;
				}
				else{
					editModel.isDuplicate = true;
					editModel.isDuplicateInactive = objDuplicate.active;
				}
				return isValid;
			};
			
			var modalConfig = {
				templateUrl : 'editModal.html',
				model : editModel,
				checkValid : checkValid,

				onOk : function() {
					var item = itemModel.createItem(editModel);
					repository.save({
						data : item,
						success : function(result) {
							repositoryLocal.udpate(item);
						},
						error : function(ex) {
							kbFactory.handleError(ex, $ctrl.controllerName);
						}
					});
				}
			};
			kbFactory.openModal(modalConfig);
		};

		$ctrl.remove = function(item) {
			var ids;
			if (item) {
				ids = [ item.id ];
			} else {
				ids = repositoryLocal.getSelectedItems();
				if (ids.length == 0) {
					return;
				}
			}
			kbFactory.openConfirmModal({
				onOk : function() {
					repository.remove({
						data : ids,
						success : function(result) {
							repositoryLocal.remove(ids);
						},
						error : function(ex) {
							kbFactory.handleError(ex, $ctrl.controllerName);
						}
					});
				}
			});
		};

		// Fetch items
		$ctrl.fetch();
	}
	
	return {
		setup : RepositoryCtrlSetup
	};
});