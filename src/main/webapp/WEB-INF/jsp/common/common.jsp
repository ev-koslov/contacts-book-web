<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url value="/webjars/jquery/3.1.0/jquery.min.js" var="jQuery"></spring:url>
<spring:url value="/webjars/bootstrap/3.3.7-1/js/bootstrap.min.js" var="bootstrap_min_js"></spring:url>
<spring:url value="/webjars/bootstrap/3.3.7-1/css/bootstrap.min.css" var="bootstrap_min_css"></spring:url>



<script src="${jQuery}"></script>
<script src="${bootstrap_min_js}"></script>
<link rel="stylesheet" href="${bootstrap_min_css}">