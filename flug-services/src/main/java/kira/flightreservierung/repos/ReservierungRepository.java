package kira.flightreservierung.repos;

import kira.flightreservierung.entities.Reservierung;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservierungRepository extends JpaRepository<Reservierung, Long> {

}
