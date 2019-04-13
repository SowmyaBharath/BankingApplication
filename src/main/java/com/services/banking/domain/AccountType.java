package com.services.banking.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class AccountType implements Serializable{
	
	@Id
	@GeneratedValue
	private Long accountTypeId;
	
	@Column(name = "ACCOUNT_TYPE",length = 10)
	private String accountType;

}
