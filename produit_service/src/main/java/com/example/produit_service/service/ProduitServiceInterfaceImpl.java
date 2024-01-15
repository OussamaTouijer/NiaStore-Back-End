package com.example.produit_service.service;

import com.example.produit_service.dto.ProduitRequestDTO;
import com.example.produit_service.dto.ProduitResponseDTO;
import com.example.produit_service.entities.Produit;
import com.example.produit_service.mapper.ProduitInterfaceMap;
import com.example.produit_service.repositories.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
@Service

@Transactional
public class ProduitServiceInterfaceImpl implements ProduitServiceInterface{
    @Autowired
    ProduitRepository produitRepository;
    @Autowired
    ProduitInterfaceMap produitInterfaceMap;
    @Override
    public void save(ProduitRequestDTO produitRequestDTO) {
        Produit p=new Produit();
        p=produitInterfaceMap.requestDTO_ToProduit(produitRequestDTO);
        produitRepository.save(p);
    }

    @Override
    public void delete(Integer id) {produitRepository.deleteById(id);}

    @Override
    public void update(Integer id, ProduitRequestDTO produitRequestDTO) {
        Produit e=produitRepository.findById(id).get();
        if(produitRequestDTO.getNom() != null) e.setNom(produitRequestDTO.getNom());
        if(produitRequestDTO.getMarque() != null) e.setMarque(produitRequestDTO.getMarque());
        if(produitRequestDTO.getDescription() != null) e.setDescription(produitRequestDTO.getDescription());
        if(produitRequestDTO.getQuantite() != null) e.setQuantite(produitRequestDTO.getQuantite());
        if(produitRequestDTO.getPrix() != null) e.setPrix(produitRequestDTO.getPrix());
        produitRepository.save(e);
    }

    @Override
    public List<ProduitResponseDTO> getAll() {
        List<Produit> Liste_produits= new ArrayList<Produit>();
        Liste_produits=produitRepository.findAll();
        List<ProduitResponseDTO> Liste_produitsRespenseDTO=new ArrayList<ProduitResponseDTO>();

        for (Produit p:Liste_produits)
        {
            ProduitResponseDTO r=produitInterfaceMap.produit_ToResponseDTO(p);
            Liste_produitsRespenseDTO.add(r);

        }

        return Liste_produitsRespenseDTO;
    }

    @Override
    public ProduitResponseDTO getProduitById(Integer id) {
        Produit p=produitRepository.findById(id).get();
        return produitInterfaceMap.produit_ToResponseDTO(p);
    }

    public Long getNombreProduits(){
        return produitRepository.count();
    }

    // Méthode de recherche par nom de produit avec un paramètre "keyword"
    public List<ProduitResponseDTO> getProduitsByNomContainingIgnoreCase(String keyword) {
       List<ProduitResponseDTO> produitResponseDTOArrayList=new ArrayList<>();
       List<Produit> pd=produitRepository.findByNomContainingIgnoreCase(keyword);
        ProduitResponseDTO produitResponseDTO=new ProduitResponseDTO();
       for(Produit produit :pd){
           produitResponseDTO=produitInterfaceMap.produit_ToResponseDTO(produit);
           produitResponseDTOArrayList.add(produitResponseDTO);
       }

        return produitResponseDTOArrayList;
    }
}
