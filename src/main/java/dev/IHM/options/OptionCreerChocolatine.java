package dev.IHM.options;

import dev.IHM.ScannerService;
import dev.service.ChocolatineService;
import dev.util.Constantes;

public class OptionCreerChocolatine extends OptionIHM {

    private ChocolatineService chocolatineService;

    private String nomChocolatine;
    private Float temperatureChocolatine;
    private Float poidsChocolatine;

    private ScannerService scannerService = Constantes.SCANNER_SERVICE;

    public OptionCreerChocolatine() {
        super("Créer une chocolatine");
        chocolatineService = new ChocolatineService();
    }

    @Override
    public void executer() {
        scannerService.getScanner().nextLine();
        System.out.println("Veuillez saisir le nom de la chocolatine : ");
        nomChocolatine = scannerService.getScanner().nextLine();

        System.out.println("Veuillez saisir la température de la chocolatine : ");
        temperatureChocolatine = scannerService.getScanner().nextFloat();

        System.out.println("Veuillez saisir le poids de la chocolatine : ");
        poidsChocolatine = scannerService.getScanner().nextFloat();
        chocolatineService.creerChocolatine(nomChocolatine, temperatureChocolatine, poidsChocolatine);
    }

}
