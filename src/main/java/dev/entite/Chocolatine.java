package dev.entite;

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

    @OneToMany(mappedBy = "commandeDetails")
    private Set<CommandeDetails> commandesDetail;

    public Chocolatine() {
    }

    public Chocolatine(String nom, Float temperature, Float poids) {
        this.nom = nom;
        this.temperature = temperature;
        this.poids = poids;
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
        builder.append("\n");
        return builder.toString();
    }

}
