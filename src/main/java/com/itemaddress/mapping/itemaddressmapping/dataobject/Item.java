package com.itemaddress.mapping.itemaddressmapping.dataobject;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "item")
@Data
public class Item implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "iterm_Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int itemId;

	@Column(name = "item_Name")
	private String itemName;

	@Column(name = "item_Price")
	private int itemPrice;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_addressid", referencedColumnName = "id")
	private Address address;

}
