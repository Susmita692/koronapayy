package com.koronapay.entity;

import java.util.Date;
import java.util.List;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
public class Sender {

	@Id
	private long senderId;
	
	private int serialNumber;
	private String firstName;
	private String lastName;
	private String middleOtherName;
	private String phoneNo;
	
	@OneToMany(mappedBy="sender")
	private List<Transfer> transfers;
	
	private Date birthDate;
	private String birthPlace;
	
	@ManyToOne
	@JoinColumn(name="cityId")
	private City city;
	
	private String address;
	
}
