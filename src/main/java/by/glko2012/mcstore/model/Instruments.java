package by.glko2012.mcstore.model;

public class Instruments {
    private int instrumentID;
    private String inst_name;
    private String type;
    private int manufFK_id;
    private int supplFK_id;
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
