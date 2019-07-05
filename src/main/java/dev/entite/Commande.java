package dev.entite;

import java.time.LocalDateTime;
import java.util.List;

//@Entity
public class Commande {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    // @Column(length = 512)
    private String referenceCommande;
    // @Column
    private LocalDateTime dateHeureCommande;
//    @Enumerated
    private Statut statutCommande;

    // !!!!!!!!!!! TODO @ManyToMany !!!!!!!!!!!!
    private List<Chocolatine> panier;
//    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
//    @JoinColumn(name = "livreur_id")
    private Livreur livreur;

    public Commande() {
    }

    public Commande(Integer id, String referenceCommande, LocalDateTime dateHeureCommande, Statut statutCommande, List<Chocolatine> panier,
            Livreur livreur) {
        this.id = id;
        this.referenceCommande = referenceCommande;
        this.dateHeureCommande = dateHeureCommande;
        this.statutCommande = statutCommande;
        this.panier = panier;
        this.livreur = livreur;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReferenceCommande() {
        return referenceCommande;
    }

    public void setReferenceCommande(String referenceCommande) {
        this.referenceCommande = referenceCommande;
    }

    public LocalDateTime getDateHeureCommande() {
        return dateHeureCommande;
    }

    public void setDateHeureCommande(LocalDateTime dateHeureCommande) {
        this.dateHeureCommande = dateHeureCommande;
    }

    public Statut getStatutCommande() {
        return statutCommande;
    }

    public void setStatutCommande(Statut statutCommande) {
        this.statutCommande = statutCommande;
    }

    public List<Chocolatine> getPanier() {
        return panier;
    }

    public void setPanier(List<Chocolatine> panier) {
        this.panier = panier;
    }

    public Livreur getLivreur() {
        return livreur;
    }

    public void setLivreur(Livreur livreur) {
        this.livreur = livreur;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Commande [id=");
        builder.append(id);
        builder.append(", referenceCommande=");
        builder.append(referenceCommande);
        builder.append(", dateHeureCommande=");
        builder.append(dateHeureCommande);
        builder.append(", statutCommande=");
        builder.append(statutCommande);
        builder.append(", panier=");
        builder.append(panier);
        builder.append(", livreur=");
        builder.append(livreur);
        builder.append("]");
        return builder.toString();
    }

}
