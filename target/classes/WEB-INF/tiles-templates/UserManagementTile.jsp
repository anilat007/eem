<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><tiles:getAsString name="title" /></title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/Common.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/UserManagement.css" />
<link href="${pageContext.request.contextPath}/css/Bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/Bootstrap/css/bootstrap-theme.min.css" rel="stylesheet">
<link rel="shortcut icon" href="${pageContext.request.contextPath}/img/KB-favicon.ico" />
</head>
<body>
	<tiles:insertAttribute name="body" />
</body>
</html>