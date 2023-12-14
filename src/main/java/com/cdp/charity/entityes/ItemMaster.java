package com.cdp.charity.entityes;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
@Table(name = "Item_master")
public class ItemMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id" , unique = true , nullable = false)
	private Integer itemId;
	
	@Column(name = "Name" , nullable = false , length = 100)
	private String itemName;
	
	@Column(name = "Quentity" , nullable = false , length = 200)
	private Integer itemQuentity;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "typeId")
	private TypyMaster typyMaster;
	
	@ManyToMany(mappedBy = "itemMasters")
	private List<DonationMaster> donationMasters;
}
