package by.glko2012.mcstore.dao;

import by.glko2012.mcstore.model.Addresses;

import java.util.List;

public interface AddressesDAO {
    void addAddress(Addresses addresses);

    void removeAddress(int addressId);

    void updateAddress(Addresses addresses);

    List<Addresses> getAddresses();


    int getNextAi();

    Addresses getAddressById(int addressId);
}