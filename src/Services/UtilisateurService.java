/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entite.Utilisateur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Config.Connexion;

/**
 *
 * @author Yassine
 */
public class UtilisateurService {    
    Connexion c = Connexion.getInstance();
     Connection con = c.getConnction(); 
     public void Signup(Utilisateur usr) throws SQLException{
      try{
         String requete = "insert into fos_user(prenom,nom,age,email,password,roles)values(?,?,?,?,?,?)";
        PreparedStatement p = con.prepareStatement(requete);
        p.setString(1, usr.getNom());
        p.setString(2, usr.getPrenom());
        p.setInt(3,usr.getAge());
        p.setString(4,usr.getEmail());
        p.setString(5,usr.getPassword());
        p.setString(6,"participant");

        p.execute();
        System.out.println("user ajoutée");
      
      }  catch(SQLException ex){
        System.out.println(ex.getMessage());
      }  
          
     }
     
     //Sign up club

     public void SignupClub(Utilisateur usr) throws SQLException{
      try{
         String requete = "insert into fos_user(nom,email,address,type,categorie,tel,password,roles)values(?,?,?,?,?,?,?,?)";
        PreparedStatement p = con.prepareStatement(requete);
        p.setString(1,usr.getNom());
        p.setString(2,usr.getEmail() );
        p.setString(3,usr.getAdresse());
        p.setString(4,usr.getType());
        p.setString(5,usr.getCategorie());
        p.setString(6,usr.getTel());
        p.setString(7,usr.getPassword());
        p.setString(8,"club");
        p.execute();
        System.out.println("user ajoutée");
      
      }  catch(SQLException ex){
        System.out.println(ex.getMessage());
      }  
          
     }
     

     //Sign up sponsor 
       public void SignupSponsor(Utilisateur usr) throws SQLException{
      try{
         String requete = "insert into fos_user(nom,email,address,tel,password,roles)values(?,?,?,?,?,?)";
        PreparedStatement p = con.prepareStatement(requete);
        p.setString(1,usr.getNom());
        p.setString(2,usr.getEmail() );
        p.setString(3,usr.getAdresse()); 
        p.setString(4,usr.getTel());
        p.setString(5,usr.getPassword());
        p.setString(6,"sponsor");
        p.execute();
        System.out.println("user ajoutée");
      
      }  catch(SQLException ex){
        System.out.println(ex.getMessage());
      }  
          
     }
     
       //connexion 
     
    public Utilisateur Connexion(String mail,String pwd) throws SQLException{
      String requete = "select * from fos_user where email = ? and password = ?"; 
         try{
        PreparedStatement p = con.prepareStatement(requete);
        Utilisateur us = new Utilisateur();
        p.setString(1,mail);
        p.setString(2,pwd);
        ResultSet rs = p.executeQuery();
          if(!rs.next()){
              System.out.println("Login error");
              return null;
          }else{
              us.setEmail(mail);
              us.setPassword(pwd);
              us.setRoles(rs.getString(13));
              System.out.println("Login sucessfull");
             return us;
          }
         }catch(SQLException ex){
            System.out.println(ex.getMessage());
         }
         return null;
    }
}
     


