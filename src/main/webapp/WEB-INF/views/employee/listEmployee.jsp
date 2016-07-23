<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List Employee</title>
</head>
<body>
<jsp:include flush="false" page="start"/>

<h3>List Employee</h3>

<form:form method="post"
           action="${pageContext.request.contextPath}/listEmployee"
           commandName="listEmployees">
</form:form>


<c:if test="${!empty listEmployees }">
    <table class="data">

        <c:forEach items="${listEmployees}" var="name">
            <tr>
                <td> ID ${name.id}</td>
                <th>&nbsp;</th>
                <td> Name - ${name.name}</td>
                <th>&#10;</th>
                <th>&nbsp;</th>
                <td> Surname - ${name.surname}</td>
                <th>&nbsp;</th>
                <td> BirthDay - ${name.phoneNumber}</td>
                <th>&nbsp;</th>
                <td> Phone - ${name.position}</td>
                <th>&nbsp;</th>
                <td> Position - ${name.position}</td>
                <th>&nbsp;</th>
                <td> Salary - ${name.salary}</td>&#10
                <th>&#10;</th>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>