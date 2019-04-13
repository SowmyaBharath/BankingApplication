package com.services.banking.converter;


import com.services.banking.converter.AccountProjection.AccountType;
import com.services.banking.converter.AccountProjection.Currency;
import com.services.banking.model.AccountDTO;

import org.springframework.stereotype.Component;

@Component
public class AccountMapperImpl implements AccountMapper {

    @Override
    public AccountDTO map(AccountProjection source) {
        if ( source == null ) {
            return null;
        }

        AccountDTO accountDTO = new AccountDTO();

        accountDTO.setBalanceDate( source.getBalanceDate() );
        accountDTO.setAccountName( source.getAccountName() );
        accountDTO.setAccountType( sourceAccountTypeAccountType( source ) );
        accountDTO.setCurrency( sourceCurrencyCurrencyCode( source ) );
        accountDTO.setAccountNumber( source.getAccountId() );
        accountDTO.setBalanceAmount( source.getAccountBalance() );

        return accountDTO;
    }

    private String sourceAccountTypeAccountType(AccountProjection accountProjection) {
        if ( accountProjection == null ) {
            return null;
        }
        AccountType accountType = accountProjection.getAccountType();
        if ( accountType == null ) {
            return null;
        }
        String accountType1 = accountType.getAccountType();
        if ( accountType1 == null ) {
            return null;
        }
        return accountType1;
    }

    private String sourceCurrencyCurrencyCode(AccountProjection accountProjection) {
        if ( accountProjection == null ) {
            return null;
        }
        Currency currency = accountProjection.getCurrency();
        if ( currency == null ) {
            return null;
        }
        String currencyCode = currency.getCurrencyCode();
        if ( currencyCode == null ) {
            return null;
        }
        return currencyCode;
    }
}
