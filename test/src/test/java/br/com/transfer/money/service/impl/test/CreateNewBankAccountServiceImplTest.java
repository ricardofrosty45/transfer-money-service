package br.com.transfer.money.service.impl.test;

import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.transfer.money.domains.Account;
import br.com.transfer.money.exception.AccountNotCreatedException;
import br.com.transfer.money.service.impl.CreateNewBankAccountServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class CreateNewBankAccountServiceImplTest {

	@InjectMocks
	private CreateNewBankAccountServiceImpl serviceImpl;

	@Test(expected = AccountNotCreatedException.class)
	public void cpfIsTheSame() throws AccountNotCreatedException {
		Account accountOne = new Account("Luan Ricardo De Luna", "10821107445", "9802352", 21, "BRL",
				new Random().nextInt(12563), new Random().nextInt(4323), new BigDecimal(100), false);

		Account accountTwo = new Account("Luan Ricardo De Luna", "10821107445", "9802352", 21, "BRL",
				new Random().nextInt(12563), new Random().nextInt(4323), new BigDecimal(100), false);
		List<Account> listOfAccounts = new ArrayList<Account>();

		listOfAccounts.add(accountOne);
		listOfAccounts.add(accountTwo);

		serviceImpl.checkIfCpfIsTheSame(listOfAccounts);
	}

	@Test(expected = AccountNotCreatedException.class)
	public void rgIsTheSame() throws AccountNotCreatedException {

		Account accountOne = new Account("Luan Ricardo De Luna", "10821107445", "9802352", 21, "BRL",
				new Random().nextInt(12563), new Random().nextInt(4323), new BigDecimal(100), false);

		Account accountTwo = new Account("Luan Ricardo De Luna", "10821107445", "9802352", 21, "BRL",
				new Random().nextInt(12563), new Random().nextInt(4323), new BigDecimal(100), false);
		List<Account> listOfAccounts = new ArrayList<Account>();

		listOfAccounts.add(accountOne);
		listOfAccounts.add(accountTwo);

		serviceImpl.checkIfRgIsTheSame(listOfAccounts);

	}

	@Test(expected = AccountNotCreatedException.class)
	public void doesNotHavePermissionToCreateNewAccount() throws AccountNotCreatedException {
		Account accountOne = new Account("Luan Ricardo De Luna", "10821107445", "9802352", 14, "BRL",
				new Random().nextInt(12563), new Random().nextInt(4323), new BigDecimal(100), true, false);

		List<Account> listOfAccounts = new ArrayList<Account>();

		listOfAccounts.add(accountOne);

		serviceImpl.checkIfMinorsCanDoBankAccounts(listOfAccounts);

	}

	@Test
	public void cpfIsNotTheSame() throws AccountNotCreatedException {
		Account accountOne = new Account("Luan Ricardo De Luna", "10821107445", "9802352", 21, "BRL",
				new Random().nextInt(12563), new Random().nextInt(4323), new BigDecimal(100), false);

		Account accountTwo = new Account("Luan Ricardo De Luna", "10821107435", "9802352", 21, "BRL",
				new Random().nextInt(12563), new Random().nextInt(4323), new BigDecimal(100), false);
		List<Account> listOfAccounts = new ArrayList<Account>();

		listOfAccounts.add(accountOne);
		listOfAccounts.add(accountTwo);

		serviceImpl.checkIfCpfIsTheSame(listOfAccounts);
	}

	@Test
	public void rgIsNotTheSame() throws AccountNotCreatedException {

		Account accountOne = new Account("Luan Ricardo De Luna", "10821107445", "8802352", 21, "BRL",
				new Random().nextInt(12563), new Random().nextInt(4323), new BigDecimal(100), false);

		Account accountTwo = new Account("Luan Ricardo De Luna", "10821107445", "9802352", 21, "BRL",
				new Random().nextInt(12563), new Random().nextInt(4323), new BigDecimal(100), false);
		List<Account> listOfAccounts = new ArrayList<Account>();

		listOfAccounts.add(accountOne);
		listOfAccounts.add(accountTwo);

		serviceImpl.checkIfRgIsTheSame(listOfAccounts);

	}

	@Test
	public void youHavePermissionToCreateNewAccount() throws AccountNotCreatedException {
		Account accountOne = new Account("Luan Ricardo De Luna", "10821107445", "9802352", 14, "BRL",
				new Random().nextInt(12563), new Random().nextInt(4323), new BigDecimal(100), true, true);

		List<Account> listOfAccounts = new ArrayList<Account>();

		listOfAccounts.add(accountOne);

		serviceImpl.checkIfMinorsCanDoBankAccounts(listOfAccounts);

	}

	@Test
	public void createNewAccountsSucess() throws AccountNotCreatedException {
		List<Account> created = serviceImpl.createNewAccounts();
		assertNotNull(created);
	}
}
