package com.services.banking.converter;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;

import com.services.banking.model.TransactionDTO;

@Mapper(componentModel = "spring")
public interface TransactionMapper {
	

    @Mapping(target = "accountNumber", source = "account.accountId")
    @Mapping(target = "accountName", source = "account.accountName")
    @Mapping(target = "transactionType", source = "transactionType")
    @Mapping(target = "currency", source = "currency.currencyCode")
    @Mapping(target = "creditAmount", source = "creditAmount")
    @Mapping(target = "debitAmount", source = "debitAmount") 
    @Mapping(target = "valueDate", source = "transactionDate")
    @Mapping(target = "transactionNarrative", source = "transactionDescription")
    TransactionDTO map(TransactionProjection source);

    default Page<TransactionDTO> map(Page<TransactionProjection> page) {
        return page.map(this::map);
    }


}
