/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

/**
 *
 * @author Yassine
 */
public class Utilisateur {
 String nom ;
 String prenom;
 int age;
 String email;
 String password;
 String categorie;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
 String type;
 String tel;
 String Adresse;
 String roles;
int id ;

    public Utilisateur(String nom, String prenom, int age, String email, String tel, int id) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.email = email;
        this.tel = tel;
        this.id = id;
    }

    public Utilisateur (int id,String nom, String prenom, int age, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.email = email;
        this.id = id;
        
    }
 
 
 
    public Utilisateur(String nom, String prenom, int age, String email, String password) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.email = email;
        this.password = password;
    }
    public Utilisateur(){
        
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String Adresse) {
        this.Adresse = Adresse;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
    

    @Override
    public String toString() {
        return "Utilisateur{" + "nom=" + nom + ", prenom=" + prenom + ", age=" + age + ", email=" + email + ", password=" + password + '}';
    }
 
}
