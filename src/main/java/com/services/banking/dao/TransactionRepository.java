package com.services.banking.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.services.banking.converter.TransactionProjection;
import com.services.banking.domain.Transaction;

@Repository
public interface TransactionRepository extends PagingAndSortingRepository<Transaction, Long> {
	
	Page<TransactionProjection> findByAccountAccountId(Long accountId,Pageable page);

}
