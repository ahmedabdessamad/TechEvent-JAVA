/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;
import java.sql.Timestamp;
import Config.Connexion;
import Entite.Event;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.util.Date
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ahmed Abdessamed
 */
public class ServiceEvent {
 Connexion db ;
    public ServiceEvent() {
    }
   
  
         Connection cn =Connexion.getInstance().getConnction();
         
          public void AjouterE(Event E) throws SQLException{
              int user_id = E.getUser_id();
              String titre =E.getTitre();
              String description = E.getDescription();
              String affiche = E.getAffiche();
              String nbrplaces =E.getNbrplaces() ;
              String localisation = E.getLocalisation();
              String  dateevent = E.getDateevent();
              String hdebut = E.getHdebut();
              String hfin = E.getHfin();
              Integer  prix =E.getPrix();
              String categorie = E.getCategorie();
              String type = E.getType();
              String psilver= E.getPsilver();
              String pglod =E.getPglod();
              String pdiamond = E.getPdiamond();
              Integer  prixsilver = E.getPrixsilver();
              Integer  prixgold = E.getPrixgold();
              Integer  prixdiamond = E.getPrixdiamond();
              
              
              
           

        try{
      String requete = "INSERT INTO event (user_id,titre,description,affiche,nbrplaces,localisation,"
                    + "dateevent,hdebut,hfin,prix,categorie,type,psilver,pglod,pdiamond,prixsilver,prixgold,prixdiamond)VALUES"
              + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      PreparedStatement st = cn.prepareStatement(requete);
      st.setInt(1, user_id);
      st.setString(2, titre);
      st.setString(3, description);
      st.setString(4, affiche);
      st.setString(5, nbrplaces);
      st.setString(6,localisation);
      st.setString(7,dateevent);
      st.setString(8,hdebut);
      st.setString(9,hfin);
      st.setInt(10,prix);
      st.setString(11,categorie);
      st.setString(12,type);
      st.setString(13,psilver);
      st.setString(14,pglod);
      st.setString(15,pdiamond);
      st.setInt (16,prixsilver);
      st.setInt(17,prixgold);
      st.setInt(18,prixdiamond);
       
      st.execute();
      System.out.println("Event ajoutée" );
       }catch(SQLException ex){
        System.out.println(ex.getMessage());
       }
     
    }
         
         public void ModifierE ( Event E) throws SQLException{
             
            int user_id = E.getUser_id();
              String titre =E.getTitre();
              String description = E.getDescription();
              String affiche = E.getAffiche();
              String nbrplaces =E.getNbrplaces() ;
              String localisation = E.getLocalisation();
              String dateevent = E.getDateevent();
              String hdebut = E.getHdebut();
              String hfin = E.getHfin();
              int  prix =E.getPrix();
              String categorie = E.getCategorie();
              String type = E.getType();
              String psilver= E.getPsilver();
              String pglod =E.getPglod();
              String pdiamond = E.getPdiamond();
              int  prixsilver = E.getPrixsilver();
              int  prixgold = E.getPrixgold();
              int  prixdiamond = E.getPrixdiamond();
              int id = E.getId();
              
              try {
               String  req = "update event SET titre=?,description=?,affiche=?,nbrplaces=?,localisation=?,dateevent=?,hdebut=?,hfin=?,prix=?,categorie=?,type=?,psilver=?,pglod=?,pdiamond=?,prixsilver=?,prixgold=?,prixdiamond=? WHERE id=? VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                      PreparedStatement st = cn.prepareStatement(req);  
      st.setString(1,titre);
      st.setString(2,description);
      st.setString(3,affiche);
      st.setString(4,nbrplaces);
      st.setString(5,localisation);
      st.setString(6,dateevent);
      st.setString(7,hdebut);
      st.setString(8,hfin);
      st.setInt(9,prix);
      st.setString(10,categorie);
      st.setString(11,type);
      st.setString(12,psilver);
      st.setString(13,pglod);
      st.setString(14,pdiamond);
      st.setInt (15,prixsilver);
      st.setInt(16,prixgold);
      st.setInt(17,prixdiamond);
      st.setInt(18,id);
 
      st.execute();
      System.out.println("Event modifée");
      }catch(SQLException ex){
        System.out.println(ex.getMessage());
      }   
             
             
         }
         public void supprimerEvent(int id) throws SQLException {
      
        String requete = "delete from event where id = ?";
            
       PreparedStatement st = cn.prepareStatement(requete);
       st.setInt(1, id);
      
        st.executeUpdate();
        System.out.println("event  supprimée !");
    }
      
         
        /* public void supprimerE(int id)throws SQLException{
       try{       
        String requete = "delete from event where id = ?";
        PreparedStatement st = cn.prepareStatement(requete);
        st.setInt(1, id);
        st.execute();
        System.out.println("Event supprimée");
     }catch(SQLException ex){
   System.out.println(ex.getMessage());
     }
     }*/
        
         
         public void AfficheEvent(int a ) throws SQLException {
             
             try{
         Statement st = cn.createStatement();
         
          ResultSet resultat;
             resultat = st.executeQuery("SELECT * FROM event WHERE id ="+a);
            while(resultat.next()){
 
                System.out.println("---------------------------");
                System.out.println("titre: "+resultat.getString("titre"));
                System.out.println("description : "+resultat.getString("description"));
                System.out.println("affiche : "+resultat.getString("affiche"));
                System.out.println("nbrplaces : "+resultat.getString("nbrplaces"));
                System.out.println("dateevent : "+resultat.getString("dateevent"));
                System.out.println("hdebut: "+resultat.getString("hdebut"));
                System.out.println("hfin  : "+resultat.getString("hfin"));
                System.out.println("prix  : "+resultat.getString("prix"));
                System.out.println("categorie : "+resultat.getString("categorie"));
                System.out.println("type: "+resultat.getString("type"));
                System.out.println("psilver: "+resultat.getString("psilver"));
                System.out.println("pglod: "+resultat.getString("pglod"));
                System.out.println("pdiamond: "+resultat.getString("pdiamond"));
                System.out.println("prixsilver: "+resultat.getString("prixsilver"));
                System.out.println("prixgold: "+resultat.getString("prixgold"));
                System.out.println("prixdiamond: "+resultat.getString("prixdiamond"));

                System.out.println("---------------------------");


 
            }
        } catch (SQLException e){
 
                               System.out.println(e.getMessage());

        }
         }
          public List<Event> afficherTouTEvent() {
        List<Event> myList = new ArrayList<Event>();
        try {

            String requete2 = "SELECT * FROM event";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(requete2);

            while (rs.next()) {
                Event u = new Event();
                u.setId(rs.getInt(1));
                u.setUser_id(rs.getInt(2));
                u.setTitre(rs.getString(3));
                u.setDescription(rs.getString(4));
                u.setAffiche(rs.getString(5));
                u.setNbrplaces(rs.getString(6));
                u.setLocalisation(rs.getString(7));
                u.setDateevent(rs.getString(8));
                u.setHdebut(rs.getString(9));
                u.setHfin(rs.getString(10));
                u.setPrix(rs.getInt(11));
                u.setCategorie(rs.getString(12));
                u.setType(rs.getString(13));
                u.setPsilver(rs.getString(14));
                u.setPglod(rs.getString(15));
                u.setPdiamond(rs.getString(16));
                u.setPrixsilver(rs.getInt(17));
                u.setPrixgold(rs.getInt(18));
                u.setPrixdiamond(rs.getInt(19));

                myList.add(u);
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
    }
         
 public List<Event> afficherByTitre(String titre) {
        List<Event> myList = new ArrayList<Event>();
        try {
            
            String requete2 = "SELECT * FROM event WHERE titre LIKE '%" + titre + "%' ";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(requete2);

            while (rs.next()) {
                Event u = new Event();
                u.setUser_id(rs.getInt(2));
                u.setTitre(rs.getString(3));
                u.setDescription(rs.getString(4));
                u.setAffiche(rs.getString(5));
                u.setNbrplaces(rs.getString(6));
                u.setLocalisation(rs.getString(7));
                u.setDateevent(rs.getString(8));
                u.setHdebut(rs.getString(9));
                u.setHfin(rs.getString(10));
                u.setPrix(rs.getInt(11));
                u.setCategorie(rs.getString(12));
                u.setType(rs.getString(13));
                u.setPsilver(rs.getString(14));
                u.setPglod(rs.getString(15));
                u.setPdiamond(rs.getString(16));
                u.setPrixsilver(rs.getInt(17));
                u.setPrixgold(rs.getInt(18));
                u.setPrixdiamond(rs.getInt(19));

                myList.add(u);
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
    }
 
        public List<Event> afficherByType(String a) {
        List<Event> myList = new ArrayList<Event>();
        try {

            String requete2 = "SELECT * FROM event WHERE type LIKE '%" + a + "%'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(requete2);

            while (rs.next()) {
                Event u = new Event();
                u.setUser_id(rs.getInt(2));
                u.setTitre(rs.getString(3));
                u.setDescription(rs.getString(4));
                u.setAffiche(rs.getString(5));
                u.setNbrplaces(rs.getString(6));
                u.setLocalisation(rs.getString(7));
                u.setDateevent(rs.getString(8));
                u.setHdebut(rs.getString(9));
                u.setHfin(rs.getString(10));
                u.setPrix(rs.getInt(11));
                u.setCategorie(rs.getString(12));
                u.setType(rs.getString(13));
                u.setPsilver(rs.getString(14));
                u.setPglod(rs.getString(15));
                u.setPdiamond(rs.getString(16));
                u.setPrixsilver(rs.getInt(17));
                u.setPrixgold(rs.getInt(18));
                u.setPrixdiamond(rs.getInt(19));

                myList.add(u);
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
    }
        public List<Event> afficherByPrix(String a) {
        List<Event> myList = new ArrayList<Event>();
        try {

            String requete2 = "SELECT * FROM event WHERE prix LIKE '%" + a + "%'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(requete2);

            while (rs.next()) {
                Event u = new Event();
                u.setUser_id(rs.getInt(2));
                u.setTitre(rs.getString(3));
                u.setDescription(rs.getString(4));
                u.setAffiche(rs.getString(5));
                u.setNbrplaces(rs.getString(6));
                u.setLocalisation(rs.getString(7));
                u.setDateevent(rs.getString(8));
                u.setHdebut(rs.getString(9));
                u.setHfin(rs.getString(10));
                u.setPrix(rs.getInt(11));
                u.setCategorie(rs.getString(12));
                u.setType(rs.getString(13));
                u.setPsilver(rs.getString(14));
                u.setPglod(rs.getString(15));
                u.setPdiamond(rs.getString(16));
                u.setPrixsilver(rs.getInt(17));
                u.setPrixgold(rs.getInt(18));
                u.setPrixdiamond(rs.getInt(19));

                myList.add(u);
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
    }
        public List<Event> afficherByDate(String a) {
        List<Event> myList = new ArrayList<Event>();
        try {

            String requete2 = "SELECT * FROM event WHERE dateevent LIKE '%" + a + "%'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(requete2);

            while (rs.next()) {
                Event u = new Event();
                u.setUser_id(rs.getInt(2));
                u.setTitre(rs.getString(3));
                u.setDescription(rs.getString(4));
                u.setAffiche(rs.getString(5));
                u.setNbrplaces(rs.getString(6));
                u.setLocalisation(rs.getString(7));
                u.setDateevent(rs.getString(8));
                u.setHdebut(rs.getString(9));
                u.setHfin(rs.getString(10));
                u.setPrix(rs.getInt(11));
                u.setCategorie(rs.getString(12));
                u.setType(rs.getString(13));
                u.setPsilver(rs.getString(14));
                u.setPglod(rs.getString(15));
                u.setPdiamond(rs.getString(16));
                u.setPrixsilver(rs.getInt(17));
                u.setPrixgold(rs.getInt(18));
                u.setPrixdiamond(rs.getInt(19));

                myList.add(u);
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
    }
    
}


