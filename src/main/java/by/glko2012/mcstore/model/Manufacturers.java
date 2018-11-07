package by.glko2012.mcstore.model;

public class Manufacturers {
    private String location;
    private String name;
    private int manuf_id;

    //constructors   //getter-setters
    public String setLocation(String location) {
        return this.location = location;
    }

    public String getLocation() {
        return this.location;
    }

    public String setName(String name) {
        return this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int setManuf_id(int manuf_id) {
        return this.manuf_id = manuf_id;
    }

    public int getManuf_id() {
        return this.manuf_id;
    }
}