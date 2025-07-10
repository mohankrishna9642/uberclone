package ubermain.services;




import java.util.List;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import ubermain.model.Driverdetails;
import ubermain.model.Drivermodeldata;
import ubermain.model.Ridedetails;
import ubermain.perstance.Driverentity;
import ubermain.perstance.Myinterface;

@Service
public class Services {
	@Autowired
	public Myinterface repo;
	@Autowired
	public Driverentity driver;
	@Autowired
	public KafkaTemplate< String, Object> template;
	
	@KafkaListener(topics = "uberdata", groupId = "driver-data" ,containerFactory = "kafkalisterobj" )
    public  void kafkadata(Ridedetails obj)
	{
		if(obj!=null)
		{
			Ridedetails ridedata=repo.save(obj);
			System.out.println(ridedata.getId());
			System.out.println(ridedata.getCost());
		}
		else
		{
			throw new IllegalArgumentException("data must not be empty");
		}
	}
	
	public List<Ridedetails>allpendingrequest()
	{
	List<Ridedetails> alldata=repo.allpendingrequest();	
	return alldata;
	}
	public Drivermodeldata data(Drivermodeldata driverdata)
	{
		 Drivermodeldata data=driver.save(driverdata);
		 return data;
	}
	public Ridedetails accepting(String id,String driverid)
	{
		System.out.println("this is the starting of the method");
		System.out.println(id);
		Ridedetails bn=repo.checking(id);
		if(bn.getStatus().equalsIgnoreCase("requested"))
		{
			System.out.println("the user is in request state");
			 Drivermodeldata dd=driver.finding(driverid);
			 if(dd.getStatus().equalsIgnoreCase("online"))
			 {
				 System.out.println("the drver is also on online");
				 bn.setStatus("accepted");
				 bn.setDriverid(dd.getDriverid());
				 bn.setDrivername(dd.getDrivername());
				 bn.setVechicalnumber(dd.getVechicalnumber());
				 bn.setOtp("123456");
				  Ridedetails gh=repo.save(bn);
				 Driverdetails dr= driverdata(dd,bn.getOtp());
				 template.send("driverdata", dr);
				  return gh;
			 }
			 else
			 {
				 return null;
			 }
		}
		else
		{
			System.out.println("the data is null sorry");
			return null;
		}
	}
	public Driverdetails driverdata( Drivermodeldata mm,String op)
	{
		Driverdetails dr= new Driverdetails();
		dr.setDd(mm);
		dr.setOtp(op);
		return dr;
	}
	

}
