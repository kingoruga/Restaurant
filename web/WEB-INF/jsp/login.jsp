<%-- 
    Document   : login
    Created on : Jan 25, 2018, 2:55:22 PM
    Author     : syntel
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Mummy's Restaurant</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/bootstrap.min.css" />
        <link href="css/signin.css" rel="stylesheet"/>
         <link rel="stylesheet" href="css/nav.css" />
          <link rel="stylesheet" href="css/manageusers.css" />
    </head>
    <body>
        <div>
            <div id="mainContainer" ></div>
            <div class="container">
                <form:form method="GET" modelAttribute="user" action="validate.htm">
                    <div class="form-signin">
                        <h2 class="form-signin-heading">Please sign in</h2>
                        <label class="sr-only"></label>
                        <form:input
                                path="email" type="email" class="form-control" name="email"
                                required="true"
                                aria-describedby="emailHelp" placeholder="Enter email"/>
                    <!--/div>
                    <div class="form-signin"-->
                        <label class="sr-only"></label>
                        <form:password path="password" class="form-control"
                                       required="true"
                                       placeholder="Password" name="password" />
                         <div class="checkbox">
                            <label>
                                <input type="checkbox" value="remember-me"> Remember me
                            </label>
                        </div>
                         <button id="submitBtn" type="submit" class="btn btn-lg btn-primary btn-block">Submit</button>
                          <br><div style="color: red">${error}</div>
                    </div>
                   
                   
                </form:form>
            </div>
        </div>
        <script>
            //define this here so that it can be used later
            var NavBar;
        </script>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="./js/react.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/babel-core/5.8.29/browser.js" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/reactstrap/4.8.0/reactstrap.min.js" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/js/bootstrap.min.js" integrity="sha384-a5N7Y/aK3qNeh15eJKGWxsqtnX/wWdSZSKp+81YjTmS15nvnvxKHuzaWwXHDli+4" crossorigin="anonymous"></script>
        <script src="js/Navbar.js" type="text/babel" ></script>
        <script type="text/babel">
            var testUser = ${userObj};
            React.render(<NavBar user={testUser} />, document.getElementById( "mainContainer" ));
        </script>
    </body>
</html>


