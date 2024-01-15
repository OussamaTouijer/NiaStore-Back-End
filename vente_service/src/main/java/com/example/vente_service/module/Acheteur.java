package com.example.vente_service.module;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString @Data
public class Acheteur {
    private Integer idAcheteur;
    private String nom;
    private String prenom;
    private String email;
    private String adresse;
    private String ville;
}
