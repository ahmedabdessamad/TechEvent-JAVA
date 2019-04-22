/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Entite.Event;
import Entite.Interesse;
import Services.ServiceEventClub;
import Services.ServiceInteresse;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Ahmed Abdessamed
 */
public class ListeInteresseController implements Initializable {

    @FXML
    private TableView<?> tableIN;
    @FXML
    private TableColumn<?, ?> testIN;
    @FXML
    private TableColumn<?, ?> prixIN;
    @FXML
    private TableColumn<?, ?> typeIN;
    @FXML
    private TableColumn<?, ?> debutIN;
    @FXML
    private TableColumn<?, ?> finIN;
    @FXML
    private TableColumn<?, ?> dateIN;
   

    /**
     * Initializes the controller class.
     */
    ServiceInteresse EI= new ServiceInteresse();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
               ArrayList Liste = (ArrayList) EI.afficherTouTinteresse(1);
               ObservableList obs =FXCollections.observableArrayList(Liste);
             tableIN.setItems(obs);
             testIN.setCellValueFactory(new PropertyValueFactory<>("titre"));
              prixIN.setCellValueFactory(new PropertyValueFactory<>("prix"));  
             
             typeIN.setCellValueFactory(new PropertyValueFactory<>("type"));
            debutIN.setCellValueFactory(new PropertyValueFactory<>("hdebut"));
            finIN.setCellValueFactory(new PropertyValueFactory<>("hfin"));
            dateIN.setCellValueFactory(new PropertyValueFactory<>("dateevent"));
        // TODO
    }    

    @FXML
    private void supprimerIN(ActionEvent event) throws SQLException {
            ServiceInteresse EI= new ServiceInteresse();

          Event E = (Event)(tableIN.getSelectionModel().getSelectedItem());
        System.out.println(E.getId());
      EI.SupIN(E.getId());
       
          JOptionPane.showMessageDialog(null, "Votre Event est supprimée avec succés!");
           
               ArrayList Liste = (ArrayList) EI.afficherTouTinteresse(1);
               ObservableList obs =FXCollections.observableArrayList(Liste);
             tableIN.setItems(obs);
    }

    @FXML
    private void toutlesevent(ActionEvent event) throws IOException {
        Parent page = FXMLLoader.load(getClass().getResource("ListeEvent.fxml"));
                Scene scene = new Scene(page);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
               stage.setTitle("Liste d'événements");
                stage.setScene(scene);
                stage.show();
    }
    
}
