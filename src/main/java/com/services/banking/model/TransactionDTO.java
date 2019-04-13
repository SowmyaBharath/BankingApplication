package com.services.banking.model;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

public class TransactionDTO {
	
	@JsonProperty(value="Account Number")
	Long accountNumber;
	
	@JsonProperty(value="Account Name")
	String accountName;
	
	@JsonProperty(value="Value Date")
	ZonedDateTime valueDate;
	
	@JsonProperty(value="Currency")
	String currency;
	
	@JsonProperty(value="Debit Amount")
	BigDecimal debitAmount;
	
	@JsonProperty(value="Credit Amount")
	BigDecimal creditAmount;
	
	@JsonProperty(value="Debit/Credit")
	String transactionType;
	
	@JsonProperty(value="Transaction Narrative")
	String transactionNarrative;

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

	public ZonedDateTime getValueDate() {
		return valueDate;
	}

	public void setValueDate(ZonedDateTime valueDate) {
		this.valueDate = valueDate;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public BigDecimal getDebitAmount() {
		return debitAmount;
	}

	public void setDebitAmount(BigDecimal debitAmount) {
		this.debitAmount = debitAmount;
	}

	public BigDecimal getCreditAmount() {
		return creditAmount;
	}

	public void setCreditAmount(BigDecimal creditAmount) {
		this.creditAmount = creditAmount;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getTransactionNarrative() {
		return transactionNarrative;
	}

	public void setTransactionNarrative(String transactionNarrative) {
		this.transactionNarrative = transactionNarrative;
	}
	

}
