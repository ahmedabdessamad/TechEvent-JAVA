/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Config.Connexion;
import Entite.Event;
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
public class ServiceEventClub {
     Connexion db ;

    public ServiceEventClub() {
    }
    
     Connection cn =Connexion.getInstance().getConnction();
     
     public List<Event> afficherByClub(int a) {
        List<Event> myList = new ArrayList<Event>();
        try {

            String requete2 = "SELECT * FROM event WHERE user_id LIKE '%" + a + "%'";
            Statement st = cn.createStatement();
            //System.out.println(requete2);
            ResultSet rs = st.executeQuery(requete2);

            while (rs.next()) {
                Event u = new Event();
                u.setId(rs.getInt("id"));
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
     
      public List<Event> afficherByClubByTitre(int a , String n) {
        List<Event> myList = new ArrayList<Event>();
        try {

            String requete2 = "SELECT * FROM event WHERE user_id LIKE '%" + a + "%' AND titre LIKE'%" + n + "%'";
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
      
      
       public List<Event> afficherByClubByCategorie(int a , String n) {
        List<Event> myList = new ArrayList<Event>();
        try {

            String requete2 = "SELECT * FROM event WHERE user_id LIKE '%" + a + "%' AND categorie LIKE'%" + n + "%'";
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
      
       public List<Event> afficherByClubByPrix(int a , String n) {
        List<Event> myList = new ArrayList<Event>();
        try {

            String requete2 = "SELECT * FROM event WHERE user_id LIKE '%" + a + "%' AND prix LIKE'%" + n + "%'";
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
     public List<Event> afficherByClubByDate(int a , String n) {
        List<Event> myList = new ArrayList<Event>();
        try {

            String requete2 = "SELECT * FROM event WHERE user_id LIKE '%" + a + "%' AND dateevent LIKE'%" + n + "%'";
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
