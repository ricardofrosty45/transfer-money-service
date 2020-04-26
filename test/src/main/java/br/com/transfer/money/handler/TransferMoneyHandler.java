package br.com.transfer.money.handler;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.transfer.money.domains.Account;
import br.com.transfer.money.exception.AccountNotCreatedException;
import br.com.transfer.money.exception.TransferErrorException;
import br.com.transfer.money.service.CreateNewBankAccountService;
import br.com.transfer.money.service.TransferMoneyService;
import br.com.transfer.money.service.impl.CreateNewBankAccountServiceImpl;
import br.com.transfer.money.service.impl.TransferMoneyServiceImpl;

public class TransferMoneyHandler {
	private static final Logger logger = LoggerFactory.getLogger(TransferMoneyHandler.class);

	private CreateNewBankAccountService createNewAccountService;
	private TransferMoneyService transferMoneyService;

	public TransferMoneyHandler() {
		this.createNewAccountService = new CreateNewBankAccountServiceImpl();
		this.transferMoneyService = new TransferMoneyServiceImpl();
	}

	public void handleRequest() throws AccountNotCreatedException, TransferErrorException {
		logger.info("## StartProject.main() - Initializing Service {. . .}");
		List<Account> accountsCreated = createNewAccountService.createNewAccounts();
		logger.info("## StartProject.main() - AccountsCreated {}", accountsCreated);
		transferMoneyService.transferMoney(accountsCreated);
	}
}
