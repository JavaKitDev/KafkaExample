package it.dedagroup.kafka.example.prodAndCons;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
	
	private KafkaTemplate<String, String> kafkaTemplate;
	
	public KafkaProducer(KafkaTemplate<String, String> template) {
		this.kafkaTemplate = template;
	}
	
	public void sendMessage(String message) {
		kafkaTemplate.send("java-order", message);
	}

}
