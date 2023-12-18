package it.dedagroup.kafka.example.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.dedagroup.kafka.example.payload.User;
import it.dedagroup.kafka.example.prodAndCons.JsonKafkaProducer;

@RestController
@RequestMapping("/kafka/json")
public class JsonController {
	
	private JsonKafkaProducer prod;

	public JsonController(JsonKafkaProducer prod) {
		super();
		this.prod = prod;
	}
	
	@GetMapping("/user")
	public ResponseEntity<String> getUser(@RequestBody User u){
		prod.sendUser(u);
		return ResponseEntity.ok("User send to the topic");
	}
	
	

}
