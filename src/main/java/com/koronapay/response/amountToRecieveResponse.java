package com.koronapay.response;

import com.koronapay.Dao.fundsDao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class amountToRecieveResponse {

	private info i;
	private String toCountryISO;
	private fee feeTotal;
	private String exchangeRate;
	private fundsDao fund;
	private payFunds payfunds;
}
