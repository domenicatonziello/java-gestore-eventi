package org.java.main;

import java.time.LocalDate;

import org.java.events.Event;

public class Main {
	public static void main(String[] args) {
	
		try {
			Event evento = new Event("Concerto", LocalDate.of(2023, 5, 18), 100);
			System.out.println("Evento creato con successo: " + evento.toString());
			System.out.println("-------------------------------------------------");
			
			
			try {
				evento.prenotaTavolo(LocalDate.of(2023, 05, 20), 3);	
				System.out.println("Prenotazione effettuata: " + evento.toString());
			} catch(Exception e) {
				System.out.println("Si è verificato un errore durante la prenotazione: " + e.getMessage());
			}
			
			try {
				evento.disdiciTavolo(LocalDate.of(2023, 05, 20));	
				System.out.println("Prenotazione effettuata: " + evento.toString());
			} catch(Exception e) {
				System.out.println("Si è verificato un errore durante la disdetta: " + e.getMessage());
			}
			
			
		} catch (Exception e) {
			System.out.println("Si è verificato un errore durante la creazione dell'evento: " + e.getMessage());
		}
		
	}

}
