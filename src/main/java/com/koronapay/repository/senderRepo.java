package com.koronapay.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.koronapay.entity.Country;
import com.koronapay.entity.Sender;

public interface senderRepo extends JpaRepository<Sender,Long>{

	
}
