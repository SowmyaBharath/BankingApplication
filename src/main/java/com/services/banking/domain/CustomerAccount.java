package com.services.banking.domain;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Column;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CustomerAccount implements Serializable{
	
	@EmbeddedId
    @AttributeOverrides({ @AttributeOverride(name = "customerId", column = @Column(name = "CUSTOMER_ID", nullable = false) ),
            @AttributeOverride(name = "accountId", column = @Column(name = "ACCOUNT_ID", nullable = false) ) })
    private CustomerAccountId customerAccountId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CUSTOMER_ID", nullable = false, insertable = false, updatable = false)
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNT_ID", nullable = false, insertable = false, updatable = false)
    private Account account;

}
