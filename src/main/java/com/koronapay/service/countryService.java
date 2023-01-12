package com.koronapay.service;

import java.util.List;

import com.koronapay.Dao.countryDao;

public interface countryService {

	countryDao addCountry(countryDao dao);
	List<countryDao> getCountries();
}
