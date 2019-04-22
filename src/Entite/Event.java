/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author Ahmed Abdessamed
 */
public class Event {
    int id;
    int user_id;
    String titre ; 
    String description ;
    String affiche;
    String nbrplaces ;
    String localisation;
    String dateevent ;
    String hdebut;
    String hfin ;
     int  prix ;
     String categorie;
     String type ;
     String psilver;
     String pglod;
     String pdiamond;
     int prixsilver;
     int  prixgold;
     int prixdiamond;

    public Event( int user_id,String titre, String description, String affiche, String nbrplaces, String localisation, String dateevent,String hdebut ,String hfin, Integer prix, String categorie, String type, String psilver, String pglod, String pdiamond, Integer  prixsilver, Integer  prixgold, Integer  prixdiamond) {
       this.user_id = user_id;
        this.titre = titre;
        this.description = description;
        this.affiche = affiche;
        this.nbrplaces = nbrplaces;
        this.localisation = localisation;
        this.dateevent = dateevent;
        this.hdebut=  hdebut;
        this.hfin = hfin;
        this.prix = prix;
        this.categorie = categorie;
        this.type = type;
        this.psilver = psilver;
        this.pglod = pglod;
        this.pdiamond = pdiamond;
        this.prixsilver = prixsilver;
        this.prixgold = prixgold;
        this.prixdiamond = prixdiamond;
        
    }

    public Event( int id,int user_id, String titre, String description, String affiche, String nbrplaces, String localisation, String  dateevent, String hdebut, String hfin, Integer  prix, String categorie, String type, String psilver, String pglod, String pdiamond, Integer  prixsilver, Integer  prixgold, Integer  prixdiamond) {
       this.id = id ;
        this.user_id = user_id;
        this.titre = titre;
        this.description = description;
        this.affiche = affiche;
        this.nbrplaces = nbrplaces;
        this.localisation = localisation;
        this.dateevent = dateevent;
        this.hdebut = hdebut;
        this.hfin = hfin;
        this.prix = prix;
        this.categorie = categorie;
        this.type = type;
        this.psilver = psilver;
        this.pglod = pglod;
        this.pdiamond = pdiamond;
        this.prixsilver = prixsilver;
        this.prixgold = prixgold;
        this.prixdiamond = prixdiamond;
    }

   
    
    public Event(int user_id,String titre, String localisation, String hdebut, String hfin, String type) {
         this.user_id = user_id;
        this.titre = titre;
        this.localisation = localisation;
        this.hdebut = hdebut;
        this.hfin = hfin;
        this.type = type;
    }

    
    

    public Event() {
    }

    

  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
     
     
     
     

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAffiche() {
        return affiche;
    }

    public void setAffiche(String affiche) {
        this.affiche = affiche;
    }

    public String getNbrplaces() {
        return nbrplaces;
    }

    public void setNbrplaces(String nbrplaces) {
        this.nbrplaces = nbrplaces;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public String getDateevent() {
        return dateevent;
    }

    public void setDateevent(String dateevent) {
        this.dateevent = dateevent;
    }

    public String getHdebut() {
        return hdebut;
    }

    public void setHdebut(String hdebut) {
        this.hdebut = hdebut;
    }

    
    public String getHfin() {
        return hfin;
    }

    public void setHfin(String hfin) {
        this.hfin = hfin;
    }

    public Integer  getPrix() {
        return prix;
    }

    public void setPrix(Integer  prix) {
        this.prix = prix;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPsilver() {
        return psilver;
    }

    public void setPsilver(String psilver) {
        this.psilver = psilver;
    }

    public String getPglod() {
        return pglod;
    }

    public void setPglod(String pglod) {
        this.pglod = pglod;
    }

    public String getPdiamond() {
        return pdiamond;
    }

    public void setPdiamond(String pdiamond) {
        this.pdiamond = pdiamond;
    }

    public Integer  getPrixsilver() {
        return prixsilver;
    }

    public void setPrixsilver(Integer  prixsilver) {
        this.prixsilver = prixsilver;
    }

    public Integer  getPrixgold() {
        return prixgold;
    }

    public void setPrixgold(Integer  prixgold) {
        this.prixgold = prixgold;
    }

    public Integer  getPrixdiamond() {
        return prixdiamond;
    }

    public void setPrixdiamond(Integer  prixdiamond) {
        this.prixdiamond = prixdiamond;
    }

    @Override
    public String toString() {
        return "Event{" + "titre=" + titre + ", description=" + description + ", affiche=" + affiche + ", nbrplaces=" + nbrplaces + ", localisation=" + localisation + ", dateevent=" + dateevent + ", hfin=" + hfin + ", prix=" + prix + ", categorie=" + categorie + ", type=" + type + ", psilver=" + psilver + ", pglod=" + pglod + ", pdiamond=" + pdiamond + ", prixsilver=" + prixsilver + ", prixgold=" + prixgold + ", prixdiamond=" + prixdiamond + '}';
    }

   
     
            
}
