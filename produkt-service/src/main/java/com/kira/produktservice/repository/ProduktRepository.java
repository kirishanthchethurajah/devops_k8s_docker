package com.kira.produktservice.repository;

import com.kira.produktservice.model.Produkt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduktRepository extends JpaRepository<Produkt, Long> {
}
