package com.example.produit_service;

import com.example.produit_service.dto.ProduitRequestDTO;
import com.example.produit_service.dto.ProduitResponseDTO;
import com.example.produit_service.web.ProduitRestControler;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
class ProduitServiceApplicationTests {

    @Autowired
    private ProduitRestControler produitRestControler;

    @Test
    public void testGetAll() throws Exception {

        // Arrange (initialisation)
        List<ProduitResponseDTO> produitResponseDTOList=new ArrayList<>();

        // Act (appelle la methode doit tester)
        produitResponseDTOList= produitRestControler.getAllProduits();

        // Assert (verifier le resultat)
        assertNotNull(produitResponseDTOList);
        assertFalse(produitResponseDTOList.isEmpty());

    }

    @Test
    public void testGetById() throws Exception {

        // Arrange (initialisation)
        Integer idProduit=1;
        ProduitResponseDTO produitResponseDTO=new ProduitResponseDTO();

        // Act (appelle la methode doit tester)
        produitResponseDTO= produitRestControler.getProduitById(idProduit);

        // Assert (verifier le resultat)
        assertNotNull(produitResponseDTO);
        assertEquals(idProduit,produitResponseDTO.getIdProduit());


    }

    @Test
    public void testUpdate_Vente() throws Exception {

        // Arrange (initialisation)
        Integer idProduit=1;
        ProduitResponseDTO produitResponseDTO=new ProduitResponseDTO();

        ProduitRequestDTO ProduitNouveau=ProduitRequestDTO.builder()
                .idProduit(idProduit)
                .nom("OnePlus 15 Pro")
                .marque("OnePlus")
                .description("d'un système de caméra quadruple avec un objectif principal de 48 Mpx, d'une batterie longue durée et de la 5G")
                .prix((double) 666.00)
                .quantite(78542)
                .build();

        // Act (appelle la methode doit tester)
        produitRestControler.update(idProduit,ProduitNouveau);
        produitResponseDTO= produitRestControler.getProduitById(idProduit);

        // Assert (verifier le resultat)
        assertEquals(ProduitNouveau.getIdProduit(),produitResponseDTO.getIdProduit());
        assertEquals(ProduitNouveau.getNom(),produitResponseDTO.getNom());
        assertEquals(ProduitNouveau.getDescription(),produitResponseDTO.getDescription());

    }


    @Test
    public void testSave_vente() {
        // Arrange
        ProduitRequestDTO produitRequestDTO = ProduitRequestDTO.builder().nom("OnePlus 15 Pro")
                .marque("OnePlus")
                .description("d'un système de caméra quadruple avec un objectif principal de 48 Mpx, d'une batterie longue durée et de la 5G")
                .prix((double) 666.00)
                .quantite(78542)
                .build();

        // Act
        produitRestControler.save(produitRequestDTO);

        // Assert
        // Ajoutez des assertions pour vérifier la sauvegarde
        List<ProduitResponseDTO> allProduitResponseDTOS = produitRestControler.getAllProduits();

        // Vérifiez que la nouvelle vente est présente dans la liste
        assertFalse(allProduitResponseDTOS.isEmpty());

        // Vérifiez que venteRequestDTO est dans la liste
    }


    @Test
    public void testDelete_vente() {
        // Arrange
        Integer id = 1;

        // Act
        produitRestControler.delete(id);

        // Assert


        // Vérifiez que la vente avec l'ID spécifié n'est plus présente dans la liste
        List<ProduitResponseDTO> allProduit = produitRestControler.getAllProduits();
        assertFalse(allProduit.stream().anyMatch(p -> id.equals(p.getIdProduit())));
    }




}
