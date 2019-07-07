package dev.IHM.options;

import dev.IHM.ScannerService;
import dev.service.ChocolatineService;
import dev.util.Constantes;

public class OptionCreerLivreur extends OptionIHM {
	
	private ChocolatineService chocolatineService;
	
	private String nomLivreur;
	private String prenomLivreur;
	
	private ScannerService scannerService = Constantes.SCANNER_SERVICE;

    public OptionCreerLivreur() {
        super("Créer un livreur");
        chocolatineService = new ChocolatineService();
    }

    @Override
    public void executer() {
    	scannerService.getScanner().nextLine();
    	
    	System.out.println("Veuillez saisir le nom du livreur : ");
    	nomLivreur = scannerService.getScanner().nextLine();
    	
    	System.out.println("eVeuillez saisir le prénom du livreur : ");
    	prenomLivreur = scannerService.getScanner().nextLine();
    	
    	chocolatineService.creerLivreur(nomLivreur, prenomLivreur);
    }

}
