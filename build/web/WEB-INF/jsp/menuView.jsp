<%-- 
    Document   : menuView
    Created on : Jan 25, 2018, 2:59:29 PM
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
            var ItemTable;
            var ItemRow;
        </script>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="./js/react.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/babel-core/5.8.29/browser.js" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/reactstrap/4.8.0/reactstrap.min.js" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/js/bootstrap.min.js" integrity="sha384-a5N7Y/aK3qNeh15eJKGWxsqtnX/wWdSZSKp+81YjTmS15nvnvxKHuzaWwXHDli+4" crossorigin="anonymous"></script>
        <script src="js/Navbar.js" type="text/babel" ></script>
        <script src="js/menuView.js" type="text/babel" ></script>
        <script type="text/babel">
        //change the following to test out whether the navbar changes correctly
        var testUser = {};
        testUser.email = "tester@email.com";
        testUser.isAdmin = true;
        testUser.orderInProgress = true;
        
        var itemsList = [
            {
                "name" : "Chicken Tikka Masala",
                "price" : 10.00,
                "des" : "Chicken marinated in a Yogurt tomato sauce. Creamy texture.",
                "veg" : "No",
                "image": <image src="https://upload.wikimedia.org/wikipedia/commons/thumb/f/fd/Chicken_tikka_masala.jpg/90px-Chicken_tikka_masala.jpg"/>
                
            },
            {
                "name" : "Kofta",
                "price" : 8.00,
                "des" : "Gram flour balls fried with vegetables. Gram flour, veggies, rolled into balls with gram flour and fried in oil and then cooked with curry.", 
                "veg" : "Yes",
                "image": <image src="https://upload.wikimedia.org/wikipedia/commons/thumb/5/54/Paneer_Kofta_Curry_-_Kolkata_2011-09-20_5426.JPG/120px-Paneer_Kofta_Curry_-_Kolkata_2011-09-20_5426.JPG"/>
                
            },
            {
                "name" : "Chana Masala",
                "price" : 9.00,
                "des" : "Chickpeas of the Chana type in tomato based sauce.", 
                "veg" : "Yes",
                "image": <image src="https://upload.wikimedia.org/wikipedia/commons/thumb/0/02/Choleindia.jpg/120px-Choleindia.jpg"/>
                
            }
        ];

        React.render(
                <div>
                    <NavBar user={testUser} />
                    <ItemTable items={itemsList} />
                </div>
            , document.getElementById( "mainContainer" )
        );
        </script>
    </body>
</html>

