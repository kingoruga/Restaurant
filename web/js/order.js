/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var AddressForm = React.createClass({

    render: function() {
        return (
            <div>
                <div className="form-row">
                    <div className="form-group col-md-5">
                        <label for="address">Street address</label>
                        <input onChange={this.props.listeners.street} value={this.props.values.street} required type="text" className="form-control" id="address" placeholder="1234 Main St" />

                    </div>

                    <div className="form-group col-md-3">
                        <label for="city">City</label>
                        <input onChange={this.props.listeners.city} value={this.props.values.city} required type="text" className="form-control" id="city" />
                    </div>

                    <div className="form-group col-md-2">
                        <label for="state">State</label>
                        <select id="state"  onChange={this.props.listeners.state} value={this.props.values.state}  className="form-control">
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
                        <input onChange={this.props.listeners.zip} value={this.props.values.zip} required type="number" className="form-control" id="zip" />
                    </div>
                </div>



            </div>

        );

    }

});

var TimeOfDayForm = React.createClass({
    render: function() {
        return (
            <div className="container">
                <div className="form-group row">
                    <label for="time">Time</label>
                    <select id="time"  onChange={this.props.listeners.time} value={this.props.values.time} className="form-control">
                        <option value="01">01</option>
                        <option value="02">02</option>
                        <option value="03">03</option>
                        <option value="04">04</option>
                        <option value="05">05</option>
                        <option value="06">06</option>
                        <option value="07">07</option>
                        <option value="08">08</option>
                        <option value="09">09</option>
                        <option value="10">10</option>
                        <option value="11">11</option>
                        <option value="12">12</option>
                    </select>
                </div>
                <div className="form-group row">
                    <label for="ampm">AM/PM</label>
                    <select id="ampm" onChange={this.props.listeners.ampm} value={this.props.values.ampm} className="form-control">
                        <option value="AM">AM</option>
                        <option value="PM">PM</option>
                    </select>
                </div>
            </div>
        );
    }
})

//

var Food = React.createClass({

    render: function() {
        var food = this.props.food;
        var onClick = () => this.props.onClick(food);

        return (
            <tr>
                <td><image src={food.image} width="180" height="128" /></td>
                <td>{food.name}</td>
                <td>{food.description}</td>
                <td>{food.price}</td>
                <td>{food.type}</td>
                <td>{food.isVeg ? "Yes" : "No"}</td>
                <td>{this.props.amount()}</td>
                <td><button onClick={onClick}>+</button></td>
            </tr>
        );
    }
});

var FoodSelect = React.createClass({

    getInitialState: function() {
        return {
            food: this.props.order.food == null ? [] : this.props.order.food,
        };
    },

    addedAmount: function(f) {

        // count the occurance
        var counts = {};
        for (var i = 0; i < this.state.food.length; i++) {
            var num = this.state.food[i].food_item_id;
            counts[num] = counts[num] ? counts[num] + 1 : 1;
        }

        return counts[f.food_item_id] || 0;
    },

    render: function() {
        
        var onClick = (food) => this.setState({food: [...this.state.food, food] });
        var disabled = this.state.food.length <= 0;
        var username = user.firstname;

        if (this.props.food.length === 0) {
            return (
                <div>
                    <h4>Sorry, there is no food available to you in your area.</h4>
                </div>
            );
        }

        return (
            <div>
                <p className="step">({this.props.step}/6)</p>
                <h1>Welcome, {username}</h1>
                <h4>Add the food you want to order.</h4>
                <table className="table table-hover text-centered">
                    <tr>
                        <th>Image</th>
                        <th>Name</th>
                        <th>Description</th>
                        <th>Price</th>
                        <th>Type</th>
                        <th>Is Veg</th>
                        <th># Added to cart</th>
                    </tr>
                    {this.props.food.map((food, index) => <Food onClick={onClick} food={food} key={index} amount={() => this.addedAmount(food)} />)}
                </table>

                <p>Items in cart: {this.state.food.length}</p>
                <hr />

                <button className="btn btn-block" onClick={() => this.setState({ food: [] })}>Reset cart</button>
                <button disabled={disabled} className="btn btn-primary btn-block" onClick={() => this.props.to({...this.props.order, "food": this.state.food}, "ADDRESS")}>Next</button>
            </div>
        );
    }
});

var Address = React.createClass({

    getInitialState: function() {

        var address = this.props.order.address == null ? this.props.user.address : this.props.order.address;
        return {
            street: address.street,
            city: address.city,
            state: address.state,
            zip: address.zip
        };
    },

    streetChange: function(evt) { this.setState({street: evt.target.value })},

    cityChange: function(evt) { this.setState({city: evt.target.value })},

    stateChange: function(evt) { this.setState({state: evt.target.value })},

    zipChange: function(evt) { this.setState({zip: evt.target.value })},

    render: function() {

        var values = {
            street: this.state.street,
            city: this.state.city,
            state: this.state.state,
            zip: this.state.zip
        };

        var listeners = {
            street: this.streetChange,
            city: this.cityChange,
            state: this.stateChange,
            zip: this.zipChange
        };

        var disabled = this.state.street.length == 0
            || this.state.city.length == 0
            || this.state.zip.length == 0
            || !this.state.zip.match(/^\d+$/);


        return (
            <div>
                <p className="step">({this.props.step}/6)</p>
                <h4>Enter your shipping information for the order. </h4>
                <AddressForm values={values} listeners={listeners} />
                <hr />
                <button className="btn btn-block" onClick={() => this.props.to({...this.props.order}, "FOOD")}>Back</button>
                <button disabled={disabled} className="btn btn-primary btn-block" onClick={() => this.props.to({...this.props.order, "address": values}, "DELIVERY_DAY")}>Next</button>
            </div>
        );
    }
});

var DeliveryDay = React.createClass({

    getInitialState: function() {
        var date = this.props.order.deliver == null ? "" : this.props.order.deliver;
        return {
            invalidInput: !this.dateValid(date),
            input: date,
            date: date
        }
    },

    dateValid: function(date) {
        var valid = date.match(/^\d{2}\/\d{2}\/\d{4}$/);
        if (!valid)
            return false;
        var then = new Date(valid);
        var now = new Date();
        var timeDiff = then.getTime() - (now).getTime();
        var diffDays = Math.ceil(timeDiff / (1000 * 3600 * 24));
        return diffDays <= 30 && diffDays >= 0;
    },

    textChanged: function(evt) {
        var text = evt.target.value;
        var valid = this.dateValid(text)
        if (valid)
            this.setState({date: text});
        this.setState({invalidInput: !valid, input: text});
    },

    render: function() {
        return (
            <div>
                <p className="step">({this.props.step}/6)</p>
                <h4>Set the delivery date you want the order to arrive (within 30 days).</h4>
                <input onChange={this.textChanged} value={this.state.input}  className="form-control" id="zip" placeholder="e.g. 01/23/2018"   />
                <hr />
                <button className="btn btn-block" onClick={() => this.props.to(this.props.order, "ADDRESS")}>Back</button>
                <button disabled={this.state.invalidInput} className="btn btn-primary btn-block"
                        onClick={() => this.props.to({...this.props.order, "deliver": this.state.date}, "DELIVERY_TIME")}>Next</button>
            </div>
        );
    }
});

var DeliveryTime = React.createClass({

    getInitialState: function() {
        var orderTime = this.props.order.time;

        if (orderTime == null)
            return {
                time: "01",
                ampm: "AM"
            };

        else
            return {
                time: orderTime.split(" ")[0],
                ampm: orderTime.split(" ")[1]
            }
    },

    timeChange: function(evt) { this.setState({time: evt.target.value })},

    ampmChange: function(evt) { this.setState({ampm: evt.target.value })},

    render: function() {
        var values = {
            time: this.state.time,
            ampm: this.state.ampm,
        };

        var listeners = {
            time: this.timeChange,
            ampm: this.ampmChange,
        };

        return (
            <div>
                <p className="step">({this.props.step}/6)</p>
                <h4>Set the time of day for the order to be delivered at.</h4>
                <TimeOfDayForm values={values} listeners={listeners} />
                <hr />
                <button className="btn btn-block" onClick={() => this.props.to(this.props.order, "DELIVERY_DAY")}>Back</button>
                <button className="btn btn-primary btn-block"
                        onClick={() => this.props.to({...this.props.order, "time": this.state.time + " " + this.state.ampm}, "PAYMENT")}>Next</button>
            </div>
        );
    }
});

var Payment = React.createClass({

    getInitialState: function() {
        return {
            payment: this.props.order.payment == null ? "" : this.props.order.payment
        }
    },

    setMethod: function(event) {
        this.setState({payment: event.target.value});
    },

    render: function() {

        var price = this.props.order.food.map(food => parseFloat(food.price)).reduce((a, b) => a + b);

        var aChecked = this.state.payment === "Cash";
        var bChecked = this.state.payment === "Card";
        var disabled = !aChecked && !bChecked;

        return (
            <div>
                <p className="step">({this.props.step}/6)</p>
                <h4>Your total is: <b>${price.toFixed(2)}</b>. Select your payment method.</h4>

                <div onChange={this.setMethod.bind(this)}>
                    <div className="form-check">
                        <label className="form-check-label" for="r1">
                            <input className="form-check-input" checked={aChecked} type="radio" value="Cash" name="method" id="r1"/>
                            Cash</label>
                    </div>
                    <div className="form-check">
                        <label className="form-check-label" for="r2">
                            <input className="form-check-input" checked={bChecked} type="radio" value="Card" name="method" id="r2"/>
                            Card</label>
                    </div>
                </div>
                <hr />
                <button className="btn btn-block" onClick={() => this.props.to(this.props.order, "DELIVERY_TIME")}>Back</button>
                <button disabled={disabled} className="btn btn-primary btn-block" onClick={() => this.props.to({...this.props.order, "payment": this.state.payment, price: price}, "CONFIRM")}>Next</button>
            </div>
        );
    }

});

var Confirm = React.createClass({

    createFoodString: function() {
        var order = this.props.order;

        // get distinct ids
        var distinctFoods = order.food
            .map(food => food.food_item_id)
            .filter( (v, i, s) => s.indexOf(v) === i);

        // count the occurance
        var counts = {};
        for (var i = 0; i < order.food.length; i++) {
            var num = order.food[i].food_item_id;
            counts[num] = counts[num] ? counts[num] + 1 : 1;
        }

        // create the string
        var foods = distinctFoods
            .map(food => food + "," + counts[food] + "|")
            .reduce((a, b) => a + b);

        return foods;
    },

    render: function() {
        var order = this.props.order;
        var address = order.address;

        return (
            <div>
                <p className="step">({this.props.step}/6)</p>
                <h4>Confirm your order below.</h4>

                <div className="container">
                    <div className="row">
                        <div className="col">
                            <h3> Food items: </h3>
                            { order.food.map(food => <p>{food.name}</p>) }
                        </div>

                        <div className="col">
                            <h3> Address Details </h3>
                            <p> Street: {address.street} </p>
                            <p> City: {address.city} </p>
                            <p> State: {address.state} </p>
                            <p> Zip: {address.zip} </p>
                        </div>

                        <div className="col">
                            <h3> Destination details </h3>
                            <p> Delivery date: {order.deliver} </p>
                            <p> Delivery time: {order.time} </p>
                        </div>

                        <div className="col">
                            <h3> Payment details </h3>
                            <p> Total: {'$' + order.price.toFixed(2)} </p>
                            <p> Method: {order.payment} </p>
                        </div>
                    </div>
                </div>
                <hr />


                <button className="btn btn-block" onClick={() => this.props.to(this.props.order, "PAYMENT")}>Back</button>
                <form action='menuView.htm' method='POST'>
                    <input type='hidden' name='street' value={address.street} />
                    <input type='hidden' name='city' value={address.city} />
                    <input type='hidden' name='state' value={address.state} />
                    <input type='hidden' name='zip' value={address.zip} />
                    <input type='hidden' name='deliver' value={order.deliver} />
                    <input type='hidden' name='time' value={order.time} />
                    <input type='hidden' name='price' value={order.price} />
                    <input type='hidden' name='payment' value={order.payment} />
                    <input type='hidden' name='food' value={this.createFoodString()} />
                    <div className="form-check">
                        <label className="form-check-label">
                            <input className="form-check-input" type="radio" value="PDF" name="print"/>
                            Print PDF</label>
                    </div>
                    <div className="form-check">
                        <label className="form-check-label">
                            <input className="form-check-input" type="radio" value="text" name="print"/>
                            Print Text</label>
                    </div>
                    <button type="submit" className="btn btn-primary btn-block">Confirm purchase</button>
                </form>
            </div>
        );
    }
})

var Receipt = React.createClass({
    render: function() {
        return <p>The food order has been confirmed. <a href="/">Click here</a> go back home.</p>;
    }
});

//

var OrderPage = React.createClass({

    getInitialState: function() {
        return {
            order: {},
            page: <FoodSelect food={this.props.food} order={{}} to={this.changePageTo} step={1} />,
        }
    },

    changePageTo: function(order, pageName) {

        this.setState({order: order});

        switch (pageName) {

            case "FOOD":
                this.setState({page: <FoodSelect food={this.props.food} order={order} user={this.props.user} to={this.changePageTo} step={1} />});
                break;

            case "ADDRESS":
                this.setState({page: <Address user={this.props.user} order={order} to={this.changePageTo} step={2} />});
                break;

            case "DELIVERY_DAY":
                this.setState({page: <DeliveryDay order={order} to={this.changePageTo} step={3} />});
                break;

            case "DELIVERY_TIME":
                this.setState({page: <DeliveryTime order={order} to={this.changePageTo} step={4} />});
                break;

            case "PAYMENT":
                this.setState({page: <Payment order={order} to={this.changePageTo} step={5} />});
                break;

            case "CONFIRM":
                this.setState({page: <Confirm order={order} to={this.changePageTo} step={6} />});
                break;

            case "RECEIPT":
                this.setState({page: <Receipt order={order} to={this.changePageTo} />});
                break;
        }
    },

    render: function() {
        console.log(this.state.order);
        console.log(this.props.user);
        return (
            <div>
                <NavBar user={this.props.user} />
                <div className='container'>
                    <hr />
                    <div className="container text-center ">
                        {this.state.page}
                    </div>
                </div>
            </div>
        );
    }
});

React.render(
        <OrderPage food={food} user={user} /> ,
    document.getElementById( "mainContainer" )
);