package com.services.banking.converter;

import com.services.banking.converter.TransactionProjection.Account;
import com.services.banking.converter.TransactionProjection.Currency;
import com.services.banking.model.TransactionDTO;

import org.springframework.stereotype.Component;

@Component
public class TransactionMapperImpl implements TransactionMapper {

    @Override
    public TransactionDTO map(TransactionProjection source) {
        if ( source == null ) {
            return null;
        }

        TransactionDTO transactionDTO = new TransactionDTO();

        transactionDTO.setTransactionType( source.getTransactionType() );
        transactionDTO.setAccountName( sourceAccountAccountName( source ) );
        transactionDTO.setTransactionNarrative( source.getTransactionDescription() );
        transactionDTO.setCurrency( sourceCurrencyCurrencyCode( source ) );
        transactionDTO.setDebitAmount( source.getDebitAmount() );
        transactionDTO.setValueDate( source.getTransactionDate() );
        transactionDTO.setAccountNumber( sourceAccountAccountId( source ) );
        transactionDTO.setCreditAmount( source.getCreditAmount() );

        return transactionDTO;
    }

    private String sourceAccountAccountName(TransactionProjection transactionProjection) {
        if ( transactionProjection == null ) {
            return null;
        }
        Account account = transactionProjection.getAccount();
        if ( account == null ) {
            return null;
        }
        String accountName = account.getAccountName();
        if ( accountName == null ) {
            return null;
        }
        return accountName;
    }

    private String sourceCurrencyCurrencyCode(TransactionProjection transactionProjection) {
        if ( transactionProjection == null ) {
            return null;
        }
        Currency currency = transactionProjection.getCurrency();
        if ( currency == null ) {
            return null;
        }
        String currencyCode = currency.getCurrencyCode();
        if ( currencyCode == null ) {
            return null;
        }
        return currencyCode;
    }

    private Long sourceAccountAccountId(TransactionProjection transactionProjection) {
        if ( transactionProjection == null ) {
            return null;
        }
        Account account = transactionProjection.getAccount();
        if ( account == null ) {
            return null;
        }
        Long accountId = account.getAccountId();
        if ( accountId == null ) {
            return null;
        }
        return accountId;
    }
}
