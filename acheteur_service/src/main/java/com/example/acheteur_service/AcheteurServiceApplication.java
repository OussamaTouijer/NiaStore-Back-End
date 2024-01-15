package com.example.acheteur_service;

import com.example.acheteur_service.entitise.Acheteur;
import com.example.acheteur_service.repositories.AcheteurRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.List;
@EnableFeignClients
@SpringBootApplication
public class AcheteurServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AcheteurServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(AcheteurRepository acheteurRepository){
        return args -> {
            acheteurRepository.save(Acheteur.builder()
                    .nom("Ali")
                    .prenom("Mohammed")
                    .email("Ali Mohammed@gmail.com")
                    .adresse("hay riad")
                    .ville("Rabat").idProduit(2)
                    .build());

            acheteurRepository.save(Acheteur.builder()
                    .nom(" wydad")
                    .prenom("Khaoula")
                    .email("Khaoula@gmail.com")
                    .adresse("darb ghalaf")
                    .ville("Casablanca").idProduit(3)
                    .build());

            acheteurRepository.save(Acheteur.builder()
                    .nom("Zahrawi")
                    .prenom("Driss")
                    .email("Driss@gmail.com")
                    .adresse("madina aolia")
                    .ville("kenitra").idProduit(5)
                    .build());

            acheteurRepository.save(Acheteur.builder()
                    .nom("Touijer")
                    .prenom("Oussama")
                    .email("Oussama5Touijer@gmail.com")
                    .adresse("hay chikh lamfadel")
                    .ville("Sale").idProduit(6)
                    .build());

            acheteurRepository.save(Acheteur.builder()
                    .nom("Nora")
                    .prenom("Samawi")
                    .email("Samawi@gmail.com")
                    .adresse("daoudiat")
                    .ville("Marrakech").idProduit(3)
                    .build());

            acheteurRepository.save(Acheteur.builder()
                    .nom("Hayat")
                    .prenom("Nanah")
                    .email("Nanah@gmail.com")
                    .adresse("hafa")
                    .ville("Tanger").idProduit(2)
                    .build());
        };
    }
}
