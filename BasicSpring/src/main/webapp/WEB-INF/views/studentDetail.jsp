<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<h2>Student Roll No=${rollno}

<table border="1">
<tr><td>Roll NO</td><td>Name</td><td>Address</td></tr>
<tr><td>${studentDetail.rollno}</td><td>${studentDetail.name}</td><td>${studentDetail.add}</td></tr>



</table>
</body>
</html>