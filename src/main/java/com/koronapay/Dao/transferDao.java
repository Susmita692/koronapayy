package com.koronapay.Dao;

import com.koronapay.entity.Beneficiary;
import com.koronapay.entity.Funds;
import com.koronapay.entity.Sender;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class transferDao {

    private int transferId;
	
    private String oid;
	private String countryISO;
	private String payerResident;
	private String cityId;
	private String sendLocationId;
	private String toCurrency;
	

	private fundsDao fund;
	

	private senderDao sender;
	
	
	private recieverDao reciever;

}
