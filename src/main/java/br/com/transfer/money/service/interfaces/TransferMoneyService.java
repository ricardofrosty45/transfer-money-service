package br.com.transfer.money.service.interfaces;

import java.util.List;

import br.com.transfer.money.service.entities.Account;
import br.com.transfer.money.service.exception.TransferErrorException;

public interface TransferMoneyService {
	void transferMoney(List<Account> accounts) throws TransferErrorException;
}
