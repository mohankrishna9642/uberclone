package ubermain.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Ridedetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer id;
	public String rideid;
	public String name;
	public String fromplace;
	public String toplace;
	public String longtitude;
	public String latitude;
	public String status;
	public String cost;
	public String driverid;
	public String drivername;
	public String vechicalnumber;
	public String ratings;
	public String otp;
	
	

}
