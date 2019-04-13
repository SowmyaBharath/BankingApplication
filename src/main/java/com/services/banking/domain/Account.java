package com.services.banking.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "ACCOUNT")
public class Account implements Serializable{
	
	@Id
	@GeneratedValue
	@Column(name = "ACCOUNT_ID", unique = true, nullable = false)
	private Long accountId;
	
	@Column(name = "ACCOUNT_NAME",length = 30)
	private String accountName;
	
	
	private BigDecimal accountBalance;
	
	@ManyToOne(targetEntity = Currency.class)
    @Fetch(FetchMode.JOIN)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "CURRENCY_ID")
	private Currency currency;
	
	@ManyToOne(targetEntity = AccountType.class)
    @Fetch(FetchMode.JOIN)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "ACCOUNT_TYPE_ID")
	private AccountType accountType;
	
	
	private ZonedDateTime balanceDate;
	
	
	 @OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
	    private Set<CustomerAccount> customerAccount = new HashSet<>(0);
	
	
}
