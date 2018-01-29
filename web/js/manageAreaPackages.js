//renders out a table row for the area given as a prop
AreaItemRow = React.createClass({
   render: function()
   {
       return (
            <tr>
                <td>{this.props.item}</td>
            </tr>    
        );
   }
});

AreaItemTable = React.createClass({
    eachItem: function( item, index )
    {
        return (
            <AreaItemRow key={index} item={item} />
        );
    },
    render: function()
    {
        return (
            <table className="table table-striped">
                <thead className="thead-dark">
                    <th>Package Name</th>
                </thead>
                {this.props.items.map( this.eachItem )}
            </table>
        );
    }
});

AreaItemForm = React.createClass({
    eachItem: function( item, index )
    {
        return (
            <option key={index} value={item.id}>{item.name}</option>
        );
    },
    render: function()
    {
        return (
        <form className="form" method="GET" action="modifyAreaPackage.htm">
            <label>Package</label><br/>
            <select name="item" className="form-control">
                {this.props.items.map( this.eachItem )}
            </select><br/>
            <input class="form-check-input" type="radio" name="command" 
                value="add" defaultChecked={true}/>
            <label>Add package to area</label><br />
            <input class="form-check-input" type="radio" name="command" 
                value="remove" />
            <label>Remove package from area</label><br />
            <input type="hidden" name="zip" value={this.props.area}/>
            <input type="submit" className="btn btn-primary" value="Submit" /><br/>
        </form>
        );
    }
});