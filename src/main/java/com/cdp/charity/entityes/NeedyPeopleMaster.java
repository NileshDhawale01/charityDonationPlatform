package com.cdp.charity.entityes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "Needy_people_master")
public class NeedyPeopleMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id" , unique = true , nullable = false)
	private Integer peopleId;
	
	@Column(name = "Name" , nullable = false , length = 50)
	private String peopleName;
	
	@Column(name="Email" , length = 100)
	private String peopleEmail;
	
	@Column(name = "Password" , nullable = false, length = 200)
	private String peoplePassword;
	
	@Column(name = "Members" , length = 50)
	private Integer familyMember;
	
	@Column(name = "Income" , length = 100)
	private Float totalIncome;
	
	@Column(name = "Location" ,length = 200)
	private String location;
	
	@Column(name = "Status" , length = 50)
	private String status;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "aproveBy")
	private AdminMaster adminMaster;
}
