package com.koronapay.response;

import java.util.Date;
import java.util.List;

import com.koronapay.Dao.fundsDao;
import com.koronapay.entity.City;
import com.koronapay.entity.Funds;
import com.koronapay.entity.Transfer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class tariffResponse {

	private info i;
	private String toCountry;
	private fee feeTotal;
}
