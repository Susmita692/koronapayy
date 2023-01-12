package com.koronapay.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.koronapay.entity.*;
public interface cityRepo extends JpaRepository<City,Integer>{

	public List<City> findByCountry(Country c);
}
