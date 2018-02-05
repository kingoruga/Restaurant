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
         <link rel="stylesheet" href="css/nav.css" />
        <script>
            var NavBar;
            var testUser = ${user};       
        </script>
        <script src="js/react.min.js"></script>
        <script src="js/Navbar.js" type="text/babel" ></script>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/babel-core/5.8.29/browser.js" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/reactstrap/4.8.0/reactstrap.min.js" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/js/bootstrap.min.js" integrity="sha384-a5N7Y/aK3qNeh15eJKGWxsqtnX/wWdSZSKp+81YjTmS15nvnvxKHuzaWwXHDli+4" crossorigin="anonymous"></script>
        <script type="text/babel">React.render(
                    <div>
                        <NavBar user={testUser} />
                    </div>,
                    document.getElementById( "mainContainer" ));
        </script>
    
    </head>
    
    <body>                
         <div id="mainContainer"> </div> 
        <c:url var="actionUrl" value="/availability.htm"/>
        <form:form method="POST" action="${actionUrl}" modelAttribute="availability"> 
        <table> 
            <tr> 
                <td>Zip Code:</td> 
                <td><form:input path="zip" /></td> 
                <td><form:errors path="zip" cssClass="error" /></td>
            </tr> 
            <tr> 
                <td>Meal Availability:</td> 
                <td><form:input path="meal" /></td> 
                <td><form:errors path="meal" cssClass="error" /></td>
            </tr> 
            <tr> 
                <td>Start Date :</td> 
                <td><form:input path="start_date" type="date" /></td> 
                <td><form:errors path="start_date" cssClass="error" /></td>
            </tr> 
            <tr> 
                <td>End Date :</td> 
                <td><form:input path="end_date" type="date"/></td> 
                <td><form:errors path="end_date" cssClass="error" /></td>
            </tr>            
            <tr> 
                <td colspan="2">
                <input type="submit" value="Add Availability"></td> 
            </tr> 
        </table> 
        </form:form>
                
    </body>
</html>
