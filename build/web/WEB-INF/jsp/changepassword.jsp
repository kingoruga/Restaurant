<%-- 
    Document   : delete
    Created on : Jan 29, 2018, 1:51:33 PM
    Author     : syntel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
     <head>
        
        <title>Mummy's Restaurant</title>
          <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/bootstrap.min.css" />
         <link rel="stylesheet" href="css/manageusers.css" />

    </head>
    <body>
         <div id="mainContainer"></div>
         <div id="my-div">
      
        <form:form class="form-group"  method="GET"  action="changepassword.htm"  modelAttribute="user" > 
                         <form:label path="email">Enter User Email:</form:label> 
                         <form:input path="email" />
                         <!--input type="text" name="email"  class="form-control"  required={true}/> <br-->
                         <br><form:label path="password">Enter New password:</form:label> 
                         <form:password path="password" />
                        <!--input type="password" name="password"  class="form-control"  required={true}/> <br-->
                        <br><br><input type="submit" value="Submit" class="btn btn-primary" onclick="showToast()"/> 
        </form:form>
                        
                        <div id="toast">The password has been updated</div>
                        
                        <script>
                            function showToast() {
                                 var x = document.getElementById("toast")
                                 x.className = "show";
                                    setTimeout(function(){ x.className = x.className.replace("show", ""); }, 4000);
                            }
                        </script>
             
             
             
             
        </div>
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
