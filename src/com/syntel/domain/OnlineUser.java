package com.syntel.domain;

import static com.syntel.domain.Orders.surroundWithQuotes;
import java.io.Serializable;

/**
 *
 * @author syntel
 */
public class OnlineUser implements Serializable {
    private int UserId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private int AddressId;
    private boolean IsAdmin;
    private boolean IsBanned;
    private Address address;

    public OnlineUser() {
        address = new Address();
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int UserId) {
        this.UserId = UserId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAddressId() {
        return AddressId;
    }

    public void setAddressId(int AddressId) {
        this.AddressId = AddressId;
    }

    public boolean isIsAdmin() {
        return IsAdmin;
    }

    public void setIsAdmin(boolean IsAdmin) {
        this.IsAdmin = IsAdmin;
    }

    public boolean isIsBanned() {
        return IsBanned;
    }

    public void setIsBanned(boolean IsBanned) {
        this.IsBanned = IsBanned;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    
    @Override
    public String toString()
    {
        StringBuilder toReturn = new StringBuilder();
        toReturn.append( "{" );
        toReturn.append( surroundWithQuotes( "userId" ) );
        toReturn.append( ":" );
        toReturn.append( surroundWithQuotes( Integer.toString(UserId) ) );
        
        toReturn.append( "," );
        toReturn.append( surroundWithQuotes( "firstName" ) );
        toReturn.append( ":" );
        toReturn.append( surroundWithQuotes( firstName ) );
                
        
        toReturn.append( "," );
        toReturn.append( surroundWithQuotes( "lastName" ) );
        toReturn.append( ":" );
        toReturn.append( surroundWithQuotes( lastName ) );
                
        toReturn.append( "," );
        toReturn.append( surroundWithQuotes( "email" ) );
        toReturn.append( ":" );
        toReturn.append( surroundWithQuotes( email ) );
        
        
        toReturn.append( "," );
        toReturn.append( surroundWithQuotes( "isAdmin" ) );
        toReturn.append( ":" );
        toReturn.append( surroundWithQuotes( Boolean.toString(IsAdmin) ) );
        
        toReturn.append( "," );
        toReturn.append( surroundWithQuotes( "isDisabled" ) );
        toReturn.append( ":" );
        toReturn.append( surroundWithQuotes( Boolean.toString(IsBanned) ) );
        
        toReturn.append( "," );
        toReturn.append( surroundWithQuotes( "address" ) );
        toReturn.append( ":" );
        toReturn.append( address.toString() );
        toReturn.append( "}" );
        return toReturn.toString();
    }
    

}
