<html>
  <head>
    <title>Home</title>
  </head>
  
  <body>
      <!--  Navigation -->
      <%@include file="navigation.jsp" %>
      
    <h1>Lets Explore!</h1>
    
    <h2>${welcomeMessage}</h2>
    
    <!--  Help module -->
    <div id="helpbox">
      <%@include file="help.jsp"%>
    </div>
  
  </body>
</html>