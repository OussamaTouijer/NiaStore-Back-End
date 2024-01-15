package com.example.acheteur_service.mapper;

import com.example.acheteur_service.dto.AcheteurRequestDTO;
import com.example.acheteur_service.dto.AcheteurResponseDTO;
import com.example.acheteur_service.entitise.Acheteur;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AcheteurInterfaceMapImpl implements AcheteurInterfaceMap{
    @Override
    public Acheteur requestDTO_ToAcheteur(AcheteurRequestDTO acheteurRequestDTO) {
        Acheteur a=new Acheteur();
        BeanUtils.copyProperties(acheteurRequestDTO,a);
        return a;
    }

    @Override
    public AcheteurResponseDTO acheteur_ToResponseDTO(Acheteur acheteur) {
        AcheteurResponseDTO aDTO =new AcheteurResponseDTO();
        BeanUtils.copyProperties(acheteur,aDTO);
        return aDTO;
    }
}
