package com.services.banking.controller;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
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

import com.services.banking.model.SearchAccountTransactionResponse;
import com.services.banking.model.TransactionDTO;
import com.services.banking.service.AccountService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = AccountController.class, secure = false)
@ContextConfiguration(classes = { AccountController.class })
@EnableSpringDataWebSupport
public class AccountControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private AccountService accountService;

	@Test
	public void whenFindByCustomerIdThenStatus200AndReturnFound() throws Exception {

		Page<TransactionDTO> transactionPage = buildData();

		SearchAccountTransactionResponse response = new SearchAccountTransactionResponse(transactionPage);

		Mockito.when(accountService.searchTransactionsByAccountId(Mockito.anyLong(), Mockito.any()))
				.thenReturn(response);

		this.mvc.perform(get("/accounts/{accountId}/transactions", 100).contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.Transactions.content[0].['Account Name']", is("testAccount")));
		Mockito.verify(accountService, Mockito.times(1)).searchTransactionsByAccountId(Mockito.anyLong(),
				Mockito.any());
	}

	private Page<TransactionDTO> buildData() {
		TransactionDTO transaction = new TransactionDTO();
		transaction.setAccountName("testAccount");

		transaction.setAccountNumber(123L);

		transaction.setCreditAmount(new BigDecimal("100.00"));

		List<TransactionDTO> accountDTOList = Collections.singletonList(transaction);
		Page<TransactionDTO> accountPage = new PageImpl<>(accountDTOList);
		return accountPage;

	}

}
