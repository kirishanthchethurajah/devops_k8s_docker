package kira.flightreservierung.dto;

import lombok.Data;

@Data
public class ReservierungRequest {

	private Long flugId;
	private String passagierVorName;
	private String passagierNachName;
	private String passagierEmail;
	private String passagierTelefon;
	private String nameAufDerKarte;
	private String karteNummer;

	private String ablaufDatum;
	private String sicherheitKode;


}
