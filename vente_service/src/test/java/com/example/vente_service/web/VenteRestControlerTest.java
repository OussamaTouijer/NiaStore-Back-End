// package com.example.vente_service.web;


// import com.example.vente_service.dto.VenteRequestDTO;
// import com.example.vente_service.dto.VenteResponseDTO;

// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;


// import java.util.ArrayList;
// import java.util.List;
// import java.util.Optional;

// import static graphql.Assert.assertFalse;
// import static org.junit.Assert.*;

// @SpringBootTest
// public class VenteRestControlerTest {


//     @Autowired
//     private VenteRestControler venteRestControler;

//     @Test
//     public void testGetAll() throws Exception {

//         // Arrange (initialisation)
//         List<VenteResponseDTO> venteResponseDTOS=new ArrayList<>();

//         // Act (appelle la methode doit tester)
//         venteResponseDTOS= venteRestControler.getAll();

//         // Assert (verifier le resultat)
//         assertNotNull(venteResponseDTOS);
//         assertFalse(venteResponseDTOS.isEmpty());

//     }

//     @Test
//     public void testGetById() throws Exception {

//         // Arrange (initialisation)
//          Integer idVente=1;
//          VenteResponseDTO venteResponseDTO=new VenteResponseDTO();

//         // Act (appelle la methode doit tester)
//         venteResponseDTO= venteRestControler.getById(idVente);

//         // Assert (verifier le resultat)
//         assertNotNull(venteResponseDTO);
//         assertEquals(idVente,venteResponseDTO.getIdV());


//     }

//     @Test
//     public void testUpdate_Vente() throws Exception {

//         // Arrange (initialisation)
//         Integer idVente=1;
//         VenteResponseDTO venteResponseDTO=new VenteResponseDTO();

//         VenteRequestDTO venteNouveau=VenteRequestDTO.builder().idV(idVente)
//                 .idA(1)
//                 .idP(1)
//                 .build();

//         // Act (appelle la methode doit tester)
//         venteRestControler.update_Vente(idVente,venteNouveau);
//         venteResponseDTO= venteRestControler.getById(idVente);

//         // Assert (verifier le resultat)
//         assertEquals(venteNouveau.getIdV(),venteResponseDTO.getIdV());
//         assertEquals(venteNouveau.getIdA(),venteResponseDTO.getIdA());
//         assertEquals(venteNouveau.getIdP(),venteResponseDTO.getIdP());

//     }


//     @Test
//     public void testSave_vente() {
//         // Arrange
//         VenteRequestDTO venteRequestDTO = VenteRequestDTO.builder()
//                 .idA(4)
//                 .idP(1)
//                 .build();

//         // Act
//         venteRestControler.save_vente(venteRequestDTO);

//         // Assert
//         // Ajoutez des assertions pour vérifier la sauvegarde
//         List<VenteResponseDTO> allVentes = venteRestControler.getAll();

//         // Vérifiez que la nouvelle vente est présente dans la liste
//         assertFalse(allVentes.isEmpty());

//         // Vérifiez que venteRequestDTO est dans la liste
//     }


//     @Test
//     public void testDelete_vente() {
//         // Arrange
//         Integer id = 1;

//         // Act
//         venteRestControler.delete_vente(id);

//         // Assert


//         // Vérifiez que la vente avec l'ID spécifié n'est plus présente dans la liste
//         List<VenteResponseDTO> allVentes = venteRestControler.getAll();
//         assertFalse(allVentes.stream().anyMatch(v -> id.equals(v.getIdV())));
//     }






// }
