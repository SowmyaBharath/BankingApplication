package com.services.banking.service;


import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.services.banking.converter.AccountMapper;
import com.services.banking.converter.AccountProjection;
import com.services.banking.dao.AccountRepository;
import com.services.banking.model.SearchCustomerAccountResponse;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerService{
	
	@Autowired
	AccountRepository accountRespository;

	@Autowired
	AccountMapper accountMapper;	
	

	public SearchCustomerAccountResponse searchAccountsByCustomerId(Long customerId, Pageable pageable) {
        
        Page<AccountProjection> customerAccountPage = Optional.ofNullable(accountRespository.findByCustomerAccountCustomerCustomerId(customerId, pageable)).orElseThrow(EntityNotFoundException::new);
        return new SearchCustomerAccountResponse(accountMapper.map(customerAccountPage));
    }

}
