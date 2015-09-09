<!DOCTYPE html>
<html>
<head>
  <title>About</title>
  <!-- javascript and css -->
  <%@include file="includes.jsp"%>
</head>

<body>
  <!--  Navigation -->
  <%@include file="navigation.jsp"%>

  <div class="container">
    <br>
    <br>
    <a href="<%=request.getContextPath()%>">Home</a> >
    <a href="/Exploration/about">About</a>
    <br>
    <hr/>
    <br>
    
    <div id="desc">
      <h2>LETS(Learn Exploratory Testing System)</h2><br>
      <p>
        Often times during the software development process, requirements or specifications aren't always present. There are also cases where the complexity of
        an application doesn't allow scripted/automated testing to cover different state transitions of the software. Exploratory testing is used in these cases
        where the tester uses black-box techniques to manually test the application.
      </p>
      <p>
        LETS was created to teach exploratory testing in a controlled environment. This application gives testers a starting point to go through the testing
        process.
      </p>
      <p><a href="https://en.wikipedia.org/wiki/Exploratory_testing">Find more about Exploratory Testing</a></p>
    </div>

  
    <br>
    <hr/>
    <br>
    <!--  Help module -->
    <div id="helpbox">
      <%@include file="help.jsp"%>
    </div>

  </div>

</body>
</html>