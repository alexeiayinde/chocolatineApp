package dev.entite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Chocolatine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(unique = true)
    private String nom;
    @Column
    private Float temperature;
    @Column
    private Float poids;

    public Chocolatine(Integer id, String nom, Float temperature, Float poids) {
        this.id = id;
        this.nom = nom;
        this.temperature = temperature;
        this.poids = poids;
    }

    public Chocolatine() {
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
