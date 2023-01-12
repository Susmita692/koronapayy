package com.koronapay.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.koronapay.entity.Country;

public interface countryRepo extends JpaRepository<Country,Integer>{

	Country findByCode(String code);
}
