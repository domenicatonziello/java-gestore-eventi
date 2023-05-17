package org.java.events;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Event {
	
	private String titolo;
	private String data;
	private int numeroPosti;
	private int numeroPrenotati;

	
	public Event (String titolo, LocalDate data, int numeroPosti) throws Exception {
		
		setTitolo(titolo);
		setData(data);
		numeroPostiTotali(numeroPosti);
		numeroPrenotati = 0;
		
	}

	public String getTitolo() {
		return titolo;
	}
	protected void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getData() {
		
		return data;
	}
	protected void setData(LocalDate data) throws Exception {
		
		LocalDate nowDate = LocalDate.now();
		
		if(data.isBefore(nowDate)) {			
			throw new Exception("La data è precedente alla data attuale");
		} 
		this.data = formatDate(data);
		
	}
	public int getNumeroPosti() {
		return numeroPosti;
	}
	public int getNumeroPrenotati() {
		return numeroPrenotati;
	}
	
	

	private int postiDisponibili() {
		return getNumeroPosti() - getNumeroPrenotati();
	}
	
	private void numeroPostiTotali (int numeroPosti) throws Exception {
		
		if(numeroPosti < 0) {
			throw new Exception("Il numero di posti totali non può essere inferiore a zero");
		}
		
		this.numeroPosti = numeroPosti;
		
	}
	
	
	public void prenotaTavolo(LocalDate dataEvento, int posti) throws Exception {
		LocalDate today = LocalDate.now();
		if(dataEvento.isBefore(today)) {
			throw new Exception ("L'evento è già passato");
		} 
		
		if(posti <= 0 ) {
			throw new Exception ("Non puoi prenotare meno di 1 posto");
		} 
		if (posti > postiDisponibili()) {
            throw new Exception("L'evento non ha posti disponibili");
        }
					
		setData(dataEvento);
		this.numeroPrenotati += posti;
		postiDisponibili();
		
	}
	
	public void disdiciTavolo (LocalDate dataEvento, int posti) throws Exception {
		LocalDate today = LocalDate.now();
		if(dataEvento.isBefore(today)) {
			throw new Exception ("L'evento è già passato");
		} 
		
		if(getNumeroPrenotati() <= 0 ) {
			throw new Exception ("Non ci sono prenotazioni, non è possibile disdire");
		}
		
		if (posti > getNumeroPrenotati()) {
            throw new Exception("Non è possibile disdire");
        }
		
		setData(dataEvento);
		this.numeroPrenotati -= posti;
		postiDisponibili();
	}
	
	public String formatDate(LocalDate data) {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String formattedDate = data.format(dateTimeFormatter); 
		return formattedDate;
		
	}
	
	@Override
	public String toString() {
		return "data: " + getData()
				+ "\nTitolo: " + getTitolo()
				+ "\nPosti totali: " + getNumeroPosti()
				+ "\nPosti prenotati: " + getNumeroPrenotati()
				+ "\nPosti disponibili: " +postiDisponibili();
	}

	
	
	
	

}
