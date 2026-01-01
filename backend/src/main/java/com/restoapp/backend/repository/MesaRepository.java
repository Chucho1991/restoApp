package com.restoapp.backend.repository;

import com.restoapp.backend.domain.Mesa;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MesaRepository extends MongoRepository<Mesa, String> {
    List<Mesa> findByDisponible(boolean disponible);
}
