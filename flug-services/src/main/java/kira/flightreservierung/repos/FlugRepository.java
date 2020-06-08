package kira.flightreservierung.repos;

import java.util.Date;
import java.util.List;

import kira.flightreservierung.entities.Flug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FlugRepository extends JpaRepository<Flug, Long> {

	@Query("from Flug where abreiseStadt=:abreiseStadt and ankunftStadt=:ankunftStadt and abreiseDatum=:abreiseDatum")
	List<Flug> findFlights(@Param("abreiseStadt") String from, @Param("ankunftStadt") String to,
						   @Param("abreiseDatum") Date abreiseDatum);

}
