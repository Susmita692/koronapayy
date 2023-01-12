package com.koronapay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koronapay.Dao.fundsDao;
import com.koronapay.service.fundsService;

@RestController
@RequestMapping("/")
public class fundsController {

	@Autowired
	private fundsService fundsservice;
	
	@PostMapping("addFund")
	public ResponseEntity<fundsDao> addFund(@RequestBody fundsDao dao){
		fundsDao fund=this.fundsservice.addFund(dao);
		return new ResponseEntity<>(fund,HttpStatus.CREATED);
	}
}
