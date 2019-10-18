package com.malaszowski.czytelnia.dao;

import com.malaszowski.czytelnia.entity.Czytelnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CzytelnikDAO extends JpaRepository<Czytelnik, Integer> {
}
