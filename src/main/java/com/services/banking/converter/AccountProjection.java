package com.services.banking.converter;

import java.math.BigDecimal;
import java.time.ZonedDateTime;


public interface AccountProjection {
	
	Long getAccountId();
	
	String getAccountName();
	
	
	Currency getCurrency();

    interface Currency {

        String getCurrencyCode();
    }
   
    
    AccountType getAccountType();
    
    interface AccountType{
    	String getAccountType();
    }
    
    ZonedDateTime getBalanceDate();  
	
	
	BigDecimal getAccountBalance();


}
