package kira.flightreservierung.repos;

import kira.flightreservierung.entities.Passagier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassagierRepository extends JpaRepository<Passagier, Long> {

}
