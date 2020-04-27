package br.com.transfer.money.service.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.transfer.money.domains.Account;
import br.com.transfer.money.enumeration.ErrorsEnum;
import br.com.transfer.money.exception.TransferErrorException;
import br.com.transfer.money.handler.TransferMoneyHandler;
import br.com.transfer.money.service.TransferMoneyService;

public class TransferMoneyServiceImpl implements TransferMoneyService {

	private static final Logger logger = LoggerFactory.getLogger(TransferMoneyHandler.class);

	@Override
	public void transferMoney(List<Account> accounts) throws TransferErrorException {
		if (accounts == null) {
			throw new TransferErrorException(ErrorsEnum.ANY_REGISTRED_ACCOUNTS.getMsg(),
					ErrorsEnum.ANY_REGISTRED_ACCOUNTS.getCampo(), ErrorsEnum.ANY_REGISTRED_ACCOUNTS.getCode());
		}

		logger.info("##TransferMoneyService.transferMoney(): Transfering money into created accounts {}", accounts);
		ListIterator<Account> it = accounts.listIterator();

		while (it.hasNext()) {

			Account to = it.next();
			if (!it.hasNext()) {
				logger.info("##TransferMoneyService.transferMoney(): Money transfered into accounts {}", accounts);
				break;
			}
			it.next();
			Account from = it.previous();

			if (!transfer(to, from, new BigDecimal(BigInteger.valueOf(new Random().nextInt(100)), 0))) {
				throw new TransferErrorException(ErrorsEnum.INSUFFICIENT_BANK_BALANCE.getMsg(),
						ErrorsEnum.INSUFFICIENT_BANK_BALANCE.getCampo(),
						ErrorsEnum.INSUFFICIENT_BANK_BALANCE.getCode());
			}

		}

	}

	private boolean transfer(Account from, Account to, BigDecimal value) throws TransferErrorException {
		if (value.compareTo(from.getNewBalance()) == 1) {
			return false;
		}
		BigDecimal newBalance;
		newBalance = from.getNewBalance().subtract(value);
		logger.info("##TransferMoneyService.transferMoney():" + from.getClientName() + " New Balance {}",
				from.getNewBalance());
		from.setNewBalance(newBalance);
		to.setNewBalance(to.getNewBalance().add(value));
		logger.info(
				"##TransferMoneyService.transferMoney(): Money Transfered To " + to.getClientName() + " New Balance {}",
				to.getNewBalance());
		return true;

	}
}
