package org.java.main;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import org.java.events.Concert;

public class Main {
	public static void main(String[] args) {
		
		
//		try {
//			Concert concerto = new Concert("concerto1", LocalDate.of(2023, 5, 18), 100, LocalTime.of(12,20), BigDecimal.valueOf(34.28));
//			System.out.println("Concerto: " + concerto.toString());
//			System.out.println("- - - - - - - - - - - ");
//		} catch (Exception e) {
//			System.err.println("Errore nella creazione del concerto: " + e.getMessage());
//		}
	
		System.out.println("Inserisci un nuovo evento.");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Inserisci il titolo dell'evento");
		String titolo = sc.next();
		
		System.out.println("Inserisci la data dell'evento: (dd/mm/yyyy)");
		String data = sc.next();
		LocalDate formatted = formatDate(data);
		
		System.out.println("Inserisci il numero dei posti dell'evento");
		int posti = sc.nextInt();
		
		System.out.println("Inserisci l'ora del concerto (HH:mm)");
		String ora = sc.next();
		LocalTime oraFormattata = formatHour(ora);
		
		System.out.println("Inserisci il prezzo (00.00)");
		String prezzo = sc.next();
		BigDecimal prezzoFormattato = formatPrice(prezzo);
		
		try {
			Concert evento = new Concert(titolo, formatted, posti,oraFormattata ,prezzoFormattato );
			System.out.println("Evento creato con successo: " + evento.toString());
			System.out.println("-------------------------------------------------");
			
			while(true) {
				
				System.out.println("Digita: \n1 se vuoi effettuare una prenotazione,\n2 se vuoi effettuare una disdetta ,\n3 se vuoi uscire");
				int userChoise = sc.nextInt();
				
				if(userChoise < 1 | userChoise > 3) {
					System.out.println("Il valore inserito non è valido.");
				}
				
				if(userChoise == 1) {
					System.out.println("Digita la data dell'evento a cui vuoi partecipare: (dd/mm/yyyy)");
					String userData = sc.next();
					LocalDate dataPrenotazione = formatDate(userData);
					
					
					System.out.println("Quanti posti vuoi prenotare?");
					int postiPrenotati = sc.nextInt();
					try {
						evento.prenotaTavolo(dataPrenotazione, postiPrenotati);	
						System.out.println("Prenotazione effettuata con successo");
					} catch(Exception e) {
						System.err.println("Si è verificato un errore durante la prenotazione: " + e.getMessage());
					}
					
					
				} else if(userChoise == 2) {
					
					System.out.println("Digita la data dell'evento a cui vuoi disdire");
					String userData = sc.next();
					LocalDate dataPrenotazione = formatDate(userData);
					
					System.out.println("Quanti posti vuoi disdire?");
					int postiPrenotati = sc.nextInt();
					try {
						evento.disdiciTavolo(dataPrenotazione, postiPrenotati);	
						System.out.println("Disdetta effettuata con successo");
					} catch(Exception e) {
						System.err.println("Si è verificato un errore durante la disdetta: " + e.getMessage());
					}
					
				}else if(userChoise == 3) {
					System.out.println("Arrivederci");
					break;
				}
			}
			 System.out.println("Informazioni evento: " + evento.toString());
			
			
			
		} catch (Exception e) {
			System.err.println("Si è verificato un errore durante la creazione dell'evento: " + e.getMessage());
		}
		
		
		sc.close();
		
	}
	
	public static LocalDate formatDate(String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate formattedDate = LocalDate.parse(date, formatter);
		
		return formattedDate;
	}
	
	public static LocalTime formatHour(String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
		LocalTime formattedHour = LocalTime.parse(date, formatter);
		
		return formattedHour;
	}
	public static BigDecimal formatPrice(String price) {
		BigDecimal valoreBigDecimal = new BigDecimal(price);
		return valoreBigDecimal;
	}

}
