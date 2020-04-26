package br.com.transfer.money.service;

import java.util.List;

import br.com.transfer.money.domains.Account;
import br.com.transfer.money.exception.TransferErrorException;

public interface TransferMoneyService {

	void transferMoney(List<Account> accounts) throws TransferErrorException;

}
