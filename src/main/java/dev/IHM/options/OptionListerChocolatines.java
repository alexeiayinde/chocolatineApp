package dev.IHM.options;

import dev.service.ListerChocolatinesService;

public class OptionListerChocolatines extends OptionIHM {

    private ListerChocolatinesService listerChocolatines;

    public OptionListerChocolatines() {
        super("Lister les chocolatines");
        listerChocolatines = new ListerChocolatinesService();
    }

    @Override
    public void executer() {
        System.out.println("\nListe de chocolatines : ");
        listerChocolatines.executer();

    }

}
