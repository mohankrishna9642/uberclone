package ubermain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ubermain.model.Driverdata;
import ubermain.model.Driverdetails;
import ubermain.model.Ridedetails;
import ubermain.services.Servicesing;
@RestController
public class Riderequest {
	@Autowired
	public Servicesing service;
	
	@PostMapping("/riderequest")
	public String rideRequest(@RequestBody Ridedetails data)
	{
		return service.addDataintoKafaka(data);
	}
	@GetMapping("/cost/{from}/{to}/{distance}")
	public String calculatecost(@PathVariable("from") String from, @PathVariable("to") String to,@PathVariable("distance") Integer distance)
	{
	 return service.costcalucatle(from, to, distance)	;
	}
	@PostMapping("/driverdata")
	public ResponseEntity<Driverdetails> driverdata(@RequestBody Driverdetails data)
	{
		return new ResponseEntity<Driverdetails>(data,HttpStatus.OK);
	}

}
