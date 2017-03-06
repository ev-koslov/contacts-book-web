<%@page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url value="/" var="url_home"/>
<spring:url value="/list?filter=" var="url_contacts_filter"/>
<spring:url value="/new" var="url_new_contact"/>
<spring:url value="/logout" var="url_logout"/>

<spring:message code="project.title" var="project_title"/>
<spring:message code="page.contacts.label.title" var="label_title"/>
<spring:message code="page.contacts.label.filter" var="label_filter"/>
<spring:message code="page.contacts.label.name" var="label_name"/>
<spring:message code="page.contacts.label.cell_phone" var="label_cell_phone"/>
<spring:message code="page.contacts.label.phone" var="label_phone"/>
<spring:message code="page.contacts.label.address" var="label_address"/>
<spring:message code="page.contacts.label.email" var="label_email"/>

<spring:message code="page.contacts.label.new_contact" var="label_new_contact"/>

<spring:message code="page.common.label.logout" var="label_logout"/>


<!DOCTYPE html>
<html lang="ru">
<head>
    <title>${label_title}</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <jsp:include page="../common/common.jsp"></jsp:include>


    <script>
        function doNav(url) {
            document.location.href = url;
        }

        function makeActive(element, isActive) {
            if (isActive) {
                $(element).addClass("success");
            } else {
                $(element).removeClass("success");
            }
        }

        function doContactFilter(filterQuery) {
            var queryString = "${url_contacts_filter}" + filterQuery;
            $.ajax({
                url: queryString,
                success: function (result) {
                    $("#contactsList").html(result);
                }
            });
        }
    </script>

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
                <li>
                    <div class="navbar-form" style="margin-left: 5px; margin-right: 5px">
                        <div class="form-group has-feedback">
                            <input
                                    name="filter"
                                    id="filter"
                                    type="text"
                                    class="form-control"
                                    placeholder="${label_filter}"
                                    onkeyup='doContactFilter($(this).val())'>
                            <span class="glyphicon glyphicon-filter form-control-feedback"></span>
                        </div>
                    </div>
                </li>
                <li><a href="${url_logout}"><span class="glyphicon glyphicon-log-out"></span> ${label_logout}</a></li>
            </ul>
        </div>
    </div>
</nav>


<div class="container-fluid" style="margin-top: 60px">

    <div class="row">
        <div class="col-lg-10 col-lg-offset-1 col-md-10 col-md-offset-1 col-sm-10 col-sm-offset-1 col-xs-12">
            <div class="panel panel-default">
                <div class="panel-body">

                    <table class="table table-condensed">

                        <thead>
                        <tr>
                            <th>
                                <span class="glyphicon glyphicon-user"></span>
                                ${label_name}
                            </th>
                            <th>
                                <span class="glyphicon glyphicon-phone"></span>
                                ${label_cell_phone}
                            </th>
                            <th class="hidden-xs">
                                <span class="glyphicon glyphicon-phone-alt"></span>
                                ${label_phone}
                            </th>
                            <th class="hidden-xs hidden-sm">
                                <span class="glyphicon glyphicon-map-marker"></span>
                                ${label_address}
                            </th>
                            <th class="hidden-xs">
                                <span class="glyphicon glyphicon-envelope"></span>
                                ${label_email}
                            </th>
                        </tr>
                        </thead>


                        <tbody id="contactsList">

                        </tbody>

                    </table>

                </div>
            </div>
        </div>
    </div>

</div>

<script>
    doContactFilter("");
</script>

</body>
</html>