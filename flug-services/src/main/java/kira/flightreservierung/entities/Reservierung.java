package kira.flightreservierung.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
@Data
@Entity
public class Reservierung extends AbstractEntity{
	private Boolean checkedIn;
	private int anzahlDerTaschen;
	@OneToOne
	private Passagier passagier;
	@OneToOne
	private Flug flug;

}
