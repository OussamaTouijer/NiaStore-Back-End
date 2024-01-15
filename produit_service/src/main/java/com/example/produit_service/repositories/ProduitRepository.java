package com.example.produit_service.repositories;

import com.example.produit_service.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProduitRepository extends JpaRepository<Produit,Integer> {
    @Query("SELECT p FROM Produit p WHERE LOWER(p.nom) LIKE LOWER(concat('%', :keyword, '%'))")
    List<Produit> findByNomContainingIgnoreCase(@Param("keyword") String keyword);
}
