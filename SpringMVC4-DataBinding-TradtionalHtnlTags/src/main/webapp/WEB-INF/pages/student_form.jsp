<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<h1 style="color: red; text-align: center">Student Registration
	page</h1>
<form action="student" method="POST">
	<table align="center" bgcolor="cyan">
		<tr>
			<td>Student no::</td>
			<td><input type="text" name="sno"></td>
		</tr>
		<tr>
			<td>Student name::</td>
			<td><input type="text" name="sname"></td>
		</tr>
		<tr>
			<td>Student address::</td>
			<td><input type="text" name="sadd"></td>
		</tr>
		<tr>
			<td>Student avg::</td>
			<td><input type="text" name="avg"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="register"></td>
		</tr>
	</table>
</form>
</body>
</html>