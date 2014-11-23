(function(window, angular, undefined) {"use strict";

	var app = angular.module("kbCommonProviders", []);

	app.provider("kbSubModuleMenu", kbSubModuleMenuProvider);

	function kbSubModuleMenuProvider () {
		var menuList = this.menuList = [];
		var activeId = -1;

		var setActive = function (menu) {
			activeId = menu.id;
		};

		var getActive = function () {
			return activeId;
		};

		var isActive = function (menu) {
			return menu.id === activeId;
		};
		
		return {
			setMenuList : function(subModuleList){
				for(var i = 0; i < subModuleList.length; i++){
					menuList.push({
						path: subModuleList[i].path, // add # for hash mode --> path: ("#" + subModules[i])
						text: subModuleList[i].text,
						id: i
					});
				}
			},

			$get: function () {
				return{
					menuList : menuList,
					isActive : isActive,
					setActive: setActive,
					getActive: getActive 
				}
			}
		};
	}
})(window, window.angular);