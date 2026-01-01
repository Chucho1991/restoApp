package com.restoapp.backend.config;

import com.restoapp.backend.domain.MenuItem;
import com.restoapp.backend.domain.Mesa;
import com.restoapp.backend.domain.User;
import com.restoapp.backend.domain.enums.MenuCategory;
import com.restoapp.backend.domain.enums.Role;
import com.restoapp.backend.repository.MenuRepository;
import com.restoapp.backend.repository.MesaRepository;
import com.restoapp.backend.repository.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class DemoDataConfig {
    private static final Logger log = LoggerFactory.getLogger(DemoDataConfig.class);
    private final UserRepository userRepository;
    private final MenuRepository menuRepository;
    private final MesaRepository mesaRepository;

    @Bean
    @ConditionalOnProperty(name = "restoapp.demo-data", havingValue = "true")
    ApplicationRunner loadDemoData() {
        return args -> {
            if (userRepository.count() == 0) {
                userRepository.saveAll(List.of(
                        User.builder().nombre("Admin").email("admin@restoapp.com").rol(Role.ADMINISTRADOR).build(),
                        User.builder().nombre("Mesero 1").email("mesero1@restoapp.com").rol(Role.MESERO).build(),
                        User.builder().nombre("Despachador 1").email("despacho@restoapp.com").rol(Role.DESPACHADOR).build()
                ));
                log.info("Usuarios demo creados");
            }

            if (menuRepository.count() == 0) {
                menuRepository.saveAll(List.of(
                        MenuItem.builder().nombre("Bruschetta").descripcion("Pan tostado con tomates").precio(4.50).categoria(MenuCategory.ENTRADA).disponible(true).build(),
                        MenuItem.builder().nombre("Pasta Alfredo").descripcion("Fetuccini con salsa cremosa").precio(10.99).categoria(MenuCategory.FUERTE).disponible(true).build(),
                        MenuItem.builder().nombre("Tiramisú").descripcion("Clásico postre italiano").precio(5.50).categoria(MenuCategory.POSTRE).disponible(true).build(),
                        MenuItem.builder().nombre("Limonada").descripcion("Bebida refrescante").precio(2.50).categoria(MenuCategory.BEBIDA).disponible(true).build()
                ));
                log.info("Menú demo creado");
            }

            if (mesaRepository.count() == 0) {
                mesaRepository.saveAll(List.of(
                        Mesa.builder().nombre("Mesa 1").disponible(true).ocupantesPosibles(4).ocupantesActuales(0).build(),
                        Mesa.builder().nombre("Mesa 2").disponible(true).ocupantesPosibles(2).ocupantesActuales(0).build(),
                        Mesa.builder().nombre("Barra").disponible(true).ocupantesPosibles(6).ocupantesActuales(0).build()
                ));
                log.info("Mesas demo creadas");
            }
        };
    }
}
