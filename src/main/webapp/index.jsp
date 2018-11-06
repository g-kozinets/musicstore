<%--
  Created by IntelliJ IDEA.
  User: gleb
  Date: 11/3/2018
  Time: 18:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="by.glko2012.mcstore.model.Addresses" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>index.jsp</title>
</head>
<body>

<%
    String timeZoneFix = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    String url = "jdbc:mysql://localhost:3306/MySQL" + timeZoneFix;
    String pass = "3344";
    String user = "root";
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection(url, user, pass);
    String sql = "select * from mydb.addresses where street_number = 34";
    Statement st = con.createStatement();
    ResultSet rs = st.executeQuery(sql);

    List<Addresses> list = new ArrayList();
    while (rs.next()) {
        Addresses address = new Addresses();
        address.setaddress(rs.getString(1));
        address.setstreet_name(rs.getString(2));
        address.setstreet_number(rs.getString(3));
        list.add(address);
    }
    rs.close();
%>

<% for (Addresses type : list) {
    out.println("<br/>" + type.getStreet_name() + " " + type.getStreet_number());
}
%>


</body>
</html>