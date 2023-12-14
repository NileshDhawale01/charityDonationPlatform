package com.cdp.charity.entityes;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Donater_master")
public class DonatorMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id" , unique = true , nullable = false)
	private Integer donatorId;
	
	@Column(name = "Name" , unique = true , length = 50)
	private String donatorName;
	
	@OneToMany(mappedBy = "donatorMaster")
	private List<DonationMaster> donationMasters;
	
}
