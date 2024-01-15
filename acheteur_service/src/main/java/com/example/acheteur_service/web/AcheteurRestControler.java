package com.example.acheteur_service.web;

import com.example.acheteur_service.dto.AcheteurRequestDTO;
import com.example.acheteur_service.dto.AcheteurResponseDTO;
import com.example.acheteur_service.entitise.Acheteur;
import com.example.acheteur_service.module.Produit;
import com.example.acheteur_service.produit.ProduitFindController;

import com.example.acheteur_service.repositories.AcheteurRepository;
import com.example.acheteur_service.service.AcheteurServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Objects;

@RestController
public class AcheteurRestControler {

    @Autowired
    AcheteurServiceInterface acheteurServiceInterface;
    @Autowired
    ProduitFindController produitFindController;

    @Autowired
   AcheteurRepository acheteurRepository;

    @GetMapping("/acheteurs")
    public List<AcheteurResponseDTO> getAll(){ return acheteurServiceInterface.getAll();}
    @GetMapping("/acheteurs/{id}")
    public AcheteurResponseDTO getById(@PathVariable("id") Integer id){return acheteurServiceInterface.getAcheteurById(id) ;}

    @PutMapping("/acheteurs/{id}")
    public void update(@PathVariable ("id") Integer id, @RequestBody AcheteurRequestDTO a){

        acheteurServiceInterface.update(id, a);
    }

    @PostMapping("/acheteurs")
    public void save(@RequestBody AcheteurRequestDTO acheteur) {acheteurServiceInterface.save(acheteur);}

    @DeleteMapping("/acheteurs/{id}")
    public void delete(@PathVariable("id") Integer id  ) {acheteurServiceInterface.delete(id);}

    @GetMapping("/nombreAcheteurs")
    public Long getNombreAcheteurs(){
        return acheteurServiceInterface.getNombreAcheteurs();
    }

    @GetMapping("/acheteurs/nom_like")
    public List<AcheteurResponseDTO> getAcheteursByNomContainingIgnoreCase(@RequestParam("keyword") String keyword){
        return acheteurServiceInterface.getAcheteursByNomContainingIgnoreCase(keyword);
    }
}
