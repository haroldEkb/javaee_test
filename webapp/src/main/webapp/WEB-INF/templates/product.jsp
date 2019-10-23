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
            <h1>Информация о товаре</h1>
            <table class="table table-bordered my-2">
                <thead>
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Title</th>
                    <th scope="col">Cost</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <th scope="row">
                        <c:out value="${product.id}"/>
                    </th>
                    <td>
                        <c:out value="${product.title}"/>
                    </td>
                    <td>
                        <c:out value="${product.cost}"/>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>

<%@ include file="footer_scripts.jsp" %>

</html>