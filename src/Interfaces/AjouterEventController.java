/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Entite.Event;
import Services.ServiceClub;
import Services.ServiceEvent;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTimePicker;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.time.LocalDate;


import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import static javax.management.Query.value;
import javax.swing.JOptionPane;
import org.controlsfx.control.textfield.TextFields;

/**
 * FXML Controller class
 *
 * @author Ahmed Abdessamed
 */
public class AjouterEventController implements Initializable {

    @FXML
    private TextField nbrplaces;
    @FXML
    private TextField localisation;
   
    @FXML
    private TextField hdebut;
    @FXML
    private TextField hfin;
    @FXML
    private TextField prix;
   
    @FXML
    private TextField titre;
   
   
    @FXML
    private TextField prixgold;
    @FXML
    private TextField prixsilver;
    @FXML
    private TextField prixdiamond;
    @FXML
    private TextField pdiamond;
    @FXML
    private TextField pglod;
    @FXML
    private TextField psilver;
    @FXML
    private DatePicker dateevent;
     
    @FXML
    private TextArea descri;
    @FXML
    private ChoiceBox<?> categoriechoise;
    @FXML
    private ChoiceBox<?> typechoise;
    
    public String UserSaveImagePath = "C:\\Users\\Ahmed Abdessamed\\Documents\\NetBeansProjects\\Tech_event_java\\src\\images\\";
    public String extention = ".png";
 ObservableList list0 = FXCollections.observableArrayList();
 ObservableList list1 = FXCollections.observableArrayList();
ServiceEvent SE = new ServiceEvent();
 
 
    private ImageView affiche;
    
   boolean inscrivalide = true ;
    @FXML
    private ImageView hfinimage;
    @FXML
    private ImageView hdebutimage;
    @FXML
    private ImageView nbrplace;
    @FXML
    private Button BListeEvent;
    @FXML
    private ImageView priximage;
    @FXML
    private ImageView imageS;
    @FXML
    private ImageView imageG;
    @FXML
    private ImageView iamgeD;
    @FXML
    private ImageView imageticket;
    @FXML
    private Button parcourir;
    
    /**
     * Initializes the controller class.
     */
      public  String imageevent ;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
           String[] PossibleVille ={     "Ariana",
"Béja",
"Ben Arous",
"Bizerte",
"Gabes",

        "Gafsa",
"Jendouba",
"Kairouan",
"Kasserine",
"Kebili",
"La Manouba",
"Le Kef",
"Mahdia",
"Médenine",
"Monastir",
"Nabeul",
"Sfax",
"Sidi Bouzid",
"Siliana",
"Sousse",
"Tataouine",
"Tozeur",
"Tunis",
"Zaghouan"};
  
        TextFields.bindAutoCompletion(localisation,PossibleVille);
    
          LoadData0();
          LoadData1();
          typechoise.getSelectionModel().selectLast();
       categoriechoise.getSelectionModel().selectLast();
       
        hdebut.textProperty().addListener((observable, oldValue, newValue) -> {
    
        if(!(newValue.matches("[0-2]+[0-9]") && newValue.length()==2)){
         hdebutimage.setVisible(true);
         inscrivalide= false;
        }
         else if(newValue.length()==0){
            hdebutimage.setVisible(true);
            inscrivalide = false;
        }
        else{
         hdebutimage.setVisible(false);
         inscrivalide = true;
        }
        
        
        
        
        
        });
        
        
        
        
        
        ServiceClub SC = new ServiceClub();
        try {
            SC.sumint(1);
        } catch (SQLException ex) {
            Logger.getLogger(AjouterEventController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         hfin.textProperty().addListener((observable, oldValue, newValue) -> {
    
        if(!(newValue.matches("[0-2]+[0-9]") && newValue.length()==2)){
         hfinimage.setVisible(true);
         inscrivalide= false;
        }
         else if(newValue.length()==0){
            hfinimage.setVisible(true);
            inscrivalide = false;
        }
        else{
         hfinimage.setVisible(false);
         inscrivalide = true;
        }
        
        
        
        
        
        });
         
         
         
         
          titre.textProperty().addListener((observable, oldValue, newValue) -> {
            titre.setStyle("-fx-background-color: "+"white");
             inscrivalide = true;
        });
       descri.textProperty().addListener((observable, oldValue, newValue) -> {
            descri.setStyle("-fx-background-color: "+"white");
             inscrivalide = true;
        });
       localisation.textProperty().addListener((observable, oldValue, newValue) -> {
            localisation.setStyle("-fx-background-color: "+"white");
             inscrivalide = true;
             
        });
       psilver.textProperty().addListener((observable, oldValue, newValue) -> {
            inscrivalide = true;
            psilver.setStyle("-fx-background-color: "+"white");
        });
       
        pglod.textProperty().addListener((observable, oldValue, newValue) -> {
             inscrivalide = true;
            pglod.setStyle("-fx-background-color: "+"white");
        });
        
        
         pdiamond.textProperty().addListener((observable, oldValue, newValue) -> {
             inscrivalide = true;
            pdiamond.setStyle("-fx-background-color: "+"white");
        });
         
         
          titre.textProperty().addListener((observable, oldValue, newValue) -> {
            titre.setStyle("-fx-background-color: "+"white");
             inscrivalide = true;
        });
           titre.textProperty().addListener((observable, oldValue, newValue) -> {
            titre.setStyle("-fx-background-color: "+"white");
             inscrivalide = true;
        });
        
         
         prixsilver.textProperty().addListener((observable, oldValue, newValue) -> {
    
        if(!(newValue.matches("[0-9]+") && newValue.length() < 5 )){
         imageS.setVisible(true);
         inscrivalide= false;
        }
         else if(newValue.length()==0){
            imageS.setVisible(true);
            inscrivalide = false;
        }
        else{
         imageS.setVisible(false);
         inscrivalide = true;
        }
        
        });
         prixgold.textProperty().addListener((observable, oldValue, newValue) -> {
    
        if(!(newValue.matches("[0-9]+") && newValue.length() < 5)){
         imageG.setVisible(true);
         inscrivalide= false;
        }
         else if(newValue.length()==0){
            imageG.setVisible(true);
            inscrivalide = false;
        }
        else{
         imageG.setVisible(false);
         inscrivalide = true;
        }
        
        });
         
          prixgold.textProperty().addListener((observable, oldValue, newValue) -> {
    
        if(!(newValue.matches("[0-9]+") && newValue.length() < 5)){
         imageG.setVisible(true);
         inscrivalide= false;
        }
         else if(newValue.length()==0){
            imageG.setVisible(true);
            inscrivalide = false;
        }
        else{
         imageG.setVisible(false);
         inscrivalide = true;
        }
        
        });
        
         prix.textProperty().addListener((observable, oldValue, newValue) -> {
    
        if(!(newValue.matches("[0-9]+") && newValue.length() < 5)){
         imageticket.setVisible(true);
         inscrivalide= false;
        }
          else if(newValue.length()==0){
            imageticket.setVisible(true);
            inscrivalide = false;
        }
        else{
         imageticket.setVisible(false);
         inscrivalide = true;
        }
        
        /*
        int a = Integer.parseInt(hfin.getText());
         int b = Integer.parseInt(hdebut.getText());
         
         if ( a<b)
         {
          inscrivalide = false;
         hfinimage.setVisible(true);}
         else{
          hdebutimage.setVisible(false);
         inscrivalide = true;
         }
         */
        });   
         nbrplaces.textProperty().addListener((observable, oldValue, newValue) -> {
    
        if(!(newValue.matches("[0-9]+") && newValue.length()<6)){
         nbrplace.setVisible(true);
         inscrivalide= false;
        }
          else if(newValue.length()==0){
            nbrplace.setVisible(true);
            inscrivalide = false;
        }
          
        else{
         nbrplace.setVisible(false);
         inscrivalide = true;
        }
        
        
        
        });   
       
         /*
        titre.textProperty().addListener((observable, oldValue, newValue) -> {
            titre.setStyle("-fx-background-color: "+"white");
        });
       descri.textProperty().addListener((observable, oldValue, newValue) -> {
            descri.setStyle("-fx-background-color: "+"white");
        });
       localisation.textProperty().addListener((observable, oldValue, newValue) -> {
            localisation.setStyle("-fx-background-color: "+"white");
        });
       
       
        psilver.textProperty().addListener((observable, oldValue, newValue) -> {
            psilver.setStyle("-fx-background-color: "+"white");
        });
        
      */
        
        // TODO
     }  

    
    private void ClearAjout(){
    nbrplaces.clear();
    localisation.clear();
    prixdiamond.clear();
    hdebut.clear();
    hfin.clear();
    prix.clear();
    

    titre.clear();
    descri.clear();
    
    prixgold.clear();
    prixsilver.clear();
    prixdiamond.clear();
    pglod.clear();
    psilver.clear();
    pdiamond.clear();
    
    
    }
    private void LoadData0(){ 
        list0.removeAll();
        String a = "Competition";
        String b = "WorkShop";
        String c = "Event Privé";
        String d= "Marketing";
        list0.addAll(a,b,c,d);
        typechoise.getItems().addAll(list0);
        }   
     private void LoadData1(){ 
        list1.removeAll();
        String a = "DS";
        String b = "cloud";
        String c = "BI";
        String d= "GL";
        list1.addAll(a,b,c,d);
        categoriechoise.getItems().addAll(list1);
        }   
    
    @FXML
    private void AjouterEventtest(ActionEvent event) throws SQLException, IOException {
         String a = dateevent.getValue().toString();
         
         int s1 = Integer.parseInt(prixsilver.getText());
         int s2 = Integer.parseInt(prixgold.getText());
         int s3 = Integer.parseInt(prixdiamond.getText());
         Event o = new Event ();
         String a1 = titre.getText();
         String a2 = descri.getText();
       //String a3;
           // a3 =(UserSaveImagePath+titre.getText()+extention);
         String a4 = nbrplaces.getText();
         String a5 = localisation.getText();
         String a6 = dateevent.getValue().toString();
        // int a6 =Integer.parseInt(prix.getText());
         String a7 = (hdebut.getText()+"h");
         String a8 = (hfin.getText()+"h");
         
         int a9 =Integer.parseInt(prix.getText());
         //String a9 = dateevent.getValue().toString();
         String a10 = categoriechoise.getValue().toString();
         String a11 = typechoise.getValue().toString();
         String a12 = psilver.getText();
         String a13 = pglod.getText();
         String a14 = pdiamond.getText();
          int a15 = Integer.parseInt(prixsilver.getText());
         int a16 = Integer.parseInt(prixgold.getText());
         int a17 = Integer.parseInt(prixdiamond.getText()); 
    
       
        Event E = new Event (1,a1,a2,imageevent,a4,a5,a6,a7,a8,a9,a10,a11,a12,a13,a14,a15,a16,a17);
    
       
                 

/*

  if(titre.getText().isEmpty()){
            titre.setStyle("-fx-background-color: #"+"ff7d9f");
            inscrivalide = false;
        }
  
        if(descri.getText().isEmpty()){
            descri.setStyle("-fx-background-color: #"+"ff7d9f");
         inscrivalide = false;}
            
        if(localisation.getText().isEmpty()){
            localisation.setStyle("-fx-background-color: #"+"ff7d9f");
           inscrivalide = false;
        } 
      
        
        if(psilver.getText().isEmpty()){
           psilver.setStyle("-fx-background-color: #"+"ff7d9f");
            inscrivalide = false;
        } 
       */

if(titre.getText().isEmpty()){
            titre.setStyle("-fx-background-color: #"+"ff7d9f");
            inscrivalide = false;
        }
        if(descri.getText().isEmpty()){
            descri.setStyle("-fx-background-color: #"+"ff7d9f");
            inscrivalide = false;
        }
        if(localisation.getText().isEmpty()){
            localisation.setStyle("-fx-background-color: #"+"ff7d9f");
            inscrivalide = false;
        }
        if(prixsilver.getText().isEmpty()){
            prixsilver.setStyle("-fx-background-color: #"+"ff7d9f");
            inscrivalide = false;
        }
        
        if(prixgold.getText().isEmpty()){
           prixgold.setStyle("-fx-background-color: #"+"ff7d9f");
           inscrivalide = false; 
        }
        if(prixdiamond.getText().isEmpty()){
           prixdiamond.setStyle("-fx-background-color: #"+"ff7d9f");
           inscrivalide = false; 
        }
        if(psilver.getText().isEmpty()){
           prixdiamond.setStyle("-fx-background-color: #"+"ff7d9f");
           inscrivalide = false; 
        }
        if(pglod.getText().isEmpty()){
           prixdiamond.setStyle("-fx-background-color: #"+"ff7d9f");
           inscrivalide = false; 
        }
        if(pdiamond.getText().isEmpty()){
           prixdiamond.setStyle("-fx-background-color: #"+"ff7d9f");
           inscrivalide = false; 
        }
 
 

        if ( inscrivalide == false ){
              JOptionPane.showMessageDialog(null, "Champ Invalide");
             

    }


if (inscrivalide){
    SE.AjouterE(E);
    
     ClearAjout();
               JOptionPane.showMessageDialog(null, "Votre Event est Ajouté avec succés!");

      Parent page = FXMLLoader.load(getClass().getResource("ClubListeEvent.fxml"));
                Scene scene = new Scene(page);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
                stage.setTitle("Liste d'événements");
                stage.setScene(scene);
                stage.show();
    }

    }
    @FXML
    private void ListeEvent(ActionEvent event) throws IOException {
         
         Parent page = FXMLLoader.load(getClass().getResource("ClubListeEvent.fxml"));
                Scene scene = new Scene(page);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
               stage.setTitle("Liste d'événements");
                stage.setScene(scene);
                stage.show();
                
    }
/*
 public void SaveImage(ImageView imageView, String imageName, String path, String extention) throws IOException {

        BufferedImage image = SwingFXUtils.fromFXImage(imageView.getImage(), null);
        File f;
        f = new File(path + imageName + extention);
        f = new File("C:\\Users\\Ahmed Abdessamed\\Documents\\NetBeansProjects\\Tech_event_java\\src\\images\\"+imageName+".png");
        ImageIO.write((RenderedImage) image, "png", f);
    }*/

    private void EventImagePickerAction(MouseEvent event) throws MalformedURLException {
        FileChooser fc = new FileChooser();
        File selectedFile = fc.showOpenDialog(null);
        if (selectedFile != null) {
            String imageUrl = selectedFile.toURI().toURL().toString();
            Image image = new Image(imageUrl);
            affiche.setImage(image);
    }
    
    
    }

    @FXML
    private void parcourir(ActionEvent event) {
        
        FileChooser fc =new  FileChooser();
        fc.getExtensionFilters().addAll(
        new FileChooser.ExtensionFilter("Images Files","*.bmp","*.png","*.jpg","*.gif"));
        
        File file = fc.showOpenDialog(null);
        String path = file.getPath();
        Image image = new Image(file.toURI().toString());
        imageevent = path ;
    }
    
}
