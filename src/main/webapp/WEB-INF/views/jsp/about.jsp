<html>

  <head>
    <title>About</title>
  </head>

  <body>
    <!--  Navigation -->
    <%@include file="navigation.jsp" %>
      
    <br>
    <br>
    <a href="<%=request.getContextPath()%>">Home</a> >
    <a href="about.html">About</a>
    <br>
    <h1>This is the about page</h1>
      
    <!--  Help module -->
    <div id="helpbox">
      <%@include file="help.jsp"%>
    </div>
    
    
  </body>
</html>