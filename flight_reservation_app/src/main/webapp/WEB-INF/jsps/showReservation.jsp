<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Reservation Details</title>
<style></style>
</head>
<body>
  <div class="container">
    <h2>Flight Details</h2>
    FlightNumber: ${flight.flightNumber}<br>
    Operating Airlines: ${flight.operatingAirlines}<br>
    Departure City: ${flight.departureCity}<br>
    Arrival City: ${flight.arrivalCity}<br>
    Date of Departure: ${flight.dateOfDeparture}<br>
    Estimated Departure Time: ${flight.estimatedDepartureTime}
    
    <h2>Enter Passenger Details</h2>
    <form action="completeReservation" method="post">
      FirstName: <input type="text" name="firstName"/>
      LastName: <input type="text" name="lastName"/>
      MiddleName: <input type="text" name="middleName"/> 
      Email: <input type="text" name="email"/>
      Phone: <input type="text" name="phone"/>
      <input type="hidden" name="flightId" value="${flight.id}"/>
      
      <h2>Enter Card Details</h2>
      Account Holder Name: <input type="text" name="accountHolderName"/>
      Card Number: <input type="text" name="cardNumber"/>
      CVV: <input type="text" name="cvv"/>
      Expiry Date: <input type="text" name="expiryDate"/>
      
      <input type="submit" value="Complete Reservation"/>
    </form>
  </div>
</body>
</html>
