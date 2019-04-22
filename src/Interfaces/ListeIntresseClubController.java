/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Entite.Event;
import Entite.Utilisateur;
import Services.ServiceClub;
import Services.serviceCSV;
import Services.sms;
import com.nexmo.client.NexmoClientException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.mail.Message.RecipientType;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Ahmed Abdessamed
 */
public class ListeIntresseClubController implements Initializable {
 ObservableList list = FXCollections.observableArrayList();
    ObservableList filteredData = FXCollections.observableArrayList();
    @FXML
    private TableView<?> tableINC;
    @FXML
    private TableColumn<?, ?> nomINC;
    @FXML
    private TableColumn<?, ?> prenomINC;
    @FXML
    private TableColumn<?, ?> ageINC;
    @FXML
    private TableColumn<?, ?> telINC;
    @FXML
    private TableColumn<?, ?> email;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ServiceClub SC = new ServiceClub();
         ArrayList Liste = (ArrayList) SC.affichuserint(129);
               ObservableList obs =FXCollections.observableArrayList(Liste);
             tableINC.setItems(obs);
             nomINC.setCellValueFactory(new PropertyValueFactory<>("nom"));
              prenomINC.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        ageINC.setCellValueFactory(new PropertyValueFactory<>("age"));
        telINC.setCellValueFactory(new PropertyValueFactory<>("tel"));
                email.setCellValueFactory(new PropertyValueFactory<>("email"));

        // TODO
    }    

    @FXML
    private void envSMS(ActionEvent event) throws IOException, NexmoClientException {
         Utilisateur E = (Utilisateur)(tableINC.getSelectionModel().getSelectedItem());
              sms s = new sms();
      s.sendSms(E.getTel());
        
    }

    @FXML
    private void envMAIL(ActionEvent event) {
                      Utilisateur E = (Utilisateur)(tableINC.getSelectionModel().getSelectedItem());
                     int a = 130 ;
  Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", 465);
        props.put("mail.smtp.user", "techevent5013@gmail.com");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.debug", "true");
        props.put("mail.smtp.socketFactory.port", 465);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1/techevent", "root", "");
            String query = "select titre,dateevent from event where id ="+a;
            PreparedStatement statmnt = con.prepareStatement(query);
            ResultSet result = statmnt.executeQuery();
            if (result.next()) {
                String titre = result.getString("titre");
                 String date = result.getString("dateevent");

                Session session = Session.getDefaultInstance(props, null);
                session.setDebug(true);
                MimeMessage message = new MimeMessage(session);
                message.setText("l'evennement  " + titre+ " Se deroule le " +date+ " \n Soyez le Bienvenue");
                message.setSubject("TechEvent : "+titre+"");
                message.setFrom(new InternetAddress("techevent5013@gmail.com"));
                message.addRecipient(RecipientType.TO, new InternetAddress(E.getEmail().trim()));
                message.saveChanges();
                javax.mail.Transport transport = session.getTransport("smtp");
                transport.connect("smtp.gmail.com", "techevent5013@gmail.com", "50135013");
                transport.sendMessage(message, message.getAllRecipients());
                transport.close();

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Attention");
                alert.setHeaderText(null);
                alert.setContentText("Email Envoyé");

                alert.showAndWait();

            }
        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Attention");
            alert.setHeaderText(null);
            alert.setContentText("Adresse e-mail introuvable");

            alert.showAndWait();

        }
    }

    @FXML
    private void lesEvent(ActionEvent event) throws IOException {
        
        Parent page = FXMLLoader.load(getClass().getResource("ClubListeEvent.fxml"));
                Scene scene = new Scene(page);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
                stage.setTitle("Liste d'événements");
                stage.setScene(scene);
                stage.show();
        
    }

    @FXML
    private void imprimer(ActionEvent event) throws FileNotFoundException {
        
        serviceCSV  cs = new serviceCSV();
   
        try{
                cs.imprimerlisteinteresser(130);
          JOptionPane.showMessageDialog(null, "Le fichier est Imprimé");

        
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "Erreur");

        }
    }
    
}
