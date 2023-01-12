package com.koronapay.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koronapay.Dao.*;
import com.koronapay.service.cityService;

@RestController
@RequestMapping("/")
public class cityController {
	
	@Autowired
	private cityService cityservice;

	@PostMapping("/addCity/{code}")
	public ResponseEntity<cityDao> addCity(@RequestBody cityDao dao,@PathVariable String code){
		
		cityDao citydao=this.cityservice.addCity(dao,code);
		return ResponseEntity.ok(citydao);
		
	}
	
	@GetMapping("Cities/{countryISO}")
	public ResponseEntity<List<cityDao>> getCities(@PathVariable String countryISO){
		List<cityDao> cities=this.cityservice.getCitiesByCountryISO(countryISO);
		return ResponseEntity.ok(cities);
		
	}
}
