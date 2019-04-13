package com.services.banking.controller;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.services.banking.model.AccountDTO;
import com.services.banking.model.SearchCustomerAccountResponse;
import com.services.banking.service.CustomerService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = CustomerController.class, secure=false)
@ContextConfiguration(classes = {CustomerController.class})
@EnableSpringDataWebSupport
public class CustomerControllerTest {
	
	@Autowired
    private MockMvc mvc;

    @MockBean
    private CustomerService customerService;

    @Test
    public void whenFindByCustomerIdThenStatus200AndReturnFound() throws Exception {
    	
    	
		 Page<AccountDTO> accountPage = buildData();
		  
		  SearchCustomerAccountResponse response = new SearchCustomerAccountResponse(accountPage);	
		  
		  Mockito.when(customerService.searchAccountsByCustomerId(Mockito.anyLong(), Mockito.any())).thenReturn(response);

		  this.mvc.perform(get("/customers/{customerId}/accounts",100)
	                .contentType(MediaType.APPLICATION_JSON_UTF8))
	                .andExpect(status().isOk())
	                .andExpect(jsonPath("$.Accounts.content[0].['Account Name']", is("testAccount")))
	                ;
		  Mockito.verify(customerService, Mockito.times(1)).searchAccountsByCustomerId(Mockito.anyLong(), Mockito.any());
    }
    


	private Page<AccountDTO> buildData() {
    	AccountDTO account = new AccountDTO();
    	account.setAccountName("testAccount");
   	
    	account.setAccountNumber(123L);
		
    	List<AccountDTO> accountDTOList = Collections.singletonList(account);
    	Page<AccountDTO> accountPage = new PageImpl<>(accountDTOList);
    	return accountPage;
    	
    }
 

    
    


}
