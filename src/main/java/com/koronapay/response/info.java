package com.koronapay.response;

import com.koronapay.entity.Beneficiary;
import com.koronapay.entity.Funds;
import com.koronapay.entity.Sender;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class info {

	private String message;
	private String code;
	
}
