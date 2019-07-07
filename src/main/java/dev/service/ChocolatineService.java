package dev.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import dev.entite.Chocolatine;
import dev.entite.Commande;
import dev.entite.CommandeDetails;
import dev.entite.Livreur;
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
        
//        liste.forEach(System.out::println);
        
        for (int i = 1; i <= liste.size(); i++) {
        	System.out.println(i + ". " + liste.get(i-1));
        }

        tx.commit();
        em.close();
    }

    public void creerChocolatine(String nomChocolatine, Float tempChocolatine, Float poidsChocolatine, Float prixChocolatine) {
    	//TODO ajouter champ prix dans BDD
        Chocolatine choco = new Chocolatine(nomChocolatine, tempChocolatine, poidsChocolatine, prixChocolatine);

        em = emfService.getEMF().createEntityManager();
        tx = em.getTransaction();
        tx.begin();
        em.persist(choco);

        tx.commit();
        em.close();
    }
    
    public Chocolatine getChocolatine(int idChocolatine) {
    	//TODO exception si id n'existe pas
    	em = emfService.getEMF().createEntityManager();
    	tx = em.getTransaction();
    	tx.begin();
    	
    	TypedQuery<Chocolatine> query = em.createQuery("SELECT c FROM chocolatine c WHERE c.id = '" + idChocolatine + "'", Chocolatine.class);
    	
    	tx.commit();
    	em.close();
    	
    	return query.getResultList().get(0);
    }

    public void creerCommande(String referenceCommande, Chocolatine chocolatine, int quantite) {
    	em = emfService.getEMF().createEntityManager();
    	tx = em.getTransaction();
    	tx.begin();
    	
    	TypedQuery<Commande> query = em.createQuery("SELECT c FROM commande c WHERE c.reference = '" + referenceCommande + "'", Commande.class);
    	
    	if (query.getResultList().isEmpty()) {
    		Commande commande = new Commande();
    		commande.setReferenceCommande(referenceCommande);
    		commande.addCommandeDetails(new CommandeDetails(chocolatine, quantite, commande)); // ne fonctionnera p-e pas. faut-il persister indépendemment le CommandeDetails?
    		em.persist(commande);
    		System.out.println(commande);
    	} else {
    		query.getResultList().get(0).addCommandeDetails(new CommandeDetails(chocolatine, quantite, query.getResultList().get(0))); // ne fonctionnera p-e pas. faut-il persister indépendemment le CommandeDetails?
    		System.out.println(query.getResultList().get(0));
    	}

    	tx.commit();
    	em.close();
    }
    
    public void creerLivreur(String nomLivreur, String prenomLivreur) {
    	Livreur livreur = new Livreur(nomLivreur, prenomLivreur);
    	
    	em = emfService.getEMF().createEntityManager();
    	tx = em.getTransaction();
    	tx.begin();
    	
    	em.persist(livreur);
    	
    	tx.commit();
    	em.close();
    	
    }


}
