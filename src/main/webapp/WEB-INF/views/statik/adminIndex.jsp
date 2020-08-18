<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ page session="false" %>
<jsp:include page="adminheader-ust.jsp"/>

<jsp:include page="adminheader-alt.jsp"/>
	Welcome ${pageContext.request.userPrincipal.name}

<jsp:include page="adminfooter.jsp"/>