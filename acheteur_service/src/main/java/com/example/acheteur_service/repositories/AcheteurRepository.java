package com.example.acheteur_service.repositories;

import com.example.acheteur_service.entitise.Acheteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AcheteurRepository extends JpaRepository<Acheteur,Integer> {
    @Query("SELECT a FROM Acheteur a WHERE LOWER(a.nom) LIKE LOWER(concat('%', :keyword, '%'))")
    List<Acheteur> findByNomContainingIgnoreCase(@Param("keyword") String keyword);
}
