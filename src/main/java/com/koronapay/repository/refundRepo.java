package com.koronapay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.koronapay.entity.Beneficiary;
import com.koronapay.entity.Refund;

public interface refundRepo extends JpaRepository<Refund,Integer>{

	
}
