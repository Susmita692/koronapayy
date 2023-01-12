package com.koronapay.Dao;

import com.koronapay.entity.Country;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class cityDao {
	
	private String id;
	private String name;
	private String direction;
	private String currency;
	private countryDao country;

}
