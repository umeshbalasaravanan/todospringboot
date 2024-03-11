package com.chitrabala.ordermanagement.twiliosms;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chitrabala.ordermanagement.entity.Customer;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@CrossOrigin("http://localhost:4200")
@RestController
public class Sendsms {
	public static final String ACCOUNT_SID = "AC6a6c5b4aa18ddb7b803124a754321222";
	public static final String AUTH_TOKEN = "65cb87b84c703bd7ba62fd7f64285522";
	
	@PostMapping("/chitrabala/sendsms")
	public ResponseEntity<String> sendMessage(@RequestBody Customer customer) {
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		Message message = Message
				.creator(new PhoneNumber("+918124871482"), 
							new PhoneNumber("+18664412080"), 
							"Good news! Your Garlands are ready delivery. Please pick them up at your earliest convenience.")
				.create();
		System.out.println(message.getSid());
		return new ResponseEntity<String>(message.getSid(), HttpStatus.OK);
	}
}
