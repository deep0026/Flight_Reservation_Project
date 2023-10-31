<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>New Registration</title>
<style></style>
</head>
<body>
  <div class="container">
    <h2>Create New Account</h2>
    <form action="saveReg" method="post">
      FirstName:<input type="text" name="firstName"/>
      LastName:<input type="text" name="lastName"/>
      Email:<input type="text" name="email"/>
      Password:<input type="password" name="password"/>
      <input type="submit" value="Save">
    </form>
  </div>
</body>
</html>
