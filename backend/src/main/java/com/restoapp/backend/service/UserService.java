package com.restoapp.backend.service;

import com.restoapp.backend.domain.User;
import com.restoapp.backend.dto.UserRequest;
import com.restoapp.backend.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User create(UserRequest request) {
        User user = User.builder()
                .nombre(request.getNombre())
                .email(request.getEmail())
                .rol(request.getRol())
                .build();
        return userRepository.save(user);
    }

    public Optional<User> update(String id, UserRequest request) {
        return userRepository.findById(id).map(existing -> {
            existing.setNombre(request.getNombre());
            existing.setEmail(request.getEmail());
            existing.setRol(request.getRol());
            return userRepository.save(existing);
        });
    }
}
