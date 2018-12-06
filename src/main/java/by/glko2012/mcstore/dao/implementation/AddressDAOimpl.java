package by.glko2012.mcstore.dao.implementation;

import by.glko2012.mcstore.dao.AddressesDAO;
import by.glko2012.mcstore.dao.exeption.DaoException;
import by.glko2012.mcstore.model.Addresses;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;

public class AddressDAOimpl implements AddressesDAO  {

        private static final String INSERT_ADDRESS = "INSERT INTO mydb.addresses (street_name, street_number) VALUES (?, ?)";
        private static final String SELECT_ADDRESS = "SELECT * FROM mydb.addresses WHERE adressPK_ID =?";
        private static final String SELECT_ADDRESSES = "SELECT * FROM mydb.addresses";
        private static final String UPDATE_ADDRESS = "UPDATE mydb.addresses SET street_name=?, street_number=? WHERE adressPK_ID=?";
        private static final String DELETE_ADDRESS = "DELETE FROM mydb.addresses WHERE adressPK_ID=?";
        private static final String NEXT_INCREMENT = "SELECT auto_increment FROM INFORMATION_SCHEMA.TABLES WHERE table_name = 'addresses'";

        private final DataSource dataSource;

        public AddressDAOimpl(DataSource dataSource) {
            this.dataSource = dataSource;
        }

        @Override
        public void addAddress(Addresses address) {
            try (Connection connection = dataSource.getConnection()) {
                try (PreparedStatement statement = connection.prepareStatement(INSERT_ADDRESS)) {

                    statement.setString(1, address.getStreet_name());
                    statement.setString(2, address.getStreet_number());

                    int rows = statement.executeUpdate();
                }

            } catch (SQLException e) {
                throw new DaoException(e);
            }
        }

        @Override
        public void removeAddress(int addressId) {
            try (Connection connection = dataSource.getConnection()) {
                try (PreparedStatement statement = connection.prepareStatement(DELETE_ADDRESS)) {
                    statement.setInt(1, addressId);
                    statement.executeUpdate();
                }
            } catch (SQLException e) {
                throw new DaoException(e);
            }
        }

        @Override
        public void updateAddress(Addresses address) {
            try (Connection connection = dataSource.getConnection()) {
                try (PreparedStatement statement = connection.prepareStatement(UPDATE_ADDRESS)) {

                    statement.setString(1, address.getStreet_name());
                    statement.setString(2, address.getStreet_number());
                    statement.setInt(3, address.getAdressID());

                    statement.executeUpdate();
                }
            } catch (SQLException e) {
                throw new DaoException(e);
            }
        }

    public int getNextAi() {
        try (Connection connection = dataSource.getConnection()) {
            int newID = 0;
            try (Statement stmt = connection.createStatement();
                 ResultSet result = stmt.executeQuery(NEXT_INCREMENT)) {
                if(result.first()) {
                    newID = result.getInt("AUTO_INCREMENT");
                }
                            }
            return newID;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
        @Override
        public ArrayList<Addresses> getAddresses() {
            try (Connection connection = dataSource.getConnection()) {
                ArrayList<Addresses> addresses = new ArrayList<>();
                try (Statement stmt = connection.createStatement();
                     ResultSet res = stmt.executeQuery(SELECT_ADDRESSES)) {
                    while (res.next()) {
                        Addresses address = new Addresses();
                        address.setaddressID(res.getInt("adressPK_id"));
                        address.setstreet_name(res.getString("street_name"));
                        address.setstreet_number(res.getString("street_number"));
                        addresses.add(address);
                    }
                }
                return addresses;
            } catch (SQLException e) {
                throw new DaoException(e);
            }
        }

        @Override
        public Addresses getAddressById(int addressID) {
            try (Connection connection = dataSource.getConnection()) {
                Addresses address = new Addresses();
                try (PreparedStatement statement = connection.prepareStatement(SELECT_ADDRESS)) {
                    statement.setInt(1, addressID);
                    try (ResultSet res = statement.executeQuery()) {
                        if (res.next()) {
                            address.setaddressID(res.getInt("adressPK_id"));
                            address.setstreet_name(res.getString("street_name"));
                            address.setstreet_number(res.getString("street_number"));
                        }
                    }
                }
                return address;
            } catch (SQLException e) {
                throw new DaoException(e);
            }
        }

    }