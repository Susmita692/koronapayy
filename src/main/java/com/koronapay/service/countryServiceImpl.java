package com.koronapay.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koronapay.Dao.countryDao;
import com.koronapay.entity.Country;
import com.koronapay.repository.countryRepo;

@Service
public class countryServiceImpl implements countryService {

	
	@Autowired
	private countryRepo countryrepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	@Override
	public countryDao addCountry(countryDao dao) {
		System.out.println(dao);
		Country country=this.modelMapper.map(dao, Country.class);
		Country country_db=this.countryrepo.save(country);
		return this.modelMapper.map(country_db, countryDao.class);
	}

	@Override
	public List<countryDao> getCountries() {
		List<Country> countries=this.countryrepo.findAll();
		List<countryDao> countriesdao=new ArrayList<>();
		for(Country c:countries) 
			countriesdao.add(this.modelMapper.map(c, countryDao.class));
		
		return countriesdao;
	}

	

}
