package ubermain.model;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Ridedetails {
	public String rideid;
	public String name;
	public String fromplace;
	public String toplace;
	public String longtitude;
	public String latitude;
	public String status="requested";
	public String cost;
	

}
