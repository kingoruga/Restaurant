<%-- 
    Document   : register
    Created on : Jan 25, 2018, 12:02:20 PM
    Author     : syntel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<!DOCTYPE html>
<html>
    <style>
        .error {
         color: #ff0000;
        font-style: italic;
        }
    </style>
    <head>
        <title>Mummy's Restaurant</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/bootstrap.min.css" />
        <script>var NavBar;</script>
        <script src="js/react.min.js"></script>
        <script src="js/Navbar.js" type="text/babel" ></script>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/babel-core/5.8.29/browser.js" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/reactstrap/4.8.0/reactstrap.min.js" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/js/bootstrap.min.js" integrity="sha384-a5N7Y/aK3qNeh15eJKGWxsqtnX/wWdSZSKp+81YjTmS15nvnvxKHuzaWwXHDli+4" crossorigin="anonymous"></script>
        <script type="text/babel">React.render(<div><NavBar /></div>,document.getElementById( "mainContainer" ));</script>
    
    </head>
    <body>
        <div id="mainContainer"> </div>  
        <form:form method="POST" commandName="update" > 
        <table> 
            <tr> 
                <td>Name:</td> 
                <td><form:input path="name" value="${fooditem.name}" /></td> 
                <td><form:errors path="name" cssClass="error" /></td>
            </tr> 
            <tr> 
                <td>Description:</td> 
                <td><form:input path="description" value="${fooditem.description}" /></td> 
                <td><form:errors path="description" cssClass="error" /></td>
            </tr> 
            <tr> 
                <td>Price :</td> 
                <td><form:input path="price" value="${fooditem.price}"/></td> 
                <td><form:errors path="price" cssClass="error" /></td>
            </tr> 
            <tr> 
                <td>Type :</td> 
                <td><form:input path="type" value="${fooditem.type}" /></td> 
                <td><form:errors path="type" cssClass="error" /></td>
            </tr> 
            <tr> 
                <td>Vegetarian? :</td> 
                <td><form:input path="veg" value="${fooditem.veg}" /></td> 
                <td><form:errors path="veg" cssClass="error" /></td>
            </tr> 
            <tr> 
                <td colspan="2">
                <input type="submit"></td> 
            </tr> 
        </table> 
        </form:form>
    </body>
</html>