<%-- 
    Document   : registerSuccess
    Created on : Jan 25, 2018, 11:58:19 AM
    Author     : syntel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="/">Home</a>
        <p>Registration successful </p>
        <hr />
        <p>First: ${user.firstName}</p>
        <p>Last: ${user.lastName}</p>
        <p>Email: ${user.email}</p>
        <p>Password: ${user.password}</p>
        <p>Address street: ${user.address.street1}</p>
        <p>Address city: ${user.address.city}</p>
        <p>Address state: ${user.address.state}</p>
        <p>Address zip: ${user.address.zip}</p>
    </body>
</html>
