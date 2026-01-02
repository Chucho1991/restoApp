package com.restoapp.backend.service;

import com.restoapp.backend.domain.Mesa;
import com.restoapp.backend.dto.MesaRequest;
import com.restoapp.backend.repository.MesaRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MesaService {
    private final MesaRepository mesaRepository;

    public List<Mesa> list(Boolean disponible) {
        if (disponible != null) {
            return mesaRepository.findByDisponible(disponible);
        }
        return mesaRepository.findAll();
    }

    public Mesa create(MesaRequest request) {
        Mesa mesa = Mesa.builder()
                .nombre(request.getNombre())
                .disponible(request.isDisponible())
                .ocupantesPosibles(request.getOcupantesPosibles())
                .ocupantesActuales(request.getOcupantesActuales())
                .build();
        return mesaRepository.save(mesa);
    }

    public Optional<Mesa> update(String id, MesaRequest request) {
        return mesaRepository.findById(id).map(existing -> {
            existing.setNombre(request.getNombre());
            existing.setDisponible(request.isDisponible());
            existing.setOcupantesPosibles(request.getOcupantesPosibles());
            existing.setOcupantesActuales(request.getOcupantesActuales());
            return mesaRepository.save(existing);
        });
    }
}
