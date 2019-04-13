package com.services.banking.model;

import org.springframework.data.domain.Page;

import com.fasterxml.jackson.annotation.JsonProperty;


public class SearchCustomerAccountResponse {
		
	public SearchCustomerAccountResponse(Page<AccountDTO> accounts) {
		super();
		this.accounts = accounts;
	}
	
	@JsonProperty(value="Accounts")
	private Page<AccountDTO> accounts;

	public Page<AccountDTO> getAccounts() {
		return accounts;
	}

	public void setAccounts(Page<AccountDTO> accounts) {
		this.accounts = accounts;
	}


}
