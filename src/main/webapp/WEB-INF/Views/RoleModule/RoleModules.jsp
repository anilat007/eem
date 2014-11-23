<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Role Modules</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/Common.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/RoleModules.css" />
<link rel="shortcut icon" href="${pageContext.request.contextPath}/img/KB-favicon.ico" />
</head>
<body>
	<div class="logo">
		<img src="${pageContext.request.contextPath}/img/KBLogo.png" />
	</div>
	<div class="roleModulesContainer">
		<ul class="menuList">
			<c:forEach var="module" items="${model}">
				<li class="menuItem">
					<div class="menuItemHeader">
						<img class="menuItemHeaderIcon"
							src="${pageContext.request.contextPath}/img/Module/${module.imageName}" />
						<span class="menuItemHeaderTitle">${module.name}</span>
					</div>
					<div class="menuItemBody">
						<ul>
							<c:forEach var="group" items="${module.groups}">
								<li class="menuSubItem"><a href="?g=${group.id}">${group.name}
								</a></li>
							</c:forEach>
						</ul>
					</div>
				</li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>