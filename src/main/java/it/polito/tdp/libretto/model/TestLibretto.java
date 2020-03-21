package it.polito.tdp.libretto.model;

import java.util.LinkedList;

public class TestLibretto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Libretto l = new Libretto();

		Voto v1 = new Voto("2020-02-01", "PGP", 22);
		Voto v2 = new Voto("2019-02-09", "Prog. a Oggetti", 25);
		Voto v3 = new Voto("2020-01-18", "Sistemi Telematici", 30);
		Voto v4 = new Voto("2020-01-27", "Analisi 1", 22);
		Voto v5 = new Voto("2019-06-28", "Analisi 2", 22);
		Voto v6 = new Voto("2019-07-07", "Informatica", 19);
		Voto v7 = new Voto("2018-01-28", "TdP", 18);
		Voto v8 = new Voto("2018-02-11", "Geometria", 25);
		Voto v9 = new Voto("2020-02-21", "Sistemi Elettrici", 19);
		Voto v10 = new Voto("2019-09-10", "Chimica", 26);

		l.add(v1);
		l.add(v2);
		l.add(v3);
		l.add(v4);
		l.add(v5);
		l.add(v6);
		l.add(v7);
		l.add(v8);
		l.add(v9);
		l.add(v10);

		System.out.println("Corsi con voto pari a 25:\n");

		for (Voto v : l.getLibretto())
			if (v.getVoto() == 25)
				System.out.println(v.getNomeCorso());

		System.out.println("\nVoto sistemi elettrici: " + l.cercaVoto("Sistemi Elettrici"));

		System.out.println("\nCerco di inserire 19 di sistemi elettrici: ");
		boolean esito = l.votoGiaEsistente("Sistemi Elettrici", 19);
		if (esito == false)
			l.add(new Voto("2020-01-29", "Sistemi Elettrici", 19));
		else
			System.out.println("Voto gia' presente!");

		System.out.println("\nCerco di inserire 27 di sistemi elettrici: ");
		boolean esito2 = l.corsoGiaEsistente("Sistemi Elettrici");
		if (esito2 == false)
			l.add(new Voto("2020-01-29", "Sistemi Elettrici", 27));
		else
			System.out.println("Voto per questo corso gia' presente!");

		System.out.println(
				"\nVoto PGP (/Migliorato)" + ": " + l.cercaVoto("PGP") + " (/" + l.cercaVotoMigliorato("PGP") + ")");

		System.out.println("\nVoto PaO (/Migliorato)" + ": " + l.cercaVoto("Prog. a Oggetti") + " (/"
				+ l.cercaVotoMigliorato("Prog. a Oggetti") + ")");
		
		l.cancellaVoti();

		LinkedList<Voto> vOrdinatiNumero = l.votiOrdinati();
		System.out.println("\n\nVoti Libretto (ordine per Voto)\n");
		for (Voto v : vOrdinatiNumero)
			System.out.println(v.getNomeCorso() + " // " + v.getDataEsame() + " // " + v.getVoto());

		LinkedList<Voto> vOrdinatiNumeroM = l.votiMiglioratiOrdinati();
		System.out.println("\n\n\nVoti Libretto MIGLIORATI (ordine per Voto)\n");
		for (Voto v : vOrdinatiNumeroM)
			System.out.println(v.getNomeCorso() + " // " + v.getDataEsame() + " // " + v.getVoto());

		LinkedList<Voto> cOrdinati = l.corsiOrdinati();
		System.out.println("\n\n\nVoti Libretto (ordine per Corso)\n");
		for (Voto v : cOrdinati)
			System.out.println(v.getNomeCorso() + " // " + v.getDataEsame() + " // " + v.getVoto());

		LinkedList<Voto> cOrdinatiM = l.corsiMiglioratiOrdinati();
		System.out.println("\n\n\nVoti Libretto MIGLIORATI (ordine per Corso)\n");
		for (Voto v : cOrdinatiM)
			System.out.println(v.getNomeCorso() + " // " + v.getDataEsame() + " // " + v.getVoto());
	}

}
