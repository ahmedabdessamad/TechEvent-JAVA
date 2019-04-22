/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

/**
 *
 * @author Ahmed Abdessamed
 */
public class Interesse  {
    
    int id ;
    int user_id ;
    int event_id ;

    
    public Interesse(int id, int user_id, int event_id) {
        this.id = id;
        this.user_id = user_id;
        this.event_id = event_id;
    }

    public Interesse(int user_id, int event_id) {
        this.user_id = user_id;
        this.event_id = event_id;
    }

    public Interesse() {
    }

    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    @Override
    public String toString() {
        return "Iintteresse{" + "id=" + id + ", user_id=" + user_id + ", event_id=" + event_id + '}';
    }
    
    
}
