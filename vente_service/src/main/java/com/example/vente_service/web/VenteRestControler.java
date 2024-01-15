package com.example.vente_service.web;

import com.example.vente_service.dto.VenteRequestDTO;
import com.example.vente_service.dto.VenteResponseDTO;
import com.example.vente_service.service.VenteServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VenteRestControler {
    @Autowired
    VenteServiceInterface venteServiceInterface;

    @GetMapping("/ventes")
    public List<VenteResponseDTO> getAll(){return venteServiceInterface.getAll();}

    @GetMapping("/ventes/{id}")
    public VenteResponseDTO getById(@PathVariable("id") Integer id){ return venteServiceInterface.getVenteById(id);}

    @PutMapping("/ventes/{id}")
    public void update_Vente(@PathVariable ("id") Integer id, @RequestBody VenteRequestDTO v){venteServiceInterface.update(id,v);}

    @PostMapping("/ventes")
    public void save_vente(@RequestBody VenteRequestDTO v){
        venteServiceInterface.save(v);
    }

    @DeleteMapping("/ventes/{id}")
    public void delete_vente(@PathVariable ("id") Integer id){
        venteServiceInterface.delete(id);
    }

    @GetMapping("/nombreVentes")
    public Long getNombreVentes(){
        return venteServiceInterface.getNombreVentes();
    }

    @GetMapping("/ventes/id_like")
    public List<VenteResponseDTO> findByIdContainingIgnoreCase(@Param("id") Integer id){
        return venteServiceInterface.findByIdContainingIgnoreCase(id);
    }
}
