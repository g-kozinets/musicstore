package by.glko2012.mcstore.model;

import javax.persistence.*;

@Entity
public class Instruments {
    public Instruments() {
    }
    public Instruments(String inst_name, String type, int manufFK_id, int supplFK_id, double price) {
        this.inst_name = inst_name;
        this.type = type;
        this.manufFK_id = manufFK_id;
        this.supplFK_id = supplFK_id;
        this.price = price;
    }

    @Id
    @Column(name = "instrPK_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int instrumentID;

    @Column(name = "instr_name")
    private String inst_name;

    @Column(name = "type")
    private String type;

    @Column(name = "manufctFK_id")
    private int manufFK_id;

    @Column(name = "supplierFK_id")
    private int supplFK_id;

    @Column(name = "price")
    private double price;

    public int getInstrumentID() {
        return instrumentID;
    }

    public void setInstrumentID(int instrumentID) {
        this.instrumentID = instrumentID;
    }

    public String getInst_name() {
        return inst_name;
    }

    public void setInst_name(String inst_name) {
        this.inst_name = inst_name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getManufFK_id() {
        return manufFK_id;
    }

    public void setManufFK_id(int manufFK_id) {
        this.manufFK_id = manufFK_id;
    }

    public int getSupplFK_id() {
        return supplFK_id;
    }

    public void setSupplFK_id(int supplFK_id) {
        this.supplFK_id = supplFK_id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
