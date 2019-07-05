package dev.IHM.options;

import dev.service.ChocolatineService;

public class OptionListerChocolatines extends OptionIHM {

    private ChocolatineService chocolatineService;

    public OptionListerChocolatines() {
        super("Lister les chocolatines");
        chocolatineService = new ChocolatineService();
    }

    @Override
    public void executer() {
        System.out.println("\nListe de chocolatines : ");
        chocolatineService.listerChocolatines();

    }

}
