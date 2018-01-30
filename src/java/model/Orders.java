package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Orders implements Serializable {
    private int OrderId;
    private int UserId;
    private int AddressId;
    private String PaymentMethod;
    private String OrderDate;
    private String DeliveryDate;
    private String Time;
    private float Price;
    private ArrayList<FoodItem> Items; 
    private Address orderAddress;
    private OnlineUser user;

    public OnlineUser getUser() {
        return user;
    }

    public void setUser(OnlineUser user) {
        this.user = user;
    }

    public Orders() {}
     
    public Orders(int orderId, int userId, int addressId, String payment, String oDate, float price, String dDate, String dTime){
         this.OrderId = orderId;
         this.UserId = userId;
         this.AddressId = addressId;
         this.PaymentMethod = payment;
         this.OrderDate = oDate;
         this.DeliveryDate = dDate;
         this.Time = dTime;
         this.Price = price;
    }
     
    
    public int getOrderId() {
        return OrderId;
    }

    public void setOrderId(int OrderId) {
        this.OrderId = OrderId;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int UserId) {
        this.UserId = UserId;
    }

    public int getAddressId() {
        return AddressId;
    }

    public void setAddressId(int AddressId) {
        this.AddressId = AddressId;
    }

    public String getPaymentMethod() {
        return PaymentMethod;
    }

    public void setPaymentMethod(String PaymentMethod) {
        this.PaymentMethod = PaymentMethod;
    }
    
    public String getOrderDate() {
        return OrderDate;
    }
     
    public String getDeliveryDate() {
         return DeliveryDate;
    }
    
    public void setDeliveryDate(String DeliveryDate) {
         this.DeliveryDate = DeliveryDate;
    }
    
     public void setOrderDate(String OrderDate) {
        this.OrderDate = OrderDate;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String Time) {
        this.Time = Time;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float Price) {
        this.Price = Price;
    }

    public ArrayList<FoodItem> getItems() {
        return Items;
    }

    public void setItems(ArrayList<FoodItem> Items) {
        this.Items = Items;
    }
    
    public void addItem(FoodItem Item){
        //this.setItems(this.getItems().add(Item));
        this.getItems().add(Item);
    }
    
    public void removeItem(FoodItem Item){
        //this.setItems(this.getItems().remove(Item)); 
        this.getItems().remove(Item);
    }
    
    public void setOrderAddress( Address address )
    {
        this.orderAddress = address;
    }
    
    public Address getOrderAddress()
    {
        return this.orderAddress;
    }

    public static String surroundWithQuotes( String toSurround )
    {
        StringBuilder toReturn = new StringBuilder();
        toReturn.append( "\"" );
        toReturn.append( toSurround );
        toReturn.append( "\"" );
        return toReturn.toString();
    }
    
    @Override
    public String toString()
    {
        StringBuilder toReturn = new StringBuilder();
        toReturn.append( "{" );
        toReturn.append( surroundWithQuotes( "orderid" ) );
        toReturn.append( ":" );
        toReturn.append( surroundWithQuotes( Integer.toString(OrderId) ) );
        
        toReturn.append( "," );
        toReturn.append( surroundWithQuotes( "payment" ) );
        toReturn.append( ":" );
        toReturn.append( surroundWithQuotes( PaymentMethod ) );
        
        toReturn.append( "," );
        toReturn.append( surroundWithQuotes( "price" ) );
        toReturn.append( ":" );
        toReturn.append( surroundWithQuotes( Float.toString( Price ) ) );

        toReturn.append( "," );
        toReturn.append( surroundWithQuotes( "orderDate" ) );
        toReturn.append( ":" );
        toReturn.append( surroundWithQuotes( OrderDate ) );
        
        toReturn.append( "," );
        toReturn.append( surroundWithQuotes( "deliveryDate" ) );
        toReturn.append( ":" );
        toReturn.append( surroundWithQuotes( DeliveryDate ) );
        
        toReturn.append( "," );
        toReturn.append( surroundWithQuotes( "time" ) );
        toReturn.append( ":" );
        toReturn.append( surroundWithQuotes( Time ) );
        
        if ( Items != null )
        {
            toReturn.append( "," );
            toReturn.append( surroundWithQuotes( "items" ) );
            toReturn.append( ":" );
            toReturn.append( Items.toString() );
        }
        
        if ( orderAddress != null )
        {
            toReturn.append( "," );
            toReturn.append( surroundWithQuotes( "address" ) );
            toReturn.append( ":" );
            toReturn.append( orderAddress.toString() );
        }
        
        toReturn.append( "}" );
        return toReturn.toString();
    }

}
