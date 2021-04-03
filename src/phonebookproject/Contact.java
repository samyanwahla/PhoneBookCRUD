/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonebookproject;

import java.util.Date;

/**
 *
 * @author Samyan
 */
public class Contact {
    private String name;
    private Date dob;
    private String contactNumber;
    private String email;
    private Date savedOn;

    public void setName(String name) {
        this.name = name;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public void setContactNumber(String contact) {
        this.contactNumber = contact;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSavedOn(Date savedOn) {
        this.savedOn = savedOn;
    }

    public String getName() {
        return name;
    }

    public Date getDob() {
        return dob;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public Date getSavedOn() {
        return savedOn;
    }
    
}
