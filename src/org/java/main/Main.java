package org.java.main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import org.java.events.Event;

public class Main {
	public static void main(String[] args) {
	
//		try {
//			Event evento = new Event("Concerto", LocalDate.of(2023, 5, 18), 100);
//			System.out.println("Evento creato con successo: " + evento.toString());
//			System.out.println("-------------------------------------------------");
//			
//			
//			try {
//				evento.prenotaTavolo(LocalDate.of(2023, 05, 20), 3);	
//				System.out.println("Prenotazione effettuata: " + evento.toString());
//			} catch(Exception e) {
//				System.out.println("Si è verificato un errore durante la prenotazione: " + e.getMessage());
//			}
//			
//			try {
//				evento.disdiciTavolo(LocalDate.of(2023, 05, 20));	
//				System.out.println("Prenotazione effettuata: " + evento.toString());
//			} catch(Exception e) {
//				System.out.println("Si è verificato un errore durante la disdetta: " + e.getMessage());
//			}
//			
//			
//		} catch (Exception e) {
//			System.out.println("Si è verificato un errore durante la creazione dell'evento: " + e.getMessage());
//		}
		System.out.println("Inserisci un nuovo evento.");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Inserisci il titolo dell'evento");
		String titolo = sc.next();
		
		System.out.println("Inserisci la data dell'evento");
		String data = sc.next();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate formattedDate = LocalDate.parse(data, formatter);
		
		System.out.println("Inserisci il numero dei posti dell'evento");
		int posti = sc.nextInt();
		
		try {
			Event evento = new Event(titolo, formattedDate, posti);
			System.out.println("Evento creato con successo: " + evento.toString());
			System.out.println("-------------------------------------------------");
			
			while(true) {
				
				System.out.println("Digita: \n1 se vuoi effettuare una prenotazione,\n2 se vuoi effettuare una disdetta ,\n3 se vuoi uscire");
				int userChoise = sc.nextInt();
				
				if(userChoise < 1 | userChoise > 3) {
					System.out.println("Il valore inserito non è valido. \nDigita: \\n1 se vuoi effettuare una prenotazione,\\n2 se vuoi effettuare una disdetta ,\\n3 se vuoi uscire");
				}
				
				if(userChoise == 1) {
					System.out.println("Digita la data dell'evento a cui vuoi partecipare");
					String userData = sc.next();
					DateTimeFormatter dataformat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					LocalDate dataPrenotazione = LocalDate.parse(userData, dataformat);
					
					System.out.println("Quanti posti vuoi prenotare?");
					int postiPrenotati = sc.nextInt();
					try {
						evento.prenotaTavolo(dataPrenotazione, postiPrenotati);	
						System.out.println("Prenotazione effettuata con successo");
					} catch(Exception e) {
						System.out.println("Si è verificato un errore durante la prenotazione: " + e.getMessage());
					}
					
					
				} else if(userChoise == 2) {
					
					System.out.println("Digita la data dell'evento a cui vuoi disdire");
					String userData = sc.next();
					DateTimeFormatter dataformat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					LocalDate dataPrenotazione = LocalDate.parse(userData, dataformat);
					
					System.out.println("Quanti posti vuoi disdire?");
					int postiPrenotati = sc.nextInt();
					try {
						evento.disdiciTavolo(dataPrenotazione, postiPrenotati);	
						System.out.println("Disdetta effettuata con successo");
					} catch(Exception e) {
						System.out.println("Si è verificato un errore durante la disdetta: " + e.getMessage());
					}
					
				}else if(userChoise == 3) {
					System.out.println("Arrivederci");
					break;
				}
			}
			 System.out.println("Informazioni evento: " + evento.toString());
			
			
			
		} catch (Exception e) {
			System.out.println("Si è verificato un errore durante la creazione dell'evento: " + e.getMessage());
		}
		
		
		
		sc.close();
		
	}

}
