package it.polito.tdp.libretto.model;

import java.util.*;

@SuppressWarnings("rawtypes")
public class ComparatorePerVoto implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		Voto v1 = (Voto) o1;
		Voto v2 = (Voto) o2;
		return (v1.getVoto()) - (v2.getVoto());
	}

}
