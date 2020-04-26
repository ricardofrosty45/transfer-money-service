package br.com.transfer.money.service;

import java.util.List;

import br.com.transfer.money.domains.Account;
import br.com.transfer.money.exception.AccountNotCreatedException;

public interface CreateNewBankAccountService {
	
	List<Account> createNewAccounts() throws AccountNotCreatedException;
	
}
