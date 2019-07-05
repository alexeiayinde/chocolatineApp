package dev.entite;

import java.util.Set;

//@Entity
public class Livreur {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
//    @Column(length = 512)
    private String nom;
//    @Column(length = 512)
    private String prenom;

    // @OneToMany(mappedBy = "commande")
    private Set<Commande> listeCommandes;

    public Livreur() {
    }

    public Livreur(Integer id, String nom, String prenom, Set<Commande> listeCommandes) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.listeCommandes = listeCommandes;
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
