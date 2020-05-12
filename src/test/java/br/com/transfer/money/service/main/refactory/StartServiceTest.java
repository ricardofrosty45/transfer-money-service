package br.com.transfer.money.service.main.refactory;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.omg.CosNaming.NamingContextPackage.NotFound;

import br.com.transfer.money.service.entities.Account;
import br.com.transfer.money.service.exception.ClientNotFoundException;
import br.com.transfer.money.service.exception.TransferErrorException;
import br.com.transfer.money.service.interfaces.IAccountRepository;
import br.com.transfer.money.service.interfaces.TransferMoneyService;

@RunWith(MockitoJUnitRunner.class)
public class StartServiceTest {

	@InjectMocks
	private StartService start;
	
	@Mock
	IAccountRepository accountRepository;
	
	@Mock
	TransferMoneyService transferMoneyService;

	@Test
	public void transferSucessful() throws TransferErrorException, ClientNotFoundException {
		Mockito.when(accountRepository.getAccountById(1,2)).thenReturn(accounts());
		Mockito.doNothing().when(transferMoneyService).transferMoney(accounts());
        boolean transfer = start.transfer();
        assertTrue(transfer);
	}
	
	@Test(expected =  ClientNotFoundException.class)
	public void didntGetAccounts() throws TransferErrorException, ClientNotFoundException {
		List<Account> accounts = accountRepository.getAccountById(5,3);
		assertNotEquals(accounts(),accounts);
		Mockito.verify(start.getAccountRepository().getAccountById(5,3),Mockito.times(1));
	}
	
	
	private List<Account> accounts(){
		List<Account> accounts = new ArrayList<Account>();

		Account accountOne = new Account("Luan Ricardo De Luna", "10821107445", "9802352", 21,
				new Random().nextInt(12563), new Random().nextInt(4323), new BigDecimal(100));

		Account accountTwo = new Account("Ricardo De Luna", "12355423499", "1234567", 27,
				new Random().nextInt(12563), new Random().nextInt(4323), new BigDecimal(100));
		accounts.add(accountOne);
		accounts.add(accountTwo);
		
		return accounts;

		
	}
}
