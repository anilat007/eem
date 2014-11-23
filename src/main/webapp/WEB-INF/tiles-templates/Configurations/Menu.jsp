<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
	$(document).ready(function() {
		i18n.init({
			lng : "en",
			fallbackLng : false,
			ns : "menu",
			useLocalStorage : true, //localStorageExpirationTime: 86400000 // in ms, default 1 week
			resGetPath : ("/eem/js/app/locales/__lng__/__ns__.json")
		}, function(t) {
			$("#kb-side-menu").i18n();
		});
	});
</script>

<ul id="kb-side-menu" class="nav navbar-inverse nav-pills nav-stacked">
	<li data-ng-repeat="menu in mCtrl.sideMenu"><a data-ng-href="#menu.path" data-ng-bind="menu.text"></a></li>
</ul>

<%-- <ul id="kb-side-menu" class="nav navbar-inverse nav-pills nav-stacked">
	<c:forEach var="link" items="${ModuleMenu}">
		<li><a href="${link.path}" data-i18n="menu:${link.i18id}"></a></li>
	</c:forEach>
</ul> --%>