<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="add.htm">新增</a>
	<a href="list.htm">list</a>
	<p>total:${count}</p>
	<form action="list.htm" method="post">
		<table>
			<tr>
				<td>id</td>
				<td><input type="text" name="id" value="${param.id}"></td>
			</tr>
			<tr>
				<td>name</td>
				<td><input type="text" name="name" value="${param.name}"></td>
			</tr>
			<tr>
				<td>age</td>
				<td><input type="text" name="age" value="${param.age}"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="submit"></td>
			</tr>
		</table>
	</form>
	<table>
		<tr>
			<td>ID</td>
			<td>name</td>
			<td>age</td>
		</tr>
		<c:forEach items="${persons}" var="person">
			<tr>
				<td>${person.id}</td>
				<td>${person.name}</td>
				<td>${person.age}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>