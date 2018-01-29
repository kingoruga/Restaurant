//renders out a table row for the area given as a prop
AreaRow = React.createClass({
   render: function()
   {
       var removalUrl = "area/remove.htm?zip=" + this.props.area;
       var packagesUrl = "area/manageAreaPackages.htm?zip=" + this.props.area;
       return (
            <tr>
                <td>{this.props.area}</td>
                <td><a href={packagesUrl}>Packages</a></td>
                <td><a href={removalUrl}>Remove</a></td>
            </tr>    
        );
   }
});

//renders out a table and uses AreaRow for rows for the areas given as a prop
AreaTable = React.createClass({
    eachArea: function( area, index )
    {
        return (
            <AreaRow key={index} area={area} />
        );
    },
    render: function()
    {
        return (
            <table className="table table-striped">
                <thead className="thead-dark">
                    <th>Zipcode</th>
                    <th>Packages</th>
                    <th>Remove</th>
                </thead>
                {this.props.areas.map( this.eachArea )}
            </table>
        );
    }
});