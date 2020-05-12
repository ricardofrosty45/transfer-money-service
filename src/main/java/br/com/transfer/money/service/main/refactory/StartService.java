package br.com.transfer.money.service.main.refactory;

import java.util.List;

import org.omg.CosNaming.NamingContextPackage.NotFound;

import br.com.transfer.money.service.entities.Account;
import br.com.transfer.money.service.exception.TransferErrorException;
import br.com.transfer.money.service.interfaces.IAccountRepository;
import br.com.transfer.money.service.interfaces.TransferMoneyService;
import br.com.transfer.money.service.interfaces.impl.IAccountRepositoryImpl;
import br.com.transfer.money.service.interfaces.impl.TransferMoneyServiceImpl;

public class StartService {

	public static void main(String[] args) throws TransferErrorException, NotFound {
		boolean transfer = transfer();
		System.out.println("Bank transfer done sucessfully");
		System.out.println("Transfer is:"+transfer);
	}

	public static boolean transfer() throws TransferErrorException, NotFound {
		IAccountRepository accountRepository = new IAccountRepositoryImpl();
		TransferMoneyService transferMoneyService = new TransferMoneyServiceImpl();
		List<Account> clientsAccounts = accountRepository.getAccountById(1,2);	
		transferMoneyService.transferMoney(clientsAccounts);
		return true;
	}
}
