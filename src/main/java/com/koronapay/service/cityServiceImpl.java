package com.koronapay.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koronapay.Dao.cityDao;
import com.koronapay.entity.City;
import com.koronapay.entity.Country;
import com.koronapay.exception.*;
import com.koronapay.repository.cityRepo;
import com.koronapay.repository.countryRepo;

@Service
public class cityServiceImpl implements cityService {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private cityRepo cityrepo;
	
	@Autowired
	private countryRepo countryrepo;
	
	@Override
	public cityDao addCity(cityDao dao,String code) {
		City city=this.modelMapper.map(dao, City.class);
		//Country country=this.countryrepo.findByCode(code).orElseThrow(()-> new ResourceNotFoundException("country","countryISO",code));
		Country country=this.countryrepo.findByCode(code);//.orElseThrow(()-> new ResourceNotFoundException("Country","Code",code));
		System.out.println(country);
		city.setCountry(country);
		System.out.println(city);
		City savedCity=this.cityrepo.save(city);
		return this.modelMapper.map(savedCity, cityDao.class);
	}

	@Override
	public List<cityDao> getCitiesByCountryISO(String countryISO) {
		Country country=this.countryrepo.findByCode(countryISO);
		List<City> cities=this.cityrepo.findByCountry(country);
		List<cityDao> citiesdao=new ArrayList<>();
		for(City c:cities)
			citiesdao.add(this.modelMapper.map(c, cityDao.class));
		return citiesdao;
	}

}
