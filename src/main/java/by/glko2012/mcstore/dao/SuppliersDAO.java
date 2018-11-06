package by.glko2012.mcstore.dao;

import by.glko2012.mcstore.model.Suppliers;

import java.util.List;

public interface SuppliersDAO {

    void addSupplier(Suppliers suppliers);

    void removeSupplier(int supplierId);

    void updateSupplier(Suppliers supplier);

    List<Suppliers> getSuppliers();

    Suppliers getSupplierById(int supplierId);
}
