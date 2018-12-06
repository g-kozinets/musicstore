package by.glko2012.mcstore.model;

import javax.persistence.*;

@Entity
public class Addresses {

    public Addresses(){}
    public Addresses(String street_name, String street_number) {
        this.street_name = street_name;
        this.street_number = street_number;
    }

    @Id
    @Column(name = "adressPK_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int adressID;

    @Column(name = "street_name")
    private String street_name;

    @Column(name = "street_number")
    private String street_number;
    //constructors   //getter-setters
    public int setaddressID(int address) {
        return this.adressID = address;
    }

    public int getAdressID() {
        return this.adressID;
    }

    public String setstreet_name(String street_name) {
        return this.street_name = street_name;
    }

    public String getStreet_name() {
        return this.street_name;
    }

    public String setstreet_number(String street_number) {
        return this.street_number = street_number;
    }

    public String getStreet_number() {
        return this.street_number;
    }
}