package com.koronapay.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class refundResponse {

	private info i;
	private String oid;
	private double amountToBeRefunded;
	private double comission;
}
