package it.dedagroup.kafka.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.dedagroup.kafka.example.payload.User;
import it.dedagroup.kafka.example.prodAndCons.JsonKafkaProducer;
import it.dedagroup.kafka.example.prodAndCons.KafkaProducer;

@RestController
@RequestMapping("/kafka/api")
public class MessageController {

	
	private KafkaProducer kafkaProducer;
	
	private JsonKafkaProducer prod;
	
	public MessageController(KafkaProducer kp) {
		this.kafkaProducer = kp;
	}
	
	
	@GetMapping("/message/{message}")
		public ResponseEntity<String> getMessage(@PathVariable String message){
			kafkaProducer.sendMessage(message);
			return ResponseEntity.ok("Message send to the topic");
		}
	
	@GetMapping("/user")
	public ResponseEntity<String> getUser(@RequestBody User u){
		prod.sendUser(u);
		return ResponseEntity.ok("User send to the topic");
	}
	
}
