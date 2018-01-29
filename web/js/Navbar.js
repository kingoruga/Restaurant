/*
 * TODO: need to pull this out into it's own js file
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
            <a className="navbar-brand" href="/index.htm">Mummy's Restaurant</a>
            <a className="nav-link text-light" href="viewMenu.htm">View Menu</a>
            <a className="nav-link text-light" href="myOrders.htm">My Orders(0)</a>
            <a className="nav-link text-light" href="manageUsers.html">Manage Users</a>
            <a className="nav-link text-light" href="manageAreas.html">Manage Areas</a>
            <a className="nav-link text-light" href="managePackages.html">Manage Packages</a>
            <a className="nav-link text-light" href="manageOrders.html">Manage Orders</a>
            <a className="nav-link text-light" href="/logout.htm">Logout</a>
        </nav>
        );
    },
    renderUserNav: function()
    {
        return (
        <nav className="navbar sticky-top navbar-expand-lg navbar-light bg-dark">
            <a className="navbar-brand" href="index.htm">Mummy's Restaurant</a>
            <a className="nav-link text-light" href="/viewMenu.htm">View Menu</a>
            <a className="nav-link text-light" href="/myOrders.htm">My Orders(0)</a>
            <a className="nav-link text-light" href="/logout.htm">Logout</a>
        </nav>
        );
    },
    renderVisitorNav: function()
    {
        return (
        <nav className="navbar sticky-top navbar-expand-lg navbar-light bg-dark">
            <a className="navbar-brand" href="index.htm">Mummy's Restaurant</a>
            <a className="nav-link text-light" href="/viewMenu.htm">View Menu</a>
            <a className="nav-link text-light" href="/login.htm">Login</a>
            <a className="nav-link text-light" href="/register.htm">Register</a>
        </nav>
        );
    },
    render: function()
    {
        if ( this.props.user == null )
            return this.renderVisitorNav();

        //call a different function and return its return value depending
        //  on whether the user is logged in/is an admin/just a visitor
        if ( this.props.user.email != null && this.props.user.isAdmin === "true" )
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
 
