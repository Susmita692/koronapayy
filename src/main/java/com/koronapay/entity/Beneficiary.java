package com.koronapay.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Beneficiary {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int recieverId;
	private String lastName;
	private String firstName;
	private String phoneNo;
	
	@OneToMany(mappedBy="reciever")
	private List<Transfer> transfers;
}
