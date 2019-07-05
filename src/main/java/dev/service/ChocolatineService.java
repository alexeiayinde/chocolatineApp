package dev.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import dev.entite.Chocolatine;
import dev.util.Constantes;

public class ChocolatineService {

    private EntityManager em;
    private EntityTransaction tx;

    private EntityManagerFactoryService emfService = Constantes.EMF_SERVICE;

    public void listerChocolatines() {
        em = emfService.getEMF().createEntityManager();
        tx = em.getTransaction();
        tx.begin();

        TypedQuery<Chocolatine> query = em.createQuery("select c from Chocolatine c", Chocolatine.class);
        List<Chocolatine> liste = query.getResultList();

        liste.forEach(System.out::println);

        tx.commit();
        em.close();
    }

    public void creerChocolatine(String nomChocolatine, Float tempChocolatine, Float poidsChocolatine) {
        Chocolatine choco = new Chocolatine(nomChocolatine, tempChocolatine, poidsChocolatine);

        em = emfService.getEMF().createEntityManager();
        tx = em.getTransaction();
        tx.begin();
        em.persist(choco);

        tx.commit();
        em.close();
    }

    public void creerCommande(String nomChocolatine, int quantite) {

    }

}
