package com.example.produit_service.web;

import com.example.produit_service.dto.ProduitRequestDTO;
import com.example.produit_service.dto.ProduitResponseDTO;
import com.example.produit_service.repositories.ProduitRepository;
import com.example.produit_service.service.ProduitServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ProduitGraphControler {
    @Autowired
    ProduitRepository produitRepository;
    @Autowired
    ProduitServiceInterface produitServiceInterface;
    @QueryMapping
    public List<ProduitResponseDTO> getAll(){return produitServiceInterface.getAll();}
//    query{
//        getAll{
//            idProduit
//            nom
//            description
//            marque
//            quantite
//            prix
//        }
//    }

    @QueryMapping
    public ProduitResponseDTO getProduitById(@Argument Integer id){ return produitServiceInterface.getProduitById(id);}
//    query{
//        getProduitById(id:1){
//            idProduit
//            nom
//            description
//            marque
//            quantite
//            prix
//        }
//    }

    @MutationMapping
    public void save(@Argument ProduitRequestDTO produit) {produitServiceInterface.save(produit);}

//    mutation{
//        save(produit:{nom:"hp i7",description:"Productivité au quotidien. Sécurité, performance et durabilité pour votre travail quotidien",marque:"hp",quantite:34569,prix:56478}){
//            idProduit
//            nom
//            description
//            marque
//            quantite
//            prix
//        }
//    }

    @MutationMapping
    public void delete(@Argument Integer id  ) {produitServiceInterface.delete(id);}
//    mutation{
//        delete(id:1){
//            nom
//        }
//    }


    @MutationMapping
    public void update(@Argument Integer id ,@Argument ProduitRequestDTO input) {
        produitServiceInterface.update(id, input);
    }
//    mutation{
//        update(id:5,input:{nom:"pcOussamaTouijer",description:"Productivité au quotidien. Sécurité, performance et durabilité pour votre travail quotidien",marque:"hp",quantite:34569}){
//            idProduit
//            nom
//            description
//            marque
//            quantite
//            prix
//        }
//    }

}
