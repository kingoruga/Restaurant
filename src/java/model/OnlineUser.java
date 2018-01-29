/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author syntel
 */
public class OnlineUser {
    private int UserId;
    private String FirstName;
    private String LastName;
    private String Email;
    private String Password;
    private int AddressId;
    private boolean IsAdmin;
    private boolean IsBanned;
    private Address address;
    
    public OnlineUser()
    {
        //default constructor for bean,do nothing
    }

    public OnlineUser(int id, String fname, String lname, String isAdmin, String email, int addressId, String status){
        this.UserId = id;
        this.FirstName = fname;
        this.LastName = lname;
        this.IsAdmin = isAdmin.compareToIgnoreCase("yes")==0;
        this.Email = email;
        this.IsBanned = status.compareToIgnoreCase("Enabled") != 0;
    }
   
    
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

           
    public int getUserId() {
        return UserId;
    }

    public void setUserId(int UserId) {
        this.UserId = UserId;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public boolean getIsAdmin() {
        return IsAdmin;
    }

    public void setIsAdmin(boolean IsAdmin) {
        this.IsAdmin = IsAdmin;
    }

    public boolean getIsBanned() {
        return IsBanned;
    }

    public void setIsBanned(boolean IsBanned) {
        this.IsBanned = IsBanned;
    }
    
    public int getAddressId() {
        return AddressId;
    }

    public void setAddressId(int AddressId) {
        this.AddressId = AddressId;
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
        toReturn.append( Orders.surroundWithQuotes( Integer.toString( UserId) ) );
        
        toReturn.append( "," );
        toReturn.append( Orders.surroundWithQuotes( "name" ) );
        toReturn.append( ":" );
        toReturn.append( Orders.surroundWithQuotes( FirstName + " " + LastName ) );
        
        toReturn.append( "," );
        toReturn.append( Orders.surroundWithQuotes( "email" ) );
        toReturn.append( ":" );
        toReturn.append( Orders.surroundWithQuotes( Email ) );

        toReturn.append( "," );
        toReturn.append( Orders.surroundWithQuotes( "admin" ) );
        toReturn.append( ":" );
        toReturn.append( Orders.surroundWithQuotes( IsAdmin + "" ) );

        toReturn.append( "," );
        toReturn.append( Orders.surroundWithQuotes( "banned" ) );
        toReturn.append( ":" );
        toReturn.append( Orders.surroundWithQuotes( IsBanned + "" ) );
        
        toReturn.append( "}" );
        return toReturn.toString();
    }
}
