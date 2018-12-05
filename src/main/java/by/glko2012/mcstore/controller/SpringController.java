package by.glko2012.mcstore.controller;

import by.glko2012.mcstore.model.Addresses;
import by.glko2012.mcstore.repository.AddressessRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
    public class SpringController {

        @Autowired
        private AddressessRepo addressessRepo;

        @GetMapping("/listAddress")
        public String listAddress(Map<String, Object> model) {
            Iterable<Addresses> addresses = addressessRepo.findAll();

            model.put("addresses", addresses);
            return "listAddress";
        }

    }