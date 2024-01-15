// package com.example.vente_service.mapper;

// import com.example.vente_service.dto.VenteRequestDTO;
// import com.example.vente_service.dto.VenteResponseDTO;
// import com.example.vente_service.entities.Vente;
// import org.junit.jupiter.api.Test;
// import org.springframework.beans.BeanUtils;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertNotNull;

// @SpringBootTest
// public class VenteInterfaceMapImplTest {

//     @Autowired
//     VenteInterfaceMap venteInterfaceMap;


//     @Test
//     public void testRequestDTO_ToVente() {
//         // Créer un objet VenteRequestDTO pour le test
//         VenteRequestDTO requestDTO=new VenteRequestDTO();
//         requestDTO.setIdV(1);
//         requestDTO.setIdA(2);
//         requestDTO.setIdP(3);
//         // Appeler la méthode de mappage
//         Vente vente=venteInterfaceMap.requestDTO_ToVente(requestDTO);

//         // Vérifier si les propriétés ont été correctement copiées
//         assertEquals(requestDTO.getIdV(), vente.getIdV());
//         assertEquals(requestDTO.getIdA(), vente.getIdA());
//         assertEquals(requestDTO.getIdP(), vente.getIdP());


//     }

//     @Test
//     public void testVente_ToResponseDTO() {
//         // Créer un objet Vente pour le test
//         Vente vente=new Vente();
//         vente.setIdV(1);
//         vente.setIdA(2);
//         vente.setIdP(3);
//         // Appeler la méthode de mappage
//         VenteResponseDTO responseDTO=venteInterfaceMap.vente_ToResponseDTO(vente);

//         // Vérifier si les propriétés ont été correctement copiées
//         assertEquals(vente.getIdV(), responseDTO.getIdV());
//         assertEquals(vente.getIdA(), responseDTO.getIdA());
//         assertEquals(vente.getIdP(), responseDTO.getIdP());

//     }


// }
