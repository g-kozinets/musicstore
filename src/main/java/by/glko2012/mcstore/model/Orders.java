package by.glko2012.mcstore.model;

public class Orders {
    private int order_id;
    private String order_name;
    private int addressFK_id;
    private double total_price;
    private int instrFK_id;

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getOrder_name() {
        return order_name;
    }

    public void setOrder_name(String order_name) {
        this.order_name = order_name;
    }

    public int getAddressFK_id() {
        return addressFK_id;
    }

    public void setAddressFK_id(int addressFK_id) {
        this.addressFK_id = addressFK_id;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public int getInstrFK_id() {
        return instrFK_id;
    }

    public void setInstrFK_id(int instrFK_id) {
        this.instrFK_id = instrFK_id;
    }


}
