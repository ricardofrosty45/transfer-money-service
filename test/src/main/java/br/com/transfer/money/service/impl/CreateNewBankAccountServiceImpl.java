package br.com.transfer.money.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import br.com.transfer.money.domains.Account;
import br.com.transfer.money.enumeration.ErrorsEnum;
import br.com.transfer.money.exception.AccountNotCreatedException;
import br.com.transfer.money.service.CreateNewBankAccount;

public class CreateNewBankAccountServiceImpl implements CreateNewBankAccount {

	private static final Logger logger = LoggerFactory.getLogger(CreateNewBankAccountServiceImpl.class);

	@Override
	public List<Account> createNewAccounts() throws AccountNotCreatedException {
		return prepareClientInformations();
	}

	private List<Account> prepareClientInformations() throws AccountNotCreatedException {
		Account accountOne = new Account("Luan Ricardo De Luna", "10821107445", "9802352", 21, "BRL",
				new Random().nextInt(12563), new Random().nextInt(4323), BigDecimal.TEN, false);

		logger.debug("## CreateNewBankAccountServiceImpl.createNewAccount(): Creating Account Number One {}",
				accountOne);

		Account accountTwo = new Account("Ricardo De Luna", "12355423499", "3234654", 27, "USD",
				new Random().nextInt(12563), new Random().nextInt(4323), BigDecimal.TEN, false);

		logger.debug("## CreateNewBankAccountServiceImpl.createNewAccount(): Creating Account Number Two {}",
				accountOne);

		Account accountThree = new Account("Luan Ricardo De Luna", "12334567845", "2134544", 17, "CAD",
				new Random().nextInt(12563), new Random().nextInt(4323), BigDecimal.TEN, true, true);

		logger.debug("## CreateNewBankAccountServiceImpl.createNewAccount(): Creating Account Number Three {}",
				accountOne);

		Account accountFour = new Account("Mariane Fernanda", "33243233467", "9234123", 29, "BRL",
				new Random().nextInt(12563), new Random().nextInt(4323), BigDecimal.TEN, false);

		logger.debug("## CreateNewBankAccountServiceImpl.createNewAccount(): Creating Account Number Four {}",
				accountOne);

		logger.debug("## CreateNewBankAccountServiceImpl.createNewAccount(): Account Objects Created !! ");

		List<Account> listOfAccounts = new ArrayList<Account>();

		listOfAccounts.add(accountOne);
		listOfAccounts.add(accountTwo);
		listOfAccounts.add(accountThree);
		listOfAccounts.add(accountFour);

		checkIfCpfIsTheSame(listOfAccounts);
		checkIfRgIsTheSame(listOfAccounts);
		checkIfMinorsCanDoBankAccounts(listOfAccounts);

		return listOfAccounts;
	}

	private void checkIfMinorsCanDoBankAccounts(List<Account> listOfAccounts) throws AccountNotCreatedException {
		logger.debug(
				"## CreateNewBankAccountServiceImpl.createNewAccount(): Checking if this person can create an account ");
		for (int i = 0; i < listOfAccounts.size(); i++) {
			Account account = listOfAccounts.get(i);
			if (account.isUnderEightteenYearsOld() && !account.isParentsAuthorization()) {
				logger.error("## CreateNewBankAccountServiceImpl.createNewAccount(): You don't have permission ");
				throw new AccountNotCreatedException(ErrorsEnum.MINOR_DOESNT_HAVE_AUTHORIZATION.getMsg(),
						ErrorsEnum.MINOR_DOESNT_HAVE_AUTHORIZATION.getCampo(),
						ErrorsEnum.MINOR_DOESNT_HAVE_AUTHORIZATION.getCode());
			}
		}
		logger.debug("## CreateNewBankAccountServiceImpl.createNewAccount(): Everything is good! ");

	}

	private void checkIfRgIsTheSame(List<Account> listOfAccounts) throws AccountNotCreatedException {
		List<String> rgs = new ArrayList<String>();
		logger.debug("## CreateNewBankAccountServiceImpl.createNewAccount(): Checking if the RG is the same");
		for (int i = 0; i < listOfAccounts.size(); i++) {

			Account account = listOfAccounts.get(i);
			if (rgs.contains(account.getClientCpf())) {
				logger.error("## CreateNewBankAccountServiceImpl.createNewAccount(): This RG is already registrated ");
				throw new AccountNotCreatedException(ErrorsEnum.SAME_RG.getMsg(), ErrorsEnum.SAME_RG.getCampo(),
						ErrorsEnum.SAME_RG.getCode());
			}
			rgs.add(account.getClientCpf());
		}

		logger.debug("## CreateNewBankAccountServiceImpl.createNewAccount(): Everything is good! ");

	}

	private void checkIfCpfIsTheSame(List<Account> listOfAccounts) throws AccountNotCreatedException {
		List<String> cpfs = new ArrayList<String>();

		for (int i = 0; i < listOfAccounts.size(); i++) {
			logger.debug("## CreateNewBankAccountServiceImpl.createNewAccount(): Checking if it's not the same CPF ");
			Account account = listOfAccounts.get(i);
			if (cpfs.contains(account.getClientCpf())) {
				logger.error("## CreateNewBankAccountServiceImpl.createNewAccount(): CPF is already registrated ");
				throw new AccountNotCreatedException(ErrorsEnum.SAME_CPF.getMsg(), ErrorsEnum.SAME_CPF.getCampo(),
						ErrorsEnum.SAME_CPF.getCode());
			}
			cpfs.add(account.getClientCpf());
		}
		logger.debug("## CreateNewBankAccountServiceImpl.createNewAccount(): Everything is good! ");
	}

}
