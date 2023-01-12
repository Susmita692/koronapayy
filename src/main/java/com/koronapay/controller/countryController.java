package com.koronapay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koronapay.Dao.countryDao;
import com.koronapay.service.countryService;

@RestController
@RequestMapping("/")
public class countryController {
	
	@Autowired
	private countryService countryservice;
	
	@PostMapping("add")
	public ResponseEntity<countryDao> addCountry(@RequestBody countryDao doa){
		countryDao country=this.countryservice.addCountry(doa);
		return ResponseEntity.ok(country);
		
	}
	
	@GetMapping("Countries")
	public ResponseEntity<List<countryDao>> getCountries(){
		
		List<countryDao> countries=this.countryservice.getCountries();
		return ResponseEntity.ok(countries);
		
	}

}
