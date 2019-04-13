package com.services.banking.model;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.services.banking.domain.AccountType;
import com.services.banking.domain.Currency;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class AccountDTO {
	
	@JsonProperty(value="Account Number")
	private Long accountNumber;
	
	@JsonProperty(value="Account Name")
	private String accountName;
	
	@JsonProperty(value="Account Type")
	private String accountType;
	
	@JsonProperty(value="Currency")
	private String currency;
	
	@JsonProperty(value = "Opening Account Balance")
	private BigDecimal balanceAmount;
	
	@JsonProperty(value="Balance Date")
	private ZonedDateTime balanceDate;
	
	
	public Long getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}


	public String getAccountName() {
		return accountName;
	}


	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}


	public String getAccountType() {
		return accountType;
	}


	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}


	public String getCurrency() {
		return currency;
	}


	public void setCurrency(String currency) {
		this.currency = currency;
	}


	public BigDecimal getBalanceAmount() {
		return balanceAmount;
	}


	public void setBalanceAmount(BigDecimal balanceAmount) {
		this.balanceAmount = balanceAmount;
	}


	public ZonedDateTime getBalanceDate() {
		return balanceDate;
	}


	public void setBalanceDate(ZonedDateTime balanceDate) {
		this.balanceDate = balanceDate;
	}



}
