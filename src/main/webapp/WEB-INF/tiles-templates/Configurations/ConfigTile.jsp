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
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/img/KB-favicon.ico" />

	<title><tiles:getAsString name="title" /></title><tiles:useAttribute name="basePath" id="basePath"/>
	<link href="${pageContext.request.contextPath}/css/Bootstrap/css/bootstrap.min.css"	rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/Bootstrap/css/bootstrap-theme.min.css" rel="stylesheet">
	<base href="${pageContext.request.contextPath}/<%=basePath%>/"/>
	<style type="text/css">
        body {
          margin-top: 50px;
        }

        .pointer{
        	cursor: pointer;
        }
        
        label.requiredMark::after {
		    color: red;
		    content:" *";
		}
		
		.formSubmitted .radioList.required,
		.formSubmitted  input.ng-invalid,
		.formSubmitted  select.ng-invalid,
		input.ng-dirty.ng-invalid,
		select.ng-dirty.ng-invalid		
		{
		    background: #fff url('img/alert.png') no-repeat 98% center;
		    background-size: 24px 24px;
		    border: solid 1px #b94a48;
		}
		.highlightSuccessFields .ng-dirty.ng-valid{
		    background: #fff url('img/success.png') no-repeat 98% center;
		    background-size: 24px 24px;
		}
		.message-container .message-error{
			color: #b94a48;
			display: block;
			margin-top: 5px;
			margin-bottom: 10px;
		}

		/*.ng-pristine:required{
		
		}*/

		.kb-switch-container *{
			cursor: pointer;
		}

		.kb-switch-container{
			display: inline-block;
			height: 32px;
		}
		.kb-switch input[type="checkbox"]{
			position: absolute;
			margin-left: -2000px;
		}

		.kb-switch-widget{			
			position: relative;
		    display: inline-block;
		    margin-left: 10px;
		    margin-right: 10px;
		    width: 70px;
		    height: 28px;
		    border-radius: 16px;		    
		    vertical-align: middle;
		    overflow: hidden;	
		    -webkit-user-select:none; -moz-user-select:none; -ms-user-select: none;
			border:solid 2px rgba(40,40,40,0.7);
		}

		.kb-switch-widget .kb-switch-button{
		    display: inline-block;
		    position: absolute;
		    width: 12px;
		    height:12px;
		    border-radius: 12px;
		    background: rgb(255,255,255);
		    border: 2px solid rgb(63,76,90);
		    margin-top: 6px;
		    left: 4px;
		    -moz-transition: all 0.3s ease-in 0s; -webkit-transition: all 0.3s ease-in 0s;
		    -o-transition: all 0.3s ease-in 0s; transition: all 0.3s ease-in 0s;
		}
		.kb-switch input[type="checkbox"]:checked + .kb-switch-widget .kb-switch-button{
		    left: 50px;
		}

		.kb-switch-widget .kb-switch-text{
			display: block;
			width: 200%;
			margin-left: -100%;
			height: 100%;
			line-height: 28px;
			background: rgba(100,100,100,.2);
			-moz-transition: margin 0.3s ease-in 0s;
		    -webkit-transition: margin 0.3s ease-in 0s;
		    -o-transition: margin 0.3s ease-in 0s;
		    transition: margin 0.3s ease-in 0s;
		}

		.kb-switch-widget .kb-switch-text .kb-switch-text-on, .kb-switch-widget .kb-switch-text .kb-switch-text-off{
			display: inline-block;
			font-size: 16px; color: white; font-family: Trebuchet, Arial, sans-serif; font-weight: bold;
		    -moz-box-sizing: border-box; -webkit-box-sizing: border-box; box-sizing: border-box;
			height: 100%;
			width: 50%;
		}

		.kb-switch-widget .kb-switch-text .kb-switch-text-on{
			padding-left: 10px;
			float:left;
			background-color: rgba(52,73,94,1);			
		    color: rgb(26,188,156);
		}

		.kb-switch-widget .kb-switch-text .kb-switch-text-off{
			padding-right: 10px;
			text-align: right;
			background-color: rgb(127, 140, 154);
		    color: rgb(63,76,90);
		}	

		.kb-switch input[type="checkbox"]:checked + .kb-switch-widget .kb-switch-text{
			margin-left: 0;
		}

		.kb-switch input[type="checkbox"]:checked + .kb-switch-widget .kb-switch-button{
			background-color:rgb(0,0,0);
			border-color:rgb(26,188,156);
		}

		.kb-switch input[type="checkbox"]:focus + .kb-switch-widget {
			border-color:rgb(26,188,156);
		}

		.kb-switch input[type="checkbox"]:disabled + .kb-switch-widget * {
			cursor: not-allowed !important;
			text-shadow: 0px 1px 1px rgb(221,221,221);
		}

		input[type="radio"] {
		    display:inline-block;
		    width:0px;height:0px;
		}

		input[type="radio"] ~ label:before{
		    content: "";
		    display:inline-block;
		    width:16px;
		    height:16px;
		    border-radius:8px;
		    margin-right: 5px;
		    margin-left: 5px;
		    background-color: #bdc3c7;
		    border:solid 6px gray;
		}

		input[type="radio"]:checked ~ label:before{
		    content: "";
		    background-color: #ffffff;
		    border: solid 4px gray;
		}

		input[type="radio"]:focus ~ label:before{
			border: solid 5px skyblue;
		    background-color: #000000;
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
		
		.navbar-nav li.active:after, .navbar-nav li.active:before {
			position: absolute;
			right: 0%;
			top:0%;
			height:100%;
			width: 0;
		    border: solid transparent;
			content: " ";
			pointer-events: none;
		    z-index: 1;
		}		
		.navbar-nav li.active:after {
			border-right-color: white;
			border-width: 5px;
		}		
		.navbar-nav li.active:before {
			border-right-color: red;
			border-width: 7px;
		}
		
		/* Full side arrow */
		/*.navbar-nav li.active:after {
			right: 0%;
		    border: solid transparent;
			content: " ";
			height:100%;
			width: 0;
			position: absolute;
			pointer-events: none;
			top:0%;
		    z-index: 1;
		}
		
		.navbar-nav li.active:after {
			border-right-color: white;
			border-width: 25px;
		}*/
	</style>

	<script type="text/javascript"><tiles:useAttribute name="domainJS" id="subModulePath"/>
		!window.kbSubModule && (window.kbSubModule = {});
		window.kbSubModule.path = "<%=subModulePath%>";
	</script>
	<script type="text/javascript" data-main="${pageContext.request.contextPath}/js/app/main" src="${pageContext.request.contextPath}/js/lib/require/require.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/lib/jquery/jquery-1.7.1.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/css/Bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/app/domain/<%=subModulePath%>.js"></script>
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
                    <li data-ng-repeat="menu in mCtrl.sideMenu.menuList"
                    	data-ng-class="{'active': mCtrl.sideMenu.isActive(menu)}">
                    	<a data-once-href="menu.path" data-once-text="menu.text"
                    		data-ng-click="mCtrl.sideMenu.setActive(menu)"></a>
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
                    <div id="viewMain" class="kb-view-animate" data-ng-view></div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>