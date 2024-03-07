<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:include page="design.jsp"/>
    <%
String msg = (String)request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert person details</title>
<style type=text/css>
table { 
border : 1px solid black;
}
</style>
</head>
<body>
<div align="center">
		<form action="./insert" method="post">
			<fieldset>
				<legend>Person Details</legend>
				<table>
					<tr>
						<td>Name</td>
						<td><input type="text" name="name"></td>
					</tr>
					<tr>
						<td>Email</td>
						<td><input type="text" name="email"></td>
					</tr>
					
				</table>
			</fieldset>
			<input type="submit" value="Insert">
		</form>

		<%
		if (msg != null) {
		%>
		<h3><%=msg%></h3>
		<%
		}
		%>
	</div>

</body>
</html>