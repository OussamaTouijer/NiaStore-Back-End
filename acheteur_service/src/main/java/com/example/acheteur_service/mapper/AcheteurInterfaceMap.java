package com.example.acheteur_service.mapper;

import com.example.acheteur_service.dto.AcheteurRequestDTO;
import com.example.acheteur_service.dto.AcheteurResponseDTO;
import com.example.acheteur_service.entitise.Acheteur;

public interface AcheteurInterfaceMap {
    public Acheteur requestDTO_ToAcheteur(AcheteurRequestDTO acheteurRequestDTO);
    public AcheteurResponseDTO acheteur_ToResponseDTO(Acheteur acheteur);
}