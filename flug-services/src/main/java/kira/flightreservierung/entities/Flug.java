package kira.flightreservierung.entities;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
@Data
@Entity
public class Flug extends AbstractEntity{
	
	private String flugNummer;
	private String flugBetreiber;
	private String abreiseStadt;
	private String ankunftStadt;
	private Date abreiseDatum;
	private Timestamp voraussichtlicheFahrzeit;

}
