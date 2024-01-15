package com.example.acheteur_service.dto;

import com.example.acheteur_service.module.Produit;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder @ToString @Getter @Setter
public class AcheteurRequestDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAcheteur;
    private String nom;
    private String prenom;
    private String email;
    private String adresse;
    private String ville;
    private Integer idProduit;
    @Transient
    private Produit produit;
}
