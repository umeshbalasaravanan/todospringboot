package com.chitrabala.ordermanagement.orders;

import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
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
	public List<Customer> getCurrentCustomers(){
		List<Customer> customers =  customerJpaRepository.findAll();
//		List<Customer> filteredCustomers = new ArrayList<Customer>();
//		for(Customer customer: customers) {
//			if((sdf.format(customer.getOrder().getOrder_date()).compareTo(sdf.format(new Date())) <= 0 && 
//					(sdf.format(customer.getOrder().getDelivery_date()).compareTo(sdf.format(new Date())) >= 0)) ||
//					((sdf.format(customer.getOrder().getDelivery_date()).compareTo(sdf.format(new Date())) <= 0) && 
//					(!customer.getOrder().isCompleted() || customer.getOrder().getRemaining_amount() > Long.valueOf(0)))
//					) {
//				filteredCustomers.add(customer);
//			}
//		}
			
			Predicate<Customer> currentCustomers = customer -> ((sdf.format(customer.getOrder().getOrder_date()).compareTo(sdf.format(new Date())) <= 0 && 
					(sdf.format(customer.getOrder().getDelivery_date()).compareTo(sdf.format(new Date())) >= 0)) ||
					((sdf.format(customer.getOrder().getDelivery_date()).compareTo(sdf.format(new Date())) <= 0) && 
					(!customer.getOrder().isCompleted() || customer.getOrder().getRemaining_amount() > Long.valueOf(0))));
	
		var filteredCustomers = customers.stream().filter(currentCustomers).collect((Collectors.toList()));
		
		return filteredCustomers;
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
