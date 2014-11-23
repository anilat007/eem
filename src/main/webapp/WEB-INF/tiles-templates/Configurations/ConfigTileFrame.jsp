<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<div oc-lazy-load="{files: ['${pageContext.request.contextPath}/js/app/domain/<tiles:insertAttribute name="domainJS"/>'] }">
	<tiles:insertAttribute name="body"/>
</div>