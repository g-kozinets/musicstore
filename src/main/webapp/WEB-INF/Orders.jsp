<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: gleb
  Date: 11/7/2018
  Time: 22:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add or Edit Orders</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

</head>
<body>
<%@ include file="header.html"%>

<div class="container">
    <form method="POST" action='OrdersController' name="frmAddOrders" role="form">
        <div class="form-group">
            <label for="order_id">
                Address ID: <input class="form-control" type="number" id="order_id" name="order_id" readonly value="<c:out value="${orders.order_id}" />" />
            </label>
        </div>
        <div class="form-group">
            <label for="order_name">
                Street name:<input class="form-control" type="text" id="order_name" name="order_name" value="<c:out value="${orders.order_name}" />" />
            </label>
        </div>
        <div class="form-group">
            <label for="addressFK_id">
                Street number: <input class="form-control" type="text" id="addressFK_id" name="addressFK_id" value="<c:out value="${orders.addressFK_id}" />" />
            </label>
        </div>
        <div class="form-group">
            <label for="instrFK_id">
                Street number: <input class="form-control" type="text" id="instrFK_id" name="instrFK_id" value="<c:out value="${orders.instrFK_id}" />" />
            </label>
        </div>
        <div class="form-group">
            <label for="total_price">
                Street number: <input class="form-control" type="text" id="total_price" name="total_price" value="<c:out value="${orders.total_price}" />" />
            </label>
        </div>
        <input type="submit" value="Submit" class="btn btn-outline-success" />
    </form>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

</body>
</html>