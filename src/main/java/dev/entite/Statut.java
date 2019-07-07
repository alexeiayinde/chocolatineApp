package dev.entite;

public enum Statut {

    EN_ATTENTE("En attente"), EN_LIVRAISON("En livraison"), LIVRE("Livré");
	
	private String statut;

	Statut(String statut) {
		this.statut = statut;
	}

	public String getStatut() {
		return statut;
	}

}
