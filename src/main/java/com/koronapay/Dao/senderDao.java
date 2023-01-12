package com.koronapay.Dao;

import java.util.Date;
import java.util.List;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class senderDao {

private long senderId;
	
	private int serialNumber;
	private String firstName;
	private String lastName;
	private String middleOtherName;
	private String phoneNo;
	
	
	
	
}
