package dev.IHM.options;

public abstract class OptionIHM {

    private String libelle;

    public OptionIHM(String libelle) {
        this.libelle = libelle;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("OptionIHM [libelle=");
        builder.append(libelle);
        builder.append("]");
        return builder.toString();
    }

    public abstract void executer();

}
