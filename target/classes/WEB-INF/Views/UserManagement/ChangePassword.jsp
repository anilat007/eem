<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

<div class="loginContainer">
	<div class="logo">
		<img src="${pageContext.request.contextPath}/img/KBLogo.png" />
	</div>
	<f:form autocomplete="off" commandName="model">
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
		            
		            <div class="input-group input-group-lg">
		                <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
		                <f:password id="uxNewPassword" class="form-control" placeholder="New Password" path="newPassword" size="30" />
		            </div>
		            
		            <div class="input-group input-group-lg">
		                <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
		                <f:password id="uxConfirmPassword" class="form-control" placeholder="Confirm Password" path="confirmPassword" size="30" />
		            </div>
		            
		            <div>
						<s:hasBindErrors name="model">
							<ul class="errorContainer" style="margin-top:2px;" >
								<s:bind path="model">
									<c:forEach var="error" items="${errors.allErrors}">
										<li>${error.defaultMessage}</li>
									</c:forEach>
								</s:bind>
							</ul>
						</s:hasBindErrors>
					</div>
		            
		            <div style="margin-top:2px;">
		            	<input id="uxSubmit" class="btn btn-primary" style="clear: left; width: 100%; height: 40px; font-size: 15px;" type="submit" value="Change" />
	            	</div>
					<div>
						<a href='<s:url value="/login"/>' style="float: right;">Back to Login</a>
					</div>
	            </div>
			
				<%-- <div>
					<f:input id="uxUserName" class="loginText" placeholder="User Name"
						path="userId" />
				</div>
				<div>
					<f:password id="uxPassword" class="loginText"
						placeholder="Password" path="password" />
				</div>
				<div>
					<f:password id="uxNewPassword" class="loginText"
						placeholder="New Password" path="newPassword" />
				</div>
				<div>
					<f:password id="uxConfirmPassword" class="loginText"
						placeholder="Confirm Password" path="confirmPassword" />
				</div>
				
				<div>
					<input id="uxSubmit" type="submit" value="Change"
						class="loginButoon" />
				</div>
				<div>
					<a href='<s:url value="/login"/>' style="float: right;">Back to
						Login</a>
				</div> --%>
			</div>
		</div>
	</f:form>
</div>
