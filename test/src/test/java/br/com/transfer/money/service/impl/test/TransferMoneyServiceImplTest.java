package br.com.transfer.money.service.impl.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.transfer.money.domains.Account;
import br.com.transfer.money.exception.TransferErrorException;
import br.com.transfer.money.service.impl.TransferMoneyServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class TransferMoneyServiceImplTest {

	@InjectMocks
	private TransferMoneyServiceImpl service;

	@Test(expected = TransferErrorException.class)
	public void transferMoneyNoAccounts() throws TransferErrorException {
		service.transferMoney(null);
	}

	@Test(expected = TransferErrorException.class)
	public void transferMoneyNoMoney() throws TransferErrorException {
		Account accountOne = new Account("Luan Ricardo De Luna", "10821107445", "9802352", 21, "BRL",
				new Random().nextInt(12563), new Random().nextInt(4323), BigDecimal.ZERO, false);
		Account accountTwo = new Account("Luan Ricardo De Luna", "10821107445", "9802352", 21, "BRL",
				new Random().nextInt(12563), new Random().nextInt(4323), BigDecimal.TEN, false);
		List<Account> accounts = new ArrayList<Account>();
		accounts.add(accountOne);
		accounts.add(accountTwo);
		service.transferMoney(accounts);
	}
	
	@Test
	public void transferMoneySucess() throws TransferErrorException {
		Account accountOne = new Account("Luan Ricardo De Luna", "10821107445", "9802352", 21, "BRL",
				new Random().nextInt(12563), new Random().nextInt(4323), new BigDecimal(100), false);
		Account accountTwo = new Account("Luan Ricardo De Luna", "10821107445", "9802352", 21, "BRL",
				new Random().nextInt(12563), new Random().nextInt(4323), BigDecimal.TEN, false);
		List<Account> accounts = new ArrayList<Account>();
		accounts.add(accountOne);
		accounts.add(accountTwo);
		service.transferMoney(accounts);
	}

}
