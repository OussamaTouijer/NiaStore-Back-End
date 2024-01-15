package com.example.produit_service.mapper;

import com.example.produit_service.dto.ProduitRequestDTO;
import com.example.produit_service.dto.ProduitResponseDTO;
import com.example.produit_service.entities.Produit;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ProduitInterfaceMapImpl  implements ProduitInterfaceMap{
    @Override
    public Produit requestDTO_ToProduit(ProduitRequestDTO produitRequestDTO) {
        Produit p=new Produit();
        BeanUtils.copyProperties(produitRequestDTO,p);
        return p;
    }

    @Override
    public ProduitResponseDTO produit_ToResponseDTO(Produit produit) {
        ProduitResponseDTO pDTO =new ProduitResponseDTO();
        BeanUtils.copyProperties(produit,pDTO);
        return pDTO;
    }
}
