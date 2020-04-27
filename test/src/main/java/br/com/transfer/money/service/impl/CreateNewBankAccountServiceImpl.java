package br.com.transfer.money.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import br.com.transfer.money.domains.Account;
import br.com.transfer.money.enumeration.ErrorsEnum;
import br.com.transfer.money.exception.AccountNotCreatedException;
import br.com.transfer.money.main.StartProject;
import br.com.transfer.money.service.CreateNewBankAccountService;

public class CreateNewBankAccountServiceImpl implements CreateNewBankAccountService {

	private static final Logger logger = LoggerFactory.getLogger(StartProject.class);

	@Override
	public List<Account> createNewAccounts() throws AccountNotCreatedException {
		return prepareClientInformations();
	}

	private List<Account> prepareClientInformations() throws AccountNotCreatedException {
		Account accountOne = new Account("Luan Ricardo De Luna", "10821107445", "9802352", 21, "BRL",
				new Random().nextInt(12563), new Random().nextInt(4323), new BigDecimal(100), false);

		logger.info("## CreateNewBankAccountServiceImpl.createNewAccount(): Creating Account Number One {}",
				accountOne);

		Account accountTwo = new Account("Ricardo De Luna", "12355423499", "1234567", 27, "USD",
				new Random().nextInt(12563), new Random().nextInt(4323), new BigDecimal(100), false);

		logger.info("## CreateNewBankAccountServiceImpl.createNewAccount(): Creating Account Number Two {}",
				accountOne);

		Account accountThree = new Account("Luan Ricardo De Luna", "12334567845", "2134544", 17, "CAD",
				new Random().nextInt(12563), new Random().nextInt(4323), new BigDecimal(100), true, true);

		logger.info("## CreateNewBankAccountServiceImpl.createNewAccount(): Creating Account Number Three {}",
				accountOne);

		Account accountFour = new Account("Mariane Fernanda", "33243233467", "9234123", 29, "BRL",
				new Random().nextInt(12563), new Random().nextInt(4323), new BigDecimal(100), false);

		logger.info("## CreateNewBankAccountServiceImpl.createNewAccount(): Creating Account Number Four {}",
				accountOne);

		logger.info("## CreateNewBankAccountServiceImpl.createNewAccount(): Account Objects Created !! ");

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

	public void checkIfMinorsCanDoBankAccounts(List<Account> listOfAccounts) throws AccountNotCreatedException {
		logger.info(
				"## CreateNewBankAccountServiceImpl.createNewAccount(): Checking if this person can create an account ");
		for (int i = 0; i < listOfAccounts.size(); i++) {
			Account account = listOfAccounts.get(i);
			if (account.isUnderEightteenYearsOld() == true && account.isParentsAuthorization() == false) {
				logger.error("## CreateNewBankAccountServiceImpl.createNewAccount(): You don't have permission ");
				throw new AccountNotCreatedException(ErrorsEnum.MINOR_DOESNT_HAVE_AUTHORIZATION.getMsg(),
						ErrorsEnum.MINOR_DOESNT_HAVE_AUTHORIZATION.getCampo(),
						ErrorsEnum.MINOR_DOESNT_HAVE_AUTHORIZATION.getCode());
			}
		}
		logger.info("## CreateNewBankAccountServiceImpl.createNewAccount(): Everything is good! ");

	}

	public void checkIfRgIsTheSame(List<Account> listOfAccounts) throws AccountNotCreatedException {
		List<String> rgs = new ArrayList<String>();

		for (int i = 0; i < listOfAccounts.size(); i++) {
			logger.info("## CreateNewBankAccountServiceImpl.createNewAccount(): Checking if it's not the same RG ");
			Account account = listOfAccounts.get(i);
			if (rgs.contains(account.getClientRg())) {
				logger.error("## CreateNewBankAccountServiceImpl.createNewAccount(): RG is already registrated ");
				throw new AccountNotCreatedException(ErrorsEnum.SAME_RG.getMsg(), ErrorsEnum.SAME_RG.getCampo(),
						ErrorsEnum.SAME_RG.getCode());
			}
			rgs.add(account.getClientRg());
		}
		logger.info("## CreateNewBankAccountServiceImpl.createNewAccount(): Everything is good! ");

	}

	public void checkIfCpfIsTheSame(List<Account> listOfAccounts) throws AccountNotCreatedException {
		List<String> cpfs = new ArrayList<String>();

		for (int i = 0; i < listOfAccounts.size(); i++) {
			logger.info("## CreateNewBankAccountServiceImpl.createNewAccount(): Checking if it's not the same CPF ");
			Account account = listOfAccounts.get(i);
			if (cpfs.contains(account.getClientCpf())) {
				logger.error("## CreateNewBankAccountServiceImpl.createNewAccount(): CPF is already registrated ");
				throw new AccountNotCreatedException(ErrorsEnum.SAME_CPF.getMsg(), ErrorsEnum.SAME_CPF.getCampo(),
						ErrorsEnum.SAME_CPF.getCode());
			}
			cpfs.add(account.getClientCpf());
		}
		logger.info("## CreateNewBankAccountServiceImpl.createNewAccount(): Everything is good! ");
	}

}
