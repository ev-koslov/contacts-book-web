<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page language="java" contentType="text/html; charset=UTF-8" %>

<spring:url value="/" var="url_home"/>
<spring:url value="/" var="url_create_contact"/>
<spring:url value="/new" var="url_new_contact"/>
<spring:url value="/delete/" var="url_delete_contact"/>

<spring:url value="/logout" var="url_logout"/>

<spring:message code="project.title" var="project_title"/>
<spring:message code="page.contact.label.surname" var="label_surname"/>
<spring:message code="page.contacts.label.name" var="label_name"/>
<spring:message code="page.contact.label.second_name" var="label_second_name"/>
<spring:message code="page.contacts.label.cell_phone" var="label_cell_phone"/>
<spring:message code="page.contacts.label.phone" var="label_phone"/>
<spring:message code="page.contacts.label.address" var="label_address"/>
<spring:message code="page.contacts.label.email" var="label_email"/>
<spring:message code="page.contacts.label.new_contact" var="label_new_contact"/>
<spring:message code="page.common.label.back" var="button_back"/>

<spring:message code="page.common.label.logout" var="label_logout"/>

<c:choose>
    <c:when test="${contactForm.id == 0}">
        <spring:message code="page.contact.label.title.new_contact" var="label_title"/>
        <spring:message code="page.contact.button.new_contact" var="button_save"/>
    </c:when>
    <c:otherwise>
        <spring:message code="page.contact.label.title.edit_contact" var="label_title"/>
        <spring:message code="page.contact.button.edit_contact" var="button_save"/>
        <spring:message code="page.contact.button.delete_contact" var="button_delete"/>
        <spring:message code="page.contact.button.delete_contact_confirmation" var="button_delete_confirmation"/>
    </c:otherwise>
</c:choose>


<!DOCTYPE html>
<html lang="ru">
<head>
    <title>${label_title} ${contactForm.surname} ${contactForm.name} ${contactForm.secondName}</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <jsp:include page="../common/common.jsp"></jsp:include>

    <%--Adding script, which triggers contact deletion only on contact edit page--%>
    <c:choose>
        <c:when test="${contactForm.id != 0}">

            <%--Perform contact delete. Available only when editing existing contact--%>
            <script>
                var deleteTriggered = false;
                function deleteContactWithTrigger(invokedButton) {
                    if (deleteTriggered) {
                        var url = "${url_delete_contact}${contactForm.id}";
                        document.location.href = url;
                    } else {
                        $(invokedButton).removeClass("btn-warning");
                        $(invokedButton).addClass("btn-danger");
                        $(invokedButton).text("${button_delete_confirmation}");
                        deleteTriggered = true;
                    }
                }
            </script>

        </c:when>
    </c:choose>

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
            <a class="navbar-brand" href="${url_home}">
                <span class="glyphicon glyphicon-list-alt"></span>
                ${project_title}
            </a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li>
                    <a href="${url_new_contact}">
                        <span class="glyphicon glyphicon-user"></span>
                        ${label_new_contact}
                    </a>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="${url_logout}"><span class="glyphicon glyphicon-log-out"></span> ${label_logout}</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container-fluid" style="margin-top: 60px">

    <div class="row" style="margin-top: 10px">

    </div>

    <div class="row">


        <div class="col-sm-10 col-sm-offset-1 col-xs-10 col-xs-offset-1">

            <div class="panel panel-default">
                <div class="panel-heading">
                    <b>
                        ${label_title} ${contactForm.surname} ${contactForm.name} ${contactForm.secondName}
                    </b>
                </div>
                <div class="panel-body">

                    <div class="row" style="margin-left: 5px; margin-right: 5px; margin-top: -5px">
                        <form:form method="post" action="${url_create_contact}" modelAttribute="contactForm" id="contactForm">
                            <form:hidden path="id"/>

                            <div class="form-group">

                                <div class="row">
                                    <div class="col-sm-4">
                                        <label for="surname">${label_surname}:</label>
                                        <form:input path="surname" cssClass="form-control"/>
                                        <span class="help-inline" style="color: red"><form:errors
                                                path="surname"/></span>
                                    </div>

                                    <div class="col-sm-4">
                                        <label for="name">${label_name}:</label>
                                        <form:input path="name" cssClass="form-control"/>
                                        <span class="help-inline" style="color: red"><form:errors path="name"/></span>
                                    </div>

                                    <div class="col-sm-4">
                                        <label for="secondName">${label_second_name}:</label>
                                        <form:input path="secondName" cssClass="form-control"/>
                                        <span class="help-inline" style="color: red"><form:errors
                                                path="secondName"/></span>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="row">
                                            <div class="col-sm-6">
                                                <label for="cellPhone">${label_cell_phone}:</label>
                                                <form:input path="cellPhone" cssClass="form-control"/>
                                                <span class="help-inline" style="color: red"><form:errors
                                                        path="cellPhone"/></span>
                                            </div>

                                            <div class="col-sm-6">
                                                <label for="phone">${label_phone}:</label>
                                                <form:input path="phone" cssClass="form-control"/>
                                                <span class="help-inline" style="color: red"><form:errors
                                                        path="phone"/></span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="row">
                                            <div class="col-sm-6">
                                                <label for="address">${label_address}:</label>
                                                <form:input path="address" cssClass="form-control"/>
                                                <span class="help-inline" style="color: red"><form:errors
                                                        path="address"/></span>
                                            </div>

                                            <div class="col-sm-6">
                                                <label for="email">${label_email}:</label>
                                                <form:input path="email" cssClass="form-control"/>
                                                <span class="help-inline" style="color: red"><form:errors
                                                        path="email"/></span>
                                            </div>
                                        </div>
                                    </div>
                                </div>


                            </div>

                        </form:form>
                    </div>

                    <div class="row" style="margin-top: -5px">

                        <%--Setting offset for buttons--%>
                        <c:choose>
                            <c:when test="${contactForm.id == 0}">
                                <c:set var="offset" value="col-sm-offset-6"></c:set>
                            </c:when>
                            <c:otherwise>
                                <c:set var="offset" value="col-sm-offset-3"></c:set>
                            </c:otherwise>
                        </c:choose>


                        <div class="col-sm-3 ${offset}">
                            <button form="contactForm" type="submit" class="btn btn-success btn-block">
                                ${button_save}
                            </button>
                        </div>

                        <c:choose>
                            <c:when test="${contactForm.id !=0 }">

                                <%--block is used to make empty space beetween button on extra small screens--%>
                                <div class="visible-xs" style="margin-top: 5px">

                                </div>

                                <div class="col-sm-3">
                                    <button class="btn btn-warning btn-block" onclick="deleteContactWithTrigger(this)">
                                    ${button_delete}
                                    </button>
                                </div>
                            </c:when>
                        </c:choose>

                        <%--block is used to make empty space beetween button on extra small screens--%>
                        <div class="visible-xs" style="margin-top: 5px">

                        </div>

                        <div class="col-sm-3">
                            <a href="${url_home}" class="btn btn-info btn-block">${button_back}</a>
                        </div>
                    </div>

                </div>
            </div>

        </div>

        <div class="col-sm-1 col-xs-1">

        </div>


    </div>

</div>

</body>
</html>