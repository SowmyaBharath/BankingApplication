package com.services.banking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.services.banking.model.SearchAccountTransactionResponse;
import com.services.banking.service.AccountService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = {"Accounts"})
@RestController
public class AccountController {
	@Autowired
	private AccountService accountService;

	@ApiOperation(value = "Search Transactions by AccountId")
    @GetMapping(value = "/accounts/{accountId}/transactions")
    @ResponseBody
    public SearchAccountTransactionResponse searchTransactionsByAccountId(@PathVariable("accountId") Long accountId,Pageable pageable) {
    
        return accountService.searchTransactionsByAccountId(accountId,pageable);
    }

}
