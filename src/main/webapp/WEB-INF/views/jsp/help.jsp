<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="<c:url value="/resources/core/js/main.js" />"></script>
<div id="helpbox">
    <table style="width: 500px;">
	  <tr>
	    <td onclick="expandCollapse('showHide');" id="expand">[+] Need Help?</td>
	  </tr>
	</table>
  <div id="showHide" style="display: none;">
  	<p> Testing help hiding and showing. </p>
	<h2>${helpTitle}</h2>
	<p>${helpBody}</p>
  </div>
</div>