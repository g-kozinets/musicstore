package by.glko2012.mcstore.dao.implementation;

import by.glko2012.mcstore.dao.OrdersDAO;
import by.glko2012.mcstore.dao.exeption.DaoException;
import by.glko2012.mcstore.model.Orders;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;

public class OrdersDAOimpl implements OrdersDAO {


    private static final String INSERT_ORDER = "INSERT INTO mydb.orders (order_name, addressFK_id, total_price, instrFK_id) VALUES (?, ?, ?, ?)";
    private static final String SELECT_ORDER = "SELECT * FROM mydb.orders WHERE orders.orderPK_id =?";
    private static final String SELECT_ORDERS = "SELECT * FROM mydb.orders";
    private static final String UPDATE_ORDER = "UPDATE mydb.orders SET order_name=?, order_addressFK_id=?, total_price=?, instrFK_id=? WHERE orders.orderPK_id=?";
    private static final String DELETE_ORDER = "DELETE FROM mydb.orders WHERE orders.orderPK_id=?";

    private final DataSource dataSource;

    public OrdersDAOimpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void addOrder(Orders orders) {
        try (Connection connection = dataSource.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(INSERT_ORDER)) {

                statement.setString(1, orders.getOrder_name());
                statement.setInt(2, orders.getAddressFK_id());
                statement.setDouble(3, orders.getTotal_price());
                statement.setInt(4, orders.getInstrFK_id());

                int rows = statement.executeUpdate();
            }

        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void removeOrder(int orderId) {
        try (Connection connection = dataSource.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(DELETE_ORDER)) {
                statement.setInt(1, orderId);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void updateOrder(Orders order) {
        try (Connection connection = dataSource.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(UPDATE_ORDER)) {

                statement.setString(1, order.getOrder_name());
                statement.setInt(2, order.getAddressFK_id());
                statement.setDouble(3, order.getTotal_price());
                statement.setInt(4, order.getInstrFK_id());
                statement.setInt(5, order.getOrder_id());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public ArrayList<Orders> getOrders() {
        try (Connection connection = dataSource.getConnection()) {
            ArrayList<Orders> orders = new ArrayList<>();
            try (Statement stmt = connection.createStatement();
                 ResultSet res = stmt.executeQuery(SELECT_ORDERS)) {
                while (res.next()) {
                    Orders order = new Orders();
                    order.setOrder_id(res.getInt("orderPK_id"));
                    order.setOrder_name(res.getString("order_name"));
                    order.setAddressFK_id(res.getInt("addressFK_ID"));
                    order.setTotal_price(res.getDouble("total_price"));
                    order.setInstrFK_id(res.getInt("instrFK_ID"));
                    orders.add(order);
                }
            }
            return orders;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Orders getOrderById(int order_id) {
        try (Connection connection = dataSource.getConnection()) {
            Orders order = new Orders();
            try (PreparedStatement statement = connection.prepareStatement(SELECT_ORDER)) {
                statement.setInt(1, order_id);
                try (ResultSet res = statement.executeQuery()) {
                    if (res.next()) {
                        order.setOrder_id(res.getInt("orderPK_id"));
                        order.setOrder_name(res.getString("order_name"));
                        order.setAddressFK_id(res.getInt("addressFK_ID"));
                        order.setTotal_price(res.getDouble("total_price"));
                        order.setInstrFK_id(res.getInt("instrFK_id"));
                    }
                }
            }
            return order;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}
