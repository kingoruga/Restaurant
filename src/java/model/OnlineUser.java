
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author syntel
 */
public class OnlineUser implements Serializable{
    private int userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private int addressId;
    private boolean isAdmin;
    private boolean isBanned;
    private Address address;
    
    /*private String street;
    private String city;
    private String state;
    private int zip;*/

    public OnlineUser(int id, String fname, String lname, String isAdmin, String email, int addressId, String status){
        this.userId = id;
        this.firstName = fname;
        this.lastName = lname;
        this.isAdmin = isAdmin.compareToIgnoreCase("yes")==0;
        this.email = email;
        this.isBanned = status.compareToIgnoreCase("Enabled") != 0;
    }

    public OnlineUser() {
        address = new Address();
    }

   /* public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
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

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }*/
    
  
   
    
    
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

           
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public boolean getIsBanned() {
        return isBanned;
    }

    public void setIsBanned(boolean isBanned) {
        this.isBanned = isBanned;
    }
    
    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }
  
      /*
    private int UserId;
    private String FirstName;
    private String LastName;
    private String Email;
    private String Password;
    private int AddressId;
    private boolean IsAdmin;
    private boolean IsBanned;
    private Address address;
    */
    @Override
    public String toString()
    {
        StringBuilder toReturn = new StringBuilder();
        toReturn.append( "{" );
        toReturn.append( Orders.surroundWithQuotes( "userid" ) );
        toReturn.append( ":" );
        toReturn.append( Orders.surroundWithQuotes( Integer.toString( userId) ) );
        
        toReturn.append( "," );
        toReturn.append( Orders.surroundWithQuotes( "name" ) );
        toReturn.append( ":" );
        toReturn.append( Orders.surroundWithQuotes( firstName + " " + lastName ) );
        
        toReturn.append( "," );
        toReturn.append( Orders.surroundWithQuotes( "firstname" ) );
        toReturn.append( ":" );
        toReturn.append( Orders.surroundWithQuotes( firstName  ) );
        
         toReturn.append( "," );
        toReturn.append( Orders.surroundWithQuotes( "lastname" ) );
        toReturn.append( ":" );
        toReturn.append( Orders.surroundWithQuotes(  lastName ) );
        
        toReturn.append( "," );
        toReturn.append( Orders.surroundWithQuotes( "email" ) );
        toReturn.append( ":" );
        toReturn.append( Orders.surroundWithQuotes( email ) );

        toReturn.append( "," );
        toReturn.append( Orders.surroundWithQuotes( "admin" ) );
        toReturn.append( ":" );
        toReturn.append(  isAdmin );
        toReturn.append("");

        toReturn.append( "," );
        toReturn.append( Orders.surroundWithQuotes( "banned" ) );
        toReturn.append( ":" );
        toReturn.append( Orders.surroundWithQuotes( isBanned + "" ) );

        if ( address != null )
        {
            toReturn.append( "," );
            toReturn.append( Orders.surroundWithQuotes( "address" ) );
            toReturn.append( ":" );
            toReturn.append( address.toString() );
        }

        toReturn.append( "}" );
        return toReturn.toString();
    }


    
}
