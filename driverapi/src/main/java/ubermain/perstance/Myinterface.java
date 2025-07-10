package ubermain.perstance;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ubermain.model.Ridedetails;

public interface Myinterface extends CrudRepository<Ridedetails, Integer> {
	@Query("from Ridedetails where status = 'requested'")
	List<Ridedetails> allpendingrequest();
	@Query("from Ridedetails where rideid =:ride")
	Ridedetails checking(@Param("ride") String id);



}
