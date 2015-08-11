<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Register</title>
<!-- javascript and css -->
<%@include file="includes.jsp"%>
</head>

<body>

  <!--  Navigation -->
  <%@include file="navigation.jsp"%>

  <div class="container">

    <br> <br> <a href="<%=request.getContextPath()%>">Home</a>
    > <a href="/Exploration/register">Register</a> <br>
    <h2>Sign In Page!</h2>

    <br>

    <!-- Register -->
    <!-- ---------------------------------------------------------------------------------------------------- -->
    <form:form action="/Exploration/register" method="POST" modelAttribute="user">
      <form:input type="hidden" path="id" id="id"/>
      <table>
        <tr>
          <td><label for="firstName">First Name: </label></td>
          <td><form:input path="firstName" id="firstName" /></td>
          <td><form:errors path="firstName" cssClass="error" /></td>
        </tr>

        <tr>
          <td><label for="lastName">Last Name: </label></td>
          <td><form:input path="lastName" id="lastName" /></td>
          <td><form:errors path="lastName" cssClass="error" /></td>
        </tr>
        
        <tr>
          <td><label for="name">Username: </label></td>
          <td><form:input path="username" id="username" /></td>
          <td><form:errors path="username" cssClass="error" /></td>
        </tr>
        
        <tr>
          <td><label for="password">Password: </label></td>
          <td><form:input type="password" path="password" id="password" /></td>
          <td><form:errors path="password" cssClass="error" /></td>
        </tr>
        
        <tr>
          <td><input type="submit" value="Register" /></td>
        </tr>

      </table>
    </form:form>

  </div>
</body>
</html>