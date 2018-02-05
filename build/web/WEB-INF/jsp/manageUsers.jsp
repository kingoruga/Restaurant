<%-- 
    Document   : manageUsers
    Created on : Jan 25, 2018, 2:58:42 PM
    Author     : syntel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<!DOCTYPE html>
<html>
    <head>
        
        <title>Mummy's Restaurant</title>
          <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/bootstrap.min.css" />


    </head>
    <body>   
         <div id="mainContainer"></div>
         <form:form class="form-group"  method="GET"   modelAttribute="user" > 
          <table class="table table-striped">
                <thead class="thead-dark">
                    <th>User ID</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Admin</th>
                    <th>Banned</th>
                    <th>Action</th>               
                </thead>   
           
         
       <c:forEach items="${users}" var="user" >    
           
             <tr>
                    <td>${user.userId}</td>
                    <td>${user.firstName}</td>
                     <td>${user.lastName}</td>
                    <td>${user.email}</td>
                    <td>${user.isAdmin}</td>
                    <td>${user.isBanned}</td>
                    <td>
                        <div class="btn-group">
                            <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                 Manage User
                            </button>
                            <div class="dropdown-menu">

                                <a class="dropdown-item" href="enable.htm?email=${user.email}" >Enable</a>
                                <a class="dropdown-item" href="disable.htm?email=${user.email}">Disable</a>
                                <a class="dropdown-item" href="changepassword.htm">Change Password</a>
                                    <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="delete.htm?email=${user.email}" >Delete User</a>
                            </div>
                        </div>
                  </td>
         </tr>
      </c:forEach>
    </table>
           </form:form>
          <script>
            var NavBar;
         </script>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/reactstrap/4.8.0/reactstrap.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/js/bootstrap.min.js" integrity="sha384-a5N7Y/aK3qNeh15eJKGWxsqtnX/wWdSZSKp+81YjTmS15nvnvxKHuzaWwXHDli+4" crossorigin="anonymous"></script>
        <script src="./js/react.min.js"></script>
        <script src="./js/Navbar.js" type="text/babel" ></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/babel-core/5.8.29/browser.js"></script>   
        <script type="text/babel">
       
          

        var testUser = {};
        testUser.email = "tester@email.com";
        testUser.isAdmin = true;
        
        
       React.render(
                     <NavBar user={testUser} />
                ,document.getElementById("mainContainer")
        );
        </script>
    </body>
</html>

