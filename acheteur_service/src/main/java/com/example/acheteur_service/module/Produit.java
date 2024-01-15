package com.example.acheteur_service.module;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString @Data
public class Produit {
    private Integer idProduit;
    private String nom;
    private String marque;
    private String description;
    private Double prix;
    private Integer quantite;
}
