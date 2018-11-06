package by.glko2012.mcstore.model;

public class Instruments {
    private String inst_id;
    private String inst_name;
    private String type;
    private String manufFK_id;
    private String supplFK_id;
    private String price;

    public String getInst_id() {
        return inst_id;
    }

    public void setInst_id(String inst_id) {
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

    public String getManufFK_id() {
        return manufFK_id;
    }

    public void setManufFK_id(String manufFK_id) {
        this.manufFK_id = manufFK_id;
    }

    public String getSupplFK_id() {
        return supplFK_id;
    }

    public void setSupplFK_id(String supplFK_id) {
        this.supplFK_id = supplFK_id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

}
