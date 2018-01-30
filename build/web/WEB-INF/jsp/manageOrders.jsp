<%-- 
    Document   : manageOrders
    Created on : Jan 25, 2018, 2:57:17 PM
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
        <div id="mainContainer">
        </div>
        <table class="table table-striped">
            <thead class="thead-dark">
                <th>Order ID</th>
                <th>Email</th>
                <th>Name</th>
                <th>Address</th>
                <th>Price</th>
                <th>Payment</th>
            </thead>
            <tr>
                <td>1000</td>
                <td>john@email.com</td>
                <td>John Doe</td>
                <td>1234 Main Street</td>
                <td>20.00</td>
                <td>Cash</td>
            </tr>
            <tr>
                <td>1001</td>
                <td>jane@email.com</td>
                <td>Jane Doe</td>
                <td>123456 Main Street</td>
                <td>25.99</td>
                <td>Card</td>
            </tr>
        </table>
    </body>
</html>
