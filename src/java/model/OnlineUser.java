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
    private int userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private int addressId;
    private boolean isAdmin;
    private boolean isBanned;
    private Address address;

    public OnlineUser(int id, String fname, String lname, String isAdmin, String email, int addressId, String status){
        this.userId = id;
        this.firstName = fname;
        this.lastName = lname;
        this.isAdmin = isAdmin.compareToIgnoreCase("yes")==0;
        this.email = email;
        this.isBanned = status.compareToIgnoreCase("Enabled") != 0;
    }

    public OnlineUser() {
        
    }
   
    
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

    
}
