<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page language="java" contentType="text/html; charset=UTF-8" %>

<spring:url value="/login" var="url_login"/>
<spring:url value="/register" var="url_register"/>

<spring:message code="page.login.label.title" var="label_title"/>
<spring:message code="page.login.label.login" var="label_login"/>
<spring:message code="page.login.label.password" var="label_password"/>

<spring:message code="page.login.button.login" var="button_login"/>
<spring:message code="page.login.button.register" var="button_register"/>

<!DOCTYPE html>
<html lang="ru">
<head>
    <title>${label_title}</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <jsp:include page="common/common.jsp"></jsp:include>

</head>
<body>

<nav class="navbar navbar-fixed-top navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="${url_register}"><span class="glyphicon glyphicon-user"></span> ${button_register}</a></li>
            </ul>
        </div>
    </div>
</nav>


<div class="container-fluid" style="margin-top: 60px">

    <div class="row" style="margin-top: 10px">

    </div>

    <div class="row">


        <div class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3 col-xs-10 col-xs-offset-1">

            <div class="panel panel-default">
                <div class="panel-heading"><b>${label_title}</b></div>
                <div class="panel-body">

                    <div class="row" style="margin-left: 5px; margin-right: 5px; margin-top: -5px">
                        <form:form method="post" action="${url_login}" modelAttribute="loginForm" id="loginForm">
                            <div class="form-group">
                                <label for="login">${label_login}:</label>
                                <form:input path="login" cssClass="form-control"/>
                                <span class="help-inline" style="color: red"><form:errors path="login"/></span>
                            </div>

                            <div class="form-group" style="margin-top: -10px">
                                <label for="password">${label_password}:</label>
                                <form:password path="password" cssClass="form-control"/>
                                <span class="help-inline" style="color: red;"><form:errors path="password"/></span>
                            </div>

                        </form:form>
                    </div>

                    <div class="row" style="margin-top: -5px">
                        <div class="col-sm-5 col-sm-offset-1">
                            <button form="loginForm" type="submit" class="btn btn-success btn-block">
                                ${button_login}
                            </button>
                        </div>

                        <%--block is used to make empty space beetween button on extra small screens--%>
                        <div class="hidden-sm hidden-md hidden-lg" style="margin-top: 5px">

                        </div>

                        <div class="col-sm-5">
                            <a href="${url_register}" class="btn btn-warning btn-block">
                                ${button_register}
                            </a>
                        </div>
                    </div>

                </div>
            </div>

        </div>

        <div class="col-md-4 col-sm-3 col-xs-1">

        </div>


    </div>

</div>

</body>
</html>

