<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login</title>
<style></style>
</head>
<body>
  <div class="container">
    <h2>Login Here</h2>
    ${Error}
    <form action="verifyLogin" method="post">
      Email-id:<input type="text" name="emailId"/>
      Password:<input type="password" name="password"/>
      <input type="submit" value="Login"/>
    </form>
  </div>
</body>
</html>
