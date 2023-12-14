package com.cdp.charity.entityes;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
@Table(name = "donation_Master")
public class DonationMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id", unique = true, nullable = false)
	private Integer donationId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "collectBy", nullable = false)
	private CharityEmployeeMaster charityEmployeeMaster;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "donateBy", nullable = false)
	private DonatorMaster donatorMaster;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "Items_Donations", joinColumns = {
			@JoinColumn(name = "donationId", nullable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "donatorId", nullable = false) })
	private List<ItemMaster> itemMasters;
}
