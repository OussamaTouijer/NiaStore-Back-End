package com.example.acheteur_service.web;

import com.example.acheteur_service.dto.AcheteurRequestDTO;
import com.example.acheteur_service.dto.AcheteurResponseDTO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
public class AcheteurRestControlerTest {

    @Autowired
    private AcheteurRestControler acheteurRestControler;

    @Test
    public void testGetAll() throws Exception {

        // Arrange (initialisation)
        List<AcheteurResponseDTO> acheteurResponseDTOList=new ArrayList<>();

        // Act (appelle la methode doit tester)
        acheteurResponseDTOList= acheteurRestControler.getAll();

        // Assert (verifier le resultat)
        assertNotNull(acheteurResponseDTOList);
        assertFalse(acheteurResponseDTOList.isEmpty());

    }

    @Test
    public void testGetById() throws Exception {

        // Arrange (initialisation)
        Integer idAcheteur=1;
        AcheteurResponseDTO acheteurResponseDTO=new AcheteurResponseDTO();

        // Act (appelle la methode doit tester)
        acheteurResponseDTO= acheteurRestControler.getById(idAcheteur);

        // Assert (verifier le resultat)
        assertNotNull(acheteurResponseDTO);
        assertEquals(idAcheteur,acheteurResponseDTO.getIdAcheteur());


    }

    @Test
    public void testUpdate_Vente() throws Exception {

        // Arrange (initialisation)
        Integer idAcheteur=1;
        AcheteurResponseDTO acheteurResponseDTO=new AcheteurResponseDTO();

        AcheteurRequestDTO AcheteurNouveau=AcheteurRequestDTO.builder().idAcheteur(idAcheteur)
                .nom("Touijer")
                .prenom("Oussama")
                .email("Oussama5Touijer@gmail.com")
                .adresse("hay chikh lamfadel")
                .ville("Sale").idProduit(6)
                .build();

        // Act (appelle la methode doit tester)
        acheteurRestControler.update(idAcheteur,AcheteurNouveau);
        acheteurResponseDTO= acheteurRestControler.getById(idAcheteur);

        // Assert (verifier le resultat)
        assertEquals(AcheteurNouveau.getIdAcheteur(),acheteurResponseDTO.getIdAcheteur());
        assertEquals(AcheteurNouveau.getNom(),acheteurResponseDTO.getNom());
        assertEquals(AcheteurNouveau.getIdProduit(),acheteurResponseDTO.getIdProduit());

    }


    @Test
    public void testSave_vente() {
        // Arrange
        AcheteurRequestDTO acheteurRequestDTO = AcheteurRequestDTO.builder()
                .nom("Touijer")
                .prenom("Oussama")
                .email("Oussama5Touijer@gmail.com")
                .adresse("hay chikh lamfadel")
                .ville("Sale").idProduit(6)
                .build();

        // Act
        acheteurRestControler.save(acheteurRequestDTO);

        // Assert
        // Ajoutez des assertions pour vérifier la sauvegarde
        List<AcheteurResponseDTO> allAcheteurs = acheteurRestControler.getAll();

        // Vérifiez que la nouvelle vente est présente dans la liste
        assertFalse(allAcheteurs.isEmpty());

        // Vérifiez que venteRequestDTO est dans la liste
    }


    @Test
    public void testDelete_vente() {
        // Arrange
        Integer id = 1;

        // Act
        acheteurRestControler.delete(id);

        // Assert


        // Vérifiez que la vente avec l'ID spécifié n'est plus présente dans la liste
        List<AcheteurResponseDTO> acheteurResponseDTOList = acheteurRestControler.getAll();
        assertFalse(acheteurResponseDTOList.stream().anyMatch(a -> id.equals(a.getIdAcheteur())));
    }



}
