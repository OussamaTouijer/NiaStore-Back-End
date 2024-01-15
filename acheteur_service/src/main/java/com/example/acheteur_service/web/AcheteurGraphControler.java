package com.example.acheteur_service.web;




import com.example.acheteur_service.dto.AcheteurRequestDTO;
import com.example.acheteur_service.dto.AcheteurResponseDTO;
import com.example.acheteur_service.service.AcheteurServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AcheteurGraphControler {

    @Autowired
    AcheteurServiceInterface acheteurServiceInterface;

    @QueryMapping
    public List<AcheteurResponseDTO> getAllAcheteurs(){return acheteurServiceInterface.getAll();}
//    query{
//        listerAcheteurs{
//            idAcheteur
//                    nom
//            prenom
//                    email
//            adresse
//                    ville
//        }
//    }

    @QueryMapping
    public AcheteurResponseDTO getAcheteurById(@Argument Integer id){
        return acheteurServiceInterface.getAcheteurById(id);}

//    query{
//        acheteurById(id:6){
//            idAcheteur
//            nom
//            prenom
//            email
//            adresse
//            ville
//        }
//    }

    @MutationMapping
    public void save(@Argument AcheteurRequestDTO acheteur) {acheteurServiceInterface.save(acheteur);}

//    mutation {
//        save(acheteur: { nom: "zina", prenom: "daoudia",email:"daoudia@fsr.ma",adresse:"maarif",ville:"casablanca" }) {
//            nom
//            prenom
//            email
//            adresse
//            ville
//        }
//    }


    @MutationMapping
    public void delete(@Argument Integer id  ) {acheteurServiceInterface.delete(id);}
//    mutation {
//        delete(id:1){
//            nom
//        }
//    }

    @MutationMapping
    public void update(@Argument Integer id ,@Argument AcheteurRequestDTO input) {acheteurServiceInterface.update(id, input);}
//    mutation {
//        update(id:1, input: { nom: "zina", prenom: "daoudia",email:"daoudia@fsr.ma",adresse:"maarif",ville:"casablanca" }) {
//            nom
//                    prenom
//            email
//                    adresse
//            ville
//        }
//    }



}
