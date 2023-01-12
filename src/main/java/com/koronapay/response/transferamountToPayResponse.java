package com.koronapay.response;

import com.koronapay.Dao.fundsDao;
import com.koronapay.Dao.transferDao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class transferamountToPayResponse {

	private info i;
	private fundsDao sendFunds;
	private transferDao transfer;
	
}
