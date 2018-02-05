<%-- 
    Document   : editavs
    Created on : Jan 31, 2018, 6:21:21 PM
    Author     : syntel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
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
        <c:url var="actionUrl" value="editav.htm"/>
        <form:form method="POST" action="${actionUrl}" modelAttribute="editav"> 
	<table>
            <tr>
		<th>Zip Code</th>
		<th>Breakfast/Lunch/Dinner</th>
		<th>Start Date</th>
		<th>End Date</th>		
            </tr>
            <c:forEach items="${editav.av}" var="avail" varStatus="status">
                    <tr>                        
			
			<td><input name="av[${status.index}].zip" value="${avail.zip}"/></td>
			<td><input name="av[${status.index}].meal" value="${avail.meal}"/></td>
			<td><input name="av[${status.index}].start_date" value="${avail.start_date}"/></td>
			<td><input name="av[${status.index}].end_date" value="${avail.end_date}"/></td>
                    </tr>
                </c:forEach>
                <tr> 
                    <td colspan="2">
                    <input type="submit" value="Commit Changes"></td> 
                </tr> 
            </table>	
            <br/>
            
	
        </form:form>

    </body>
</html>
