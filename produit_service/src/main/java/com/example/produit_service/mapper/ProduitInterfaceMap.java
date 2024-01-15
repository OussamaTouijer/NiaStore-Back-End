package com.example.produit_service.mapper;


import com.example.produit_service.dto.ProduitRequestDTO;
import com.example.produit_service.dto.ProduitResponseDTO;
import com.example.produit_service.entities.Produit;

public interface ProduitInterfaceMap {
    public Produit requestDTO_ToProduit(ProduitRequestDTO produitRequestDTO);
    public ProduitResponseDTO produit_ToResponseDTO(Produit produit);
}
