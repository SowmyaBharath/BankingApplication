package com.services.banking.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Customer implements Serializable{
	
	@Id
	@GeneratedValue
	@Column(name = "CUSTOMER_ID", unique = true, nullable = false)
	private Long customerId;
	
	@Column(name = "CUSTOMER_NAME",length = 30)
	private String customerName;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    private Set<CustomerAccount> customerAccounts = new HashSet<>();	



}
