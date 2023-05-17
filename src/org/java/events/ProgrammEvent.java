package org.java.events;

import java.util.ArrayList;
import java.util.List;

public class ProgrammEvent {
	
	private String titolo;
	private List<Event> eventi;
	
	public ProgrammEvent(String titolo) {
		this.titolo = titolo;
        this.eventi = new ArrayList<>();
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public List<Event> getEventi() {
		return eventi;
	}

	public void setEventi(List<Event> eventi) {
		this.eventi = eventi;
	}
	
	public void aggiungiEvento(Event evento) {
		eventi.add(evento);
	}
	
	public List<Event> getEventiPerData(String data) {
        List<Event> eventiPerData = new ArrayList<>();
        for (Event evento : eventi) {
            if (evento.getData().equals(data)) {
                eventiPerData.add(evento);
            }
        }
        return eventiPerData;
    }
	
	public int getNumeroEventi() {
        return eventi.size();
    }
	public void rimuoviEventi() {
		eventi.clear();
	}
	public String getEventiOrdinati() {
		String list = getTitolo();
		for (Event evento : eventi) {
			String titolo = evento.getTitolo();
			String data = evento.getData();
			list += "\n. " + titolo + " - " + data + "\n";
		}
		return list;		
	}
	
	@Override
	public String toString() {
		return getEventiOrdinati();
	}
	
}
