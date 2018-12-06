<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
</head>
<body>
<%@ include file="header.html" %>
<h3>Enter Address Details</h3>
<form:form method="POST"
           action="/spring-mvc-xml/addEmployee" modelAttribute="addresses">
    <table>
        <tr>
            <td><form:label path="street_name">Street name</form:label></td>
            <td><form:input path="street_name"/></td>
        </tr>
        <tr>
            <td><form:label path="street_number">Street number</form:label></td>
            <td><form:input path="street_number"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>