package com.koronapay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koronapay.Dao.senderDao;
import com.koronapay.service.senderService;

@RestController
@RequestMapping("/")
public class senderController {

	@Autowired
	private senderService senderservice;
	
	@PostMapping("addSender/")
	public ResponseEntity<senderDao> addSender(@RequestBody senderDao dao){
		
		senderDao sender=this.senderservice.addSender(dao);
		return new ResponseEntity<>(sender,HttpStatus.CREATED);
	}
}
