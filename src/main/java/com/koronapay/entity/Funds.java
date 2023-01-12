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
public class Funds {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int fundId;
	private double amount;
	private String currency;
	
	@OneToOne(mappedBy="fund")
	private Transfer transfer;
	

}
