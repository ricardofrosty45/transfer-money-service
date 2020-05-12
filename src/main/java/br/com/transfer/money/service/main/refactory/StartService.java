package br.com.transfer.money.service.main.refactory;

import java.util.List;

import br.com.transfer.money.service.entities.Account;
import br.com.transfer.money.service.exception.ClientNotFoundException;
import br.com.transfer.money.service.exception.TransferErrorException;
import br.com.transfer.money.service.interfaces.IAccountRepository;
import br.com.transfer.money.service.interfaces.TransferMoneyService;
import br.com.transfer.money.service.interfaces.impl.IAccountRepositoryImpl;
import br.com.transfer.money.service.interfaces.impl.TransferMoneyServiceImpl;

public class StartService {
	private static IAccountRepository accountRepository;
	private static TransferMoneyService transferMoneyService;

	public static void main(String[] args) throws TransferErrorException, ClientNotFoundException {
		boolean transfer = transfer();
		System.out.println("Bank transfer done sucessfully");
		System.out.println("Transfer is:" + transfer);
	}

	public static boolean transfer() throws TransferErrorException, ClientNotFoundException {
		accountRepository = new IAccountRepositoryImpl();
		transferMoneyService = new TransferMoneyServiceImpl();
		List<Account> clientsAccounts = accountRepository.getAccountById(1, 2);
		transferMoneyService.transferMoney(clientsAccounts);
		return true;
	}
	public static IAccountRepository getAccountRepository() {
		return accountRepository;
	}

	public static void setAccountRepository(IAccountRepository accountRepository) {
		StartService.accountRepository = accountRepository;
	}

	public static TransferMoneyService getTransferMoneyService() {
		return transferMoneyService;
	}

	public static void setTransferMoneyService(TransferMoneyService transferMoneyService) {
		StartService.transferMoneyService = transferMoneyService;
	}
}
