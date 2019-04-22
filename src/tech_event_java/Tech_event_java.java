/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech_event_java;

import Entite.Event;
import Entite.Interesse;
import Services.ServiceEvent;
import Services.ServiceInteresse;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import Services.*;
import com.nexmo.client.NexmoClientException;
import java.io.IOException;
/**
 *
 * @author Ahmed Abdessamed
 */
public class Tech_event_java {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws SQLException, IOException, NexmoClientException {
       
        Date date = new Date(1994,07,11);
        Event E = new Event (5,"fatma","abdesamed","salut","hello","test","2019-02-08","test","test", 48,"test","info","test","test",
        "test",15,15,1521);
        Event E1 = new Event (1,"test444","test555","test666","test","test","date","test","test", 15,"test","test","test","test",
        "test",15,15,1521);
        Event E2 = new Event (1,"test777","test888","tes9999t","test","test","date","test","test", 15,"test","test","test","test",
        "test",15,15,1521);
        // sendSMS  sm = new sendSMS();
        // System.out.println(sm.sendSms("ahmed abdessamed","21620077449"));
      sms s = new sms();
      //s.sendSms();
        ServiceEvent SE = new ServiceEvent();
        
       // SE.AjouterE(E);
        
       // E.setTitre("ayoub");
       // E.setDescription("ayyyy");
      // SE.ModifierE(E);
      //  ServiceClub e = new ServiceClub();
       // e.sumint(1);
        
       //SE.supprimerE(1);
    //   SE.AfficheEvent(2);
     // SE.afficherTouTEvent();
    //  ArrayList<Event> t = new ArrayList();
  //t =   (ArrayList<Event>) SE.afficherTouTEvent();
   //  for(Event ar : t){
    //   System.out.println(ar);
   //  }
   
   serviceCSV  cs = new serviceCSV();
   cs.imprimerlisteinteresser(130);
    
    Interesse EN = new Interesse(1,81);
    Interesse EN1 = new Interesse(1,3);

   // ServiceInteresse SI;
     //  SI = new  ServiceInteresse ();
  // SI.AjouterEInteresse(EN);
   // SI.SupprimerEInteresse(9);
    //SI.AfficheEventInteresse(9);
    //SE.afficherByTitre("test777");
    
    
}
}