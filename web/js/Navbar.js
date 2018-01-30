
/*
 * NavBar class
 * Properties:
 * user,object containing information on the currently logged in user
 *      pass as undefined if the user is not logged in
 */
NavBar = React.createClass({
    renderAdminNav: function()
    {
        return (
        <nav className="navbar sticky-top navbar-expand-lg navbar-light bg-dark">
            <a className="navbar-brand" href="index.htm">Mummy's Restaurant</a>
            <a className="nav-link text-light" href="menuView.htm">View Menu</a>
            <a className="nav-link text-light" href="myOrders.htm">My Orders({this.props.user.orderCount})</a>
            <a className="nav-link text-light" href="manageUsers.htm">Manage Users</a>
            <a className="nav-link text-light" href="manageAreas.htm">Manage Areas</a>
            <a className="nav-link text-light" href="managePackages.htm">Manage Packages</a>
            <a className="nav-link text-light" href="manageOrders.htm">Manage Orders</a>
            <a className="nav-link text-light" href="logout.htm">Logout</a>
        </nav>
        );
    },
    renderUserNav: function()
    {
        return (
        <nav className="navbar sticky-top navbar-expand-lg navbar-light bg-dark">
            <a className="navbar-brand" href="index.htm">Mummy's Restaurant</a>
            <a className="nav-link text-light" href="menuView.htm">View Menu</a>
            <a className="nav-link text-light" href="myOrders.htm">My Orders({this.props.user.orderCount})</a>
            <a className="nav-link text-light" href="logout.htm">Logout</a>
        </nav>
        );
    },
    renderVisitorNav: function()
    {
        return (
        <nav className="navbar sticky-top navbar-expand-lg navbar-light bg-dark">
            <a className="navbar-brand" href="index.htm">Mummy's Restaurant</a>
            <a className="nav-link text-light" href="menuView.htm">View Menu</a>
            <a className="nav-link text-light" href="login.htm">Login</a>
            <a className="nav-link text-light" href="register.htm">Register</a>
        </nav>
        );
    },
    render: function()
    {
        if ( this.props.user == null )
            return this.renderVisitorNav();
        
        //call a different function and return its return value depending
        //  on whether the user is logged in/is an admin/just a visitor
        else if ( this.props.user.email != null && this.props.user.isAdmin === "true" )
        {
            return this.renderAdminNav();
        }
        else if ( this.props.user.email != null )
        {
            return this.renderUserNav();
        }
        else
        {
            return this.renderVisitorNav();
        }
    }
});
 

