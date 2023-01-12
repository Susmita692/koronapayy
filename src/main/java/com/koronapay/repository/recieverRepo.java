package com.koronapay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.koronapay.entity.Beneficiary;
import com.koronapay.entity.Transfer;

public interface recieverRepo  extends JpaRepository<Beneficiary,Integer>{

}
