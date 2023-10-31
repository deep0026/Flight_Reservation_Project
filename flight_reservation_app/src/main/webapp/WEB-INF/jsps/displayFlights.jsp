<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Display Flights</title>
<style></style>
</head>
<body>
  <div class="container">
    <h2>Flight Search Results</h2>
    <table>
      <tr>
        <th>flightNumber</th>
        <th>operatingAirlines</th>
        <th>departureCity</th>
        <th>arrivalCity</th>
        <th>dateOfDeparture</th>
        <th>estimatedDepartureTime</th>
        <th>Select Flight</th>
      </tr>
      <c:forEach var="findFlights" items="${findFlights}">
        <tr>
          <td>${findFlights.flightNumber}</td>
          <td>${findFlights.operatingAirlines}</td>
          <td>${findFlights.departureCity}</td>
          <td>${findFlights.arrivalCity}</td>
          <td>${findFlights.dateOfDeparture}</td>
          <td>${findFlights.estimatedDepartureTime}</td>
          <td><a href="showCompleteReservation?flightId=${findFlights.id}">select</a></td>
        </tr>
      </c:forEach>
    </table>
  </div>
</body>
</html>
