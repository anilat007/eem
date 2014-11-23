<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!doctype html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title><tiles:getAsString name="title" /></title>
	
	<script type="text/javascript"><tiles:useAttribute name="domainJS" id="subModulePath"/>
		!window.kbSubModule && (window.kbSubModule = {});
		window.kbSubModule.path = "<%=subModulePath%>";
	</script>
	
	<script type="text/javascript" data-main="${pageContext.request.contextPath}/js/app/main" src="${pageContext.request.contextPath}/js/lib/require/require.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/lib/jquery/jquery-1.7.1.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/css/Bootstrap/js/bootstrap.min.js"></script>
	<link href="${pageContext.request.contextPath}/css/Bootstrap/css/bootstrap.min.css"	rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/Bootstrap/css/bootstrap-theme.min.css"	rel="stylesheet">
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/img/KB-favicon.ico" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/app/domain/<%=subModulePath%>.js"></script>
	
	<style type="text/css">
		#kb-top-navbar {
			height: 60px;
		}
		
		#kb-top-navbar-brand {
			padding: 0;
			margin: 0;
		}
		
		#kb-main-container {
			position: relative;
			top: 60px;
		}
		
		#kb-message-container{
			margin:0;
			margin-top: 5px;
		}
		
		.pointerCursor{
			cursor: pointer;
		}
		
		.containerBox {
			border: solid 1px #ccc;
			border-radius: 5px;
			margin: 10px 10px 10px 0px;
		}
		
		.kb-icon {
			cursor: pointer;
			opacity: 0.9;
			margin: 3px;
		}
		
		.kb-icon:HOVER {
			opacity: 1;
		}
		
		.kb-icon-primary {
			color: #2d6ca2;
		}
		
		.kb-icon-delete {
			color: #b92c28;
		}
		
		.kb-repeat-animate.ng-enter {
			-webkit-transition: all ease 0.3s;
			   -moz-transition: all ease 0.3s;
			     -o-transition: all ease 0.3s;
			        transition: all ease 0.3s;
		}
		.kb-repeat-animate.ng-enter {
			opacity: 0;
		}		
		.kb-repeat-animate.ng-enter.ng-enter-active {
			opacity: 1;
		}		
		.kb-repeat-animate.ng-leave {
			opacity: 0;
		}		
		.kb-repeat-animate.ng-leave.ng-leave-active {
			opacity: 0;
		}
		
		.kb-view-animate.ng-enter 		{  
		    -webkit-animation:scaleIn 0.3s both ease-in;
			-moz-animation:scaleIn 0.3s both ease-in;
			animation:scaleIn 0.3s both ease-in;    
		}		
		@keyframes scaleIn {
			from { opacity: 0.9; transform: scale(0.99); }
			to { opacity: 1; transform: scale(1); }
		}
		@-moz-keyframes scaleIn {
			from { opacity: 0.9; -moz-transform: scale(0.99); }
			to { opacity: 1; -moz-transform: scale(1); }
		}
		@-webkit-keyframes scaleIn {
			from { opacity: 0.9; -webkit-transform: scale(0.99); }
			to { opacity: 1; -webkit-transform: scale(1); }
		}
</style>
</head>
<body id="kb.module.main" data-ng-controller="MainCtrl as mCtrl">
	<tiles:insertAttribute name="header" />
	<!--main-->
	<div id="kb-main-container" class="container">
		<div class="row">
			<!--left-->
			<div class="col-md-2">
				<ul id="kb-side-menu" class="nav navbar-inverse nav-pills nav-stacked">
					<li data-ng-repeat="menu in mCtrl.sideMenu"><a data-once-href="menu.path" data-once-text="menu.text"></a></li>
				</ul>
			</div>
			<!--/left-->

			<!--right-->
			<div class="col-md-10" style="height:100%">
				<div id="kb-message-container" class="alert" data-ng-show="mCtrl.messaging.message.text" data-ng-class="{'alert-danger': mCtrl.messaging.message.type == 'error', 'alert-success': mCtrl.messaging.message.type == 'success', 'alert-info': mCtrl.messaging.message.info == 'info' }">
					<button type="button" class="close" data-ng-click="mCtrl.messaging.clearMessage()">&times;</button>
					<div data-ng-bind-html="mCtrl.messaging.message.text"></div>
				</div>
				<div class="kb-view-animate" data-ng-view></div>
			</div>
			<!--/right-->
		</div>
		<!--/row-->
	</div>
	<!--/container-->
	
	<script type="text/ng-template" id="deleteConfirmModal.html">
        <div class="modal-header">
			<button type="button" class="close" aria-hidden="true" ng-click="cancel()">x</button>
            <h3 class="modal-title" ng-bind="title"></h3>
        </div>
        <div class="modal-body">
            <div ng-bind="message"></div>
        </div>
        <div class="modal-footer">
			<kb-button btntype="ok" ng-click="ok()"></kb-button>
			<kb-button btntype="cancel" ng-click="cancel()"></kb-button>
        </div>
    </script>
</body>
</html>