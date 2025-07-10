package ubermain.model;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Driverdata {
	public String driverid;
	public String drivername;
	public String vechicalname;
	public String ratings;
	public String otp;

}
