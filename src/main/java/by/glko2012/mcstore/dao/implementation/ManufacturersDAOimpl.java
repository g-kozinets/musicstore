package by.glko2012.mcstore.dao.implementation;

import by.glko2012.mcstore.dao.ManufacturersDAO;
import by.glko2012.mcstore.dao.exeption.DaoException;
import by.glko2012.mcstore.model.Instruments;
import by.glko2012.mcstore.model.Manufacturers;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;

public class ManufacturersDAOimpl implements ManufacturersDAO {


    private static final String INSERT_MANUFACTURE = "INSERT INTO mydb.manufacturers (manufct_name, manufct_location) VALUES (?, ?)";
    private static final String SELECT_MANUFACTURE = "SELECT * FROM mydb.manufacturers WHERE manufacturers.manufacturePK_id =?";
    private static final String SELECT_MANUFACTURERS = "SELECT * FROM mydb.manufacturers";
    private static final String UPDATE_MANUFACTURE = "UPDATE mydb.manufacturers SET manufct_name=?, manufct_location=? WHERE manufacturers.manufacturePK_id=?";
    private static final String DELETE_MANUFACTURE = "DELETE FROM mydb.manufacturers WHERE manufacturers.manufacturePK_id=?";

    private final DataSource dataSource;

    public ManufacturersDAOimpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void addManufacture(Manufacturers manufacturers) {
        try (Connection connection = dataSource.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(INSERT_MANUFACTURE)) {

                statement.setString(1, manufacturers.getName());
                statement.setString(2, manufacturers.getLocation());

                int rows = statement.executeUpdate();
            }

        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void removeManufacture(int manufactureId) {
        try (Connection connection = dataSource.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(DELETE_MANUFACTURE)) {
                statement.setInt(1, manufactureId);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void updateManufacture(Manufacturers manufacturers) {
        try (Connection connection = dataSource.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(UPDATE_MANUFACTURE)) {

                statement.setString(1, manufacturers.getName());
                statement.setString(2, manufacturers.getLocation());
                statement.setInt(3, manufacturers.getManuf_id());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public ArrayList<Manufacturers> getManufacturers() {
        try (Connection connection = dataSource.getConnection()) {
            ArrayList<Manufacturers> instruments = new ArrayList<>();
            try (Statement stmt = connection.createStatement();
                 ResultSet res = stmt.executeQuery(SELECT_MANUFACTURERS)) {
                while (res.next()) {
                    Manufacturers manufacturers = new Manufacturers();
                    manufacturers.setManuf_id(res.getInt("manufctPK_id"));
                    manufacturers.setName(res.getString("manufct_name"));
                    manufacturers.setLocation(res.getString("manufct_location"));
                    instruments.add(manufacturers);
                }
            }
            return instruments;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Manufacturers getManufactureById(int manufactureId){
        try (Connection connection = dataSource.getConnection()) {
            Manufacturers manufacturers = new Manufacturers();
            try (PreparedStatement statement = connection.prepareStatement(SELECT_MANUFACTURE)) {
                statement.setInt(1, manufactureId);
                try (ResultSet res = statement.executeQuery()) {
                    if (res.next()) {
                        manufacturers.setManuf_id(res.getInt("manufctPK_id"));
                        manufacturers.setName(res.getString("manufct_name"));
                        manufacturers.setLocation(res.getString("manufct_location"));
                    }
                }
            }
            return manufacturers;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

}