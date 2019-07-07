package dev.entite;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Livreur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String nom;
    @Column
    private String prenom;

    // @OneToMany(mappedBy = "commande")
    private Set<Commande> listeCommandes;

    public Livreur() {
    }

    public Livreur(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }
    
    public void addCommande(Commande commande) {
    	this.listeCommandes.add(commande);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Set<Commande> getListeCommandes() {
        return listeCommandes;
    }

    public void setListeCommandes(Set<Commande> listeCommandes) {
        this.listeCommandes = listeCommandes;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Livreur [id=");
        builder.append(id);
        builder.append(", nom=");
        builder.append(nom);
        builder.append(", prenom=");
        builder.append(prenom);
        builder.append(", listeCommandes=");
        builder.append(listeCommandes);
        builder.append("]");
        return builder.toString();
    }

}
