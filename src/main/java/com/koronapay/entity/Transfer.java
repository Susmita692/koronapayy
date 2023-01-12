package com.koronapay.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Transfer {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int transferId;
	
	private String oid;
	private String countryISO;
	private String payerResident;
	private String cityId;
	private String sendLocationId;
	private String toCurrency;
	private String transferStatus;
	
	@OneToOne
	@JoinColumn(name="fundId",referencedColumnName="fundId")
	private Funds fund;
	
	@ManyToOne
	@JoinColumn(name="senderId")
	private Sender sender;
	
	@ManyToOne
	@JoinColumn(name="recieverId")
	private Beneficiary reciever;
	
	@OneToOne(mappedBy="transfer")
	private Refund refund;
}
