package br.com.transfer.money.service;

import java.util.List;

import br.com.transfer.money.domains.Account;

public interface TransferMoneyService {
	
	void transferMoney(List<Account> accounts);

}
