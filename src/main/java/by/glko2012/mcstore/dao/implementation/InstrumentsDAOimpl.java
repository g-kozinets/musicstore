package by.glko2012.mcstore.dao.implementation;

import by.glko2012.mcstore.dao.InstrumentsDAO;
import by.glko2012.mcstore.dao.exeption.DaoException;
import by.glko2012.mcstore.model.Addresses;
import by.glko2012.mcstore.model.Instruments;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;

public class InstrumentsDAOimpl implements InstrumentsDAO {

        private static final String INSERT_INSTRUMENT = "INSERT INTO instruments (instr_name, type, manufct_FK_id, supplierFK_id) VALUES (?, ?, ?, ?)";
        private static final String SELECT_INSTRUMENT = "SELECT * FROM instruments WHERE instruments.instrPK_id =?";
        private static final String SELECT_INSTRUMENTS = "SELECT * FROM instruments";
        private static final String UPDATE_INSTRUMENT = "UPDATE instruments SET instr_name=?, type=?, manufct_id, supplierFK_id WHERE addresses.addressPK_ID=?";
        private static final String DELETE_INSTRUMENT = "DELETE FROM instruments WHERE instruments.instrPK_ID=?";

        private final DataSource dataSource;

        public InstrumentsDAOimpl(DataSource dataSource) {
            this.dataSource = dataSource;
        }

        @Override
        public void addInstrument (Instruments instruments) {
            try (Connection connection = dataSource.getConnection()) {
                try (PreparedStatement statement = connection.prepareStatement(INSERT_INSTRUMENT)) {

                    statement.setString(1, instruments.getInst_name());
                    statement.setString(2, instruments.getType());
                    statement.setInt(3, instruments.getManufFK_id());
                    statement.setInt(4, instruments.getSupplFK_id());


                    int rows = statement.executeUpdate();
                }

            } catch (SQLException e) {
                throw new DaoException(e);
            }
        }

        @Override
        public void removeInstrument(int instrumentId) {
            try (Connection connection = dataSource.getConnection()) {
                try (PreparedStatement statement = connection.prepareStatement(DELETE_INSTRUMENT)) {
                    statement.setInt(1, instrumentId);
                    statement.executeUpdate();
                }
            } catch (SQLException e) {
                throw new DaoException(e);
            }
        }

        @Override
        public void updateInstrument(Instruments instruments) {
            try (Connection connection = dataSource.getConnection()) {
                try (PreparedStatement statement = connection.prepareStatement(UPDATE_INSTRUMENT)) {

                    statement.setString(1, instruments.getInst_name());
                    statement.setString(2, instruments.getType());
                    statement.setInt(3, instruments.getManufFK_id());
                    statement.setInt(4, instruments.getSupplFK_id());
                    statement.setInt(5, instruments.getInst_id());

                    statement.executeUpdate();
                }
            } catch (SQLException e) {
                throw new DaoException(e);
            }
        }

        @Override
        public ArrayList<Instruments> getInstruments() {
            try (Connection connection = dataSource.getConnection()) {
                ArrayList<Instruments> instruments = new ArrayList<>();
                try (Statement stmt = connection.createStatement();
                     ResultSet res = stmt.executeQuery(SELECT_INSTRUMENTS)) {
                    while (res.next()) {
                        Instruments instrument = new Instruments();
                        instrument.setInst_id(res.getInt("instrPK_id"));
                        instrument.setInst_name(res.getString("instr_name"));
                        instrument.setType(res.getString("type"));
                        instrument.setManufFK_id(res.getInt("manufctFK_ID"));
                        instrument.setSupplFK_id(res.getInt("supplierFK_ID"));
                        instruments.add(instrument);
                    }
                }
                return instruments;
            } catch (SQLException e) {
                throw new DaoException(e);
            }
        }

        @Override
        public Instruments getInstrumentById(int instrumentId) {
            try (Connection connection = dataSource.getConnection()) {
                Instruments instrument = new Instruments();
                try (PreparedStatement statement = connection.prepareStatement(SELECT_INSTRUMENT)) {
                    statement.setInt(1, instrumentId);
                    try (ResultSet res = statement.executeQuery()) {
                        if (res.next()) {
                            instrument.setInst_id(res.getInt("instrPK_id"));
                            instrument.setInst_name(res.getString("instr_name"));
                            instrument.setType(res.getString("type"));
                            instrument.setManufFK_id(res.getInt("manufctFK_ID"));
                            instrument.setSupplFK_id(res.getInt("supplierFK_ID"));
                        }
                    }
                }
                return instrument;
            } catch (SQLException e) {
                throw new DaoException(e);
            }
        }

    }