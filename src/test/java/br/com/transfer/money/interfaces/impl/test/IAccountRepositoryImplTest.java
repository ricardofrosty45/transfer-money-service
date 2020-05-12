package br.com.transfer.money.interfaces.impl.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.omg.CosNaming.NamingContextPackage.NotFound;

import br.com.transfer.money.service.entities.Account;
import br.com.transfer.money.service.interfaces.impl.IAccountRepositoryImpl;

@RunWith(MockitoJUnitRunner.class)
public class IAccountRepositoryImplTest {

	@InjectMocks
	private IAccountRepositoryImpl repository;

	@Test(expected = NotFound.class)
	public void getAccountsByIdNotFound() throws NotFound {
		 List<Account> accounts = repository.getAccountById(5, 6);
		 assertEquals(accounts, Collections.EMPTY_LIST);
	}

	@Test
	public void getAccountByIdSucess() throws NotFound {
		 List<Account> accounts = repository.getAccountById(1, 2);
		 assertNotNull(accounts);
	}
}
