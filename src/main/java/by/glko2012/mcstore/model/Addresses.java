package by.glko2012.mcstore.model;

public class Addresses {
    private int addressID;
    private String street_name;
    private String street_number;
    //constructors   //getter-setters
    public int setaddressID(int address) {
        return this.addressID = address;
    }

    public int getAddressID() {
        return this.addressID;
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