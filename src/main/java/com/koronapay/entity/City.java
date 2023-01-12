package com.koronapay.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class City {

	@Id
	private String id;
	
	private String name;
	private String direction;
	private String currency;
	
	@ManyToOne
	@JoinColumn(name="countryCode")
	private Country country;
	
	@OneToMany(mappedBy="city")
	private List<Sender> senders;

	

	
}
