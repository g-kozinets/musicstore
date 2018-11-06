package by.glko2012.mcstore.dao;

import by.glko2012.mcstore.model.Manufacturers;

import java.util.List;

public interface ManufacturersDAO {

    void addManufacture(Manufacturers manufacturers);

    void removeManufacture(int manufactureId);

    void updateManufacture(Manufacturers manufacturers);

    List<Manufacturers> getManufacturers();

    Manufacturers getManufactureById(int manufactureId);
}
