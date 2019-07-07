package dev.entite;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "reference", unique = true)
    private String reference;

    @Column(name = "dateHeure")
    private LocalDateTime dateHeureCommande;

    @Enumerated
    private Statut statut;

    @OneToMany(mappedBy = "commandeDetails")
    private Set<CommandeDetails> panier;

//    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
//    @JoinColumn(name = "id")
    private Livreur livreur;

    public Commande() {
    	this.panier = new HashSet<>();
        this.dateHeureCommande = LocalDateTime.now();
        this.statut = Statut.EN_ATTENTE;
    }

    public void addCommandeDetails(CommandeDetails details) {
        this.panier.add(details);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReferenceCommande() {
        return reference;
    }

    public void setReferenceCommande(String referenceCommande) {
        this.reference = referenceCommande;
    }

    public LocalDateTime getDateHeureCommande() {
        return dateHeureCommande;
    }

    public void setDateHeureCommande(LocalDateTime dateHeureCommande) {
        this.dateHeureCommande = dateHeureCommande;
    }

    public Statut getStatutCommande() {
        return statut;
    }

    public void setStatutCommande(Statut statutCommande) {
        this.statut = statutCommande;
    }

    public Set<CommandeDetails> getPanier() {
        return panier;
    }

    public void setPanier(Set<CommandeDetails> panier) {
        this.panier = panier;
    }

    public Livreur getLivreur() {
        return livreur;
    }

    public void setLivreur(Livreur livreur) {
        this.livreur = livreur;
    }
    
    public Float getMontant() {
    	float montant = 0;
    	for (CommandeDetails details : panier) {
    		montant = details.getQuantite() * details.getChocolatine().getPrix();
    	}
    	
    	return montant;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Commande (id =");
        builder.append(id);
        builder.append(", référence =");
        builder.append(reference);
        builder.append(", date de commande =");
        builder.append(dateHeureCommande);
        builder.append(", statut =");
        builder.append(statut);
        builder.append(", livreur =");
        builder.append(livreur);
        builder.append(") \n\tPanier : ");
        builder.append(panier);
        builder.append("\n\tPrix total de la commande : ");
        builder.append(getMontant());
        return builder.toString();
    }

}
