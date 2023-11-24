package com.example.encurterlinkapi.services;

import com.example.encurterlinkapi.models.EncurterModel;
import com.example.encurterlinkapi.repositories.EncurterRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EncurterService {
    final EncurterRepository encurterRepository;

    public EncurterService(EncurterRepository encurterRepository) {
        this.encurterRepository = encurterRepository;
    }

    public EncurterModel save(EncurterModel encurterModel) {
        return encurterRepository.save(encurterModel);
    }

    public boolean existsByEncurterCode(Integer encurterCode) {
        return encurterRepository.existsByEncurterCode(encurterCode);
    }
    public Optional<EncurterModel> findByEncurterCode(Integer encurterCode) {
        return encurterRepository.findByEncurterCode(encurterCode);
    }
}
