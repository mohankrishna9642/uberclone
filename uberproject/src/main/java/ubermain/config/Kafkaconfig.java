package ubermain.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;


@Configuration
public class Kafkaconfig {
	
	public ProducerFactory<String ,Object> producerobject()
	{
		Map<String,Object> dd= new HashMap<String, Object>();
		dd.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		dd.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		dd.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,  JsonSerializer.class);
		return new DefaultKafkaProducerFactory<String, Object>(dd);
		
	}
	@Bean
	public KafkaTemplate<String, Object>kafkaobject()
	{
		return new KafkaTemplate<String, Object>(producerobject());
	}

}
