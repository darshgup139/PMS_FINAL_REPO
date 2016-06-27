<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<H2>CSV download option</H2>
	<form action="testCSV" method="get">
		<input type="text" name="companyname" value="JP Morgan" hidden/>
		<input type="text" name="year" value="2016" hidden/>
	  <input type="checkbox" name="columns" value="BRANCH" checked/>BRANCH<br>
	  <input type="checkbox" name="columns" value="EMAIL" checked/>EMAIL<br>
	  <input type="checkbox" name="columns"  value="CONTACT" checked/>CONTACT<br>
	  <input type="checkbox" name="columns" value="SSC" />SSC<br>
	  <input type="checkbox" name="columns" value="HSC" />HSC<br>
	  <input type="checkbox" name="columns" value="CGPA" />CGPA<br>
	  <input type="checkbox" name="columns" value="CORRESPONDENCE ADDRESS" />CORRESPONDENCE ADDRESS<br>
	  <input type="submit" value="download"/>
	</form>
	
	<hr/>
	
<H2>SCSV download option</H2>
	<form action="testSCSV" method="get">
		<input type="text" name="companyname" value="JP Morgan" hidden/>
		<input type="text" name="year" value="2016" hidden/>
	  <input type="checkbox" name="columns" value="BRANCH" checked/>BRANCH<br>
	  <input type="checkbox" name="columns" value="EMAIL" checked/>EMAIL<br>
	  <input type="checkbox" name="columns"  value="CONTACT" checked/>CONTACT<br>
	  <input type="checkbox" name="columns" value="SSC" />SSC<br>
	  <input type="checkbox" name="columns" value="HSC" />HSC<br>
	  <input type="checkbox" name="columns" value="CGPA" />CGPA<br>
	  <input type="checkbox" name="columns" value="CORRESPONDENCE ADDRESS" />CORRESPONDENCE ADDRESS<br>
	  <input type="submit" value="download"/>
	</form>
</body>	
</body>
</body>
</html>