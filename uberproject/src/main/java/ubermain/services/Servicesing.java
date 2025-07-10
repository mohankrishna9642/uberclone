package ubermain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import ubermain.model.Driverdetails;
import ubermain.model.Ridedetails;

@Service
public class Servicesing {
	@Autowired
	public Ridedetails dd;
	@Autowired
	public KafkaTemplate< String, Object> kafkatemplete;
	
	public String addDataintoKafaka(Ridedetails details)
	{
		System.out.println("the method is started"+details.rideid);
		kafkatemplete.send("uberdata", details);
		return "the data is added sucessfully";
	}
	public String costcalucatle(String from,String to,Integer distance)
	{
		int tax=20;
		Integer totalcost=distance*10+tax;
		System.out.println(totalcost);
		String cost=totalcost.toString();
		dd.setCost(cost);
		return dd.getCost();
	
	}
	@KafkaListener(topics = "driverdata",groupId = "driver-data1",containerFactory = "kafkalisterobj")
	public void data(Driverdetails driver)
	{
		System.out.println("this is the driverdeyails method");
		System.out.println(driver);
	}

}
