package by.glko2012.mcstore.dao.implementation;

import by.glko2012.mcstore.dao.SuppliersDAO;
import by.glko2012.mcstore.dao.exeption.DaoException;
import by.glko2012.mcstore.model.Orders;
import by.glko2012.mcstore.model.Suppliers;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;

public class SuppliersDAOimpl implements SuppliersDAO{


    private static final String INSERT_SUPPLIER = "INSERT INTO mydb.suppliers (supplier_name, supplier_location, delivery_price) VALUES (?, ?, ?)";
    private static final String SELECT_SUPPLIER = "SELECT * FROM mydb.suppliers WHERE suppliers.supplierPK_id =?";
    private static final String SELECT_SUPPLIERS = "SELECT * FROM mydb.suppliers";
    private static final String UPDATE_SUPPLIER = "UPDATE mydb.suppliers SET supplier_name=?, supplier_location=?, delivery_price=? WHERE suppliers.supplierPK_id=?";
    private static final String DELETE_SUPPLIER = "DELETE FROM mydb.suppliers WHERE suppliers.supplierPK_id=?";

    private final DataSource dataSource;

    public SuppliersDAOimpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void addSupplier(Suppliers suppliers) {
        try (Connection connection = dataSource.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(INSERT_SUPPLIER)) {

                statement.setString(1, suppliers.getSuppl_name());
                statement.setString(2, suppliers.getSuppl_location());
                statement.setDouble(3, suppliers.getDelivery_price());
                int rows = statement.executeUpdate();
            }

        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void removeSupplier(int supplierId) {
        try (Connection connection = dataSource.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(DELETE_SUPPLIER)) {
                statement.setInt(1, supplierId);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void updateSupplier(Suppliers supplier) {
        try (Connection connection = dataSource.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(UPDATE_SUPPLIER)) {

                statement.setString(1, supplier.getSuppl_name());
                statement.setString(2, supplier.getSuppl_location());
                statement.setDouble(3, supplier.getDelivery_price());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public ArrayList<Suppliers> getSuppliers() {
        try (Connection connection = dataSource.getConnection()) {
            ArrayList<Suppliers> suppliers = new ArrayList<>();
            try (Statement stmt = connection.createStatement();
                 ResultSet res = stmt.executeQuery(SELECT_SUPPLIERS)) {
                while (res.next()) {
                    Suppliers supplier = new Suppliers();
                    supplier.setSuppl_id(res.getInt("orderPK_id"));
                    supplier.setSuppl_name(res.getString("order_name"));
                    supplier.setSuppl_location(res.getString("addressFK_ID"));
                    supplier.setDelivery_price(res.getDouble("totsl_price"));
                    suppliers.add(supplier);
                }
            }
            return suppliers;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Suppliers getSupplierById(int supplierId) {
        try (Connection connection = dataSource.getConnection()) {
            Suppliers supplier = new Suppliers();
            try (PreparedStatement statement = connection.prepareStatement(SELECT_SUPPLIER)) {
                statement.setInt(1, supplierId);
                try (ResultSet res = statement.executeQuery()) {
                    if (res.next()) {
                        supplier.setSuppl_id(res.getInt("supplier"));
                        supplier.setSuppl_name(res.getString("supplier"));
                        supplier.setSuppl_location(res.getString("supplier_location"));
                        supplier.setDelivery_price(res.getDouble("delivery_price"));
                    }
                }
            }
            return supplier;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}

