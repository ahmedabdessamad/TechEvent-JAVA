/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Config.Connexion;
import Entite.Event;
import Entite.Interesse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ahmed Abdessamed
 */
public class ServiceInteresse  extends Event{

    public ServiceInteresse() {
    }        
    Connection cn =Connexion.getInstance().getConnction();

    
    public void AjouterEInteresse ( Interesse E)throws SQLException{ 
    
        int id = E.getId();
        int user_id = E.getUser_id();
        int event_id= E.getEvent_id();
       
         try{
        String requete = "INSERT INTO  interesser (user_id,event_id)VALUES(?,?)";    
        PreparedStatement st = cn.prepareStatement(requete);
        st.setInt(1, user_id);
        st.setInt(2, event_id);
        st.execute();
              System.out.println("Event Ajouté a la liste d'evenement intérresé.");

     }catch(SQLException ex){
        System.out.println(ex.getMessage());
       }
    }
    
    
    
/*
     public void AfficheEventInteresse(int a ) throws SQLException {
             
             try{
         Statement st = cn.createStatement();
         
          ResultSet resultat;
          //   resultat = st.executeQuery("SELECT event_id FROM inttereser WHERE user_id="+a);
                 ResultSet resultat1 = st.executeQuery("SELECT * FROM event WHERE id ="+a);
            while(resultat1.next()){
 
                System.out.println("---------------------------");
                System.out.println("titre: "+resultat1.getString("titre"));
                System.out.println("description : "+resultat1.getString("description"));
                System.out.println("affiche : "+resultat1.getString("affiche"));
                System.out.println("nbrplaces : "+resultat1.getString("nbrplaces"));
                System.out.println("dateevent : "+resultat1.getString("dateevent"));
                System.out.println("hdebut: "+resultat1.getString("hdebut"));
                System.out.println("hfin  : "+resultat1.getString("hfin"));
                System.out.println("prix  : "+resultat1.getString("prix"));
                System.out.println("categorie : "+resultat1.getString("categorie"));
                System.out.println("type: "+resultat1.getString("type"));
                System.out.println("psilver: "+resultat1.getString("psilver"));
                System.out.println("pglod: "+resultat1.getString("pglod"));
                System.out.println("pdiamond: "+resultat1.getString("pdiamond"));
                System.out.println("prixsilver: "+resultat1.getString("prixsilver"));
                System.out.println("prixgold: "+resultat1.getString("prixgold"));
                System.out.println("prixdiamond: "+resultat1.getString("prixdiamond"));

                System.out.println("---------------------------");


 
            }
        } catch (SQLException e){
 
                               System.out.println(e.getMessage());

        }
         }*/
      public List<Event> afficherTouTinteresse(int a) {
        List<Event> myList = new ArrayList<Event>();
        try {

            String requete2 = "SELECT * FROM event E where id IN( select event_id from interesser where user_id ="+a+") " ;
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
     
     public void SupIN(int id) throws SQLException {
      
        String requete = "delete from interesser where event_id ="+id+"";
            
       PreparedStatement st = cn.prepareStatement(requete);
       
      
        st.executeUpdate();
        System.out.println("event  supprimée !");
    }
}
