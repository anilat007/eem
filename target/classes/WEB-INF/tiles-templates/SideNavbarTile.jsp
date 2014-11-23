<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!doctype html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

	<title><tiles:getAsString name="title" /></title>
	
	<script type="text/javascript"><tiles:useAttribute name="domainJS" id="subModulePath"/>
		!window.kbSubModule && (window.kbSubModule = {});
		window.kbSubModule.path = "<%=subModulePath%>";
	</script>
	
	<script type="text/javascript" data-main="${pageContext.request.contextPath}/js/app/main" src="${pageContext.request.contextPath}/js/lib/require/require.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/lib/jquery/jquery-1.7.1.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/css/Bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/app/domain/<%=subModulePath%>.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>

	<link href="${pageContext.request.contextPath}/css/Common.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/Bootstrap/css/bootstrap.min.css"	rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/Bootstrap/css/bootstrap-theme.min.css" rel="stylesheet">
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/img/KB-favicon.ico" />

	<style type="text/css">
        body {
          margin-top: 50px;
        }

        .navbar-collapse {
          padding-left: 15px !important;
          padding-right: 15px !important;
        }

        #wrapper-nav {
          padding-left: 0;
        }

        #wrapper-page {
          width: 100%;
          padding: 5px 15px;
        }

        .sidebar-nav>li {
            width: 100%;
        }

        /* Edit Below to Customize Widths > 768px */
        @media (min-width:768px) {
            #wrapper-nav {
              padding-left: 225px;
            }

            #wrapper-page {
                padding: 15px 25px;
            }

            .sidebar-nav{
                margin-left: -225px;
                left: 225px;
                width: 225px;
                position: fixed;
                top:50px;
                border-radius: 0;
                border: none;
                overflow-y: auto;
                padding-bottom: 100%;
            }
            
            .container{
            	margin-left: inherit !important;
            }
        }
		
		#kb-top-navbar-brand {
			padding: 0;
			margin: 0;
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
		
		@media (min-width:768px) {		
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
		}
</style>
</head>
<body id="kb.module.main" data-ng-controller="MainCtrl as mCtrl">
    <div id="wrapper-nav">
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-module">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <img id="kb-top-navbar-brand" src="${pageContext.request.contextPath}/img/KBLogo.png" class="navbar-brand" />
            </div>

            <div class="collapse navbar-collapse" id="navbar-module">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="<c:url value="/roleModule"/>">Change Module</a></li>
                    <li><a href="<c:url value="/j_spring_security_logout"/>">Logout</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-inverse sidebar-nav">
                    <li data-ng-repeat="menu in mCtrl.sideMenu" ng-class="{'active': menu.id == mCtrl.sideMenu.activeId}">
                    	<a data-once-href="menu.path" data-once-text="menu.text" ng-click="mCtrl.sideMenu.setActive(menu.id)"></a>
                	</li>
                </ul>
            </div>
        </nav>

        <div id="wrapper-page">
            <div class="row">
                <div class="col-lg-12">
                    <div id="kb-message-container" class="alert" data-ng-show="mCtrl.messaging.message.text"
                        data-ng-class="{'alert-danger': mCtrl.messaging.message.type == 'error', 'alert-success': mCtrl.messaging.message.type == 'success', 'alert-info': mCtrl.messaging.message.info == 'info' }">
                        <button type="button" class="close" data-ng-click="mCtrl.messaging.clearMessage()">&times;</button>
                        <div data-ng-bind-html="mCtrl.messaging.message.text"></div>
                    </div>
                    <div class="kb-view-animate" data-ng-view></div>
                </div>
            </div>
        </div>
    </div>
	
	<!--<script type="text/ng-template" id="deleteConfirmModal.html">
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
    </script>-->
</body>
</html>