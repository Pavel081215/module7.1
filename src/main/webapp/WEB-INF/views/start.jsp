
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
               pageEncoding="UTF-8" %>


<!DOCTYPE html>
<html>
<head>
    <title>My store3434343</title>
   <!-- <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/css/style.css">-->
      <link href="d://ТомСат9/apache-tomcat-9.0.0.M9/webapps/com/hibernate/base/resources/css/style.css" rel="stylesheet" type="text/css "/>
    <!--<link href="<c:url value="../../resources/css/style.css" />" type="text/css "/>-->

</head>


<body >


<a  href="${pageContext.request.contextPath}/order" title="Order">Order</a>
<a href="${pageContext.request.contextPath}/admin" title="Admin">Admin</a>
<a href="${pageContext.request.contextPath}/staff" title="Staff">Staff</a>
<a href="${pageContext.request.contextPath}/ingredients" title="Ingredients">Ingredients</a>
<a href="${pageContext.request.contextPath}/dish" title="Dish">Dish</a>
<a href="${pageContext.request.contextPath}/listEmployee" title="listEmployee">listEmployee</a>
<br/>
<script >
    var t = '#';
    for (var i = 0; i < 7; i++) {
        document.write(t + ' <br /> ');
        t = t + '#';
    }
</script>
<p style="color: blueviolet">HHH</p>


<h2>tggggggfdhdhsdfjsgjgjsjsf</h2>
</body>



</html>