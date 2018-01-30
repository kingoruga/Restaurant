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
            <a className="nav-link text-light" href="#">Logout</a>
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
            <a className="nav-link text-light" href="#">Logout</a>
        </nav>
        );
    },
    renderVisitorNav: function()
    {
        return (
        <nav className="navbar sticky-top navbar-expand-lg navbar-light bg-dark">
            <a className="navbar-brand" href="index.htm">Mummy's Restaurant</a>
            <a className="nav-link text-light" href="menuView.htm">View Menu</a>
            <a className="nav-link text-light" href="#">Login</a>
            <a className="nav-link text-light" href="#">Register</a>
        </nav>
        );
    },
    render: function()
    {
        //call a different function and return its return value depending
        //  on whether the user is logged in/is an admin/just a visitor
        if ( this.props.user && this.props.user.isAdmin )
        {
            return this.renderAdminNav();
        }
        else if ( this.props.user )
        {
            return this.renderUserNav();
        }
        else
        {
            return this.renderVisitorNav();
        }
    }
});
 
