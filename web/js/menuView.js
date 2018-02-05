//renders the menu

   <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet" type="text/css" />;
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>;

ItemRow = React.createClass({
   renderLoggedIn: function(){
       return (
            <tr>
                <td>{this.props.item.name}</td>
                <td>{this.props.item.price}</td>
                <td>{this.props.item.des}</td>
                <td>{this.props.item.veg}</td>
                <td><img src={this.props.item.image} alt="Food" width="64" height="64"/></td>
            
             </tr> 
             
        );
   },
    
    renderVisitor: function(){
          return (
            <tr>
                <td>{this.props.item.name}</td>
                <td>{this.props.item.price}</td>
                <td>{this.props.item.des}</td>
                <td>{this.props.item.veg}</td>
                <td><img src={this.props.item.image} alt="Food"  width="64" height="64"/></td>
               
             </tr>    
              
        );
    },
    
    renderOrderInProgress: function(){
          return (
            <tr>
                <td>{this.props.item.name}</td>
                <td>{this.props.item.price}</td>
                <td>{this.props.item.des}</td>
                <td>{this.props.item.veg}</td>
                <td><img src={this.props.item.image} alt="Food"  width="64" height="64"/></td>
                
             </tr>    
        );
    },
    
    
    render: function()
   {
       if(this.props.user && this.props.user.orderInPrgress){
           return this.renderOrderInProgress();
       }
       else if(this.props.user){
           return this.renderLoggedIn();
       }
       else{
           return this.renderVisitor();
       }
   }
});

//renders out a table and uses ItemRow for rows for the items given as a prop
ItemTable = React.createClass({
    eachItem: function( item, index )
    {
        return (
            <ItemRow key={index} item={item} />
        );
    },
    render: function()
    {
        return (
            <table className="table table-striped">
                <thead className="thead-dark">
                    <th>Name</th>
                    <th>Price</th>
                    <th>Description</th>
                    <th>Vegetarian</th>
                    <th>Image</th>
                    <th> </th>
                </thead>
                {this.props.items.map( this.eachItem )}
            </table>
        );
    }
});