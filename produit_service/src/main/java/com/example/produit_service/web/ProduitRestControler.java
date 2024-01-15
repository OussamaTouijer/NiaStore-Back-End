package com.example.produit_service.web;

import com.example.produit_service.config.GlobalConfig;
import com.example.produit_service.config.ProduitConfig;
import com.example.produit_service.dto.ProduitRequestDTO;
import com.example.produit_service.dto.ProduitResponseDTO;
import com.example.produit_service.entities.Produit;
import com.example.produit_service.repositories.ProduitRepository;
import com.example.produit_service.service.ProduitServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProduitRestControler {

    @Autowired
    ProduitServiceInterface produitServiceInterface;

    @Autowired
    ProduitRepository produitRepository;

    @Autowired
    GlobalConfig globalConfig;

    @Autowired
    ProduitConfig produitConfig;

    @GetMapping("/globalConfigs")
    public GlobalConfig globalConfig(){
        return globalConfig;
    }

    @GetMapping("/produitConfigs")
    public ProduitConfig produitConfig(){
        return produitConfig;
    }

    @GetMapping("/produits")
    public List<ProduitResponseDTO> getAllProduits(){ return  produitServiceInterface.getAll();}

    @GetMapping("/produits/{id}")
    public ProduitResponseDTO getProduitById(@PathVariable("id") Integer id){ return produitServiceInterface.getProduitById(id);}

    @PutMapping("/produits/{id}")
    public void update(@PathVariable("id") Integer id,@RequestBody ProduitRequestDTO p){
        produitServiceInterface.update(id,p);
    }

    @PostMapping("/produits")
    public void save(@RequestBody ProduitRequestDTO p){
        produitServiceInterface.save(p);
    }

    @DeleteMapping("/produits/{id}")
    public void delete(@PathVariable("id") Integer id) {produitServiceInterface.delete(id);}

    @GetMapping("/nombreProduits")
    public Long getNombreProduits(){
        return produitServiceInterface.getNombreProduits();
    }

    @GetMapping("/produits/nom_like")
    public List<ProduitResponseDTO> getProduitsByNomContainingIgnoreCase(@RequestParam("keyword") String keyword) {
        return produitServiceInterface.getProduitsByNomContainingIgnoreCase(keyword);
    }

}
