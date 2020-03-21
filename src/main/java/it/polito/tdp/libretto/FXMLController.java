package it.polito.tdp.libretto;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

import it.polito.tdp.libretto.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	Libretto libretto;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField testoInserito;

	@FXML
	private Button buttIns;

	@FXML
	private Button nuovoLibretto;

	@FXML
	private Button buttSta;

	@FXML
	private Button buttStaM;

	@FXML
	private Button buttOrV;

	@FXML
	private Button buttstaC;

	@FXML
	private TextArea spazioFinale;

	@FXML
	void creaLibretto(ActionEvent event) {
		libretto = new Libretto();
		testoInserito.setEditable(true);
	}

	@FXML
	void inserisciTesto(ActionEvent event) {
		try {
			String testo[] = testoInserito.getText().split(" ");
			libretto.add(new Voto(testo[0], testo[1], Integer.parseInt(testo[2])));
		} catch (Exception e) {
			spazioFinale.appendText("Voto inserito in modo errato, inserire 'AAAA-MM-GG nome_corso voto'\n");
		}

	}

	@FXML
	void sampaOrdineCorso(ActionEvent event) {
		LinkedList<Voto> vOrdinatiNumero = libretto.corsiOrdinati();
		spazioFinale.appendText("\n\nVoti Libretto (ordine per Corso)\n");
		for (Voto v : vOrdinatiNumero)
			spazioFinale.appendText("\n"+v.getNomeCorso() + " // " + v.getDataEsame() + " // " + v.getVoto());
	}

	@FXML
	void stampaMigliorati(ActionEvent event) {
		spazioFinale.appendText("\n\nVoti Libretto (Migliorati)\n");
		for (Voto v : libretto.getLibrettoMigliorato())
			spazioFinale.appendText("\n"+v.getNomeCorso() + " // " + v.getDataEsame() + " // " + v.getVoto());
	}

	@FXML
	void stampaOrdineVoto(ActionEvent event) {
		LinkedList<Voto> vOrdinatiNumero = libretto.votiOrdinati();
		spazioFinale.appendText("\n\nVoti Libretto (ordine per Voto)\n");
		for (Voto v : vOrdinatiNumero)
			spazioFinale.appendText("\n"+v.getNomeCorso() + " // " + v.getDataEsame() + " // " + v.getVoto());
	}

	@FXML
	void stampaVoti(ActionEvent event) {
		spazioFinale.appendText("\n\nVoti Libretto\n");
		for (Voto v : libretto.getLibretto())
			spazioFinale.appendText("\n"+v.getNomeCorso() + " // " + v.getDataEsame() + " // " + v.getVoto());

	}

	@FXML
	void initialize() {
		assert testoInserito != null : "fx:id=\"testoInserito\" was not injected: check your FXML file 'Scene.fxml'.";
		assert buttIns != null : "fx:id=\"buttIns\" was not injected: check your FXML file 'Scene.fxml'.";
		assert nuovoLibretto != null : "fx:id=\"nuovoLibretto\" was not injected: check your FXML file 'Scene.fxml'.";
		assert buttSta != null : "fx:id=\"buttSta\" was not injected: check your FXML file 'Scene.fxml'.";
		assert buttStaM != null : "fx:id=\"buttStaM\" was not injected: check your FXML file 'Scene.fxml'.";
		assert buttOrV != null : "fx:id=\"buttOrV\" was not injected: check your FXML file 'Scene.fxml'.";
		assert buttstaC != null : "fx:id=\"buttstaC\" was not injected: check your FXML file 'Scene.fxml'.";
		assert spazioFinale != null : "fx:id=\"spazioFinale\" was not injected: check your FXML file 'Scene.fxml'.";

	}
}
