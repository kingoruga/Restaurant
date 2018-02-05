
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
       
<nav className="site-header sticky-top py-1">
    <div className="container d-flex flex-column flex-md-row justify-content-between">
    
        <a className="py-2" href="index.htm">Mummy's Restaurant</a>
        <a className="py-2 d-none d-md-inline-block" href="menuView.htm">View Menu</a>
        <a className="py-2 d-none d-md-inline-block" href="myOrders.htm">My Orders{this.props.user.orderCount}</a>        
        <a className="py-2 d-none d-md-inline-block" href="manageUsers.htm">Manage Users</a>
        <a className="py-2 d-none d-md-inline-block" href="manageAreas.htm">Manage Areas</a>
        <a className="py-2 d-none d-md-inline-block" href="managePackages.htm">Manage Packages</a>
        <a className="py-2 d-none d-md-inline-block" href="manageOrders.htm">Manage Orders</a>
        <a className="nav-item dropdown">
               <a className="nav-link dropdown-toggle" href="myprofile.htm" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    {this.props.user.name}
               </a>                        
               <div className="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                     <a className="dropdown-item" href="logout.htm">Log out</a>
               </div>                           
        </a>
    </div>
</nav>

       

        );
},
        renderUserNav: function()
        {
        return (
        <nav className="site-header sticky-top py-1">
            <div className="container d-flex flex-column flex-md-row justify-content-between">
                <a className="py-2" href="index.htm">
                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="d-block mx-auto"><circle cx="12" cy="12" r="10"></circle><line x1="14.31" y1="8" x2="20.05" y2="17.94"></line><line x1="9.69" y1="8" x2="21.17" y2="8"></line><line x1="7.38" y1="12" x2="13.12" y2="2.06"></line><line x1="9.69" y1="16" x2="3.95" y2="6.06"></line><line x1="14.31" y1="16" x2="2.83" y2="16"></line><line x1="16.62" y1="12" x2="10.88" y2="21.94"></line></svg>
                </a>
                <a className="py-2" href="index.htm">Mummy's Restaurant</a>
                <a className="py-2 d-none d-md-inline-block" href="menuView.htm">View Menu</a>
                <a className="py-2 d-none d-md-inline-block" href="myOrders.htm">My Orders{this.props.user.orderCount}</a>
                <a className="nav-item dropdown">
                        <a className="nav-link dropdown-toggle" href="myprofile.htm" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            {this.props.user.name}
                         </a>                        
                          <div className="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                             <a className="dropdown-item" href="logout.htm">Log out</a>
                          </div>                           
                </a>
                
            </div>
        </nav>
                );
        },
        renderVisitorNav: function()
        {
        return (
                //<nav className="navbar sticky-top navbar-expand-lg navbar-light bg-dark">

        <nav className="site-header sticky-top py-1">

            <div className="container d-flex flex-column flex-md-row justify-content-between">    
                <a className="py-2" href="index.htm">
                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="d-block mx-auto"><circle cx="12" cy="12" r="10"></circle><line x1="14.31" y1="8" x2="20.05" y2="17.94"></line><line x1="9.69" y1="8" x2="21.17" y2="8"></line><line x1="7.38" y1="12" x2="13.12" y2="2.06"></line><line x1="9.69" y1="16" x2="3.95" y2="6.06"></line><line x1="14.31" y1="16" x2="2.83" y2="16"></line><line x1="16.62" y1="12" x2="10.88" y2="21.94"></line></svg>
                </a>
                <a className="py-2" href="index.htm">Mummy's Restaurant</a>
                <a className="py-2 d-none d-md-inline-block" href="menuView.htm">View Menu</a>
                <a className="py-2 d-none d-md-inline-block" href="login.htm">Login</a>
                <a className="py-2 d-none d-md-inline-block" href="register.htm">Register</a>
            </div>

        </nav>
                );
        },
        render: function()
        {
        //call a different function and return its return value depending
        //  on whether the user is logged in/is an admin/just a visitor
        if (this.props.user && this.props.user.admin)
        {
        console.log('admin');
                return this.renderAdminNav();
        }
        else if (this.props.user && this.props.user.email)
        {
        console.log('non-admin');
                return this.renderUserNav();
        }
        else
        {
        return this.renderVisitorNav();
        }
        }
});


