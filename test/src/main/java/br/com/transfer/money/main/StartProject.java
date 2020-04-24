package br.com.transfer.money.main;

import java.util.List;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import br.com.transfer.money.domains.Account;
import br.com.transfer.money.exception.AccountNotCreatedException;
import br.com.transfer.money.service.CreateNewBankAccount;
import br.com.transfer.money.service.TransferMoneyService;
import br.com.transfer.money.service.impl.CreateNewBankAccountServiceImpl;
import br.com.transfer.money.service.impl.TransferMoneyServiceImpl;

public class StartProject {

	private static final Logger logger = LoggerFactory.getLogger(StartProject.class);
	private static CreateNewBankAccount createNewAccountService;
	private static TransferMoneyService transferMoneyService;

	public StartProject() {
		this.createNewAccountService = new CreateNewBankAccountServiceImpl();
		this.transferMoneyService = new TransferMoneyServiceImpl();
	}

	public static void main(String[] args) throws AccountNotCreatedException{
		logger.debug("## StartProject.main() - Creating New Bank Accounts {. . .}");
		List<Account> accountsCreated = createNewAccountService.createNewAccounts();		
		logger.debug("## StartProject.main() - AccountsCreated {}",accountsCreated);
		transferMoneyService.transferMoney(accountsCreated);
	

	}

}
