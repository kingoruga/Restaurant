var AddressForm = React.createClass({
   render: function() {
       var address = this.props.address;
       return (
            <div>
                <div className="form-row">
                    <div className="form-group col-md-5">
                        <label for="address">Street address</label>
                        <input required type="text" defaultValue={address.street} className="form-control" name="street" id="address" placeholder="1234 Main St" />
                    </div>
                    <div className="form-group col-md-3">
                        <label for="city">City</label>
                        <input required type="text" defaultValue={address.city} className="form-control" name="city" id="city" />
                    </div>
                    <div className="form-group col-md-2">
                        <label for="state">State</label>
                        <select id="state" defaultValue={address.state} name="state" className="form-control">
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
                        </select>
                    </div>
                    <div className="form-group col-md-2">
                        <label for="zip">Zip</label>
                        <input required type="number" defaultValue={address.zip} name="zip" className="form-control" id="zip" />
                    </div>
                </div>
                
            </div>
        );
   } 
});

var OrderDropdown = React.createClass({
    render: function() {
        return (
            <div className="container dropdown">
                <p>Current {this.props.title}: </p>
                <form method="POST">
                    {this.props.children}
                    <input type="hidden" name="action" value={this.props.action} />
                    <input type='hidden' name='orderId' value={this.props.orderId} />
                    <button>Change</button>
                </form>
            </div>
        );
    }
});

var OrderItem = React.createClass({
    render: function() {
        var food = this.props.item;
        var amount = this.props.amount > 1 ? "(" + this.props.amount + "x)" : "";
        
        var veg = food.is_veg === "false" ? "not vegetarian" : "vegetarian"
        return (
            <div className="row">
                <img className="col-sm-2" alt="meal-image" src={food.image} width="64" height="90" />
                <div className="col-md-10 h-50">
                    <div className='space'>
                        <div className="row"><h4>{food.name} - {food.type} {amount}</h4></div>
                        <div className="row">
                        <p>{food.description} <i>({veg})</i></p>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
})

var Order = React.createClass({
    
    getInitialState: function() {
        return {
            dropdownVisible: false,
            dropdownIndex: 0,
            order: this.props.order
        }
    },
    
    toggleDropdown: function(event, index) {
        event.preventDefault();
        
        if (this.state.dropdownVisible) {
            
            // clicking same button, close
            if (this.state.dropdownIndex === index) {
                this.setState({
                    dropdownVisible: false,
                    dropdownIndex: 0
                });
            }
            
            // clicking new button, dont close just change dialog
            else {
                this.setState({dropdownIndex: index});
            }
            
        }
        
        // otherwise show 
        else {
            this.setState({
                    dropdownVisible: true,
                    dropdownIndex: index
                });
        }
    },
    
    getDropdown: function() {
        // Not visible, dont render
        if (!this.state.dropdownVisible)
            return "";
        
        // Get the selected dropdown
        switch (this.state.dropdownIndex) {

            // Extend delivery date
            case 1:
                return (
                    <OrderDropdown title='Delivery date' orderId={this.state.order.orderid} action="DATE">
                        <div className="form-row">
                            <div className="form-group col-md-5">
                                <input required className="form-control" id="date" name="date" defaultValue={this.state.order.deliveryDate} />
                            </div>
                        </div>
                    </OrderDropdown>
                );

            // Modify meal options
            case 2: 
                return (
                    <OrderDropdown title='Meal option' orderId={this.state.order.orderid}>
                        <div className="form-group col-md-2">
                            <select id="mealOption" className="form-control">
                                <option value="br">Breakfast</option>
                                <option value="lu">Lunch</option>
                                <option value="di">Dinner</option>
                            </select>
                        </div>
                    </OrderDropdown>
                );
        
            // Modify delivery address
            case 3:
                return (
                    <OrderDropdown title='Address information' orderId={this.state.order.orderid} action="ADDRESS">
                        <AddressForm address={this.state.order.address} />
                    </OrderDropdown>
                );
        
            default:
                return "";
        }
    },
    
    render: function() {

        var orderDate = new Date(this.state.order.orderDate.split(' ')[0]);
        var orderDateStr = orderDate.getMonth()+1 + "/" + orderDate.getDate();
        
        var deliveryDate = new Date(this.state.order.deliveryDate.split(' ')[0]);
        var deliveryDateStr = deliveryDate.getMonth()+1 + "/" + deliveryDate.getDate();

        var timeDiff = Math.abs(deliveryDate.getTime() - (new Date()).getTime());
        var diffDays = Math.ceil(timeDiff / (1000 * 3600 * 24));
        diffDays = diffDays >= 1 ? diffDays : "0";
        
        return (
            <div className="container item">
                { this.state.order.items.map((item, index) => <OrderItem item={item} key={index} amount={this.props.amounts[item.food_item_id]} />) }
                <div className="row justify-content-md-center">
                    <span>Day ordered: {orderDateStr}</span>,&nbsp;
                    <span>Day of delivery: {deliveryDateStr}</span>,&nbsp;
                    <span>Days remaining: {diffDays}</span>
                </div>
                <div className="row justify-content-md-center">
                    <a onClick={(e) => this.toggleDropdown(e, 1)} className="col-md-3 btn btn-default" href="#" role="button">Extend delivery date</a>
                    <a onClick={(e) => this.toggleDropdown(e, 3)} className="col-md-3 btn btn-default" href="#" role="button">Modify delivery address</a>
                </div>
                {this.getDropdown()}
                <hr />
            </div>
        );
    }
});

var OrderPage = React.createClass({
        
    render: function() {
        
        var orders = this.props.orders.map((o, i) => {
            return (<Order order={o} key={i} amounts={this.props.amounts[o.orderid]} />);
        });

        return (
            <div>
                <NavBar user={user} />
                <div className='container'>
                    <div className="page-header">
                        <h2>My orders</h2>
                    </div>

                    <p>Manage all your ongoing orders. You currently have <b>{orders.length}</b> ongoing order/s.</p>
                    <hr />

                    <div className="container-fluid">
                        {orders}
                    </div>
                </div>
            </div>
        )
    }
});

React.render(<OrderPage orders={orders} amounts={amounts} />,
        document.getElementById('react-container'));
