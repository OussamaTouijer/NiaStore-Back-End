package com.example.vente_service.mapper;

import com.example.vente_service.dto.VenteRequestDTO;
import com.example.vente_service.dto.VenteResponseDTO;
import com.example.vente_service.entities.Vente;

public interface VenteInterfaceMap {
    public Vente requestDTO_ToVente(VenteRequestDTO venteRequestDTO);
    public VenteResponseDTO vente_ToResponseDTO(Vente vente);
}
