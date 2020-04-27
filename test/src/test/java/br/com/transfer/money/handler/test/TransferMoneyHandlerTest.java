package br.com.transfer.money.handler.test;

import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.transfer.money.domains.Account;
import br.com.transfer.money.exception.AccountNotCreatedException;
import br.com.transfer.money.exception.TransferErrorException;
import br.com.transfer.money.handler.TransferMoneyHandler;
import br.com.transfer.money.service.CreateNewBankAccountService;
import br.com.transfer.money.service.TransferMoneyService;

@RunWith(MockitoJUnitRunner.class)
public class TransferMoneyHandlerTest {

	@InjectMocks
	private TransferMoneyHandler handler;

	@Mock
	private CreateNewBankAccountService createNewAccountService;

	@Mock
	private TransferMoneyService transferMoneyService;

	@Before
	public void createMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test(expected = AccountNotCreatedException.class)
	public void handleRequestAccountsNotCreated() throws AccountNotCreatedException, TransferErrorException {
		when(createNewAccountService.createNewAccounts()).thenThrow(AccountNotCreatedException.class);
		handler.handleRequest();
	}

	@Test
	public void handleRequestSucess() throws AccountNotCreatedException, TransferErrorException {

		Account accountOne = new Account("Luan Ricardo De Luna", "10821107445", "9802352", 21, "BRL",
				new Random().nextInt(12563), new Random().nextInt(4323), new BigDecimal(100), false);
		List<Account> listOfAccounts = new ArrayList<Account>();

		listOfAccounts.add(accountOne);

		when(createNewAccountService.createNewAccounts()).thenReturn(listOfAccounts);
		Mockito.doNothing().when(transferMoneyService).transferMoney(listOfAccounts);

		handler.handleRequest();
	}
	
	@Test(expected = TransferErrorException.class)
	public void handleRequestTransferError() throws AccountNotCreatedException, TransferErrorException {

		Account accountOne = new Account("Luan Ricardo De Luna", "10821107445", "9802352", 21, "BRL",
				new Random().nextInt(12563), new Random().nextInt(4323), new BigDecimal(100), false);
		List<Account> listOfAccounts = new ArrayList<Account>();

		listOfAccounts.add(accountOne);

		when(createNewAccountService.createNewAccounts()).thenReturn(listOfAccounts);
		Mockito.doThrow(TransferErrorException.class).when(transferMoneyService).transferMoney(listOfAccounts);

		handler.handleRequest();
	}

}
