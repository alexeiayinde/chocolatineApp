package dev.entite;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Chocolatine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String nom;

    @Column
    private Float temperature;

    @Column
    private Float poids;
    
    @Column
    private Float prix;

    @OneToMany(mappedBy = "commandeDetails")
    private Set<CommandeDetails> commandesDetail;

    public Chocolatine() {
    	this.commandesDetail = new HashSet<>();
    }

    public Chocolatine(String nom, Float temperature, Float poids, Float prix) {
    	this();
        this.nom = nom;
        this.temperature = temperature;
        this.poids = poids;
        this.prix = prix;
    }

    public void addCommandeDetails(CommandeDetails details) {
        this.commandesDetail.add(details);
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

    public Float getTemperature() {
        return temperature;
    }

    public void setTemperature(Float temperature) {
        this.temperature = temperature;
    }

    public Float getPoids() {
        return poids;
    }

    public void setPoids(Float poids) {
        this.poids = poids;
    }

    public Float getPrix() {
		return prix;
	}

	public void setPrix(Float prix) {
		this.prix = prix;
	}

	public Set<CommandeDetails> getCommandesDetail() {
		return commandesDetail;
	}

	public void setCommandesDetail(Set<CommandeDetails> commandesDetail) {
		this.commandesDetail = commandesDetail;
	}

	@Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Chocolatine (id=");
        builder.append(id);
        builder.append(") : \n\tNom = ");
        builder.append(nom);
        builder.append(", \n\tTemperature = ");
        builder.append(temperature);
        builder.append(", \n\tPoids = ");
        builder.append(poids);
        builder.append(", \n\tPrix = ");
        builder.append(prix);
        builder.append("\n");
        return builder.toString();
    }

}
