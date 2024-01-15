package com.example.vente_service.repositories;

import com.example.vente_service.entities.Vente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VenteRepository extends JpaRepository<Vente,Integer> {
    @Query("SELECT v FROM Vente v WHERE v.idV = :id")
    List<Vente> findByIdContainingIgnoreCase(@Param("id") Integer id);

}
