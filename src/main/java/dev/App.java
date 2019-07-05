package dev;

import dev.IHM.Menu;

public class App {

    public static void main(String[] args) {
//
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("rappels-jpa");
//
//        EntityManager em = emf.createEntityManager();
//
//        Chocolatine chocol = new Chocolatine(2, "alex", 37.5f, 2.0f);
//
//        EntityTransaction tx = em.getTransaction();
//
////        tx.begin();
////        em.persist(chocol);
////        tx.commit();
////        em.close();
////        emf.close();
//
//        tx.begin();
//
//        TypedQuery<Chocolatine> query = em.createQuery("select c from Chocolatine c", Chocolatine.class);
//        List<Chocolatine> list = query.getResultList();
//        for (Chocolatine c : list)
//            System.out.println(c);
//
//        tx.commit();
//        em.close();
//        emf.close();

        Menu menu = new Menu();

    }

}
