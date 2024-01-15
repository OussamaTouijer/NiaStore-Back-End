package com.example.vente_service.service;

import com.example.vente_service.dto.VenteRequestDTO;
import com.example.vente_service.dto.VenteResponseDTO;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VenteServiceInterface {
    public void save(VenteRequestDTO venteRequestDTO) ;
    public void delete(Integer id) ;
    public void update(Integer id ,VenteRequestDTO venteRequestDTO) ;
    public List<VenteResponseDTO> getAll();
    public VenteResponseDTO getVenteById(Integer id);
    public Long getNombreVentes();
    public List<VenteResponseDTO> findByIdContainingIgnoreCase(@Param("id") Integer id);
}
