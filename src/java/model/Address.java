
package model;
import static model.Orders.surroundWithQuotes;
import java.io.Serializable;

public class Address implements Serializable {

    private int addressId;
    private String street1;
    private String street2;
    private String city;
    private String state;
    private String zip;
    private boolean isDeliverable;

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public boolean isIsDeliverable() {
        return isDeliverable;
    }
    
    
    @Override
    public String toString()
    {
        StringBuilder toReturn = new StringBuilder();
        toReturn.append( "{" );
        toReturn.append( surroundWithQuotes( "addressId" ) );
        toReturn.append( ":" );
        toReturn.append( surroundWithQuotes( Integer.toString(addressId) ) );
        
        toReturn.append( "," );
        toReturn.append( surroundWithQuotes( "city" ) );
        toReturn.append( ":" );
        toReturn.append( surroundWithQuotes( city ) );
        
        
        toReturn.append( "," );
        toReturn.append( surroundWithQuotes( "state" ) );
        toReturn.append( ":" );
        toReturn.append( surroundWithQuotes( state ) );
        
        
        toReturn.append( "," );
        toReturn.append( surroundWithQuotes( "zip" ) );
        toReturn.append( ":" );
        toReturn.append( surroundWithQuotes( zip ) );
        
        toReturn.append( "}" );
        return toReturn.toString();
    }

    public void setIsDeliverable(boolean isDeliverable) {
        this.isDeliverable = isDeliverable;
    }


}
