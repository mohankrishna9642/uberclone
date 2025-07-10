package ubermain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Drivermodeldata {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer id;
	public String drivername;
	 public String vechicalnumber;
	 public String driverid;
	 public String ratings;
	 public String status;
	 
	 

}
