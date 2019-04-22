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
public class Club {
    int id;
    String nom ;
    String email;
     String address;
      String type;
       String categorie;
        String tel;
         String password;
         String roles;

    public Club() {
    }
            
    public Club(String nom, String email, String address, String type, String categorie, String tel, String password, String roles) {
        this.nom = nom;
        this.email = email;
        this.address = address;
        this.type = type;
        this.categorie = categorie;
        this.tel = tel;
        this.password = password;
        this.roles = roles;
    }

    public Club(int id, String nom, String email, String address, String type, String categorie, String tel, String password, String roles) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.address = address;
        this.type = type;
        this.categorie = categorie;
        this.tel = tel;
        this.password = password;
        this.roles = roles;
    }

    public Club(String nom, String email, String address, String type, String tel, String password) {
        this.nom = nom;
        this.email = email;
        this.address = address;
        this.type = type;
        this.tel = tel;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Club{" + "id=" + id + ", nom=" + nom + ", email=" + email + ", address=" + address + ", type=" + type + ", categorie=" + categorie + ", tel=" + tel + ", password=" + password + ", roles=" + roles + '}';
    }
  

    
}
