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
    <title>Add or Edit Suppliers</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

</head>
<body>
<%@ include file="header.html"%>

<div class="container">
    <form method="POST" action='SuppliersController' name="frmAddSuppliers" role="form">
        <div class="form-group">
            <label for="suppl_id">
                Supplier ID: <input class="form-control" type="number" id="suppl_id" name="suppl_id" readonly value="<c:out value="${suppliers.suppl_id}" />" />
            </label>
        </div>
        <div class="form-group">
            <label for="suppl_name">
                Suppliers name:<input class="form-control" type="text" id="suppl_name" name="suppl_name" value="<c:out value="${suppliers.suppl_name}" />" />
            </label>
        </div>
        <div class="form-group">
            <label for="suppl_location">
                Suppliers location: <input class="form-control" type="text" id="suppl_location" name="suppl_location" value="<c:out value="${suppliers.suppl_location}" />" />
            </label>
        </div>
        <div class="form-group">
            <label for="delivery_price">
                Suppliers location: <input class="form-control" type="text" id="delivery_price" name="delivery_price" value="<c:out value="${suppliers.delivery_price}" />" />
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