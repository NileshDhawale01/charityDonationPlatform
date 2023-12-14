package com.cdp.charity.entityes;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "DonationBox_master")
public class DonationBoxMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id" , unique = true , nullable = false)
	private Integer boxId;
	
	@Column(name = "Name" , nullable = false , length = 50)
	private String boxName;
	
	@Column(name = "Stutus" , length = 50)
	private String boxStatus;
	
	@Column(name = "Location" , nullable = false , length = 200)
	private String boxLocation;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CreatedBy" , nullable = false)
	private AdminMaster adminMaster;
	
	@OneToMany(mappedBy = "boxMaster")
	private List<CharityEmployeeMaster> charityEmployeeMasters;
}
