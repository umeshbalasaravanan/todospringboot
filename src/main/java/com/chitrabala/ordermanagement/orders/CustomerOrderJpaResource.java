package com.chitrabala.ordermanagement.orders;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.chitrabala.ordermanagement.entity.Customer;
import com.chitrabala.ordermanagement.orders.repository.CustomerJpaRepository;
import com.chitrabala.ordermanagement.orders.repository.OrderJpaRepository;

@CrossOrigin("http://localhost:4200")
//@CrossOrigin("https://chitrabalafrontend.uk.r.appspot.com")
@RestController
public class CustomerOrderJpaResource {

	@Autowired
	public CustomerJpaRepository customerJpaRepository;
	
	@Autowired
	public OrderJpaRepository orderJpaRepository;
	
	@GetMapping("/helloworld")
	public String getHelloWorld(){
		return "rest api is working fine";
	}
	
	@PostMapping("/chitrabala/addorder")
	public ResponseEntity<Void> addNewOrder(@RequestBody Customer customerData){
		Customer createdCustomer = customerJpaRepository.save(customerData);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(createdCustomer.getCust_id()).toUri();
		return ResponseEntity.created(uri).build(); 
	}
	
	@GetMapping("/chitrabala/getorders")
	public List<Customer> getAllCustomers(){
		return customerJpaRepository.findAll();
	}
	
	@GetMapping("/chitrabala/order/{id}")
	public Customer getCustomerOrder(@PathVariable long id) {
		
		return customerJpaRepository.findById(id).get();
	}
	
	@PutMapping("/chitrabala/order/{id}")
	public ResponseEntity<Customer> updateOrder(@RequestBody Customer customerData,
			@PathVariable long id){
		Customer updatedCustomer = customerJpaRepository.save(customerData);
		return new ResponseEntity<Customer>(updatedCustomer, HttpStatus.OK);
	}
	
	@DeleteMapping("/chitrabala/order/{id}")
	public ResponseEntity<Void> deleteCustomerOrder(@PathVariable long id) {
		
		customerJpaRepository.deleteById(id);
		return ResponseEntity.noContent().build();
		
	}
}
