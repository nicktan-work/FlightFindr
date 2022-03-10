<%@page import="java.util.ArrayList"%>
<%@page import="ca.sait.flightfindr.models.Flight"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Flight Findr - Book a Flight</title>

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
                            <a class="nav-link" href="/flights">Flights</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="/booking">Book a Flight</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        
        <div class="container">

            <div class="row mt-3 justify-content-center">
                <div class="col-8">
                    <div class="card">
                        <div class="card-body">
                            <h1 class="text-center">Book Flight</h1>
                            
                            <% if (request.getAttribute("error") != null) { %>
                            <div class="alert alert-danger" role="alert">
                                ${error}
                            </div>
                            <% } %>
                            
                            <form action="booking" method="get">
                                <div class="row mb-3">
                                    <label for="code" class="col-2 col-form-label text-end">Flight code</label>
                                    <div class="col-8">
                                        <input type="text" class="form-control" name="code" id="code" placeholder="AB-1234" value="${code}">
                                    </div>
                                    <div class="col">
                                        <button class="btn btn-primary" type="submit">Book</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                    <% if (request.getAttribute("lastFourDigits") != null && request.getAttribute("cost") != null) { %>
                    <div class="card mt-3">
                        <div class="card-body text-center">
                            <h1>Payment Successful</h1>
                            <p>Your credit card number (ending in ${lastFourDigits}) was charged ${cost}.</p>
                            <p><a href="flights" class="btn btn-link">&larr; Go Back</a></p>
                        </div>
                    </div>
                    <% } %>
                </div>
            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
    </body>
</html>
