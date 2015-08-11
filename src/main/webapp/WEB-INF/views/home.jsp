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
				<td>ID</td><td>Page</td><td>Body</td><td></td>
			</tr>
		    <c:forEach items="${employees}" var="employee">
				<tr>
					<td>${employee.id}</td>
					<td>${employee.pageTitle}</td>
					<td>${employee.helpMessage}</td>				
				</tr>
			</c:forEach>
		</table> --%>
      
    </div>

  </div>

</body>

</html>