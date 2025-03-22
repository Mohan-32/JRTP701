package com.example.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/ssa-web-api")
public class SsaWebOperationController {
	
	@GetMapping("/find/{ssn}")
	public ResponseEntity<String > getStateBySsn(@PathVariable int ssn){
		
		if(String.valueOf(ssn).length() !=9)
			return new ResponseEntity<String>("Invalid ssn", HttpStatus.BAD_REQUEST);
		
		int statecode=ssn%100;
		String stateName=null;
		
		if(statecode == 01)
			stateName="washington Dc";
		else if(statecode == 02)
			stateName="ohio";
		else if(statecode == 03)
			stateName="Texas";
		else if(statecode == 04)
			stateName="california";
		else if(statecode == 05)
			stateName="florida";
		else 
			stateName="invalid ssn";
		return new ResponseEntity<String>(stateName,HttpStatus.OK);
	}

}
