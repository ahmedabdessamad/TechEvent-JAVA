/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Config.Connexion;
import Entite.Utilisateur;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ahmed Abdessamed
 */
public class serviceCSV  {
    Connexion db ;
 Connection cn =Connexion.getInstance().getConnction();

public void outputCSV()throws FileNotFoundException{
FileOutputStream fos =new FileOutputStream("Intresse.csv",true);

PrintWriter pw = new PrintWriter(fos);
pw.println("Nom, Prenom , Age,Email,Tel ");
pw.println("ahmed, 18 , mmmm ");
pw.println("jdidi, 50 , gggg ");
pw.close();

System.out.println("toooop");

}

public List<Utilisateur> imprimerlisteinteresser(int idevent) throws FileNotFoundException{
    List<Utilisateur> myList = new ArrayList<Utilisateur>();
     FileOutputStream fos =new FileOutputStream("Liste_Intresse.csv",true);
    PrintWriter pw = new PrintWriter(fos);
    pw.println("Nom,Prenom,Age,Email,Tel");
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
                
                
                pw.println(rs.getString(14)+","+rs.getString(15)+","+rs.getInt(17)+","+rs.getString(5)+","+rs.getString(16));
               
               
                                myList.add(u);
            }
            System.out.println("le fichier CSV est imprimé");
            pw.close();
           
            //System.out.println(myList);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
    }
}
