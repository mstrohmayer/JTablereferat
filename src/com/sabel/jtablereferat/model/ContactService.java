package com.sabel.jtablereferat.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Matthias on 19.03.2017.
 */
public class ContactService {
    private List<Contact> contacts;

    public ContactService() {
        contacts = new ArrayList<>();
        generiereTestdaten();
    }

    public int getSize() {
        return contacts.size();
    }

    public Contact getContact(int index) {
        return contacts.get(index);
    }

    public void add(Contact contact) {
        contacts.add(contact);
    }

    public void remove(int id) {
        contacts.remove(id);
    }

    public void setContact(Contact contact) {
        Contact c = suchen(contact.getName());
        if (c == null) {
            add(contact);
            return;
        }
        c.setFirstname(contact.getFirstname());
        c.setName(contact.getName());
        c.setEmailAddress(contact.getEmail());
        c.setPhoneNumber(contact.getNummer());
    }

    public String[] getHeader() {
        String[] header = {"ID", "Vorname", "Nachname", "Email-Adresse", "Telefon-Nr."};

        return header;
    }

    public Contact suchen(String name) {
        Contact foundContact = null;
        Iterator<Contact> it = contacts.iterator();
        while (it.hasNext()) {
            Contact k = it.next();
            if (k.getName().equals(name)) {
                foundContact = k;
                return foundContact;
            }
        }
        return foundContact;
    }

    private void generiereTestdaten() {
        Contact k1 = new Contact("Erster");
        Contact k2 = new Contact("Zweiter");
        Contact k3 = new Contact("Dritter");
        k1.setEmailAddress("heinz@irgend.wo");
        k2.setEmailAddress("hugo@web.de");
        k3.setEmailAddress("heino@orf.at");
        k1.setPhoneNumber("017048110815");
        k2.setPhoneNumber("015632546515");
        k3.setPhoneNumber("089 3395545");
        contacts.add(k1);
        contacts.add(k2);
        contacts.add(k3);
    }
}
