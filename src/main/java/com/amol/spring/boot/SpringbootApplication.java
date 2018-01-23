package com.amol.spring.boot;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.amol.spring.data.jpa.entity.Address;
import com.amol.spring.data.jpa.repository.UserRepository;

@SpringBootApplication (scanBasePackages = "com.amol.spring")
public class SpringbootApplication {

	public static void main(String[] args) {
		ApplicationContext appContext = SpringApplication.run(SpringbootApplication.class, args);
		
		UserRepository userRepository = (UserRepository) appContext.getBean(UserRepository.class);
		
		com.amol.spring.data.jpa.entity.User userEntity = new com.amol.spring.data.jpa.entity.User();
		userEntity.setName("AMOL");
		
		Address addressEntity = new Address();
		addressEntity.setAddressLine1("addressLine1");
		addressEntity.setAddressLine2("addressLine2");
		addressEntity.setPostCode("AB1 2CD");
		//addressEntity.setUser(userEntity);
		
		Address addressEntity2 = new Address();
		addressEntity2.setAddressLine1("addressLine1");
		addressEntity2.setAddressLine2("addressLine2");
		addressEntity2.setPostCode("AB1 2CD");
		//addressEntity2.setUser(userEntity);
		//object references an unsaved transient instance - save the transient instance before flushing: 
		//com.amol.spring.data.jpa.entity.Address
		// FIX- CascadeType.ALL
	
		//addressRepository.save(addressEntity);
		
		Set<Address> addresses = new HashSet<Address>();
		addresses.add(addressEntity);
		addresses.add(addressEntity2);
		userEntity.setAddresses(addresses);
		
		//userEntity.setAddress(addressEntity);
		userRepository.save(userEntity);
		//addressRepository.save(addressEntity);
		
		
		

	}
}
