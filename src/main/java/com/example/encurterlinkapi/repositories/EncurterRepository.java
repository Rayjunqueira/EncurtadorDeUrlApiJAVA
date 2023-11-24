package com.example.encurterlinkapi.repositories;

import com.example.encurterlinkapi.models.EncurterModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface EncurterRepository extends JpaRepository<EncurterModel, UUID> {
    boolean existsByEncurterCode(Integer code);
    Optional<EncurterModel> findByEncurterCode(Integer encurterCode);
}
