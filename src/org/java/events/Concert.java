package org.java.events;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concert extends Event{
	
	private String ora;
	private String prezzo;

	public Concert(String titolo, LocalDate data, int numeroPosti, LocalTime ora, BigDecimal prezzo ) throws Exception {
		super(titolo, data, numeroPosti);
		setOra(ora);
		setPrezzo(prezzo);
		
	}

	public String getOra() {
		return ora;
	}
	public void setOra(LocalTime ora) {
		this.ora = formatHour(ora);
	}
	public String getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(BigDecimal prezzo) {
		this.prezzo = formatPrice(prezzo);
	}
	
	public String formatPrice(BigDecimal price) {
        DecimalFormat decimalFormat = new DecimalFormat("##,##€");
        String prezzoFormattato = decimalFormat.format(price);
        return prezzoFormattato;
		
	}
	public String formatHour(LocalTime ora) {
//		LocalTime ora = LocalTime.of(9, 30);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        String oraFormattata = ora.format(formatter);
        return oraFormattata;
	}
	
	@Override
	public String toString() {
		return super.toString()
				+"\nOra: " + getOra()
				+ "\nprezzo: " + getPrezzo();
	} 
	
}
