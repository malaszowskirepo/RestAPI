package com.malaszowski.czytelnia.dao;

import com.malaszowski.czytelnia.entity.Ksiazka;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KsiazkaDAO extends JpaRepository<Ksiazka, Integer> {
    Optional<Ksiazka> findByTytul(String tytul);
}

