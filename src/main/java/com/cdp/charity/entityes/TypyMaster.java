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
@Table(name = "Type_master")
public class TypyMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id" , unique = true , nullable = false)
	private Integer typeId;
	
	@Column(name = "Name" , nullable = false , length = 150)
	private String typeName;
	
	@OneToMany(mappedBy = "typyMaster")
	private List<ItemMaster> itemMasters;
}
