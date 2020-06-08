package kira.flightreservierung.dto;

import lombok.Data;

@Data
public class ReservierungAktualisierenRequest {
	
	private Long id;
	private Boolean checkedIn;
	private int anzahlDerTaschen;


}
