package by.glko2012.mcstore.dao;

import by.glko2012.mcstore.model.Orders;

import java.util.List;

public interface OrdersDAO {

    void addOrder(Orders orders);

    void removeOrder(int orderId);

    void updateOrder(Orders order);

    List<Orders> getOrders();

    Orders getOrderById(int orderId);
}
