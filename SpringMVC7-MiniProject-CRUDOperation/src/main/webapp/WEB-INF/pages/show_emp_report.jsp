<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:choose>
	<c:when test="${!empty  listEmps}">
		<table align="center" bgcolor="cyan" border="1">
			<tr style="color: red">
				<th>Empno</th>
				<th>EmpName</th>
				<th>EmpJob</th>
				<th>Emp Salary</th>
				<th>Deptno</th>
				<th>Operations</th>
			</tr>
			<c:forEach var="emp" items="${listEmps}">
				<tr>
					<td>${emp.empno }</td>
					<td>${emp.ename }</td>
					<td>${emp.job }</td>
					<td>${emp.sal }</td>
					<td>${emp.deptno}</td>
					<td><a href="edit_employee?no=${emp.empno}"><img
							src="resources/images/edit.jpeg" width="30" height="30"></a>
						&nbsp;&nbsp; <a href="delete_employee?no=${emp.empno}"
						onclick="return confirm(' Do u want delete?')"><img
							src="resources/images/delete.jpeg" width="30" height="30"></a>
					</td>
				</tr>

			</c:forEach>
		</table>
	</c:when>
	<c:otherwise>
		<h1 style="color: red; text-align: center">Records not found</h1>
	</c:otherwise>
</c:choose>

<h1 style="text-align: center; color: green">${resultMsg }</h1>

<br>
<br>
<h1 style="color: red; text-align: center">
	<a href="add_employee"><img src="resources/images/add.jpeg"
		widht="50" height="50">Add Employee</a>
</h1>

<br>
<br>
<center>
	<a href="./"><img src="resources/images/home.jpeg" width="50"
		height="50">home</a>
</center>