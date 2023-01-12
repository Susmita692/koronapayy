package com.koronapay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koronapay.Dao.recieverDao;
import com.koronapay.service.recieverService;

@RestController
@RequestMapping("/")
public class recieverController {

	@Autowired
	private recieverService recieverservice;
	
	
	@PostMapping("addR")
	public ResponseEntity<recieverDao> add(@RequestBody recieverDao dao){
		recieverDao r=this.recieverservice.add(dao);
		return new ResponseEntity<>(r,HttpStatus.CREATED);
	}
}
