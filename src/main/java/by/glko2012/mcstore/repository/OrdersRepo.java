package by.glko2012.mcstore.repository;

import by.glko2012.mcstore.model.Orders;
import org.springframework.data.repository.CrudRepository;

public interface OrdersRepo extends CrudRepository<Orders, Long> {
}
