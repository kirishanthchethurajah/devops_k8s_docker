package kira.flightreservierung.entities;

import lombok.Data;

import javax.persistence.Entity;
@Data
@Entity
public class Passagier extends AbstractEntity{
	
	private String vorName;
	private String nachName;
	private String zweiterVorName;
	private String email;
	private String telefon;

}
