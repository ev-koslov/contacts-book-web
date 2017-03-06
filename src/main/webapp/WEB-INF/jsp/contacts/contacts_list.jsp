<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page language="java" contentType="text/html; charset=UTF-8" %>

<spring:url value="/view/" var="url_view_contact"/>

<c:forEach items="${contacts}" var="contact">
    <tr onclick="doNav('${url_view_contact}${contact.id}')" onmouseover="makeActive(this, true)"
        onmouseout="makeActive(this, false)">
        <td>${contact.surname} ${contact.name} ${contact.secondName}</td>
        <td>${contact.cellPhone}</td>
        <td class="hidden-xs">${contact.phone}</td>
        <td class="hidden-xs hidden-sm">${contact.address}</td>
        <td class="hidden-xs">${contact.email}</td>
    </tr>
</c:forEach>