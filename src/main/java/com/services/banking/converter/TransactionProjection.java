package com.services.banking.converter;

import java.math.BigDecimal;
import java.time.ZonedDateTime;


public interface TransactionProjection {
	
	Account getAccount();
	
	interface Account{
		Long getAccountId();
		String getAccountName();
	}
	

	String getTransactionType();
	
	BigDecimal getCreditAmount();
	
	BigDecimal getDebitAmount();	
	
	
	Currency getCurrency();

    interface Currency {

        String getCurrencyCode();
    }   
   
    
    ZonedDateTime getTransactionDate();  
    
    String getTransactionDescription();


}
