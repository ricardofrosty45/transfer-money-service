package br.com.transfer.money.service.interfaces;

import java.util.List;

import org.omg.CosNaming.NamingContextPackage.NotFound;

import br.com.transfer.money.service.entities.Account;
import br.com.transfer.money.service.exception.ClientNotFoundException;

public interface IAccountRepository  {

	 List<Account> getAccountById(Integer firstAccountId, Integer secondAccountIdTarget) throws ClientNotFoundException;
}
