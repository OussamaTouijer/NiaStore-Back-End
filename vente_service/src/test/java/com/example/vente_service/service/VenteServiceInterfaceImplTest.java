// package com.example.vente_service.service;

// import com.example.vente_service.acheteurs.AcheteurOpenFeing;
// import com.example.vente_service.dto.VenteRequestDTO;
// import com.example.vente_service.dto.VenteResponseDTO;
// import com.example.vente_service.entities.Vente;
// import com.example.vente_service.mapper.VenteInterfaceMap;
// import com.example.vente_service.module.Acheteur;
// import com.example.vente_service.module.Produit;
// import com.example.vente_service.produits.ProduitOpenFeing;
// import com.example.vente_service.repositories.VenteRepository;
// import org.junit.jupiter.api.Test;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.springframework.boot.test.context.SpringBootTest;

// import java.util.ArrayList;
// import java.util.List;
// import java.util.Optional;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.mockito.Mockito.*;

// @SpringBootTest
// public class VenteServiceInterfaceImplTest {

//     @Mock
//     private VenteRepository venteRepository;

//     @Mock
//     private VenteInterfaceMap venteInterfaceMap;

//     @Mock
//     private ProduitOpenFeing produitOpenFeing;

//     @Mock
//     private AcheteurOpenFeing acheteurOpenFeing;

//     @InjectMocks
//     private VenteServiceInterfaceImpl venteService;

//     @Test
//     public void testSave() {
//         VenteRequestDTO venteRequestDTO = new VenteRequestDTO();
//         Vente venteMapped = new Vente();

//         when(venteInterfaceMap.requestDTO_ToVente(venteRequestDTO)).thenReturn(venteMapped);

//         venteService.save(venteRequestDTO);

//         verify(venteRepository, times(1)).save(venteMapped);
//     }

//     @Test
//     public void testDelete() {
//         Integer venteIdToDelete = 1;

//         venteService.delete(venteIdToDelete);

//         verify(venteRepository, times(1)).deleteById(venteIdToDelete);
//     }

//     @Test
//     public void testUpdate() {
//         Integer venteIdToUpdate = 1;
//         VenteRequestDTO venteRequestDTO = new VenteRequestDTO(/* Initialisez l'objet VenteRequestDTO simulé ici */);
//         Vente existingVente = new Vente(/* Initialisez l'objet Vente existant ici */);

//         when(venteRepository.findById(venteIdToUpdate)).thenReturn(Optional.of(existingVente));

//         venteService.update(venteIdToUpdate, venteRequestDTO);

//         verify(venteRepository, times(1)).save(existingVente);
//         // Ajoutez des assertions spécifiques en fonction de vos besoins
//     }

//     @Test
//     public void testGetAll() {
//         List<Produit> produits = new ArrayList<>(); // Initialisez la liste des produits simulée
//         List<Acheteur> acheteurs = new ArrayList<>(); // Initialisez la liste des acheteurs simulée
//         List<Vente> ventes = new ArrayList<>(); // Initialisez la liste des ventes simulée

//         when(produitOpenFeing.getAll()).thenReturn(produits);
//         when(acheteurOpenFeing.getAll()).thenReturn(acheteurs);
//         when(venteRepository.findAll()).thenReturn(ventes);

//         venteService.getAll();

//         // Vérifiez que les méthodes correspondantes ont été appelées le bon nombre de fois
//         verify(produitOpenFeing, times(1)).getAll();
//         verify(acheteurOpenFeing, times(1)).getAll();
//         verify(venteRepository, times(1)).findAll();
//         // Ajoutez d'autres assertions spécifiques en fonction de vos besoins
//     }

//     @Test
//     public void testGetVenteById() {
//         Integer venteIdToRetrieve = 1;
//         Vente vente = new Vente(/* Initialisez l'objet Vente simulé ici */);
//         Acheteur acheteur = new Acheteur(/* Initialisez l'objet Acheteur simulé ici */);
//         Produit produit = new Produit(/* Initialisez l'objet Produit simulé ici */);

//         when(venteRepository.findById(venteIdToRetrieve)).thenReturn(Optional.of(vente));
//         when(acheteurOpenFeing.getById(vente.getIdA())).thenReturn(acheteur);
//         when(produitOpenFeing.getById(vente.getIdP())).thenReturn(produit);

//         venteService.getVenteById(venteIdToRetrieve);

//         // Vérifiez que les méthodes correspondantes ont été appelées le bon nombre de fois
//         verify(venteRepository, times(1)).findById(venteIdToRetrieve);
//         verify(acheteurOpenFeing, times(1)).getById(vente.getIdA());
//         verify(produitOpenFeing, times(1)).getById(vente.getIdP());
//         // Ajoutez d'autres assertions spécifiques en fonction de vos besoins
//     }

//     // Ajoutez d'autres méthodes de test au besoin
// }
