<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav id="kb-top-navbar" class="navbar navbar-inverse navbar-fixed-top" role="banner">
  <div class="container">
    <div class="navbar-header">
      <button class="navbar-toggle" type="button" data-toggle="collapse" data-target=".navbar-collapse">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <img id="kb-top-navbar-brand" src="${pageContext.request.contextPath}/img/KBLogo.png" class="navbar-brand" />      
    </div>
    <nav class="collapse navbar-collapse" role="navigation">
      <ul class="nav navbar-nav navbar-right">
			<li><a href="<c:url value="/roleModule"/>">Change Module</a></li>
			<li><a href="<c:url value="/j_spring_security_logout"/>">Logout</a></li>
		</ul>
    </nav>
  </div>
</nav>