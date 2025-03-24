package com.example.ms;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Wish-api")
public class WishMessageOperationController {
	
	
	
    @GetMapping("/display")
    public ResponseEntity<String> wishMessage(){
    	return new ResponseEntity<String>("Welcome to java", HttpStatus.OK);
    }

}
