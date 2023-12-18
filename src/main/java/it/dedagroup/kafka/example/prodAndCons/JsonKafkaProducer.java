package it.dedagroup.kafka.example.prodAndCons;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import it.dedagroup.kafka.example.payload.User;

@Service
public class JsonKafkaProducer {
	
	private KafkaTemplate<String, User> template;

	public JsonKafkaProducer(KafkaTemplate<String, User> template) {
		super();
		this.template = template;
	}
	
	public void sendUser(User u) {
		Message<User> message = MessageBuilder
				.withPayload(u)
				.setHeader(KafkaHeaders.TOPIC, "java-order")
				.build();
		template.send(message);
	}

}
