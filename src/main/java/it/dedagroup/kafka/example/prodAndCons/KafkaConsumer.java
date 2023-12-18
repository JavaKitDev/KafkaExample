package it.dedagroup.kafka.example.prodAndCons;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import it.dedagroup.kafka.example.payload.User;

@Service
public class KafkaConsumer {
	
	@KafkaListener(topics = "java-order", groupId = "myGroup")
	public void consume(User message) {
		System.out.println("ei sono listener");
	}

}
