package com.services.banking.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Transaction implements Serializable{
	
	@Id
	@GeneratedValue
	private Long transactionId;
		
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNT_ID", nullable = false)   
	private Account account;
	
	
	@Column(name = "TRANSACTION_TYPE", length = 10)
	private String transactionType;

	@ManyToOne(targetEntity = Currency.class)
    @Fetch(FetchMode.JOIN)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "CURRENCY_ID")
	private Long currency;
	
	private BigDecimal debitAmount;
	
	private BigDecimal creditAmount;
	
	private ZonedDateTime transactionDate;
	
	
	@Column(name = "TRANSACTION_DESCRIPTION", length = 200)
	private String transactionDescription;
}
