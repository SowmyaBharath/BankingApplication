package com.services.banking.converter;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;

import com.services.banking.model.AccountDTO;

@Mapper(componentModel = "spring")
public interface AccountMapper {	
	

    @Mapping(target = "accountNumber", source = "accountId")
    @Mapping(target = "accountName", source = "accountName")
    @Mapping(target = "accountType", source = "accountType.accountType")
    @Mapping(target = "currency", source = "currency.currencyCode")
    @Mapping(target = "balanceDate", source = "balanceDate")
    @Mapping(target = "balanceAmount", source = "accountBalance")   
    AccountDTO map(AccountProjection source);

    default Page<AccountDTO> map(Page<AccountProjection> page) {
        return page.map(this::map);
    }

}
