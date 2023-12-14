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
@Table(name = "admin_master")
public class AdminMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id", unique = true, nullable = false)
	private Integer adminId;

	@Column(name = "Name", nullable = false, length = 50)
	private String adminName;

	@Column(name = "Email", nullable = false, length = 100)
	private String adminEmail;

	@Column(name = "password", nullable = false, length = 200)
	private String adminPassword;

	@OneToMany(mappedBy = "adminMaster")
	private List<NeedyPeopleMaster> needyPeopleMasters;

	@OneToMany(mappedBy = "adminMaster")
	private List<DonationBoxMaster> boxMasters;

	@OneToMany(mappedBy = "adminMaster")
	private List<CharityEmployeeMaster> charityEmployeeMasters;
}
