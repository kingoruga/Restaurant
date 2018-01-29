
package model;


public class Address {
    private int AddressId;
    private String Street1;
    private String Street2;
    private String City;
    private String State;
    private String Zip;
    private boolean IsDeliverable;


    public int getAddressId() {
        return AddressId;
    }

    public void setAddressId(int AddressId) {
        this.AddressId = AddressId;
    }

    public String getStreet1() {
        return Street1;
    }

    public void setStreet1(String Street1) {
        this.Street1 = Street1;
    }

    public String getStreet2() {
        return Street2;
    }

    public void setStreet2(String Street2) {
        this.Street2 = Street2;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getState() {
        return State;
    }

    public void setState(String State) {
        this.State = State;
    }

    public String getZip() {
        return Zip;
    }

    public void setZip(String Zip) {
        this.Zip = Zip;
    }

    public boolean isIsDeliverable() {
        return IsDeliverable;
    }

    public void setIsDeliverable(boolean IsDeliverable) {
        this.IsDeliverable = IsDeliverable;
    }

    /*
    private int AddressId;
    private String Street1;
    private String Street2;
    private String City;
    private String State;
    private String Zip;
    private boolean IsDeliverable;
    */
    @Override
    public String toString()
    {
        StringBuilder toReturn = new StringBuilder();
        toReturn.append( "{" );
        toReturn.append( Orders.surroundWithQuotes( "addressid" ) );
        toReturn.append( ":" );
        toReturn.append( Orders.surroundWithQuotes( Integer.toString( AddressId) ) );
        
        toReturn.append( "," );
        toReturn.append( Orders.surroundWithQuotes( "street" ) );
        toReturn.append( ":" );
        toReturn.append( Orders.surroundWithQuotes( Street1 ) );
        
        toReturn.append( "," );
        toReturn.append( Orders.surroundWithQuotes( "city" ) );
        toReturn.append( ":" );
        toReturn.append( Orders.surroundWithQuotes( City ) );

        toReturn.append( "," );
        toReturn.append( Orders.surroundWithQuotes( "state" ) );
        toReturn.append( ":" );
        toReturn.append( Orders.surroundWithQuotes( State ) );

        toReturn.append( "," );
        toReturn.append( Orders.surroundWithQuotes( "zipcode" ) );
        toReturn.append( ":" );
        toReturn.append( Orders.surroundWithQuotes( Zip ) );
        
        toReturn.append( "}" );
        return toReturn.toString();
    }
}

