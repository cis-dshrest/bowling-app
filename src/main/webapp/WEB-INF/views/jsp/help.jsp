<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript" src="<c:url value="/resources/core/js/main.js" />"></script>
<script type="text/javascript" src=http://code.jquery.com/jquery-2.1.4.min.js></script>
<div id="helpbox">
    <table style="width: 500px;">
	  <tr>
	    <td onclick="expandCollapse('showHide');" id="expand">[+] Need Help?</td>
	  </tr>
	</table>
  <div id="showHide" style="display: none;">
	<div id="helpBody" name="helpBody"></div>
  
  </div>
</div>
