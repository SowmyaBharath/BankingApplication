package com.services.banking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.services.banking.model.SearchCustomerAccountResponse;
import com.services.banking.service.CustomerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = {"Customers"})
@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

	@ApiOperation(value = "Search Accounts by CustomerId")
    @GetMapping(value = "/customers/{customerId}/accounts")
    @ResponseBody
    public SearchCustomerAccountResponse searchAccountsByCustomerId(@PathVariable("customerId") Long customerId,Pageable pageable) {
        return customerService.searchAccountsByCustomerId(customerId,pageable);
    }

}
