<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Search Flights</title>
<style></style>
</head>
<body>
  <div class="container">
    <h2>Find Flights</h2>
    <form action="findFlights" method="post">
      from:<input type="text" name="from"/>
      to:<input type="text" name="to"/>
      departure date:<input type="text" name="departureDate"/>
      <input type="submit" value="Search"/>
    </form>
  </div>
</body>
</html>
