<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <c:url value="/" var="main"/>
    <c:url value="/catalog" var="catalog"/>
    <c:url value="/catalog" var="catalog"/>
    <c:url value="/order" var="order"/>
    <c:url value="/cart" var="cart"/>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="${main}">Main</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="${catalog}">Catalog</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="${order}">Order</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="${cart}">Cart</a>
            </li>
        </ul>
    </div>
</nav>