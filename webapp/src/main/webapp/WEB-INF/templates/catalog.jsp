<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">

<%@ include file="head.jsp"%>

<body>

<%@ include file="header.jsp"%>

<div class="container">
    <div class="row py-2">
        <div class="col-12">
            <p>Каталог</p>
            <ul>
                <c:url value="/product" var="product"/>
                <c:forEach var="item" items="${requestScope.products}">
                    <li>
                        <a href="${product}?id=${item.id}" ><c:out value="${item.title}"/></a>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>
</div>

<%@ include file="footer_scripts.jsp" %>

</html>