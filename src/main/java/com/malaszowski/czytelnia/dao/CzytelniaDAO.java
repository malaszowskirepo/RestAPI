package com.malaszowski.czytelnia.dao;

import com.malaszowski.czytelnia.entity.Czytelnia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CzytelniaDAO extends JpaRepository<Czytelnia, Integer> {
    Czytelnia getCzytelniaByNazwa(String nazwa);
}
