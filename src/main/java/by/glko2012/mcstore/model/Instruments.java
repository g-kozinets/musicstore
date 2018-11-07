package by.glko2012.mcstore.model;

public class Instruments {
    private int inst_id;
    private String inst_name;
    private String type;
    private int manufFK_id;
    private int supplFK_id;
    private double price;

    public int getInst_id() {
        return inst_id;
    }

    public void setInst_id(int inst_id) {
        this.inst_id = inst_id;
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
