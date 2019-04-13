package com.services.banking.model;

import org.springframework.data.domain.Page;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SearchAccountTransactionResponse {

	@JsonProperty(value="Transactions")
	private Page<TransactionDTO> transactions;

	public Page<TransactionDTO> getTransactions() {
		return transactions;
	}

	public SearchAccountTransactionResponse(Page<TransactionDTO> transactions) {
		super();
		this.transactions = transactions;
	}

	public void setTransactions(Page<TransactionDTO> transactions) {
		this.transactions = transactions;
	}
	

}
