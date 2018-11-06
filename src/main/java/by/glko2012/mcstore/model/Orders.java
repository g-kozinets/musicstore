package by.glko2012.mcstore.model;

public class Orders {
    private String order_id;
    private String order_name;
    private String addressFK_id;
    private String total_price;
    private String instrFK_id;

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getOrder_name() {
        return order_name;
    }

    public void setOrder_name(String order_name) {
        this.order_name = order_name;
    }

    public String getAddressFK_id() {
        return addressFK_id;
    }

    public void setAddressFK_id(String addressFK_id) {
        this.addressFK_id = addressFK_id;
    }

    public String getTotal_price() {
        return total_price;
    }

    public void setTotal_price(String total_price) {
        this.total_price = total_price;
    }

    public String getInstrFK_id() {
        return instrFK_id;
    }

    public void setInstrFK_id(String instrFK_id) {
        this.instrFK_id = instrFK_id;
    }


}
