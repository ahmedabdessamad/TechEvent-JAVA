/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Config.Connexion;
import Entite.Club;
import Entite.Event;
import Entite.Utilisateur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import static org.apache.commons.lang3.CharSetUtils.count;

/**
 *
 * @author Ahmed Abdessamed
 */
public class ServiceClub {
 Connexion db ;
          Connection cn =Connexion.getInstance().getConnction();
   
   public Club AffichierClub(int id) 
   {
     Club a = new Club();
     try 
        {
        Statement stm = Connexion.getInstance().getConnction().createStatement();
         String requete = "select (nom,email,address,type,tel,password) from fos_user where id = "+id+"";
       ResultSet rest= stm.executeQuery(requete);
      
       
         
         while (rest.next()) 
        {
            
           // System.out.println("le contenu de commentaire:"+rest.getString(1));
       a.setNom(rest.getString(1));
       a.setEmail(rest.getString(2));
       a.setAddress(rest.getString(3));
       a.setType(rest.getString(4));
       a.setTel(rest.getString(5));
      
       a.setPassword(rest.getString(6));
       
      
          // System.out.println("Date de comm:"+rest.getDate("dateCom"));
            
        } }
          catch (SQLException e)
                {
                    System.err.println("SQLException: "+e.getMessage());
                    System.err.println("SQLSTATE: "+e.getSQLState());
                    System.err.println("VnedorError: "+e.getErrorCode());
                }
       
       return a;

}
    
   
   public List<Utilisateur> affichuserint(int idevent){
    List<Utilisateur> myList = new ArrayList<Utilisateur>();
        try {

            String requete2 = "SELECT * from fos_user where id IN ( SELECT user_id From interesser WHERE event_id = "+idevent+" )";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(requete2);

            while (rs.next()) {
                Utilisateur u = new Utilisateur();
               u.setId(rs.getInt(1));
                u.setNom(rs.getString(14));
                u.setPrenom(rs.getString(15));
                u.setAge(rs.getInt(17));
                u.setEmail(rs.getString(5));
                u.setTel(rs.getString(16));

                myList.add(u);
            }
            //System.out.println(myList);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
    }
        public String  sumint(int a) throws SQLException{
            
         String requete2 = "SELECT COUNT(DISTINCT event_id) AS Ahmed FROM interesser WHERE user_id ="+a ;
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(requete2);
        int b =0;
        while(rs.next()){
          b  = rs.getInt(1);
        }
                   // System.out.println(b);

       String res = Integer.toString(b);
       return res ;
           
        }
   }
    
    
    
    
    
    

