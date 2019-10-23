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
            <p>Оформление заказа</p>
        </div>
        <div class="col-6">
            <p>Для оформления заказа вы должны ввести следующие данные:</p>
            <c:url value="${main}" var="productPostUrl"/>
            <form action="${productPostUrl}" method="post">

                <div class="form-group">
                    <label>Имя</label>
                    <input type="text" class="form-control" id="name" name="name" placeholder="Введите ваше имя">
                </div>

                <div class="form-group">
                    <label>Фамилия</label>
                    <input type="text" class="form-control" id="last_name" name="last_name">
                </div>

                <div class="form-group">
                    <label>Телефон</label>
                    <input type="text" class="form-control" id="phone" name="phone">
                </div>

                <div class="form-group">
                    <label>Адрес</label>
                    <input type="text" class="form-control" id="address" name="address">
                </div>

                <div class="form-group">
                    <label>Способ оплаты</label>
                    <input type="radio" class="form-check" name="cash">
                    <input type="radio" class="form-check" name="card">
                </div>

                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </div>
</div>

<%@ include file="footer_scripts.jsp" %>

</html>