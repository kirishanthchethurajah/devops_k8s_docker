package com.kira.gutscheinservice.repository;

import com.kira.gutscheinservice.model.Gutschein;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GutscheinRepository extends JpaRepository<Gutschein,Long> {
    Gutschein findByCode(String code);
}
