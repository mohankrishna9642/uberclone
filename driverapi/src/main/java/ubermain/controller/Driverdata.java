package ubermain.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import ubermain.model.Driverdetails;
import ubermain.model.Drivermodeldata;
import ubermain.model.Ridedetails;
import ubermain.services.Services;

@RestController
public class Driverdata {
	@Autowired
	public Services ss;
	@Autowired
	public RestTemplate resttemplete;
	
	@GetMapping("/pendingrequest")
	public ResponseEntity<List<Ridedetails>> pendingrequest()
	{
		List<Ridedetails>allrides=ss.allpendingrequest();
		return new ResponseEntity<List<Ridedetails>>(allrides,HttpStatus.OK);
	}
	@PostMapping("/register")
	public ResponseEntity<String> driverregister(@RequestBody Drivermodeldata driverdata)
	{
		 Drivermodeldata data=ss.data(driverdata);
		 String gg= "register is sucesssful with id"+data.getDriverid();
		 return new ResponseEntity<String>(gg,HttpStatus.OK);
	}
	@GetMapping("/accept/{raidid}/{driverid}")
	public void raidaccept(@PathVariable("raidid") String id,@PathVariable("driverid") String driverid)
	{
		ss.accepting(id, driverid);
		 
		 
	}
	
}
