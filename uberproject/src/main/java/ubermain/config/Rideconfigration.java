package ubermain.config;

import java.util.HashMap;

import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.web.client.RestTemplate;

import ubermain.model.Driverdetails;
import ubermain.model.Ridedetails;






@Configuration
public class Rideconfigration {
	
	public ConsumerFactory<String,Driverdetails> consumerObject()
	{
		Map<String,Object> dd=new HashMap<String, Object>();
		dd.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		dd.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		dd.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,JsonDeserializer.class);
		dd.put(ConsumerConfig.GROUP_ID_CONFIG, "driver-data1");
	dd.put(JsonDeserializer.TRUSTED_PACKAGES, "ubermain.model");
		

		return new DefaultKafkaConsumerFactory<String, Driverdetails>(dd);
	}
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String,Driverdetails> kafkalisterobj()
	{
		ConcurrentKafkaListenerContainerFactory<String, Driverdetails> bb= new ConcurrentKafkaListenerContainerFactory<String, Driverdetails>();
		 bb.setConsumerFactory(consumerObject());
		 return bb;
	}
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
	

}
