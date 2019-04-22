/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;
import javafx.util.Duration;
import tray.notification.TrayNotification;
import Config.Connexion;
import Entite.Event;
import Services.ServiceClub;
import Services.ServiceEvent;
import Services.ServiceEventClub;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author Ahmed Abdessamed
 */
public class ClubListeEventController implements Initializable {
 ObservableList list = FXCollections.observableArrayList();
  ObservableList list1 = FXCollections.observableArrayList();
    ObservableList filteredData = FXCollections.observableArrayList();
    @FXML
    private TableView<?> tableTC;
    @FXML
    private TableColumn<?, ?> titreTC;
    @FXML
    private TableColumn<?, ?> descTC;
    @FXML
    private TableColumn<?, ?> hdebutTC;
    @FXML
    private TableColumn<?, ?> hfinTC;
    @FXML
    private TableColumn<?, ?> prixTC;
    @FXML
    private TableColumn<?, ?> typeTC;
    @FXML
    private Button buttonS;
    @FXML
    private Button buttonM;
    @FXML
    private Button ButtonR;
    @FXML
    private TextField recherche;
    @FXML
    private ChoiceBox<?> itemC;
    @FXML
    private DatePicker dateEC;
   

    /**
     * Initializes the controller class.
     */
    
    ServiceEvent SE = new ServiceEvent();
    @FXML
    private TableColumn<?, ?> localisationTC;
    @FXML
    private TextField modifierE;
    @FXML
    private ChoiceBox<?> ChoiseModifier;
    
    
   
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     LoadData();
     LoadDataM();
        itemC.getSelectionModel().selectLast();
       ChoiseModifier.getSelectionModel().selectLast();
               ServiceEventClub   ms =  new ServiceEventClub();
               ArrayList Liste = (ArrayList) ms.afficherByClub(1);
               ObservableList obs =FXCollections.observableArrayList(Liste);
             tableTC.setItems(obs);
             titreTC.setCellValueFactory(new PropertyValueFactory<>("titre"));
               localisationTC.setCellValueFactory(new PropertyValueFactory<>("localisation"));  
             hdebutTC.setCellValueFactory(new PropertyValueFactory<>("hdebut"));
             hfinTC.setCellValueFactory(new PropertyValueFactory<>("hfin"));
             prixTC.setCellValueFactory(new PropertyValueFactory<>("prix"));
             typeTC.setCellValueFactory(new PropertyValueFactory<>("type"));
             descTC.setCellValueFactory(new PropertyValueFactory<>("description"));
           //Notification
           
           
           
             TrayNotification tray = new TrayNotification();
        tray.setTitle("Nombre des Personnse qui sont intéressé :");
     try {
         tray.setMessage(E.sumint(1));
     } catch (SQLException ex) {
         Logger.getLogger(ClubListeEventController.class.getName()).log(Level.SEVERE, null, ex);
     }

      tray.showAndDismiss(Duration.seconds(20));
            
    }   
    
ServiceClub E = new ServiceClub();

 
    private void LoadData(){ 
        list.removeAll();
        String a = "catégorie";
        String b = "titre";
        String c = "prix";
        String d= "tous";
        list.addAll(a,b,c,d);
        itemC.getItems().addAll(list);
        }   
    
    
    private void LoadDataM(){ 
        list1.removeAll();
        String a = "place";
        String b = "titre";
        String c = "prix";
        String d= "Localisation";
        list1.addAll(a,b,c,d);
        ChoiseModifier.getItems().addAll(list1);
        }   
    @FXML
    private void supprimerEvent(ActionEvent event)throws IOException, SQLException {
        Event r = (Event)(tableTC.getSelectionModel().getSelectedItem());
       //System.out.println(r.getId());
       /*Button supprimer =new Button("Supprimer Event");
       supprimer.setFont(Font.font("Sansarif",15));
       supprimer.setOnAction(e->{
        Alert alert= new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmaation");
        alert.setHeaderText(null);
        alert.setContentText("tu est sur ?");
        Optional <ButtonType> action= alert.showAndWait();
        if (action.get()==ButtonType.OK){
                try{
                    SE.supprimerEvent(r.getId());
                    ServiceEventClub   ms =  new ServiceEventClub();
               ArrayList Liste = (ArrayList) ms.afficherByClub(1);
               ObservableList obs =FXCollections.observableArrayList(Liste);
             tableTC.setItems(obs);;
                } catch (SQLException ex) {
                Logger.getLogger(ClubListeEventController.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
       });*/
      
       Alert alert = new Alert(AlertType.CONFIRMATION);
alert.setTitle("Confirmation du  suppression");
alert.setHeaderText("Confirmation de supprission");
alert.setContentText("étes-vous Sur ?");

Optional<ButtonType> result = alert.showAndWait();
if (result.get() == ButtonType.OK){
    SE.supprimerEvent(r.getId());
} else {
    // ... user chose CANCEL or closed the dialog
}
       
       
       
                    ServiceEventClub   ms =  new ServiceEventClub();
               ArrayList Liste = (ArrayList) ms.afficherByClub(1);
               ObservableList obs =FXCollections.observableArrayList(Liste);
             tableTC.setItems(obs);;
        
        
         
         
        
    }
    
    
    
    public void modifierEvent(ActionEvent event) throws IOException, SQLException {
          Event V =  (Event) tableTC.getSelectionModel().getSelectedItem(); 
        
           ServiceEventClub   ms =  new ServiceEventClub();
               ArrayList Liste = (ArrayList) ms.afficherByClub(1);
               ObservableList obs =FXCollections.observableArrayList(Liste);
             tableTC.setItems(obs);
          
            
    }
 public void ahmed(){
 
 }
    @FXML
    private void rechercheEvent(ActionEvent event) {
         if ( itemC.getSelectionModel().getSelectedItem() == "titre"){
         ServiceEventClub   ms =  new ServiceEventClub();
               ArrayList Liste = (ArrayList) ms.afficherByClubByTitre(1,recherche.getText());
               ObservableList obs =FXCollections.observableArrayList(Liste);
             tableTC.setItems(obs);
            
         }
           if ( itemC.getSelectionModel().getSelectedItem() == "catégorie"){
           ServiceEventClub   ms =  new ServiceEventClub();
               ArrayList Liste = (ArrayList) ms.afficherByClubByCategorie(1,recherche.getText());
               ObservableList obs =FXCollections.observableArrayList(Liste);
             tableTC.setItems(obs);
           
           
           }
         if ( itemC.getSelectionModel().getSelectedItem() == "prix"){
           ServiceEventClub   ms =  new ServiceEventClub();
               ArrayList Liste = (ArrayList) ms.afficherByClubByPrix(1,recherche.getText());
               ObservableList obs =FXCollections.observableArrayList(Liste);
             tableTC.setItems(obs);

           
           }
         if ( itemC.getSelectionModel().getSelectedItem() == "tous"){
           ServiceEventClub   ms =  new ServiceEventClub();
               ArrayList Liste = (ArrayList) ms.afficherByClub(1);
               ObservableList obs =FXCollections.observableArrayList(Liste);
             tableTC.setItems(obs);
       
           }
    }

    @FXML
    private void ListerDateEC(ActionEvent event) {
        
           String a = dateEC.getValue().toString();
 ServiceEventClub   ms =  new ServiceEventClub();
               ArrayList Liste = (ArrayList) ms.afficherByClubByDate(1,a);
               ObservableList obs =FXCollections.observableArrayList(Liste);
               tableTC.setItems(obs);
              
    }

    

    @FXML
    private void ajouterEvent(ActionEvent event) throws IOException {
        
        Parent page = FXMLLoader.load(getClass().getResource("AjouterEvent.fxml"));
                Scene scene = new Scene(page);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
               stage.setTitle("Liste d'événements");
                stage.setScene(scene);
                stage.show();
    }

    @FXML
    private void recherchetext(ActionEvent event) {
       
    }

    @FXML
    private void selectitemM(MouseEvent event) {
        
                  Event V =  (Event) tableTC.getSelectionModel().getSelectedItem(); 

       if (ChoiseModifier.getSelectionModel().getSelectedItem() == "titre")
       {
           
       String a = V.getTitre();
       modifierE.setText(a);
       }
         if (ChoiseModifier.getSelectionModel().getSelectedItem() == "type")
       {
           
       String a = V.getType();
       modifierE.setText(a);
       
       }
           if (ChoiseModifier.getSelectionModel().getSelectedItem() == "prix")
       {
           
       String  a = Integer.toString(V.getPrix());
       modifierE.setText(a);
       }
              if (ChoiseModifier.getSelectionModel().getSelectedItem() == "Localisation")
       {
           
       String  a = (V.getLocalisation());
       modifierE.setText(a);
       }
    }

    @FXML
    private void modifierEventE(ActionEvent event) throws SQLException {
        
      modifier();  
    }
ServiceEvent a = new ServiceEvent();
 Connexion db ;
          Connection cn =Connexion.getInstance().getConnction();

    public void modifier() throws SQLException{
                          Event V =  (Event) tableTC.getSelectionModel().getSelectedItem(); 
        //System.out.println(V.getId());
        
       if (ChoiseModifier.getSelectionModel().getSelectedItem() == "titre")
       {
       String sql="update event SET titre= ? where id = ?";
           PreparedStatement pst = cn.prepareStatement(sql);
           pst.setString(1,modifierE.getText());
           pst.setInt(2,V.getId());
        pst.execute();
        ServiceEventClub   ms =  new ServiceEventClub();
               ArrayList Liste = (ArrayList) ms.afficherByClub(1);
               ObservableList obs =FXCollections.observableArrayList(Liste);
             tableTC.setItems(obs);
       } 
       if (ChoiseModifier.getSelectionModel().getSelectedItem() == "prix")
       {
       String sql="update event SET prix= ? where id = ?";
           PreparedStatement pst = cn.prepareStatement(sql);
           int a = Integer.parseInt(modifierE.getText());
           pst.setInt(1,a);
           pst.setInt(2,V.getId());
        pst.execute();
        ServiceEventClub   ms =  new ServiceEventClub();
               ArrayList Liste = (ArrayList) ms.afficherByClub(1);
               ObservableList obs =FXCollections.observableArrayList(Liste);
             tableTC.setItems(obs);
       } 
       if (ChoiseModifier.getSelectionModel().getSelectedItem() == "place")
       {
       String sql="update event SET nbrplaces= ? where id = ?";
           PreparedStatement pst = cn.prepareStatement(sql);
           int a = Integer.parseInt(modifierE.getText());
           pst.setInt(1,a);
           pst.setInt(2,V.getId());;
        pst.execute();
        ServiceEventClub   ms =  new ServiceEventClub();
               ArrayList Liste = (ArrayList) ms.afficherByClub(1);
               ObservableList obs =FXCollections.observableArrayList(Liste);
             tableTC.setItems(obs);
       } 
       if (ChoiseModifier.getSelectionModel().getSelectedItem() == "Localisation")
       {
       String sql="update event SET localisation= ? where id = ?";
           PreparedStatement pst = cn.prepareStatement(sql);
           pst.setString(1,modifierE.getText());
           pst.setInt(2,V.getId());
        pst.execute();
        ServiceEventClub   ms =  new ServiceEventClub();
               ArrayList Liste = (ArrayList) ms.afficherByClub(1);
               ObservableList obs =FXCollections.observableArrayList(Liste);
             tableTC.setItems(obs);
       } 
    }    

    @FXML
    private void GP(ActionEvent event) throws IOException {
         Parent page = FXMLLoader.load(getClass().getResource("ProfilClub.fxml"));
                Scene scene = new Scene(page);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
               stage.setTitle("Liste d'événements");
                stage.setScene(scene);
                stage.show();
    }

    @FXML
    private void listin(ActionEvent event) throws IOException {
                  Event c =  (Event) tableTC.getSelectionModel().getSelectedItem(); 
       
        Parent page = FXMLLoader.load(getClass().getResource("ListeIntresseClub.fxml"));
                Scene scene = new Scene(page);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
               stage.setTitle("Liste d'événements");
                stage.setScene(scene);
                stage.show();
        
    }
    
}
