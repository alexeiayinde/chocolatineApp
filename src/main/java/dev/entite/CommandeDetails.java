package dev.entite;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CommandeDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name = "choco_id")
    private Chocolatine chocolatine;
    
    @Column
    private Integer quantite;
    
    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name = "commande_id")
    private Commande commande;

    public CommandeDetails() {
        this.chocolatine.addCommandeDetails(this);
    }
    
    public CommandeDetails(Chocolatine chocolatine, Integer quantite, Commande commande) {
    	this();
    	this.chocolatine = chocolatine;
    	this.quantite = quantite;
    	this.commande = commande;
    }

    public Integer getId() {
        return id;
    }

    public Chocolatine getChocolatine() {
        return chocolatine;
    }

    public void setChocolatine(Chocolatine chocolatine) {
        this.chocolatine = chocolatine;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Détails de la commande (id=");
        builder.append(id);
        builder.append(") : \n\tChocolatine = ");
        builder.append(chocolatine.getNom());
        builder.append(", \n\tQuantité = ");
        builder.append(quantite);
        builder.append(".");
        return builder.toString();
    }

}
