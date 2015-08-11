<html>
<head>
  <title>Home</title>
  <!-- javascript and css -->
  <%@include file="includes.jsp"%>
  
</head>

<body>
  <!--  Navigation -->
  <%@include file="navigation.jsp"%>
  
  <div class="container">
    <div class="jumbotron">
      <h1>Lets Explore!</h1>

      <h2>${welcomeMessage}</h2>
    
      <!--  Help module -->
      <%@include file="help.jsp"%>
<%--       	<table>
			<tr>
				<td>ID</td><td>first name</td><td>last name</td><td>username</td><td>password</td><td>role</td><td></td>
			</tr>
		    <c:forEach items="${users}" var="user">
				<tr>
					<td>${user.id}</td>
					<td>${user.firstName}</td>
					<td>${user.lastName}</td>
                    <td>${user.username}</td>
                    <td>${user.password}</td>
                    <td>${user.role}</td>			
				</tr>
			</c:forEach>
		</table> --%>
      
    </div>

  </div>

</body>

</html>