package com.example.vente_service.web;

import com.example.vente_service.dto.VenteRequestDTO;
import com.example.vente_service.dto.VenteResponseDTO;
import com.example.vente_service.service.VenteServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class VenteGraphControler {
    @Autowired
    VenteServiceInterface venteServiceInterface;

    @QueryMapping
    public List<VenteResponseDTO> getAllAcheteurs(){return venteServiceInterface.getAll();}

    @QueryMapping
    public VenteResponseDTO getAcheteurById(@Argument Integer id){ return venteServiceInterface.getVenteById(id);}


    @MutationMapping
    public void save(@Argument VenteRequestDTO venteRequestDTO) {venteServiceInterface.save(venteRequestDTO);}

    @MutationMapping
    public void delete(@Argument Integer id  ) {venteServiceInterface.delete(id);}

    @MutationMapping
    public void update(@Argument Integer id ,@Argument VenteRequestDTO input) {venteServiceInterface.update(id, input);}



}
