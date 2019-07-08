<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<form action ="/addPerson" method ="post">	
			<label >Enter Person Information</label><br>
			<label>Enter name</label>
			<input type ="text" name = "personName" required="required"><br>
			<label>Enter age</label>
			<input type="number" name = "personAge" ><br>
			<input type="submit"> <br>
			<br>
			<br>
			</form>		
				
			<form action ="/addPet" method ="post">	
			<label >Enter Pet Information</label><br>
			<label>Enter name</label>
			<input type="text"  name= "petName" ><br>
			<label>Insert color</label>
			<input type="text" name = "petColor" ><br>
			<input type="submit"> <br>
			<br>
			<br>
			</form>	

			<form action ="/getPerson">
			<label >Click here to get person list</label>
			<input type="submit"> <br>
			<br>
			<br>
			</form>	
			
			<form action ="/getPet">
			<label >Click here to get pet list</label>
			<input type="submit"> <br>
			<br>
			<br>
		</form>		
</body>
</html>