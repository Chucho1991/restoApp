package com.restoapp.backend.repository;

import com.restoapp.backend.domain.Orden;
import com.restoapp.backend.domain.enums.OrderStatus;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrdenRepository extends MongoRepository<Orden, String> {
    List<Orden> findByEstadoOrderByCreadaEnAsc(OrderStatus estado);
}
