package com.example.vente_service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.openfeign.EnableFeignClients;


import com.example.vente_service.entities.Vente;
import com.example.vente_service.repositories.VenteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class VenteServiceApplicationTests {

    @Autowired
    private VenteRepository venteRepository;

    @Test
    void testVenteRepository() {
        // Create instances of Vente
        Vente u1 = Vente.builder().idA(1).idP(2).build();
        Vente u2 = Vente.builder().idA(1).idP(3).build();
        Vente u3 = Vente.builder().idA(1).idP(4).build();
        Vente u4 = Vente.builder().idA(5).idP(3).build();
        Vente u5 = Vente.builder().idA(3).idP(1).build();

        // Save instances to the repository
        venteRepository.save(u1);
        venteRepository.save(u2);
        venteRepository.save(u3);
        venteRepository.save(u4);
        venteRepository.save(u5);

        // Retrieve instances from the repository
        Vente savedU1 = venteRepository.findById(u1.getIdV()).orElse(null);
        Vente savedU2 = venteRepository.findById(u2.getIdV()).orElse(null);
        Vente savedU3 = venteRepository.findById(u3.getIdV()).orElse(null);
        Vente savedU4 = venteRepository.findById(u4.getIdV()).orElse(null);
        Vente savedU5 = venteRepository.findById(u5.getIdV()).orElse(null);

        // Perform assertions
        assertEquals(u1, savedU1);
        assertEquals(u2, savedU2);
        assertEquals(u3, savedU3);
        assertEquals(u4, savedU4);
        assertEquals(u5, savedU5);
    }
}
