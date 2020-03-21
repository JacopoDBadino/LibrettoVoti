package it.polito.tdp.libretto.model;

import java.util.Collections;
import java.util.LinkedList;

public class Libretto {

	LinkedList<Voto> libretto;
	LinkedList<Voto> librettoMigliorato;

	public Libretto() {
		super();
		this.libretto = new LinkedList<Voto>();
		this.librettoMigliorato = new LinkedList<Voto>();
	}

	public void add(Voto v) {
		if (votoGiaEsistente(v.getNomeCorso(), v.getVoto()) == false && corsoGiaEsistente(v.getNomeCorso()) == false) {
			libretto.add(v);
			Voto vM = new Voto(v.getDataEsame(), v.getNomeCorso(), v.getVoto());
			if (v.getVoto() >= 18 && v.getVoto() < 24)
				vM.setVoto(vM.getVoto() + 1);
			if (v.getVoto() >= 24 && v.getVoto() < 29)
				vM.setVoto(vM.getVoto() + 2);
			if (v.getVoto() == 29)
				vM.setVoto(vM.getVoto() + 1);
			librettoMigliorato.add(vM);

		}
	}

	public LinkedList<Voto> getLibretto() {
		return libretto;
	}

	public LinkedList<Voto> getLibrettoMigliorato() {
		return librettoMigliorato;
	}

	public int cercaVoto(String nomeCorso) {
		for (Voto v : libretto)
			if (v.getNomeCorso().equals(nomeCorso))
				return v.getVoto();
		return -1;
	}

	public int cercaVotoMigliorato(String nomeCorso) {
		for (Voto v : librettoMigliorato)
			if (v.getNomeCorso().equals(nomeCorso))
				return v.getVoto();
		return -1;
	}

	public boolean votoGiaEsistente(String nomeCorso, int voto) {
		for (Voto v : libretto)
			if (v.getNomeCorso().equals(nomeCorso) && v.getVoto() == voto)
				return true;
		return false;
	}

	public boolean corsoGiaEsistente(String nomeCorso) {
		for (Voto v : libretto)
			if (v.getNomeCorso().equals(nomeCorso))
				return true;
		return false;
	}

	public LinkedList<Voto> votiOrdinati() {
		LinkedList<Voto> librettoTemp = new LinkedList<Voto>(libretto);
		Collections.sort(librettoTemp, new ComparatorePerVoto());
		return librettoTemp;
	}

	public LinkedList<Voto> votiMiglioratiOrdinati() {
		LinkedList<Voto> librettoTemp = new LinkedList<Voto>(librettoMigliorato);
		Collections.sort(librettoTemp, new ComparatorePerVoto());
		return librettoTemp;
	}

	public LinkedList<Voto> corsiOrdinati() {
		LinkedList<Voto> librettoTemp = new LinkedList<Voto>(libretto);
		Collections.sort(librettoTemp, new ComparatorePerNome());
		return librettoTemp;
	}

	public LinkedList<Voto> corsiMiglioratiOrdinati() {
		LinkedList<Voto> librettoTemp = new LinkedList<Voto>(librettoMigliorato);
		Collections.sort(librettoTemp, new ComparatorePerNome());
		return librettoTemp;
	}

	public void cancellaVoti() {
		LinkedList<Voto> voti1 = new LinkedList<Voto>();
		LinkedList<Voto> voti2 = new LinkedList<Voto>();

		for (Voto v : libretto)
			if (v.getVoto() < 24)
				voti1.add(v);

		for (Voto v : librettoMigliorato)
			if (v.getVoto() < 24)
				voti2.add(v);

		libretto.removeAll(voti1);
		librettoMigliorato.removeAll(voti2);
	}

}
