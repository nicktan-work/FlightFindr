<%@page import="java.util.ArrayList"%>
<%@page import="ca.sait.flightfindr.models.Flight"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Flight Findr</title>

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">

    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">Flight Findr</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="/flights">Flights</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/booking">Book a Flight</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        
        <div class="container">
            <div class="row justify-content-center mt-3">
                <div class="col-8">
                    <h1 class="text-center">Flights</h1>

                    <div class="card">
                        <div class="card-body">
                            <form action="flights" method="post" class="row gy-2 gx-3 align-items-center">
                                <div class="col-5">
                                    <input name="departure" type="text" class="form-control" id="departure" placeholder="Departing City" value="${departure}">
                                </div>
                                <div class="col-5">
                                    <input name="destination" type="text" class="form-control" id="destination" placeholder="Destination City" value="${destination}">
                                </div>
                                <div class="col-auto">
                                    <button type="submit" class="btn btn-primary">Search</button>
                                </div>
                            </form>
                        </div>
                    </div>

                </div>
            </div>

            <div class="row mt-3 justify-content-center">
                <div class="col-8">
                    <div class="card">
                        <div class="card-body text-center">
                            <% if (request.getAttribute("flights") != null) { %>
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th>Code</th>
                                        <th>Departure</th>
                                        <th>Destination</th>
                                        <th>Day</th>
                                        <th>Time</th>
                                        <th>Cost</th>
                                        <th>Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <% for (Flight flight : (ArrayList<Flight>) request.getAttribute("flights")) { %>
                                    <tr>
                                        <td><%= flight.getCode() %></td>
                                        <td><%= flight.getDeparture() %></td>
                                        <td><%= flight.getDestination() %></td>
                                        <td><%= flight.getDay() %></td>
                                        <td><%= flight.getTime() %></td>
                                        <td><%= String.format("$%.2f", flight.getCost()) %></td>
                                        <td><a href="booking?code=<%= flight.getCode() %>">Book</a></td>
                                    </tr>
                                    <% } %>
                                </tbody>
                            </table>
                            <% } %>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
    </body>
</html>
