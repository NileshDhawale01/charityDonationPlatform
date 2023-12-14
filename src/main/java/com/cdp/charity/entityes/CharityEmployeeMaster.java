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
@Table(name = "Employee_master")
public class CharityEmployeeMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id" , unique = true, nullable = false)
	private Integer employeeId;
	
	@Column(name = "Name" , nullable = false , length = 50)
	private String employeeName;
	
	@Column(name = "Password" , nullable = false , length = 200)
	private String employeePassword;
	
	@Column(name = "Stutus" , nullable = false , length = 50)
	private String employeeStatus;
	
	@Column(name = "Emial" , nullable = false , length = 100)
	private String employeeEmail;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "createdBy" , nullable = false)
	private AdminMaster adminMaster;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DonationBoxId")
	private DonationBoxMaster boxMaster;
	
	@OneToMany(mappedBy = "charityEmployeeMaster")
	private List<DonationMaster> donationMasters;
}
