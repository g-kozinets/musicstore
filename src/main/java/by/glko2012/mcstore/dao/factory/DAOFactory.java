package by.glko2012.mcstore.dao.factory;

import by.glko2012.mcstore.dao.*;
import by.glko2012.mcstore.dao.implementation.*;

public class DAOFactory {
    private static final DAOFactory INSTANCE = new DAOFactory();

    private AddressesDAO addressesDAO = new AddressDAOimpl(DataSourceFactory.getDataSourceFactory().getDataSource());
    private InstrumentsDAO instrumentsDAO = new InstrumentsDAOimpl(DataSourceFactory.getDataSourceFactory().getDataSource());
    private ManufacturersDAO manufacturersDAO = new ManufacturersDAOimpl(DataSourceFactory.getDataSourceFactory().getDataSource());
    private OrdersDAO ordersDAO = new OrdersDAOimpl(DataSourceFactory.getDataSourceFactory().getDataSource());
    private SuppliersDAO suppliersDAO = new SuppliersDAOimpl(DataSourceFactory.getDataSourceFactory().getDataSource());

    public InstrumentsDAO getInstrumentsDAO() {
        return instrumentsDAO;
    }

    public ManufacturersDAO getManufacturersDAO() {
        return manufacturersDAO;
    }

    public OrdersDAO getOrdersDAO() {
        return ordersDAO;
    }

    public SuppliersDAO getSuppliersDAO() {
        return suppliersDAO;
    }

    public static DAOFactory getInstance() {
        return INSTANCE;
    }

}