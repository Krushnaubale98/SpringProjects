<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<h1 style="color: red; text-align: center">Register the Employee</h1>
<form:form action="add_employee" method="POST" modelAttribute="emp">
	<table align="center" border="0" bgcolor="cyan">
		<tr>
			<td>Emp name::</td>
			<td><form:input path="ename" />
		</tr>
		<tr>
			<td>Emp job::</td>
			<td><form:input path="job" />
		</tr>
		<tr>
			<td>Emp salary::</td>
			<td><form:input path="sal" />
		</tr>
		<tr>
			<td>Emp deptno::</td>
			<td><form:input path="deptno" />
		</tr>
		<tr>
			<td><input type="submit" value="Regsiter Employee"></td>
			<td><input type="reset" value="clear"></td>
		</tr>

	</table>
</form:form>