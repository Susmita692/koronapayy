package com.koronapay.service;

import java.util.List;

import com.koronapay.Dao.cityDao;

public interface cityService {

	cityDao addCity(cityDao dao,String code);
	List<cityDao> getCitiesByCountryISO(String countryISO);
}
