package by.glko2012.mcstore.model;

import javax.persistence.*;

@Entity
public class Manufacturers {
    public Manufacturers() {
    }

    public Manufacturers(String location, String name) {
        this.location = location;
        this.name = name;
    }

    @Column(name = "manufct_location")
    private String location;

    @Column(name = "manufct_name")
    private String name;

    @Id
    @Column(name = "manufacturePK_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
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