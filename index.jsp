<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Aditya < Alex Co.</title>
</head>
<body>
	<div class="container">
    <h1>Submit Employee Data</h1>
    <p>Please fill in this form to submit an Employee.</p>
    <hr>

    <form method = "post" action = "UploadFormDataController">
    	<label for="first"><b>First Name</b></label>
    <input type="text" placeholder="First Name" name="first" required>

    <label for="last"><b>Last Name</b></label>
    <input type="text" placeholder="Last Name" name="last" required>
    
     <label for="dpt"><b>Employee Department</b></label>
    <input type="text" placeholder="Dpt." name="dpt" required>

	 <label for="salary"><b>Employee Salary</b></label>
    <input type="text" placeholder="Salary" name="salary" required>
    
    <p>By clicking submit, you agree that Alex < Aditya</p>
    <button type="submit" class="submit">Submit</button>
    </form>
    

    
  </div>
</body>
</html>