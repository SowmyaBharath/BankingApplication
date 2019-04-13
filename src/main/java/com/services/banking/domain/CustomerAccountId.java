package com.services.banking.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class CustomerAccountId implements Serializable{
	
	 	@Column(name = "CUSTOMER_ID", nullable = false)
	    private Long customerId;

	    @Column(name = "ACCOUNT_ID", nullable = false)
	    private Long accountId;

}
