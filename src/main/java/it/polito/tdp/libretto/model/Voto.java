package it.polito.tdp.libretto.model;

public class Voto {
	private String dataEsame;
	private String nomeCorso;
	private int voto;

	public Voto(String dataEsame, String nomeCorso, int voto) {
		super();
		this.dataEsame = dataEsame;
		this.nomeCorso = nomeCorso;
		this.voto = voto;
	}

	public String getDataEsame() {
		return dataEsame;
	}

	public String getNomeCorso() {
		return nomeCorso;
	}

	public int getVoto() {
		return voto;
	}

	public void setVoto(int voto) {
		this.voto = voto;
	}
}
