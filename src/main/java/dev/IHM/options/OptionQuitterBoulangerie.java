package dev.IHM.options;

public class OptionQuitterBoulangerie extends OptionIHM {

    public OptionQuitterBoulangerie() {
        super("Quitter la boulangerie");
    }

    @Override
    public void executer() {
        System.out.println("\nMerci d'avoir visité notre boulangerie et à la prochaine fois !");

    }

}
