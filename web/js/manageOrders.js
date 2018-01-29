//renders out a table row for the order given as a prop
OrderRow = React.createClass({
   renderAddress : function()
   {
        return (
            <td>
                {this.props.order.address.street},
                &nbsp;{this.props.order.address.city},
                &nbsp;{this.props.order.address.state},
                &nbsp;{this.props.order.address.zipcode}
            </td>
         );
   },
   render: function()
   {
       return (
            <tr>
                <td>{this.props.order.orderid}</td>
                <td>{this.props.order.user.email}</td>
                <td>{this.props.order.user.name}</td>
                {this.renderAddress()}
                <td>{this.props.order.price}</td>
                <td>{this.props.order.payment}</td>
            </tr>    
        );
   }
});

//renders out a table and uses OrderRow for rows for the orders given as a prop
OrderTable = React.createClass({
    eachOrder: function( order, index )
    {
        return (
            <OrderRow key={index} order={order} />
        );
    },
    renderTableHeader: function()
    {
        return (
            <thead className="thead-dark">
                <th>Order ID 
                    &nbsp;<a href='?col=order_id'>&#8595;</a>
                </th>
                <th>Email
                    &nbsp;<a href='?col=email'>&#8595;</a>
                </th>
                <th>Name 
                    &nbsp;<a href='?col=last_name'>&#8595;</a>
                </th>
                <th>Address 
                    &nbsp;<a href='?col=zip_code'>&#8595;</a>
                </th>
                <th>Price 
                    &nbsp;<a href='?col=price'>&#8595;</a>
                </th>
                <th>Payment 
                    &nbsp;<a href='?col=payment_type'>&#8595;</a>
                </th>
            </thead> 
        );
    },
    render: function()
    {
        return (
            <table className="table table-striped">
                {this.renderTableHeader()}
                {this.props.orders.map( this.eachOrder )}
            </table>
        );
    }
});