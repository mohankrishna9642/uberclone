package ubermain.perstance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ubermain.model.Drivermodeldata;

public interface Driverentity extends JpaRepository<Drivermodeldata, Integer> {
	@Query("from Drivermodeldata where driverid=?1")
	Drivermodeldata finding(String id);

}
