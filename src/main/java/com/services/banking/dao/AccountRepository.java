package com.services.banking.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.services.banking.converter.AccountProjection;
import com.services.banking.domain.Account;

@Repository
public interface AccountRepository extends PagingAndSortingRepository<Account,Long>{

	Page<AccountProjection> findByCustomerAccountCustomerCustomerId(Long customerId,Pageable page);

}
