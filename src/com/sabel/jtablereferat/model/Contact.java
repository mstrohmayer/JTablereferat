package com.sabel.jtablereferat.model;


/**
 * Created by Matthias on 19.03.2017.
 */
public class Contact {
    private static int letzteID;

    private String emailAddress;
    private int id;
    private String name;
    private String phoneNummer;
    private String firstname;

    public Contact() {
        super();
        id = letzteID++;
    }

    public Contact(String name) {
        this();
        this.name = name;
    }

    public void setEmailAddress(String email) {
        this.emailAddress = email;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getEmail() {
        return this.emailAddress;
    }

    public String getNummer() {
        return this.phoneNummer;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setPhoneNumber(String nummer) {
        this.phoneNummer = nummer;
    }
}
