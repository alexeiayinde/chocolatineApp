package dev.IHM.options;

import java.util.UUID;

import dev.IHM.ScannerService;
import dev.service.ChocolatineService;
import dev.util.Constantes;

public class OptionCreerCommande extends OptionIHM {

    private ChocolatineService chocolatineService;

    private String referenceCommande;
    private int idChocolatine;
    private int quantite;
    private String choix;

    private ScannerService scannerService = Constantes.SCANNER_SERVICE;

    public OptionCreerCommande() {
        super("Créer une commande");
        chocolatineService = new ChocolatineService();
    }

    @Override
    public void executer() {

		referenceCommande = UUID.randomUUID().toString();
		
    	while (choix.toUpperCase() != "N") {
        	
        	System.out.println("Veuillez choisir une chocolatine à ajouter dans le panier parmi le choix suivant : ");
        	chocolatineService.listerChocolatines();
        	System.out.println("Id de la chocolatine : ");
        	idChocolatine = scannerService.getScanner().nextInt();

            System.out.println("Veuillez saisir le nombre de chocolatines à ajouter dans le panier : ");
            quantite = scannerService.getScanner().nextInt();

            chocolatineService.creerCommande(referenceCommande, chocolatineService.getChocolatine(idChocolatine), quantite);
            
            while (choix != "N" && choix != "n" && choix != "O" && choix != "o") {
            	System.out.println("Souhaitez-vous ajouter d'autres chocolatines au panier ? (O/N)");
                scannerService.getScanner().nextLine();
                choix = scannerService.getScanner().nextLine();
            }            
    	}
    }

}
