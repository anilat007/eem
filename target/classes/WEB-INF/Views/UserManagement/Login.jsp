<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>


<div class="loginContainer">
	<div class="logo">
		<img src="${pageContext.request.contextPath}/img/KBLogo.png" />
	</div>
	<c:if test="${not empty errormsg}">
		<div  style="margin-top:2px; margin-bottom: 2px;">
			<span>${errormsg}</span>
		</div>		
	</c:if>
	
	<c:url value="j_spring_security_check" var="securityUrl"></c:url>
	
	<f:form autocomplete="off" commandName="model" action="${securityUrl}"
		method='POST'>
		<div>
			<div class="loginInputContainer">			
				<div class="row">
					<div class="input-group input-group-lg">
		                <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
		                <f:input id="uxUserName" class="form-control" placeholder="User Name" path="userId" size="30" />
		            </div>
		            
		            <div class="input-group input-group-lg">
		                <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
		                <f:password id="uxPassword" class="form-control" placeholder="Password" path="password" size="30" />
		            </div>
		            <div style="margin-top:2px;">
		            	<input id="uxSubmit" class="btn btn-primary" style="clear: left; width: 100%; height: 40px; font-size: 15px;" type="submit" value="Log In" />
	            	</div>
	            	
					<div>
						<a href='<s:url value="/changepwd"/>' style="float: right;">Change Password</a>
					</div>
	            </div>
					<%-- <div>
					<s:hasBindErrors name="model">
						<ul class="errorContainer">
							<s:bind path="model">
								<c:forEach var="error" items="${errors.allErrors}">
									<li>${error.defaultMessage}</li>
								</c:forEach>
							</s:bind>
						</ul>
					</s:hasBindErrors>
				</div> --%>
				<!-- <div>
					<input id="uxSubmit" type="submit" value="Log In"
						class="loginButoon" />
				</div> -->
			</div>
		</div>
	</f:form>
</div>