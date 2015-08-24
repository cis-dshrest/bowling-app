<html>
<head>
<title>Create Game</title>
<!-- javascript and css -->
<%@include file="includes.jsp"%>

</head>

<body>

  <!--  Navigation -->
  <%@include file="navigation.jsp"%>

  <div class="container">
    <br> <br> <a href="<%=request.getContextPath()%>">Home</a>
    > <a href="/Exploration/user/game/new">Create Game</a> <br>
    <!-- New game form -->

    <h4>${username } | Create a New Game</h4>
    <br>

    <form class="" action='<c:url value="/user/game/view" />'
      method="GET">

      <!-- Game Title -->
      <div>
        <label class=" " for="gameTitle">Game Title: </label>
        <input class=" " type="text" id="gameTitle" name="gameTitle"/>
      </div>
      <br>
      <h5>Add other players:</h5>
      <br>
      <!-- List of users to add -->
      <table class="table">
        <tr>
          <td>First Name</td>
          <td>Last Name</td>
          <td>Username</td>
          <td>Add</td>
        </tr>
        <c:forEach items="${users}" var="user">
          <tr>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.username}</td>
            <td><input type="checkbox" name="addUser"
              value="${user.username }"> <span
              class="glyphicon glyphicon-user"></span></td>
          </tr>
        </c:forEach>
      </table>
      
      <input class="btn btn-success" type="submit"  value="Play" />
    </form>
    <!-- End new game form -->

    <!--  Help module -->
    <div id="helpbox">
      <%@include file="help.jsp"%>
    </div>
  </div>

</body>
</html>