package kira.flightreservierung.Kontroller;

import java.util.List;

import kira.flightreservierung.entities.Passagier;
import kira.flightreservierung.entities.Reservierung;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import kira.flightreservierung.dto.ReservierungRequest;
import kira.flightreservierung.dto.ReservierungAktualisierenRequest;
import kira.flightreservierung.entities.Flug;
import kira.flightreservierung.repos.FlugRepository;
import kira.flightreservierung.repos.PassagierRepository;
import kira.flightreservierung.repos.ReservierungRepository;

@RestController
@CrossOrigin
public class ReservierungRestKontroller {

	private static final Logger LOGGER = LoggerFactory.getLogger(ReservierungRestKontroller.class);

	ReservierungRepository reservierungRepository;

	FlugRepository flugRepository;

	PassagierRepository passagierRepository;

	public ReservierungRestKontroller(ReservierungRepository reservierungRepository, FlugRepository flugRepository, PassagierRepository passagierRepository) {
		this.reservierungRepository = reservierungRepository;
		this.flugRepository = flugRepository;
		this.passagierRepository = passagierRepository;
	}

	@GetMapping("/reservations/{id}")
	public Reservierung erhaltenReservierung(@PathVariable Long id) {
		LOGGER.info("In erhaltenReservierung() for id: " + id);
		return reservierungRepository.findById(id).get();
	}
	
	@GetMapping("/fluge")
	public List<Flug> erhaltenAlleFlug() {
		return flugRepository.findAll();
	}

	@PostMapping("/reservierungen")
	@Transactional
	public Reservierung speichernReservierung(@RequestBody ReservierungRequest request) {
		LOGGER.info("In speichernReservierung()");
		// Make Payment
		Long flightId = request.getFlugId();
		LOGGER.info("holen  flug fur flug id:" + flightId);
		Flug flug = flugRepository.findById(flightId).get();

		Passagier passagier = new Passagier();
		passagier.setVorName(request.getPassagierVorName());
		passagier.setNachName(request.getPassagierNachName());
		passagier.setTelefon(request.getPassagierTelefon());
		passagier.setEmail(request.getPassagierEmail());
		LOGGER.info("passagier speichern:" + passagier);
		Passagier gespeichertPassagier = passagierRepository.save(passagier);

		Reservierung reservierung = new Reservierung();
		reservierung.setFlug(flug);
		reservierung.setPassagier(gespeichertPassagier);
		reservierung.setCheckedIn(false);

		LOGGER.info("Reservierung speichern:" + reservierung);
		Reservierung gespeichertReservierung = reservierungRepository.save(reservierung);
		return gespeichertReservierung;

	}

	@PutMapping("/reservations")
	public Reservierung aktualisierenReservierung(@RequestBody ReservierungAktualisierenRequest request) {
		LOGGER.info("In aktualisierenReservierung() for " + request);
		System.out.println("Inside aktualisierenReservierung() for " + request);
		Reservierung reservierung = reservierungRepository.findById(request.getId()).get();
		reservierung.setAnzahlDerTaschen(request.getAnzahlDerTaschen());
		reservierung.setCheckedIn(request.getCheckedIn());
		LOGGER.info("Reservierung speichern");
		return reservierungRepository.save(reservierung);

	}

}
