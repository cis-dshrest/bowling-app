<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<style>
nav>ul { list-style-type:none;
    margin: 0;
    padding: 0;
  }
  
nav ul>li {
    display: inline;
}
 
</style>
<nav>
 <ul>
   <li><a href="<%=request.getContextPath()%>">Home</a></li>
   <li><a href="about.html">About</a></li>
   <li><a href="signin.html">Sign In</a></li>
   <li><a href="admin.html">Admin</a></li>
   <li><a href="newgame.html">New Game</a></li>
   <li><a href="viewgame.html">View Game</a></li>
   <li><a href="signout.html">Sign Out</a></li>
   <li><a href="profile.html">Name</a></li>
 </ul>
</nav>

