<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>studentDetail jsp</title>
</head>
<body>
<h2>studentDetail.jsp</h2>
<h2>${message}</h2>


<h3>${msg}</h3>

<table border="1">
<tr><td>Roll NO</td><td>Name</td><td>Address</td></tr>
<tr><td>${studentDetail.rollno}</td><td>${studentDetail.name}</td><td>${studentDetail.add}</td></tr>



</body>
</html>