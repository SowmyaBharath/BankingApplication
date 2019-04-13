package com.services.banking.service;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.services.banking.converter.TransactionMapper;
import com.services.banking.converter.TransactionProjection;
import com.services.banking.dao.TransactionRepository;
import com.services.banking.model.SearchAccountTransactionResponse;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AccountService {
	
	@Autowired
	TransactionRepository transactionRepository;

	@Autowired
	TransactionMapper transactionMapper;	
	

	public SearchAccountTransactionResponse searchTransactionsByAccountId(Long accountId, Pageable pageable) {
        
        Page<TransactionProjection> accountTransactions = Optional.ofNullable(transactionRepository.findByAccountAccountId(accountId, pageable)).orElseThrow(EntityNotFoundException :: new);
        SearchAccountTransactionResponse response = new SearchAccountTransactionResponse(transactionMapper.map(accountTransactions));
       
        return response;
    }

}
