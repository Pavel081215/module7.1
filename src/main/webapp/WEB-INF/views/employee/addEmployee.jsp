<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add Employer</title>
</head>
<body>
<jsp:include flush="false" page="/start"/>

<h3>Add Employee</h3>
<div class="span-12 last">
<form:form method="post"
           action="${pageContext.request.contextPath}/addEmployee"
           commandName="Employee">
    <fieldset>
        <legend>Add Employee</legend>

        <p>Enter id:         <input type="logout" name="id"></p>
        <p>Enter name:    <input type="logout" name="name"></p>
        <p>Enter surname:  <input type="logout" name="surname"></p>
        <p>Enter birthDay: <input type="date" name="birthDay"></p>
        <p>Enter phone:    <input type="logout" name="phone"></p>
        <p>Enter position: <input type="logout" name="position"></p>
        <p>Enter salary:   <input type="logout" name="salary"></p>

         <p>
            <input type="submit" />
        </p>
    </fieldset>
</form:form>
</div>




</body>
</html>