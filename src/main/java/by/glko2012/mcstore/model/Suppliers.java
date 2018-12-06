package by.glko2012.mcstore.model;

import javax.persistence.*;

@Entity
public class Suppliers {
    public Suppliers() {
    }

    public Suppliers(String suppl_name, String suppl_location, double delivery_price) {
        this.suppl_name = suppl_name;
        this.suppl_location = suppl_location;
        this.delivery_price = delivery_price;
    }

    @Id
    @Column(name = "supplierPK_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int suppl_id;

    @Column(name = "supplier_name")
    private String suppl_name;

    @Column(name = "supplier_location")
    private String suppl_location;

    @Column(name = "delivery_price")
    private double delivery_price;

    public int getSuppl_id() {
        return suppl_id;
    }

    public void setSuppl_id(int suppl_id) {
        this.suppl_id = suppl_id;
    }

    public String getSuppl_name() {
        return suppl_name;
    }

    public void setSuppl_name(String suppl_name) {
        this.suppl_name = suppl_name;
    }

    public String getSuppl_location() {
        return suppl_location;
    }

    public void setSuppl_location(String suppl_location) {
        this.suppl_location = suppl_location;
    }

    public double getDelivery_price() {
        return delivery_price;
    }

    public void setDelivery_price(double delivery_price) {
        this.delivery_price = delivery_price;
    }



}
