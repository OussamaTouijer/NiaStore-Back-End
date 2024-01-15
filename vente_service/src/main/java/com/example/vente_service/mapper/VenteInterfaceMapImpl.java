package com.example.vente_service.mapper;

import com.example.vente_service.dto.VenteRequestDTO;
import com.example.vente_service.dto.VenteResponseDTO;
import com.example.vente_service.entities.Vente;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class VenteInterfaceMapImpl implements VenteInterfaceMap {
    @Override
    public Vente requestDTO_ToVente(VenteRequestDTO venteRequestDTO) {
        Vente v=new Vente();
        BeanUtils.copyProperties(venteRequestDTO,v);
        return v;
    }

    @Override
    public VenteResponseDTO vente_ToResponseDTO(Vente vente) {
        VenteResponseDTO vDTO =new VenteResponseDTO();
        BeanUtils.copyProperties(vente,vDTO);
        return vDTO;
    }
}
