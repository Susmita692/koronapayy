package com.koronapay.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
public class Refund {

	@Id
	private int refundId;
	
	@OneToOne
	@JoinColumn(name="transferId",referencedColumnName="transferId")
	private Transfer transfer;
	
}
