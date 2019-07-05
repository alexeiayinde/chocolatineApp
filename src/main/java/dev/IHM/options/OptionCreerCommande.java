package dev.IHM.options;

import dev.IHM.ScannerService;
import dev.service.ChocolatineService;
import dev.util.Constantes;

public class OptionCreerCommande extends OptionIHM {

    private ChocolatineService chocolatineService;

    private String nomChocolatine;
    private int quantite;

    private ScannerService scannerService = Constantes.SCANNER_SERVICE;

    public OptionCreerCommande() {
        super("Créer une commande");
        chocolatineService = new ChocolatineService();
    }

    @Override
    public void executer() {
        scannerService.getScanner().nextLine();
        System.out.println("Veuillez saisir le nom de la chocolatine à ajouter dans le panier : ");
        nomChocolatine = scannerService.getScanner().nextLine();

        System.out.println("Veuillez saisir le nombre de chocolatines à ajouter dans le panier : ");
        quantite = scannerService.getScanner().nextInt();

        chocolatineService.creerCommande(nomChocolatine, quantite);

    }

}
