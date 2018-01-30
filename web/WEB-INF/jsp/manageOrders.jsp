<%-- 
    Document   : manageOrders
    Created on : Jan 25, 2018, 1:57:38 PM
    Author     : syntel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Mummy's Restaurant</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/bootstrap.min.css" />
    </head>
    <body>
        <div id="mainContainer">
        </div>
        <script>
            //define this here so that it can be used later
            var NavBar;
            var OrderTable;
            var OrderRow;
        </script>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="js/react.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/babel-core/5.8.29/browser.js" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/reactstrap/4.8.0/reactstrap.min.js" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/js/bootstrap.min.js" integrity="sha384-a5N7Y/aK3qNeh15eJKGWxsqtnX/wWdSZSKp+81YjTmS15nvnvxKHuzaWwXHDli+4" crossorigin="anonymous"></script>
        <script src="js/Navbar.js" type="text/babel" ></script>
        <script src="js/manageOrders.js" type="text/babel" ></script>
        <script type="text/babel">
        //change the following to test out whether the navbar changes correctly
        var testUser = {};
        testUser.email = "tester@email.com";
        testUser.isAdmin = true;
        //this changes what gets shown on the navbar with My Orders
        testUser.orderCount = 10;
        //get the order list from what the java controller passed
        var ordersList = ${orderList};
        console.log( ordersList );

        React.render(
                <div>
                    <NavBar user={testUser} />
                    <OrderTable orders={ordersList} />
                </div>
            , document.getElementById( "mainContainer" )
        );
        </script>
    </body>
</html>
