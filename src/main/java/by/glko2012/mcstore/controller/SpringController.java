package by.glko2012.mcstore.controller;

import by.glko2012.mcstore.model.*;
import by.glko2012.mcstore.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class SpringController {


    @Autowired
    private AddressessRepo addressessRepo;
    @Autowired
    private InstrumentsRepo instrumentsRepo;
    @Autowired
    private ManufacturersRepo manufacturersRepo;
    @Autowired
    private SuppliersRepo suppliersRepo;
    @Autowired
    private OrdersRepo ordersRepo;


    @GetMapping("/listAddress")
    public String listAddress(Map<String, Object> model) {
        Iterable<Addresses> addresses = addressessRepo.findAll();

        model.put("addresses", addresses);
        return "jsp/listAddress";
    }

    @GetMapping("/listInstrument")
    public String listInstrument(Map<String, Object> model) {
        Iterable<Instruments> instruments = instrumentsRepo.findAll();

        model.put("instruments", instruments);
        return "jsp/listInstrument";
    }

    @GetMapping("/listManufacture")
    public String listManufacture(Map<String, Object> model) {
        Iterable<Manufacturers> manufacturers = manufacturersRepo.findAll();

        model.put("manufacturers", manufacturers);
        return "jsp/listManufacture";
    }

    @GetMapping("/listSupplier")
    public String listSupplier(Map<String, Object> model) {
        Iterable<Suppliers> suppliers = suppliersRepo.findAll();

        model.put("suppliers", suppliers);
        return "jsp/listSupplier";
    }

    @GetMapping("/listOrder")
    public String listOrder(Map<String, Object> model) {
        Iterable<Orders> orders = ordersRepo.findAll();

        model.put("orders", orders);
        return "jsp/listOrders";
    }


}