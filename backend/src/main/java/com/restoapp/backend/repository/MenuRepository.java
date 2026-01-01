package com.restoapp.backend.repository;

import com.restoapp.backend.domain.MenuItem;
import com.restoapp.backend.domain.enums.MenuCategory;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MenuRepository extends MongoRepository<MenuItem, String> {
    List<MenuItem> findByCategoria(MenuCategory categoria);
}
