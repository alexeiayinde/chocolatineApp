package dev.IHM;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import dev.IHM.options.OptionAffecterLivreurACommande;
import dev.IHM.options.OptionCreerChocolatine;
import dev.IHM.options.OptionCreerCommande;
import dev.IHM.options.OptionCreerLivreur;
import dev.IHM.options.OptionIHM;
import dev.IHM.options.OptionListerChocolatines;
import dev.IHM.options.OptionQuitterBoulangerie;
import dev.IHM.options.OptionTopChocolatine;
import dev.util.Constantes;

public class Menu {

    private Map<Integer, OptionIHM> listeOptionsIHM;
    private int choix;

    private ScannerService scannerService = Constantes.SCANNER_SERVICE;

    public Menu() {
        initMenu();
    }

    private void initMenu() {

        while (choix != 9) {
            listeOptionsIHM = new HashMap<Integer, OptionIHM>();
            listeOptionsIHM.put(1, new OptionListerChocolatines());
            listeOptionsIHM.put(2, new OptionCreerChocolatine());
            listeOptionsIHM.put(3, new OptionCreerCommande());
            listeOptionsIHM.put(4, new OptionTopChocolatine());
            listeOptionsIHM.put(5, new OptionCreerLivreur());
            listeOptionsIHM.put(6, new OptionAffecterLivreurACommande());
            listeOptionsIHM.put(9, new OptionQuitterBoulangerie());

            System.out.println("*********** Bienvenue chez Glen ***********");
            System.out.println("\nVeuillez choisir parmi les options suivantes : \n");

            for (Entry<Integer, OptionIHM> element : listeOptionsIHM.entrySet()) {
                System.out.println(element.getKey() + ". " + element.getValue().getLibelle());
            }

            System.out.print("\nChoix = ");
            choix = scannerService.getScanner().nextInt();

            listeOptionsIHM.get(choix).executer();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

}