package com.koronapay.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.koronapay.entity.*;

public interface fundsRepo extends JpaRepository<Funds,Integer> {

	List<Funds> findByFundId(int id);
}
