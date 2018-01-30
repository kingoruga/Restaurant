<%-- 
    Document   : register
    Created on : Jan 25, 2018, 11:52:33 AM
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
        <!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/css/bootstrap.min.css" crossorigin="anonymous"> -->
        <link rel="stylesheet" href="./css/bootstrap.min.css" />
        <style>
            /* add stylesheet */
            h4 { margin-top: 24px; }
            form button { margin-bottom: 24px; }
        </style>
    </head>
    <body>
        <div>
            <div id="navbar"></div>
            <div class="container">

            <div class="page-header">
                <H2>Registration</H2>
            </div>
            <p>Register as a customer. All fields are required to be filled out for successful registration.</p>
            <hr>
            <form:form method="POST" commandName="userModel">

                <h4>Login information</h4>
                <div class="form-group">
                    <label for="email">Email address</label>
                    <form:input path="email" required="true" type="email" cssClass="form-control" id="email" placeholder="name@example.com" />
                </div>
                
                <div class="form-group">
                    <label for="password">Password</label>
                    <form:password path="password" required="true" class="form-control" id="password" placeholder="Password" />
                </div>

                <h4>Personal details</h4>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="firstname">First name</label>
                        <form:input path="firstName" required="true" type="text" class="form-control" id="firstname" placeholder="First name" />
                    </div>
                    <div class="form-group col-md-6">
                        <label for="lastname">Last name</label>
                        <form:input path="lastName" required="true" type="text" class="form-control" id="lastname" placeholder="Last name" />
                    </div>
                </div>

                <h4>Address information</h4>
                <div class="form-row">
                    <div class="form-group col-md-5">
                        <label for="address">Street address</label>
                        <form:input path="address.street1" required="true" type="text" class="form-control" id="address" placeholder="1234 Main St" />
                    </div>

                    <div class="form-group col-md-3">
                        <label for="city">City</label>
                        <form:input path="address.city" required="true" type="text" class="form-control" id="city" />
                    </div>
                    <div class="form-group col-md-2">
                        <label for="state">State</label>
                        <form:select path="address.state" id="state" class="form-control">
                            <option value="AK">Alaska</option>
                            <option value="AL">Alabama</option>
                            <option value="AR">Arkansas</option>
                            <option value="AZ">Arizona</option>
                            <option value="CA">California</option>
                            <option value="CO">Colorado</option>
                            <option value="CT">Connecticut</option>
                            <option value="DC">District of Columbia</option>
                            <option value="DE">Delaware</option>
                            <option value="FL">Florida</option>
                            <option value="GA">Georgia</option>
                            <option value="HI">Hawaii</option>
                            <option value="IA">Iowa</option>
                            <option value="ID">Idaho</option>
                            <option value="IL">Illinois</option>
                            <option value="IN">Indiana</option>
                            <option value="KS">Kansas</option>
                            <option value="KY">Kentucky</option>
                            <option value="LA">Louisiana</option>
                            <option value="MA">Massachusetts</option>
                            <option value="MD">Maryland</option>
                            <option value="ME">Maine</option>
                            <option value="MI">Michigan</option>
                            <option value="MN">Minnesota</option>
                            <option value="MO">Missouri</option>
                            <option value="MS">Mississippi</option>
                            <option value="MT">Montana</option>
                            <option value="NC">North Carolina</option>
                            <option value="ND">North Dakota</option>
                            <option value="NE">Nebraska</option>
                            <option value="NH">New Hampshire</option>
                            <option value="NJ">New Jersey</option>
                            <option value="NM">New Mexico</option>
                            <option value="NV">Nevada</option>
                            <option value="NY">New York</option>
                            <option value="OH">Ohio</option>
                            <option value="OK">Oklahoma</option>
                            <option value="OR">Oregon</option>
                            <option value="PA">Pennsylvania</option>
                            <option value="PR">Puerto Rico</option>
                            <option value="RI">Rhode Island</option>
                            <option value="SC">South Carolina</option>
                            <option value="SD">South Dakota</option>
                            <option value="TN">Tennessee</option>
                            <option value="TX">Texas</option>
                            <option value="UT">Utah</option>
                            <option value="VA">Virginia</option>
                            <option value="VT">Vermont</option>
                            <option value="WA">Washington</option>
                            <option value="WI">Wisconsin</option>
                            <option value="WV">West Virginia</option>
                            <option value="WY">Wyoming</option>
                        </form:select>
                    </div>
                    <div class="form-group col-md-2">
                        <label for="zip">Zip</label>
                        <form:input path="address.zip" required="true" type="number" class="form-control" id="zip" />
                    </div>
                </div>
                <hr />
                <button type="submit" class="btn btn-primary btn-block">Register</button>
            </form:form>
        </div>
        </div>
        <script>
            var NavBar;
        </script>
        <script src="./js/react.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/babel-core/5.8.29/browser.js" crossorigin="anonymous"></script>
        <script src="./js/Navbar.js" type="text/babel" ></script>
        <script type="text/babel">
            var user = eval(${user});
            React.render(
                <div>
                    <NavBar user={user} />
                </div>
            , document.getElementById( "navbar" ))
        </script>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/js/bootstrap.min.js" integrity="sha384-a5N7Y/aK3qNeh15eJKGWxsqtnX/wWdSZSKp+81YjTmS15nvnvxKHuzaWwXHDli+4" crossorigin="anonymous"></script>
    </body>
</html>
