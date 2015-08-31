<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Reports</title>
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
    <a href="/Exploration/reports">Reports</a>
    <br>
    <hr/>
    <br>
    <div class="dropdown">
      <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
        Pick a report to view
        <span class="caret"></span>
      </button>
      <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
        <li><a href="#">Game Scores</a></li>
        <li><a href="/Exploration/reports/listUsers">List of Registered Users</a></li>
        <li><a href="#">List of Admins</a></li>
      </ul>
    </div>
    <br><br>
    <div id="report-result" style="display: ${display };">
      <h3 style="text-align: center;"><span class="label label-default">Reports for ${title }</span></h3>
      <br>
      ${report }
    </div>
  </div>
</body>
</html>