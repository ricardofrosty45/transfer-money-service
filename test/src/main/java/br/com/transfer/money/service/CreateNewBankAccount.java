package br.com.transfer.money.service;

import java.util.List;

import br.com.transfer.money.domains.Account;
import br.com.transfer.money.exception.AccountNotCreatedException;

public interface CreateNewBankAccount {
	
	List<Account> createNewAccounts() throws AccountNotCreatedException;
	
}
