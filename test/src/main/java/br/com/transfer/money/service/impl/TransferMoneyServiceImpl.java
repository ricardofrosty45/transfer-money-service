package br.com.transfer.money.service.impl;

import java.util.List;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import br.com.transfer.money.domains.Account;
import br.com.transfer.money.service.TransferMoneyService;

public class TransferMoneyServiceImpl implements TransferMoneyService{

	private static final Logger logger = LoggerFactory.getLogger(TransferMoneyServiceImpl.class);
	
	@Override
	public void transferMoney(List<Account> accounts) {
		
		logger.debug("##TransferMoneyService.transferMoney(): Transfering money into created accounts {}",accounts);
		
		
	}

}
