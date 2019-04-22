/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Config.Connexion;
import Entite.Club;
import Services.ServiceClub;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Ahmed Abdessamed
 */
public class ProfilClubController implements Initializable {
Connexion db ;
    @FXML
    private TextField nom;
    @FXML
    private TextField email;
    @FXML
    private TextField adress;
    @FXML
    private TextField type;
    @FXML
    private TextField password;
    @FXML
    private TextField tel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
        int id = 5;
        String requete2 = "SELECT nom FROM fos_user WHERE id ="+id+"";
            Statement st;
    Statement sst = cn.createStatement();
            ResultSet rs = sst.executeQuery(requete2);
            while(rs.next()){
            nom.setText(rs.getString(1));
    }  }  catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
            
          try {
        int id = 5 ;
        String requete2 = "SELECT email FROM fos_user WHERE id ="+id+"";
            Statement st;
    Statement sst = cn.createStatement();
            ResultSet rs = sst.executeQuery(requete2);
            while(rs.next()){
            email.setText(rs.getString(1));
    }  }  catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
            try {
        int id = 5 ;
        String requete2 = "SELECT address FROM fos_user WHERE id ="+id+"";
            Statement st;
    Statement sst = cn.createStatement();
            ResultSet rs = sst.executeQuery(requete2);
            while(rs.next()){
            adress.setText(rs.getString(1));
    }  }  catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
              try {
        int id = 5 ;
        String requete2 = "SELECT type FROM fos_user WHERE id ="+id+"";
            Statement st;
    Statement sst = cn.createStatement();
            ResultSet rs = sst.executeQuery(requete2);
            while(rs.next()){
            type.setText(rs.getString(1));
    }  }  catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
                try {
        int id = 5 ;
        String requete2 = "SELECT tel FROM fos_user WHERE id ="+id+"";
            Statement st;
    Statement sst = cn.createStatement();
            ResultSet rs = sst.executeQuery(requete2);
            while(rs.next()){
            tel.setText(rs.getString(1));
    }  }  catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
                
       try {
        int id = 5 ;
        String requete2 = "SELECT password FROM fos_user WHERE id ="+id+"";
            Statement st;
    Statement sst = cn.createStatement();
            ResultSet rs = sst.executeQuery(requete2);
            while(rs.next()){
            password.setText(rs.getString(1));
    }  }  catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
       
       
// TODO
    }    
Connection cn =Connexion.getInstance().getConnction(); 
  


    @FXML
    private void Modifier(ActionEvent event) throws SQLException, IOException {
        
         String sql="UPDATE `fos_user` SET email ='"+email.getText()+"',password ='"+password.getText()+"',type ='"+type.getText()+"',nom='"+nom.getText()+"',tel = '"+tel.getText()+"',address ='"+adress.getText()+"'WHERE `fos_user`.`id`="+1+"";
           PreparedStatement pst = cn.prepareStatement(sql);
          
        pst.execute();
                      JOptionPane.showMessageDialog(null,"Profil  Modifée");
 Parent page = FXMLLoader.load(getClass().getResource("ClubListeEvent.fxml"));
                Scene scene = new Scene(page);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
               stage.setTitle("Liste d'événements");
                stage.setScene(scene);
                stage.show();
    }
/*
    private void supprimerCompte(ActionEvent event) throws SQLException, IOException {
        int a = 1;
        String requete = "delete from fos_user where id = "+a+"";
            
       PreparedStatement st = cn.prepareStatement(requete);
       
      
        st.executeUpdate();
        System.out.println("Compte supprimer  supprimée !");
        
        Parent page = FXMLLoader.load(getClass().getResource("AjouterEvent.fxml"));
                Scene scene = new Scene(page);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
               stage.setTitle("Liste d'événements");
                stage.setScene(scene);
                stage.show();
       
    }*/

    @FXML
    private void retour(ActionEvent event) throws IOException {
        
        Parent page = FXMLLoader.load(getClass().getResource("ClubListeEvent.fxml"));
                Scene scene = new Scene(page);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
               stage.setTitle("Liste d'événements");
                stage.setScene(scene);
                stage.show();
                
    }
    
}
